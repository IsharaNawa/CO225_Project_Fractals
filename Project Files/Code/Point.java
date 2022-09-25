class Point { 

    private double x, y; 
    
    public Point(double x, double y) { 
	this.x = x; 
	this.y = y; 
    }

    public double getX() { return this.x; } 
    public double getY() { return this.y; } 
    
    // bunch of overloaded functions 
    public Point findMidTo(Point p) { 
	return new Point((this.getX() + p.getX())/2, 
			 (this.getY() + p.getY())/2); 
    }

    public Point findMidTo(Point p1, Point p2) { 
	return new Point((this.getX() + p1.getX() + p2.getX())/3, 
			 (this.getY() + p1.getY() + p2.getY())/3 ); 
    }

    public static Point findMidTo(Point p1, Point p2, Point p3) { 
	return new Point((p1.getX() + p2.getX() + p3.getX())/3, 
			 (p1.getY() + p2.getY() + p3.getY())/3 ); 
    }
}
	