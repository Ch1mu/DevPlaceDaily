package classes;

import java.util.ArrayList;

import interfaces.*;

public class Vendor extends Employee implements SalaryInterface, ListsInterface{
private Car car;
private String vendorPhone;
private String area;
ArrayList<Client>clients;
private int percentage;




public Vendor(String dni, String firstName, String lastname, String address, int since, String phone, double salary,
		 Employee supervisor, Car car, String vendorPhone, String area, int percentage) {
	super(dni, firstName, lastname, address, since, phone, salary, supervisor);
	clients = new ArrayList<Client>();
	this.car = car;
	this.vendorPhone = vendorPhone;
	this.area = area;
	this.percentage = percentage;
	setSalary(salary);
	

}

public void setSalary(double salary)
{
	
	salary =  salary + (salary*0.10)*since;
}

public void add(Object client)
{
	clients.add((Client)client);
}
public void remove(int i)
{
	clients.remove(i);
}

public Car getCar() {
	return car;
}
public void setCar(Car car) { //Car change
	this.car = car;
}
public String getVendorPhone() {
	return vendorPhone;
}
public void setVendorPhone(String vendorPhone) {
	this.vendorPhone = vendorPhone;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public ArrayList<Client> getClients() {
	return clients;
}

public int getPercentage() {
	return percentage;
}
public void setPercentage(int percentage) {
	this.percentage = percentage;
}

@Override
public String toString() {
	return "Vendor ["+super.toString()+"car=" + car + ", vendorPhone=" + vendorPhone + ", area=" + area + ", clients=" + clients
			+ ", percentage=" + percentage + "]";
}



}
