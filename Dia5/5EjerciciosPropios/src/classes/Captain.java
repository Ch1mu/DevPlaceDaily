package classes;

public class Captain extends Member{

	public Captain(String firstName, String lastName, String dni, String race) {
		super(firstName, lastName, dni, race);
		
	}

	public void Order(String order)
	{
		System.out.println("NEW ORDER: " + order);
	}
	
	public void Drive()
	{
		System.out.println( super.getFirstName() +" " + super.getLastName() + " is driving the ship");
	}

	@Override
	public String toString() {
		return "Captain [firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni + ", race=" + race + "]";
	}
	
	
	
	
}
