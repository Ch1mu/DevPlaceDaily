package models;

public class Person {
protected String firstname;
protected String lastname;
protected String dni;



public Person(String firstname, String lastname, String dni) {

	this.firstname = firstname;
	this.lastname = lastname;
	this.dni = dni;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}


}
