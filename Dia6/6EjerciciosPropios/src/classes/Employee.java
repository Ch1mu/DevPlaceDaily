package classes;

public class Employee extends Person{

	private int since;

	
	
	public Employee(String firstName, String lasName, String dni, int since) {
		super(firstName, lasName, dni);
		this.since = since;

	}
	
	public int getSince() {
		return since;
	}
	public void setSince(int since) {
		this.since = since;
	}

	
	
	
}
