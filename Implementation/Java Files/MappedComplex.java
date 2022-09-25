//This class converts the point on the canvas to point on the region of interest

//this class is a subclass of the the complexNumber class
public class MappedComplex extends complexNumber{
	
	//attributes of the class
	private double heightDiff;		//height difference of the region of interest
	private double widthDiff;		//width difference of the region of interest
	
	private double hScalingFactor;		//scaling factor for the height(y axis)
	private double wScalingFactor;		//scaling factor for the width(x axis)
	
	//making the complex number using constructor
	public MappedComplex(double left,double right,double down,double up){
		
		//instantiating using the default constructor
		super();
		
		//calculating attributes of the class
		this.heightDiff=up-down;
		this.widthDiff=right-left;
		
		this.hScalingFactor=(double)800/heightDiff;
		this.wScalingFactor=(double)800/widthDiff;
	}
	
	//setting the corresponding values for the complex number
	public void setValues(Point p) {
		super.setReal((p.getX()-(double)400)/wScalingFactor);
		super.setImg(((double)400-p.getY())/hScalingFactor);
	}	
}