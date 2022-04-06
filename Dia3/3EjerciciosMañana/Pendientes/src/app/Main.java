package app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int info[] []= new int[5][4];
		String names[] []= new String[5][4];
		
		//CountrysAndCities(info, names); //Enter names
		//printAll(info, names); //view all (names and ids)
		Hangman();
		//numbersGame();
	}

	//Exercise 4
	
	public static void CountrysAndCities(int info[] [], String names[] [])
	{
		String country;
		
		String city;
		int aCity = 0;
		Scanner scan = new Scanner(System.in);
		for(int i =0; i<5; i++)
		{
			System.out.println("\n Enter a country name: ");
			names[i][0] = scan.nextLine();
			info[i][0] = i+1;
		}
		for(int i =0; i<5; i++)
		{
			for(int j = 0; j<3; j++)
			{
				aCity++;
				System.out.println("\n Enter a city for: " + names[i][0]);
				names[i][j+1] = scan.nextLine();
				info[i][j+1] =aCity;
			}
			
		}

	}
	public static void printAll(int info[] [], String names[] [])
	{
		for(int i =0; i<5; i++)
		{
			System.out.println("\n");
			for(int j = 0; j<4; j++)
			{
				System.out.print(" [ " + names[i][j] + " ]");
			}
		}
		for(int i =0; i<5; i++)
		{
			System.out.println("\n");
			for(int j = 0; j<4; j++)
			{
				System.out.print(" [ " + info[i][j] + " ]");
			}
		}
			}
	
	//Excercise 5
	
	public static void Hangman ()
	{
		Scanner scan = new Scanner(System.in);
		String p1, p2, word ="", hint = "";
		int op  =6, trys = 0;
		int i = 0;
		char letters[] = new char[20];
		boolean win = false, flag = false;
		int p1points = 0, p2points = 0;
		int t = 1
				;
		
		
		System.out.println("Player one: ");
		p1 = scan.nextLine();
		System.out.println("\n Player two: ");
		p2 = scan.nextLine();
		
		if(p1points ==3)
			System.out.println("Player 1 wins");
		if(p2points ==3)
			System.out.println("Player 2 wins");
		
		while(p1points < 3 || p2points<3)
		{
			
			
		
		if(t == 1)
		{
		
				System.out.println("\n Player one enter a WORD: ");
				word = scan.nextLine();
				System.out.println("\n Player one enter a HINT: ");
				hint = scan.nextLine();
		}
		else if(t == 2)
		{
			System.out.println("\n Player two enter a WORD: ");
			word = scan.nextLine();
			System.out.println("\n Player two enter a HINT: ");
			hint = scan.nextLine();
		}
	
		
	
		
		while(op > 0 && win == false)
		{
			
			System.out.println("Opportunities left: " + op);
			System.out.println("Hint: " + hint);
			System.out.println("\n Player two enter a Letter: ");
			letters[i] = scan.next().charAt(0);
			
			
			for(int j = 0; j<word.length(); j++)
			{
				if(letters[i] == word.charAt(j))
				{
					System.out.println("That's it \n");
					flag = true;
				}
			}
			if(flag ==true)
			{
				trys++;
			flag = false;
			}
			else
				op--;
			
			if(trys == word.length())
				win = true;
			
			i++;
		}
		if(op == 0)
		{
			System.out.println("Game over You lose");
			
			if(t == 1)
			{
				p1points++;
				t = 2;
			}
			
			else if(t == 2)
			{
				p2points++;
				t = 1;
			}
				
		}
		
		if(win == true)
		{
			System.out.println("Game over You Win");
			if(t == 1)
			{
				p2points++;
				t = 2;
			}
				
			else if(t == 2)
			{
				p1points++;
				t = 1;
			}
			
		}
			
		
		System.out.println("All letters you enter: ");
		for(int x = 0; x<letters.length; x++)
			System.out.print(" [ " + letters[x] + " ]");
		scan.nextLine();
	}
	}
	
	//Excercise 6
	
	public static void numbersGame()
	{
		Scanner scan = new Scanner(System.in);
		int p1[] = new int[4];
		double p1points = 0;
		double p2points = 0;
		double p3points = 0;
		int p2[] = new int[4];
		int p3[] = new int[4];
		int num1, num2;
		
		for(int i = 0; i<4; i++)
		{
			System.out.println("Player 1 enter a number: ");
			p1[i] = scan.nextInt();
		}
		for(int i = 0; i<4; i++)
		{
			System.out.println("Player 2 enter a number: ");
			p2[i] = scan.nextInt();
		}
		for(int i = 0; i<4; i++)
		{
			System.out.println("Player 3 enter a number: ");
			p3[i] = scan.nextInt();
		}
		System.out.println("Referee Please insert your first number: ");
		num1  = scan.nextInt();
		System.out.println("Referee Please insert your second number: ");
		num2  = scan.nextInt();
		
		System.out.println("\n Player 1: ");
		for(int i = 0; i<4; i++)
		{
		
			if((p1[i] < num1 && p1[i] > num2) || (p1[i] > num1 && p1[i] < num2))
			{
				p1points++;
				System.out.print(" [ "+p1[i]+" ]");
			}
		}
			System.out.println("\n Player 2: ");
			for(int i = 0; i<4; i++)
			{
			if((p2[i] < num1 && p2[i] > num2) || (p2[i] > num1 && p2[i] < num2))
			{
				p2points++;
				System.out.print(" [ "+p2[i]+" ]");
			}
			}
			System.out.println("\n Player 3: ");
			for(int i = 0; i<4; i++)
			{
			if((p3[i] <= num1 && p3[i] >= num2) || (p3[i] >= num1 && p3[i] <= num2))
			{
				p3points++;
				System.out.print(" [ "+p3[i]+" ]");
			}
			}
		System.out.println("The numbers were: " +num1 +" and "+ num2);
		System.out.println("Player1 average= " + p1points/4);
		System.out.println("Player2 average= " + p2points/4);
		System.out.println("Player3 average= " + p3points/4);
		
		System.out.println("\n\n Player 1 Numbers: ");
		
		for(int i = 0; i<4; i++)
		{
		System.out.print(" [ "+p1[i] + " ]");
		
		}
System.out.println("\n Player 2 Numbers: ");
		
		for(int i = 0; i<4; i++)
		{
		System.out.print(" [ "+p2[i] + " ]");
		
		}
System.out.println(" \nPlayer 3 Numbers: ");
		
		for(int i = 0; i<4; i++)
		{
		System.out.print(" [ "+p3[i] + " ]");
		
		}
	
	

}
}
	

