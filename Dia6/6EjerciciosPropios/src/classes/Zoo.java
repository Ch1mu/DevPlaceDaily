package classes;

public class Zoo { //SINGLETON
private static  Zoo myInstance;
private GenArray<Enclosure>enclosures;
private GenArray<Employee>employees;
private Zoo()
{
	enclosures = new GenArray<Enclosure>();
	employees = new GenArray<Employee>();
}

public static Zoo getInstance()
{
	if (myInstance == null)
	return	myInstance = new Zoo();
	
	return myInstance;
}


public GenArray<Enclosure> getEnclosures() {
	return enclosures;
}

public GenArray<Employee> getEmployees() {
	return employees;
}

public void addAnimalToEnclosure(Animal animal)
{
	for (int i = 0; i<enclosures.getSize(); i++)
	{
	if(animal.getName() == (enclosures.getElement(i).getAnimalName()))	{
		enclosures.getElement(i).getAnimals().addElement(animal);
	}
	}
}
}
