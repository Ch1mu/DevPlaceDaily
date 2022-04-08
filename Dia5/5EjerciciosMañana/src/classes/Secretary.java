package classes;

public class Secretary extends Employee{
private int office;
private int fax;
public Secretary(String dni, String firstName, String lastname, String address, int since, String phone, double salary,
		Employee supervisor, int office, int fax) {
	super(dni, firstName, lastname, address, since, phone, salary, supervisor);
	this.office = office;
	this.fax = fax;
	setSalary(salary);
}

public void setSalary(double salary)
{
	
	salary =  salary + (salary*0.05)*since;
}
public int getOffice() {
	return office;
}
public void setOffice(int office) {
	this.office = office;
}
public int getFax() {
	return fax;
}
public void setFax(int fax) {
	this.fax = fax;
}

@Override
public String toString() {
	return "Secretary ["+ super.toString()+ ", office=" + office + ", fax=" + fax + "]";
}


}
