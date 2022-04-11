package classes;

public class Zebra extends Animal{
public static int id;
private int ownId;
	public Zebra() {
		super("Mammal", "Herbivore", "Zebra");
		id++;
		ownId = id;

	}
	@Override
	public String toString() {
		return "Zebra [ownId= " + ownId + ", type=" + type + ", diet=" + diet + ", name=" + name + "]";
	}
	
	

}
