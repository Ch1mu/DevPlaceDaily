package app;

import database.dbController;
import models.*;

public class Main {

	public static void main(String[] args) {

		dbController db = new dbController();	
		RecordCompany company;
		company = RecordCompany.getInstance();
		
		Artist justin = new Artist("Justin", "Bieber", "123", "pop");
		
		Album a1 = new Album("Never say never", justin);
		
		Song song1 = new Song("Baby", 3.10);
		Song song2 = new Song("Boyfriend", 2.10);
		Song song3 = new Song("Suggar", 2.40);
		
		a1.getSongs().addElement(song1);
		a1.getSongs().addElement(song2);
		a1.getSongs().addElement(song3);
		
		company.getAlbums().addElement(a1);
		
		for(int i = 0; i<company.getAlbums().getSize(); i++)
		db.insert((Album)company.getAlbums().getElement(i));
		
		Menu.menu(company);
		 
		

		
	}

}
