package classes;

public class Lion extends Animal{
public static int id;
private int ownId;
	public Lion() {
		super("Mammal ", "Carnivore", "Lion");
		ownId = id;
	id++;
	}
	@Override
	public String toString() {
		return "Lion [ID= "+ownId+", type=" + type + ", diet=" + diet + ", name=" + name + "]";
	}

	
	
}
