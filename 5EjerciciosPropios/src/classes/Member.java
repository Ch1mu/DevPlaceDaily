package classes;

public class Member {
	
protected String firstName;
protected String lastName;
protected String dni;
protected String race;

public Member(String firstName, String lastName, String dni, String race) {

	this.firstName = firstName;
	this.lastName = lastName;
	this.dni = dni;
	this.race = race;
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
public String getRace() {
	return race;
}
public void setRace(String race) {
	this.race = race;
}

@Override
public String toString() {
	return "Member [firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni + ", race=" + race + "]";
}



}
