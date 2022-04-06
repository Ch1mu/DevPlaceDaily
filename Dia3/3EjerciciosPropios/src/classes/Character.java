package classes;

public class Character {

	protected String name;
	protected String race;
	
	public Character(String name, String race) {
	
		this.name = name;
		this.race = race;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", race=" + race + "]";
	}
	
	
}
