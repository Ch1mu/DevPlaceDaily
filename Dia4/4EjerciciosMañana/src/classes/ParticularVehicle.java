package classes;

public class ParticularVehicle extends Vehicle{
	

protected int doors;

public ParticularVehicle(String plate, int doors) {
	super(plate);
	this.doors = doors;
}

public int getDoors() {
	return doors;
}

public void setDoors(int doors) {
	this.doors = doors;
}

@Override
public String toString() {
	return "ParticularVehicle [Plate= "+ super.getPlate()+"doors=" + doors + "]";
}

}
