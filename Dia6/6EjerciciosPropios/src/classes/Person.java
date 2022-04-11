package classes;

public abstract class Person {
protected String firstName;
protected String lasName;
protected String dni;



public Person(String firstName, String lasName, String dni) {
	super();
	this.firstName = firstName;
	this.lasName = lasName;
	this.dni = dni;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLasName() {
	return lasName;
}
public void setLasName(String lasName) {
	this.lasName = lasName;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}


}
