package classes;

import java.util.Random;

public class Enclosure {

	private String animalName;
	private GenArray<Animal> animals;
	private boolean clean;
	
	
	
	public Enclosure(String animalName) {
		super();
		this.animalName = animalName;
		animals = new GenArray<Animal>();
	clean = true;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String isClean() {
		if(clean)
		return "Clean";
		else
			return "Dirty";
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	public GenArray<Animal> getAnimals() {
		return animals;
	}
	public void randomClean()
	{
		Random rnd = new Random();
		int number = rnd.nextInt(10); //random int between 0 and 10
		if(number >=5 ) {
			clean = false;
		}
	}
	@Override
	public String toString() {
		return "Enclosure [animalName=" + animalName + ", animals=" + animals + ", clean=" + clean + "]";
	}

	
	
}
