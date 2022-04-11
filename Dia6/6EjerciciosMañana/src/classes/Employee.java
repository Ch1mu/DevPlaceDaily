package classes;

public class Employee extends Person{
	private int since;
	private  int office;
	public Employee(String firstname, String lastname, String dni, String civilStatus, int since, int office) {
		super(firstname, lastname, dni, civilStatus);
		this.since = since;
		this.office = office;
	}
	public int getSince() {
		return since;
	}
	public void setSince(int since) {
		this.since = since;
	}
	public int getOffice() {
		return office;
	}
	public void setOffice(int office) { //Change Office
		this.office = office;
	}
	
	
}
