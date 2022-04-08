package classes;



import java.util.ArrayList;

import interfaces.*;

public class ZoneLeader extends Employee implements ListsInterface{
private int office;
private Secretary secretary;
private ArrayList<Vendor>vendors;
Car car;

public ZoneLeader(String dni, String firstName, String lastname, String address, int since, String phone, double salary,
		 int office, Secretary secretary, ArrayList<Vendor> vendors, Car car) {
	super(dni, firstName, lastname, address, since, phone, salary, null);
	this.office = office;
	this.secretary = secretary;
	this.vendors = vendors;
	this.car = car;
	vendors = new ArrayList<Vendor>();
	setSalary(salary);
}

public void add(Object vendor)
{
	vendors.add((Vendor)vendor);
}
public void remove(int i)
{
	vendors.remove(i);
}

public void setSalary(double salary)
{
	
	salary =  salary + (salary*0.2)*since;
}
public int getOffice() {
	return office;
}
public void setOffice(int office) {
	this.office = office;
}
public Secretary getSecretary() {
	return secretary;
}
public void setSecretary(Secretary secretary) {
	this.secretary = secretary;
}

public ArrayList<Vendor> getVendors() {
	return vendors;
}

public Car getCar() {
	return car;
}
public void setCar(Car car) {
	this.car = car;
}

@Override
public String toString() {
	return "ZoneLeader ["+super.toString()+ ", office=" + office + ", secretary=" + secretary + ", vendors=" + vendors + ", car=" + car + "]";
}





}
