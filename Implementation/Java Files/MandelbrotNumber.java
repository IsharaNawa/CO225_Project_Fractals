//the mapped complex number is passed to here
//this class check if it is in the Mandelbrot set and returns true or false

public class MandelbrotNumber{

	//attributes of the class
	private  int iterations;
	private int counter=0;
	
	//constructor of the class
	public MandelbrotNumber(int i) {
		this.iterations = i;
	}
	
	//this method check if it is in the Mandelbrot set or not
	public boolean isMandelbrot(MappedComplex c) {
		
		complexNumber Zn = new complexNumber(0,0);
	
		for(this.counter=0;this.counter<this.iterations;this.counter++) {
			Zn.comSquare();	//squaring the complex number
			Zn.comAddition(c);		//getting the addition of the complex number
			
			//comparison of the square of the absolute value of the complex number
			if(Zn.getSquareOfAbs()>4) {
				return false;
			}
			
		}
		return true;
	}		
	
	//getting the number of iterations for coloring
	public int getIter() {
		return this.counter;
	}
	
}
