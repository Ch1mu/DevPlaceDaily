package classes;

public class Owner {

	String firstName;
	String lastName;
	String dni;
	
	
	public Owner(String firstName, String lastName, String dni) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	
}
