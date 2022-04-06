package classesEx2;

public class Circle extends Shape{

	double radius;
		
		
	public Circle(double radius) {
	
		super(0);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getPer()
	{
		return 2*3.14*this.radius;
	}
	public double getArea()
	{
		return 3.14*Math.pow(radius, 2);
	}
	
}
