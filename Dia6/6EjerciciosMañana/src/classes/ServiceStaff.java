package classes;

public class ServiceStaff extends Employee{

private String section;

public ServiceStaff(String firstname, String lastname, String dni, String civilStatus, int since, int office,
		String section) {
	super(firstname, lastname, dni, civilStatus, since, office);
	this.section = section;
}

public String getSection() {
	return section;
}

public void setSection(String section) { //Change section
	this.section = section;
}

@Override
public String toString() {
	return "ServiceStaff [section=" + section + ", firstname=" + firstname + ", lastname=" + lastname + ", dni=" + dni
			+ ", civilStatus=" + civilStatus + "]";
}




}
