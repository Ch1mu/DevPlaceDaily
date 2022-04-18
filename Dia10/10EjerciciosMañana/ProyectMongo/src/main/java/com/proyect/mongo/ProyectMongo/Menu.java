package com.proyect.mongo.ProyectMongo;

import java.util.Scanner;

import dataBase.PersonController;
import models.Person;

public class Menu {

public Menu()
{
	
	
}
public static void menu()
{
	Scanner scan = new Scanner(System.in);
	int option;
	boolean flag = true;
	while(flag)
	{
		System.out.println("1- Data Register");
		System.out.println("2- Data Query");
		System.out.println("3- Data Delete");
		System.out.println("4- Data List");
		System.out.println("5- Exit");
		option = scan.nextInt();
		
		switch(option) {
	
		case 1:
			PersonController pc = new PersonController();
			Person person = new Person();
			
			System.out.println("First Name: ");
			scan.nextLine();
			person.setFirstname(scan.nextLine());
			System.out.println("Last Name: ");
			person.setLastname(scan.nextLine());
			System.out.println("DNI: ");
			person.setDni(scan.nextLine());
			System.out.println("Address: ");
			person.setAddress(scan.nextLine());
			
			pc.insertPerson(person);
			break;
		case 2:
			PersonController pc2 = new PersonController();
		System.out.println("Enter Dni: ");
		scan.nextLine();
		
		pc2.getPersonDni(scan.nextLine());
		
			break;
		case 3:
			PersonController pc3 = new PersonController();
		
			System.out.println("Enter DNI: ");
			scan.nextLine();
			
			pc3.deletePerson(scan.nextLine());
			
			break;
		case 4:
			PersonController pc4 = new PersonController();
			
			pc4.getPersons();
			
			break;
		case 5: flag = false;
		break;
		default: System.out.println("Invalid Option");
		break;
		}
	}

}
}
