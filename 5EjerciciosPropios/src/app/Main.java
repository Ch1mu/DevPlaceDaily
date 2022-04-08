package app;

import java.util.Scanner;

import classes.*;
import exception.InvalidObjectException;
import exception.NegativeDistanceException;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			Member member = new Member("Matias", "Ramirez", "123", "Human");
			Member captain = new Captain("Lucas", "Rodriguez", "234", "Human");
			SolarSystem s= new SolarSystem();
			
			Planet planet1 = new Planet("Earth", 100, 20);
			Planet planet2 = new Planet("Mars", 200, -2);
			Planet planet3 = new Planet("Pluton", 500, 20);
			
			SpaceShip ship = new SpaceShip("Nave", 100, planet1);
			
			
			
			try {
				ship.add(new Problem("Fractura del casco", 4));
				ship.add(member);
				ship.add(captain);
				s.add(ship);
				s.add(planet1);
				s.add(planet2);
				s.add(planet3);
				
			} catch (InvalidObjectException e) {
			
				e.printStackTrace();
			}
		
			menu(s);
		
			
		} catch (NegativeDistanceException e) {
	
			e.printStackTrace();
		}

	
	
	}

	
	public static void menu(SolarSystem s)
	{
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		int option;
		
		while(!flag)
		{
			System.out.println("1- view planet list");
			System.out.println("2- View Crew members");
			System.out.println("3- Fast Travel");
			System.out.println("4- View Problems");
			System.out.println("5- Fix problems");
			System.out.println("6- View Ships");
			System.out.println("7- Exit Program");
			
			option = scan.nextInt();
			
			switch(option)
			{
			case 1: 
				
				System.out.println(s.getPlanets().toString());
				break;
				
			case 2:
				int op = 0;

				for(int i = 0; i<s.getShips().getSize(); i++)
				{
					System.out.println( (i+1)+ "-  " + s.getShips().getElement(op).getShipName());
				}
				System.out.print("Select a Ship: ");
				op = scan.nextInt() -1;
				System.out.println(s.getShips().getElement(op).getAirCrew().toString());
				break;
				
			case 3:
				int op1 = 0;
				for(int i = 0; i<s.getShips().getSize(); i++)
				{
					System.out.println( (i+1)+ "-  " + s.getShips().getElement(i).getShipName());
				}
				System.out.print("Select a Ship: ");
				op1 = scan.nextInt() -1;
				
				System.out.println(s.getPlanets().toString());
				System.out.print("Select a Planet: ");
				op = scan.nextInt() -1;
				s.getShips().getElement(op1).setLocation(s.getPlanets().getElement(op));
				
				break;
			case 4:
				
				for(int i = 0; i<s.getShips().getSize(); i++)
				{
					System.out.println( (i+1)+ "-  " + s.getShips().getElement(i).getShipName());
				}
				System.out.print("Select a Ship: ");
				op1 = scan.nextInt() -1;
			
				System.out.println(s.getShips().getElement(op1).getProblems().toString());
			
				break;
				
			case 5:
				int problem2fix;
				for(int i = 0; i<s.getShips().getSize(); i++)
				{
					System.out.println( (i+1)+ "-  " + s.getShips().getElement(i).getShipName());
				}
				System.out.print("Select a Ship: ");
				op1 = scan.nextInt() -1;
			
				System.out.println(s.getShips().getElement(op1).getProblems().toString());
				
				System.out.print("Select a Problem to fix: ");
				problem2fix = scan.nextInt() -1;
				
				s.getShips().getElement(op1).fixProblem(problem2fix);
				
				
				break;
			case 6:
				System.out.println(s.getShips().toString());
				break;
			case 7:
				flag = true;
				break;
				default:
					System.out.println("Invalid Option");
					break;
			}
			
		}
	}
}
