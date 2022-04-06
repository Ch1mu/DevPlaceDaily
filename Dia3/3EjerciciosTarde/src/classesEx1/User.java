package classesEx1;

public class User {

	String name;
	boolean premium = false;
	
	public  User(String name)
	{
		this.name = name;
	}

	public boolean download() {
		return true;
	}
	public boolean advertisements()
	{
		return false;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
