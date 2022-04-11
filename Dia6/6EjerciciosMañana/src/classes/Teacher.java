package classes;

public class Teacher extends Employee{

private String department;



public Teacher(String firstname, String lastname, String dni, String civilStatus, int since, int office,
		String department) {
	super(firstname, lastname, dni, civilStatus, since, office);
	this.department = department;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) { //Change department
	this.department = department;
}

@Override
public String toString() {
	return "Teacher [department=" + department + ", firstname=" + firstname + ", lastname=" + lastname + ", dni=" + dni
			+ ", civilStatus=" + civilStatus + "]";
}



}
