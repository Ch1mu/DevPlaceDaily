package app;

import java.util.ArrayList;
import java.util.Scanner;

import classes.*;

public class Main {

	public static void main(String[] args) {

		ArrayList<Jedi>jedis = new ArrayList<Jedi>();
		ArrayList<Sith>sith = new ArrayList<Sith>();
		Battlefield battlefield = new Battlefield();
		Jedi jedi1 = new Jedi("Blue", 140,"Obiwan Kenobi","Human");
		Jedi jedi2 = new Jedi("Blue", 150,"Anakin Skywalker","Human");
		Jedi jedi3 = new Jedi("Blue", 100,"Ahsoka","Human");
		Jedi jedi4 = new Jedi("Green", 180,"Yoda","Unknown");
		Jedi jedi5 = new Jedi("Laser Gun", 110,"Han solo","Human");
		Sith sith1 = new Sith(165, "Darth Vader", "Cyborg");
		Sith sith2 = new Sith(125, "Palpatine", "Human");
		Sith sith3 = new Sith(155, "Darth Maul", "Zabrak");
		Sith sith4 = new Sith(145, "Grievous", "Kaleesh");
		Sith sith5 = new Sith(130, "Dookur", "Human");
		jedis.add(jedi1);
		jedis.add(jedi2);
		jedis.add(jedi3);
		jedis.add(jedi4);
		jedis.add(jedi5);
		sith.add(sith1);
		sith.add(sith2);
		sith.add(sith3);
		sith.add(sith4);
		sith.add(sith5);
	menu(battlefield,jedis, sith);
		
		
	}
	public static void menu(Battlefield battle,ArrayList<Jedi>jedis, ArrayList<Sith>sith)
	{
		Scanner scan = new Scanner(System.in);
		int option;
		boolean flag = true;
		System.out.println("----Welcome to star wars fights-----");
		System.out.println("     _                                     __  \r\n"
				+ "    | |                                   /  | \r\n"
				+ " ___| |_ __ _ _ ____      ____ _ _ __ ___ `| | \r\n"
				+ "/ __| __/ _` | '__\\ \\ /\\ / / _` | '__/ __| | | \r\n"
				+ "\\__ \\ || (_| | |   \\ V  V / (_| | |  \\__ \\_| |_\r\n"
				+ "|___/\\__\\__,_|_|    \\_/\\_/ \\__,_|_|  |___/\\___/\r\n"
				+ "                                               ");
		
		while(flag)
		{
			
		
		System.out.println("\n\n 1- Select Characters to fight");
		System.out.println(" 2- Points");
		System.out.println(" 3- End Game");
		option = scan.nextInt();
	
		switch(option)
		{
		
		case 1: 
			
			int option2, option1;
			System.out.println("Jedis: ");
			for(int i = 0; i<jedis.size(); i++)
			{
				System.out.println("\n" + (i+1) +"- " + jedis.get(i).getName());
			}
			option1 = scan.nextInt();
			System.out.println("n Siths: ");
			
			for(int i = 0; i<sith.size(); i++)
			{
				System.out.println("\n" + (i+1) +"- " + sith.get(i).getName());
			}
			option2 = scan.nextInt();
			
			
			battle.addJedi(jedis.get(option1-1));
			battle.addSith(sith.get(option2-1));
			battle.fight();
		break;
		case 2:
			battle.showPoints();
			
			break;
			
		case 3: 
			battle.winner();
			flag = false;
			
	break;
			default: System.out.println("Enter a valid Option"); break;
		}
		}
		
	}
	
	

}
