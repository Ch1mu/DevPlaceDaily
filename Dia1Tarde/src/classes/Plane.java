package classes;


//Excercise 2: Build a plane class with util methods
public class Plane {

	private String model;
	private boolean flying = false;
	private int capacity;
	private int passengers = 0;
	
	public Plane(String model, int capacity)
	{
		this.model = model; 
		this.capacity = capacity;
	}
	//getters and setters
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isFlying() {
		return flying;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
	//methods
	public void launch() {
		flying =true;
	}
	public void land() {
		flying =false;
	}
	
	//Excercise 3: Create a method that you can use to add passengers to a plane, checking if the plane isn't full
	public boolean checkCapacity()
	{
		if(capacity - passengers != 0)
			return true;
			else 
				return false;
	}
	public void addPassenger()
	{
	 if(checkCapacity())
			passengers++;
	 else
		 System.out.println("Sorry, the plane is already full!"); // i wanted to use an exception but we don't see it
		
	}
	
}
