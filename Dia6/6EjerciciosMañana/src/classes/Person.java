package classes;

public abstract class Person {
protected String firstname;
protected String lastname;
protected String dni;
protected String civilStatus;

protected Person(String firstname, String lastname, String dni, String civilStatus) {

	this.firstname = firstname;
	this.lastname = lastname;
	this.dni = dni;
	this.civilStatus = civilStatus;
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
public String getCivilStatus() {
	return civilStatus;
}
public void setCivilStatus(String civilStatus) { //Change CivilStatus
	this.civilStatus = civilStatus;
}


}
