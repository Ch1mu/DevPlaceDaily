package app;

import classes.*;

public class Main {

	public static void main(String[] args) {
	
		Zoo zoo = Zoo.getInstance();
		Enclosure lions = new Enclosure("Lion");
		Enclosure Zebra = new Enclosure("Zebra");
		Enclosure Penguin = new Enclosure("Penguin");
		Enclosure  Crocodile = new Enclosure("Crocodile");
		zoo.getEnclosures().addElement(lions);
		zoo.getEnclosures().addElement(Zebra);
		zoo.getEnclosures().addElement(Crocodile);
		zoo.getEnclosures().addElement(Penguin);
	
		Menu.menu(zoo);

	}

}
