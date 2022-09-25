//importing important libraries
import java.awt.*; 
import javax.swing.*;
import java.awt.geom.Line2D;

//Panel class is created extending JPanel
//This class handles the printing points on the canvas using different colors
public class Panel extends JPanel{

	//attributes of the class
	private int width;		//stores the width of the panel 
	private int height;		//stores the height of the panel
	private String type;	//stores the type of complexSet(mandelbrot or julia)
	private int iter;		//stores the number of iterations
	private complexNumber c = new complexNumber();	//creating a new complex number
	private double left,right,down,up;	//limits of the 
	
	//this method makes the panel for the corresponding height and width
	public Panel(int width, int height,String type) { 
		// set the panel size 
		this.width  = width; 
		this.height = height; 
		this.type= String.valueOf(type);
		
		//creating the panel using dimensions
		setPreferredSize(new Dimension(this.width, this.height)); 
	}
	
	//setting the number of iterations
	public void setIter(int i) {this.iter=i;}
	
	//setting the complex number for the julia set
	public void setComplex(complexNumber z) {
		
		this.c.setReal(z.getReal());
		this.c.setImg(z.getImg());
	}
	
	//setting the region of interest
	public void setRegion(double left,double right,double down,double up) {
		this.left=left;
		this.right=right;
		this.down=down;
		this.up=up;
	}
	
	//printing a point on the canves
	private static void printPoint(Graphics2D frame, Color c, Point p) {

		frame.setColor(c); 
		frame.draw(new Line2D.Double(p.getX(), p.getY(), 
					     p.getX(), p.getY())); 
	 }

	//printing the color based on iterations
	public void Coloring(int i,Graphics g,Point p) {
		if(i>=900) {printPoint((Graphics2D)g,new Color(82, 65, 42) , p);}
		else if(i>=200) {printPoint((Graphics2D)g,new Color(138, 78, 33) , p);}
		else if(i>=100) {printPoint((Graphics2D)g,new Color(150, 102, 30) , p);}
		else if(i>=80) {printPoint((Graphics2D)g,new Color(150, 126, 30) , p);}
		else if(i>=65) {printPoint((Graphics2D)g,new Color(156, 153, 30) , p);}
		else if(i>=55) {printPoint((Graphics2D)g,new Color(114, 156, 30) , p);}
		else if(i>=50) {printPoint((Graphics2D)g,new Color(70, 156, 30) , p);}
		else if(i>=45) {printPoint((Graphics2D)g,new Color(30, 156, 43) , p);}
		else if(i>=43) {printPoint((Graphics2D)g,new Color(27, 181, 73) , p);}
		else if(i>=40) {printPoint((Graphics2D)g,new Color(27, 181, 114) , p);}
		else if(i>=35) {printPoint((Graphics2D)g,new Color(27, 181, 143) , p);}
		else if(i>=30) {printPoint((Graphics2D)g,new Color(27, 181, 171) , p);}
		else if(i>=25) {printPoint((Graphics2D)g,new Color(27, 158, 181) , p);}
		else if(i>=22) {printPoint((Graphics2D)g,new Color(27, 109, 181) , p);}
		else if(i>=20) {printPoint((Graphics2D)g,new Color(27, 76, 181) , p);}
		else if(i>=18) {printPoint((Graphics2D)g,new Color(27, 53, 181) , p);}
		else if(i>=16) {printPoint((Graphics2D)g,new Color(40, 27, 181) , p);}
		else if(i>=14) {printPoint((Graphics2D)g,new Color(149, 17, 189) , p);}
		else if(i>=12) {printPoint((Graphics2D)g,new Color(169, 17, 189) , p);}
		else if(i>=10) {printPoint((Graphics2D)g,new Color(189, 17, 183) , p);}
		else if(i>=9) {printPoint((Graphics2D)g,new Color(189, 17, 157) , p);}
		else if(i>=8) {printPoint((Graphics2D)g,new Color(189, 17, 137) , p);}
		else if(i>=7) {printPoint((Graphics2D)g,new Color(189, 17, 120) , p);}
		else if(i>=6) {printPoint((Graphics2D)g,new Color(189, 17, 109) , p);}
		else if(i>=5) {printPoint((Graphics2D)g,new Color(189, 17, 97) , p);}
		else if(i>=4) {printPoint((Graphics2D)g,new Color(189, 17, 92) , p);}
		else if(i>=3) {printPoint((Graphics2D)g,new Color(189, 17, 74) , p);}
		else if(i>=2) {printPoint((Graphics2D)g,new Color(189, 17, 60) , p);}
		else if(i>=1) {printPoint((Graphics2D)g,new Color(189, 17, 49) , p);}
		else if(i>=0) {printPoint((Graphics2D)g,new Color(189, 17, 17) , p);}
	}
	
	//printing the point set
	public void paintComponent(Graphics g) { 
		// call paintComponent from parent class 
		super.paintComponent(g); 
		
		//variables for for looping 
		int row,col;
		
		//if the use user wants Mandrelbrot set ,this block will be executed
		if(this.type.equals("Mandelbrot")) {
			
			for(row=0;row<800;row++) {
				for(col=0;col<800;col++) {
					//creating the point based on the coordinates of the canvas
					Point p = new Point((double)row,(double)col);
					//making the mapped point based on the point on the canvas
					MappedComplex m = new MappedComplex(this.left,this.right,this.down,this.up);
					//setting real and complex parts of the mapped complex number
					m.setValues(p);
					
					//to check if the current point is a mandelbrot or not
					MandelbrotNumber mn=new MandelbrotNumber(this.iter);
	
					if(mn.isMandelbrot(m)) {//if the current point is mandelbrot it is printed on the canvas using black
						printPoint((Graphics2D)g, new Color(0, 0, 0), p);
					}else {//otherwise print another color on the canvas using another color
						Coloring(mn.getIter(),g,p);
					}
				}
			}
		}
		
		else if(this.type.equals("Julia")) {
			for(row=0;row<800;row++) {
				for(col=0;col<800;col++) {
					//creating the point based on the coordinates of the canvas
					Point p = new Point((double)row,(double)col);
					//making the mapped point based on the point on the canvas
					MappedComplex m = new MappedComplex(this.left,this.right,this.down,this.up);
					//setting real and complex parts of the mapped complex number
					m.setValues(p);
					
					//to check if the current point is a julia or not
					JuliaNumber mn=new JuliaNumber(this.iter,this.c);
	
					if(mn.isJulia(m)) {//if the current point is julia it is printed on the canvas using black
						printPoint((Graphics2D)g, Color.BLACK, p);
					}else {//otherwise print another color on the canvas using another color
						Coloring(mn.getIter(),g,p);
					}
				}
			}
		}
	}	
}
