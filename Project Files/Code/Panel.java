import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;

class Panel extends JPanel { // inherit JPanel 

    private int width, height; 
    private Point [] triangle; 
    private static int points = 100000; 

    public Panel(int width, int height) { 
	// set the panel size 
	this.width  = width; 
	this.height = height; 
	setPreferredSize(new Dimension(width, height)); 

	// panel is supposed to have a triangle in it. 
	triangle = new Point[3];
	triangle[0] = new Point(0d, 0d); 
	triangle[1] = new Point(width/2d, (double)height); 
	triangle[2] = new Point((double)width, 0d); 

    }

    private static void printPoint(Graphics2D frame, Color c, Point p) {

	frame.setColor(c); 
	frame.draw(new Line2D.Double(p.getX(), p.getY(), 
				     p.getX(), p.getY())); 
    }

    public void paintComponent(Graphics g) { 
	// call paintComponent from parent class 
	super.paintComponent(g); 

	Point mid = Point.findMidTo(triangle[0], triangle[1], triangle[2]); 


	Random ran = new Random(); 

	// When it refreshes this function is called again. 
	// So do not change the value of static points
	int points = Panel.points; 

	while(points-- > 0) { 
	    int r = ran.nextInt(3); 
	    mid = mid.findMidTo(triangle[r]); 
	    printPoint((Graphics2D)g, Color.RED, mid); 
	}

    }

    public static void main(String [] args) { 

	// create a frame
	JFrame frame = new JFrame("Serpenski's Triangle"); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	// set the content of the frame as one of this panel
	frame.setContentPane(new Panel(600, 800)); 

	frame.pack(); 
	frame.setLocationRelativeTo(null); 
	frame.setVisible(true); 
    }
}