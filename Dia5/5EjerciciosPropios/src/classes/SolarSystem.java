package classes;

import exception.InvalidObjectException;
import interfaces.ListsInterface;

public class SolarSystem implements ListsInterface{

	GenericArray<Planet> planets;
	GenericArray<SpaceShip> ships;
	
	public SolarSystem() {
	planets = new GenericArray<Planet>();
	ships = new GenericArray<SpaceShip>();
	}
	
	public GenericArray<SpaceShip> getShips() {
		return ships;
	}
	public GenericArray<Planet> getPlanets() {
		return planets;
	}

	
	@Override
	public void add(Object object) throws InvalidObjectException {
		if(object instanceof SpaceShip)
		{
			ships.addElement((SpaceShip)object);
		}
		else if(object instanceof Planet)
		{
			planets.addElement((Planet)object);
		}
		else 
			throw new InvalidObjectException();
		
	}
		
	
}
