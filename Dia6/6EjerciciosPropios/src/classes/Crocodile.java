package classes;

public class Crocodile extends Animal{
public static int id;
private int ownId;
	public Crocodile() {
		super("Reptile", "Carnivore", "Crocodile");
		id++;
		ownId = id;
	
	}
	
	
	
	@Override
	public String toString() {
		return "Crocodile [ownId=" + ownId + ", type=" + type + ", diet=" + diet + ", name=" + name + "]";
	}
	

}
