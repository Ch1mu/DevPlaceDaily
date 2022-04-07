package app;

import java.util.Scanner;

import classes.*;
import exceptions.NegativeWindException;

public class Main {

	public static void main(String[] args) {
		
		Owner owner1 = new Owner("Lukita", "Perez", "123");
		Owner owner2 = new Owner("Jorge", "Rodriguez", "234");
		Owner owner3 = new Owner("Carlos", "Almendra", "345");
		Owner owner4 = new Owner("Julian", "Ramirez", "456");
		Plane plane1 = new Plane(owner1, "El avionazo");
		Plane plane2 = new Plane(owner2, "La nave");
		Plane plane3 = new Plane(owner3, "el volador");
		Plane plane4 = new Plane(owner4, "Rayo Mcqueen");
		
	try {
		Track track = new Track(10, true);
		track.addPlane(plane1);
		track.addPlane(plane2);
		track.addPlane(plane3);
		track.addPlane(plane4);
		
		menu(track);
		
	} catch (NegativeWindException e) {
		e.printStackTrace();
	}


	}
	
	public static void menu(Track track)
	{
		System.out.println("------ Paper Plane Torunament ------");
		
		
		Scanner scan = new Scanner(System.in);
		var flag = false; //VAR USE
		int option;
		while(!flag)
			{
			System.out.println("\n------ Menu ------\n");
			System.out.println("1- Watch Planes");
			System.out.println("2- Launch Planes");
			System.out.println("3- Look for an Owner");
			System.out.println("4- Finish");
			option = scan.nextInt();
			
			switch(option)
			{
			case 1: 
				track.listPlanes();
				break;
			case 2: 
			
				track.listUnlanchedPlanes();
				int op = scan.nextInt();
				flag = track.launchPlane(op);
				break;
			case 3:
				String dni;
				System.out.println("Enter Owner Dni");
			scan.nextLine();
				dni = scan.nextLine();
				track.getOwnerName(dni);
				
				
			break;
			case 4: 
				track.winner();
				flag = true;
			break;
			default:
				
				System.out.println("Invalid option!");
			break;
			}
			
			}
		
		
	}

}
