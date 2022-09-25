//This class contains the main Application for this software

//importing libraries
import javax.swing.*;

public class Fractal {
	
	//returns a panel containing Mandrelbrot set according to the parameters
	public static Panel panelMandelbrot(int iter,double [] region) {
		
		Panel panelobj=new Panel(800, 800,"Mandelbrot");
		
		panelobj.setIter(iter);
		
		panelobj.setRegion(region[0],region[1],region[2],region[3]);
		
		return panelobj;
	}
	
	//returns a panel containing Julia set according to the parameters
	public static Panel panelJulia(int iter,double [] region,double real,double img) {
		
		Panel panelobj=new Panel(800, 800,"Julia");
		
		panelobj.setIter(iter);
		
		panelobj.setRegion(region[0],region[1],region[2],region[3]);
		
		complexNumber z = new complexNumber(real,img);
		
		panelobj.setComplex(z);
		
		return panelobj;
	}
	
	//gives the desired output
	public static void main(String args[]) {
		

		try {
			
			//setting the Title of the frame
			String Title = args[0]+" Set";
			
			//getting a new frame
			JFrame frame = new JFrame(Title);
			
			//setting the exit method for the frame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//setting the region of interest for the default case
			double [] defaultRegion = {-1,1,-1,1};
			
			//if there are no cmd args then terminate the program with an error message
			if(args.length==0) {//There are no cmdline arguments.print the error message
				
				System.out.println("Please specify the plotting type set!");
				System.exit(0);
				
			}else if(args.length==1){//basic case should be plot
				
				if(args[0].toLowerCase().equals("mandelbrot")) {//basic mandelbrot set
					frame.setContentPane(panelMandelbrot(1000,defaultRegion));
				}
				else if(args[0].toLowerCase().equals("julia")) {//basic julia set 
					frame.setContentPane(panelJulia(1000,defaultRegion,-0.4,0.6));
				}
				else {//if other,then type must be wrong.Terminate the program with an error
					System.out.println("Please specify the type of the plot correctly!");
					System.exit(0);
				}
				
			}else if(args.length==4) {//case two of the julia set
			
				if(args[0].toLowerCase().equals("julia")) {
					
					try {//try because some double args can be non double/integer Strings
						frame.setContentPane(panelJulia(Integer.parseInt(args[3]),
								defaultRegion,Double.parseDouble(args[1]),Double.parseDouble(args[2])));
						
					}catch(Exception e) {//catching the exception
						System.out.println("There is an error with complex number of iteration number.Check your inputs again!");
						System.exit(0);
					}
					
				}else {//if other than julia==>usage must be wrong
					System.out.println("Invalid Usage.Please check your inputs again!");
				}
				
			}else if(args.length==5) {//case two of the mandelbrot set
				
				if(args[0].toLowerCase().equals("mandelbrot")) {
					
					try {//try because some double args can be non double/integer Strings
						
						double [] region= {
											Double.parseDouble(args[1]),
											Double.parseDouble(args[2]),
											Double.parseDouble(args[3]),
											Double.parseDouble(args[4])
											};
						
						frame.setContentPane(panelMandelbrot(1000,region));
						
					}catch(Exception e){//catching the exception
						
						System.out.println("There is an error with the region of interest.Check your inputs again!");
						System.exit(0);
					}
					
				}else{//other than mandelbrot set==>the usage must be wrong 
					System.out.println("Invalid Usage.Please check your inputs again!");
					System.exit(0);
				}
				
			
			}else if(args.length==6) {//case three of the mandelbrot set
				
				if(args[0].toLowerCase().equals("mandelbrot")) {
					
					try {//try because some double args can be non double/integer Strings
						
						double [] valueSet= {
								Double.parseDouble(args[1]),
								Double.parseDouble(args[2]),
								Double.parseDouble(args[3]),
								Double.parseDouble(args[4]),
								
								};
							
						frame.setContentPane(panelMandelbrot(Integer.parseInt(args[5]),valueSet));
						
					}catch(Exception e) {//catching the exception
						System.out.println("There is an error with the region of interest or iteration number.Check your inputs again!");
						System.exit(0);
					}
			
				}else {//other than mandelbrot set==>usage must be wrong
					System.out.println("Invalid Usage.Please check your inputs again!");
					System.exit(0);
				}
				
			}else {//for all the argument sets which have invalid number of args
				
				System.out.println("Invalid Usage.Please check your inputs again!");
				System.exit(0);
				
			}
			
			//including panel in the frame
			frame.pack();
			
			//setting the frame at the center of the screen
			frame.setLocationRelativeTo(null);
			
			//showing the frame
			frame.setVisible(true);
			
		}catch(ArrayIndexOutOfBoundsException i) {//catching errors in arrayout of bound
			System.out.println("Not enough arguments.Try again!");
		}catch(Exception ee) {//catching all other errors
			System.out.println(ee);
		}
		
	}
	
}
