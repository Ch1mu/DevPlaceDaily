package classes;

import exception.NegativeDistanceException;

public class Planet {

	private String name;
	private double distance; // 0 = sun -  DISTANCE IN MILLION OF KM
	private double temp;
	

	public Planet(String name, double distance, double temp) throws NegativeDistanceException {

		
		
		if(distance>0)
		{
			this.distance = distance;
			this.name = name;
			this.temp = temp;
		}
		else
			throw new NegativeDistanceException();
	
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", distance=" + distance+" Million KM,  " + "temp=" + temp + "° " +"]";
	}
	
	
	
	
}
