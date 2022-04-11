package classes;

import java.util.ArrayList;

public class Academy {
public static Academy instance;
ArrayList<Student>students;
ArrayList<Teacher>teachers;
ArrayList<ServiceStaff> serviceStaff;
String prueba;
	private Academy(){
		students = new ArrayList<Student>();
		teachers = new ArrayList<Teacher>();
		 serviceStaff = new ArrayList<ServiceStaff>();
	}
	public static Academy getInstance()
	{
		if(instance==null)
			instance = new Academy();
		return instance;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	public ArrayList<ServiceStaff> getServiceStaff() {
		return serviceStaff;
	}
	
}
