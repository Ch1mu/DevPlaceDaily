package classes;

import exceptions.TooFastException;

public class Vehicle {
protected String plate;
protected double velocity;



public Vehicle(String plate) {
	this.plate = plate;
	this.velocity = 0;
	
}

public String getPlate() {
	return plate;
}
public void setPlate(String plate) {
	this.plate = plate;
}
public double getVelocity() {
	return velocity;
}
public void setVelocity(double acceleration) {
	this.velocity = acceleration;
}

public void accelerate(double acceleration) throws TooFastException
{
	velocity+= acceleration;
}
@Override
public String toString() {
	return "Vehicle [plate=" + plate + ", velocity=" + velocity + "]";
}



}
