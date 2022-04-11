package classes;

public class Student extends Person{
private String course;



public Student(String firstname, String lastname, String dni, String civilStatus, String course) { //New Student
	super(firstname, lastname, dni, civilStatus);
	this.course = course;
}

public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}

@Override
public String toString() {
	return "Student [course=" + course + ", firstname=" + firstname + ", lastname=" + lastname + ", dni=" + dni
			+ ", civilStatus=" + civilStatus + "]";
}


}
