package classes;

public abstract class Animal {

	protected String type;
	protected String diet;
	protected String name;
	

	public Animal(String type, String diet, String name) {
		
		this.type = type;
		this.diet = diet;
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
