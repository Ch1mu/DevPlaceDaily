package app;

import java.util.Scanner;

import database.dbController;
import models.*;

public class Menu {

	public static void menu(RecordCompany company)
	{
		dbController db = new dbController();
		Scanner scan = new Scanner(System.in);
		int option;
		boolean flag = true;
		
		while(flag)
		{
			System.out.println("-------- Menu -------- ");
			System.out.println("1- Check all Artist");
			System.out.println("2- Check all Albums");
			System.out.println("3- Check all Songs");
			System.out.println("4- Exit");
			option = scan.nextInt();
			switch(option) {
			case 1:
				
				db.selectArtist();
				
				break;
				
			case 2:
				db.selectAlbums();
				break;
			case 3:
				db.selectSongs();
				break;
			case 4:
				flag = false;
				break;
				default: System.out.println("Invalid Option");
			}
		}
	
	}
}
