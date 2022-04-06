package classesEx2;

public class Square extends Shape {
protected double side;

public Square(double side) {
	super(4);
	this.side = side;
}

public double getSide() {
	return side;
}

public void setSide(double side) {
	this.side = side;
}
public double getPer()
{
	return side*4;
}
public double getArea()
{
	return side*side;
}
}
