package classes;

import interfaces.SalaryInterface;

public class Employee implements SalaryInterface{

	protected String dni;
	protected String firstName;
	protected String lastname;
	protected String address;
	protected int since;
	protected String phone;
	protected double salary;
	Employee supervisor;

	
	public Employee(String dni, String firstName, String lastname, String address, int since, String phone,
			double salary, Employee supervisor) {
		this.supervisor = supervisor;
		this.dni = dni;
		this.firstName = firstName;
		this.lastname = lastname;
		this.address = address;
		this.since = since;
		this.phone = phone;
		this.salary = salary;
	}
	
	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public int getSince() {
		return since;
	}
	public void setSince(int since) {
		this.since = since;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void incrementSalary(double ammount)
	{
		 salary+= ammount;
	}
	
	@Override
	public String toString() {
		return "Employer [dni=" + dni + ", firstName=" + firstName + ", lastname=" + lastname + ", address=" + address
				+ ", since=" + since + ", phone=" + phone + ", salary=" + salary + ", supervisor=" + supervisor + "]";
	}
	
	
	
}
