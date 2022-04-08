package classes;

import exception.InvalidObjectException;
import interfaces.ListsInterface;

public class SpaceShip implements ListsInterface {
	
private String shipName;

private GenericArray<Member> airCrew;
private GenericArray<Problem> problems;

private double fuel; //Liters
private Planet location;

public SpaceShip(String shipName, int fuel, Planet origin) {

airCrew = new GenericArray<Member>();
problems =new GenericArray<Problem>();
	location = origin;
	this.shipName = shipName;
	this.fuel = fuel;
}

public Planet getLocation() {
	return location;
}

public void setLocation(Planet location) {
	this.location = location;
}

public String getShipName() {
	return shipName;
}
public void setShipName(String shipName) {
	this.shipName = shipName;
}
public double getFuel() {
	return fuel;
}
public void setFuel(double fuel) {
	this.fuel = fuel;
}
public GenericArray<Member> getAirCrew() {
	return airCrew;
}
public GenericArray<Problem> getProblems() {
	return problems;
}



public void fastTravel(Planet planet)
{
	double newFuel;
	
	newFuel = fuel - (fuel* 0.1);
	setFuel(newFuel);
	
	setLocation(planet);
	
}

public void fixProblem(int i )
{
	problems.remove(i);
}

@Override
public void add(Object object) throws InvalidObjectException {
	if(object instanceof Problem)
	{
		problems.addElement((Problem)object);
	}
	else if(object instanceof Member)
	{
		airCrew.addElement((Member)object);
	}
	else
		throw new InvalidObjectException();
	
}

@Override
public String toString() {
	return "SpaceShip [shipName=" + shipName +", fuel=" + fuel
			+ ", location=" + location .getName()+ "]";
}




}
