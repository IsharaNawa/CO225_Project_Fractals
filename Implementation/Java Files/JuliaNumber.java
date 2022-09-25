//the mapped complex number is passed to here
//this class check if it is in the Julia set and returns true or false

public class JuliaNumber {
	
	//attributes of the class
	private  int iterations;
	private int counter=0;
	private complexNumber c;
	
	//constructor of the class
	public JuliaNumber(int i,complexNumber c) {
		this.iterations=i;
		this.c=c;
	}
	
	//this method checks if the complex number is in the Julia set or not
	public boolean isJulia(MappedComplex Zn) {
		
		for(this.counter=0;this.counter<this.iterations;this.counter++) {
			Zn.comSquare();
			Zn.comAddition(this.c);
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
