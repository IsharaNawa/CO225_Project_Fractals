//importing libraries
import java.lang.Math;

//Class for the representation of a Complex Number

public class complexNumber {
	
	//attributes of the class
	private double real;	//stores the real part of the complex number
	private double img;		//stores the imaginary part of the complex number
	
	//default constructor
	public complexNumber(){}
	
	//constructor with real and imaginary part set
	public complexNumber(double real,double img){
		this.real=real;
		this.img=img;
	}
	
	//setting the real value
	public void setReal(double real) {
		this.real=real;
	}
	
	//setting the imaginary value
	public void setImg(double img) {
		this.img=img;
	}
	
	//getting real part
	public double getReal() {
		return this.real;
	}
	
	//getting imaginary part
	public double getImg() {
		return this.img;
	}

	//getting square of the absolute value
	public double getSquareOfAbs() { 
		return Math.pow(this.real, 2)+Math.pow(this.img, 2);
	}
	
	//adding another complex number to this complex number
	public void comAddition(complexNumber y) {
		
		this.real=this.real+y.real;
		this.img=this.img+y.img;
	}
	
	//setting the current complex number to its' square
	public void comSquare() {
		
		double newReal = Math.pow(this.real, 2)-Math.pow(this.img, 2);
		double newImg = (double)2*this.real*this.img;
		
		this.real=newReal;
		this.img= newImg;
	}
	
	//getting the information of the complex number
	public void getComplexInfo() {
		System.out.printf("%f + i(%f) with abs of %f.",this.real,this.img,this.getSquareOfAbs());
	}
}
