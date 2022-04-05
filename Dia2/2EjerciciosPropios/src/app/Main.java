package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import classes.*;

//Excercise: There is a supermarket that needs an administration system to do the functions you think that are necessary to complete this work

public class Main {

	public static void main(String[] args) {
		

		ArrayList<Client> clients = new ArrayList<Client>();
		
		menu(clients);

	}
	
	
	
	
	public static void menu( ArrayList<Client> clients) 
	{
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		int option;
		
		while(flag) {
			
			System.out.println("---------------Menu---------------");
		System.out.println("1- New Client");
		System.out.println("2- Check  waiting lines");
		System.out.println("3- Sort waiting lines by ammount of products");
		System.out.println("4- Wipe lines");
		System.out.println("5- Advance line");
		System.out.println("6- Exit");
		
		option = scan.nextInt();
		
		switch(option) {
		case 1: 
	
			 newClient(clients);
	
		break;
		case 2: 
			
			CheckLines(clients);
			
		break;
		
		case 3:
			
			sortArrayByProducts(clients);
			
			break;
			
		case 4:
			
			clearLines(clients);
			
			break;
			
		case 5:	
			advanceLine(clients);
			break;
			
		case 6:	
			flag = false; 
		break;
	
		
		}
			
		}
		
		
	}
	
	public static void newClient(ArrayList<Client> clients)
	{
		int op;
		String name;
		int ammount;
		Scanner scan = new Scanner(System.in);
		System.out.println("\n Ingrese el nombre del cliente");
		name = scan.nextLine();
		System.out.println("\n Enter Ammount of products");
		ammount = scan.nextInt();
		
		Client client = new Client(name, ammount);
		System.out.println("\n which line do you want to enter?");
		op = scan.nextInt();
		
		client.setLine(op);

		System.out.println(client.getLine());
		clients.add(client);
		
	
	}
	
	public static void sortArrayByLine(ArrayList<Client> clientsOriginal)
	{
		ArrayList<Client>clients = new ArrayList<Client>(clientsOriginal);
		Client aux;
		for (int i = 0; i<clients.size(); i++)
		{
			for(int j = 0; j<clients.size();j++)
			{
				if(clients.get(i).getLine() < clients.get(j).getLine()) //Sort by the bubble method
				{
					aux = clients.get(i);
					clients.set(i, clients.get(j));
					clients.set(j, aux);
					
				}
					
			}
		}
	}
	
	public static void sortArrayByProducts(ArrayList<Client> clientsOriginal)
	{
		ArrayList<Client>clients = new ArrayList<Client>(clientsOriginal);
		
		Client aux;
		for (int i = 0; i<clients.size(); i++)
		{
			for(int j = 0; j<clients.size();j++)
			{
				if(clients.get(i).getProductsAmmount() < clients.get(j).getProductsAmmount()) //Sort by the bubble method
				{
					aux = clients.get(i);
					clients.set(i, clients.get(j));
					clients.set(j, aux);
					
				}
					
			}
		}
		for(int i = 0; i<clients.size(); i++)
		{
			System.out.println("Line: " + clients.get(i).getLine() + ", Name: " + clients.get(i).getName() + ", Ammount of Products: " +clients.get(i).getProductsAmmount() );
		}
	}
	public static void CheckLines(ArrayList<Client> clients)
	{
		sortArrayByLine(clients);
		
		for(int i = 0; i<clients.size(); i++)
		{
			System.out.println("Line: " + clients.get(i).getLine() + ", Name: " + clients.get(i).getName() + ", Ammount of Products: " +clients.get(i).getProductsAmmount() );
		}
	}
	public static void clearLines(ArrayList<Client> clients)
	{
		clients.clear();
	}
	
	public static void advanceLine(ArrayList<Client> clients)
	{
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		int line;
		int i = 0;
		
		System.out.println("\n enter the number of line you want to advance");
		line = scan.nextInt();
		
		while(flag)
		{
			if(clients.get(i).getLine() == line)
			{
				clients.remove(i);
				flag = false;
			}
			i++;
		}
		
	}

}
