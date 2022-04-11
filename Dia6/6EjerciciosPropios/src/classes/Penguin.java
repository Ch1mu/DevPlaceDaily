package classes;

public class Penguin extends Animal
{
	public static int id;
	private int ownId;
	public Penguin() {
		super("Bird", "Carnivore ", "Penguin");
		id++;
	ownId = id;
	
	}
	@Override
	public String toString() {
		return "Penguin [ownId=" + ownId + ", type=" + type + ", diet=" + diet + ", name=" + name + "]";
	}
	
	
}
