package app;

import java.util.Scanner;

import classes.*;
import factories.AnimalFactory;
import payment.*;

public class Menu {

	public static void menu(Zoo zoo) {
		Scanner scan = new Scanner(System.in);
		int option, payOption, strategy;
		boolean flag = false;
		boolean pay = false;
		Strategy strat;
		
		System.out.println("Before you enter to the zoo you need to pay $10 entrance");
		System.out.println("Do you want to pay for it? ");
		System.out.println("1- Yes \n 2- No ");
		System.out.print("option: ");
		payOption = scan.nextInt();
		switch(payOption)
		{
		case 1:
				System.out.println("Which method do you want to pay with");
				System.out.println(" If you pay with effective you have 10% disccount");
				System.out.println("1- Effective \n 2- Debit Card ");
				System.out.print("option: ");
				strategy = scan.nextInt();
				
				switch(strategy)
				{
				case 1: 
				strat = new Effective();
				pay = strat.pay();
				break;
				case 2:
					strat = new Debit();
					pay = strat.pay();
					break;
				}
				
		case 2: break;
		default: System.out.println("Invalid Option");break;
		}
		
		while(!flag && pay)
		{
			
		
		System.out.println("--------------- MENU ---------------");
		System.out.println("1- Add new animal");
		System.out.println("2- Check Enclosures");
		System.out.println("3- Clean Enclosures");
		System.out.println("4- Exit");
		option = scan.nextInt();
		
	
		switch(option)
		{
		case 1:
			int op1;
			Animal animal;
			System.out.println("1- Lion");
			System.out.println("2- Zebra");
			System.out.println("3- Crocodile");
			System.out.println("4- Penguin");
			System.out.print("option: "); 
			op1 = scan.nextInt(); 
			zoo.addAnimalToEnclosure(AnimalFactory.addAnimal(op1)); 
			
			break;
		case 2:
			System.out.println("1- Lions");
			System.out.println("2- Zebras");
			System.out.println("3- Crocodiles");
			System.out.println("4- Penguins");
			System.out.print("option: "); 
			op1 = scan.nextInt(); 
			
			
			zoo.getEnclosures().getElement(op1-1).randomClean(); //Makes it dirty
			
		System.out.println(zoo.getEnclosures().getElement((op1-1)).getAnimals().toString());
		
		break;
		case 3:
			
			int op2;
			System.out.println("1- Lions");
			System.out.println("2- Zebras");
			System.out.println("3- Crocodiles");
			System.out.println("4- Penguins");
			System.out.print("option: "); 
			op1 = scan.nextInt(); 
			System.out.println(zoo.getEnclosures().getElement(op1-1).isClean());
			if(zoo.getEnclosures().getElement(op1-1).isClean().equals("Dirty"))
			{
				System.out.println("Do you want to clean the Enclosure?");
				System.out.print("1- Yes 2- No: "); 
				op2 = scan.nextInt(); 
	
				if(op2 == 1)
				{
					zoo.getEnclosures().getElement(op1-1).setClean(true);
					System.out.println("Clean complete");
				}
					
					
				
			}
			
			break;
		case 4:
			flag = true;
			default:
				System.out.println("Invalid Option");
				break;
		}
		}
		
		
	}
	
	
}
