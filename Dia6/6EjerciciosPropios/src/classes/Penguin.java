package classes;

public class Penguin extends Animal
{
	public static int id;
	private int ownId;
	public Penguin() {
		super("Bird", "Carnivore ", "Penguin");
	ownId = id;
		id++;
	}
	@Override
	public String toString() {
		return "Penguin [ownId=" + ownId + ", type=" + type + ", diet=" + diet + ", name=" + name + "]";
	}
	
	
}
