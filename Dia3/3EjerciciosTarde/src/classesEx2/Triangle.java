package classesEx2;

public class Triangle extends Shape{
	
private static final int sAmmount = 3;

	protected double base, side2, side3, height;

	public Triangle(double base, double side2, double side3, double height) {
		super(sAmmount);
		this.base = base;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return base;
	}

	public void setSide1(double base) {
		this.base = base;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	public double getPer()
	{
	return base + side2 + side3;
	}
	public double getArea()
	{
		return (base*height)/2;
	}
	
}
