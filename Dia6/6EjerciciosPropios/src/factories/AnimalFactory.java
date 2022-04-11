package factories;

import classes.*;

public class AnimalFactory {

	public static Animal addAnimal(int option) {
		
		switch(option)
		{
		case 1:  return new Lion();
		
		case 2: return new Zebra();
		
		case 3: return new Crocodile();
		
		case 4: return new Penguin();
		
		default:
			return null;
			
		}
	
		
		
		
	}
}
