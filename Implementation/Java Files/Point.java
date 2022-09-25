//Class for the point in the 2D space

class Point { 
	
	//attributes of the class
    private double x;		//stores the x coordinate of a point
    private double y; 		//stores the y coordinate of a point
    
    //making a point with x and y already set
    public Point(double x, double y) { 
    	this.x = x; 
    	this.y = y; 
    }

    //getting the x coordinate of the point
    public double getX() { 
    	return this.x; 
    }
    
    //getting the y coordinate of the point
    public double getY() { 
    	return this.y; 
    } 
}
	