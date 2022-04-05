package app;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//calculator();
		lowerCaseLetters();
		//numbers();
	}
	
	//Excercise 1
	public static void calculator()
	{
		Scanner scan = new Scanner(System.in);
		String option ;
		boolean flag = true;
		double num1, num2, ans;
		
		System.out.println("-----CALACULATOR---- \n");
		System.out.println("\n Enter the first Number: ");
		num1 = scan.nextDouble();
		System.out.println("\n Enter the Second Number: ");
		num2 = scan.nextDouble();
		
		while(flag)
		{
			System.out.println("- Press [m] to multiply -");
			System.out.println("- Press [p] to plus -");
			System.out.println("- Press [s] to substract -");
			System.out.println("- Press [d] to divide -");
			scan.nextLine();
			option = scan.nextLine();
		
			switch(option)
			{
		
			
			case "m": ans = num1 * num2; 
			System.out.println("The result is: " + ans);
			flag = false; 
			break;
			
			case "p": ans = num1 + num2; 
			System.out.println("The result is: " + ans);
			flag = false;
			break;
			
			case "s": ans = num1 - num2; 
			System.out.println("The result is: " + ans);
			flag = false;
			break;
			
			case "d": ans = num1 / num2;
			System.out.println("The result is: " + ans);
			flag = false;
			break;
			
			default: System.out.println("Incorrect Option!");
			break;
			
			}
			
			
		
		}
	}
	
	//Excercise 2
	public static void lowerCaseLetters()
	{
	
		for(int i = 'a'; i<='z'; i++)
				System.out.print((char)i +"- ");
			
		
		
	}
	
	
	//Excercise 3
	public static void numbers()
	{
		Scanner scan = new Scanner(System.in);
		
		int[] numbers = new int[10];
		
		int[] pair = new int[10];
		int pairr = 0;
		
		int odd[];
		odd = new int[10];
		int oddd = 0;
		
		int asc[];
		asc = new int[10];
		
		
		int desc[];
		desc = new int[10];
		int descc = 0;
		
		
		
		for(int i = 0; i<numbers.length; i++)
		{
			System.out.println("\n Enter a number: ");
			numbers[i] = scan.nextInt();
		}
		
		int max = numbers[0];
		int low  = numbers[0];
		
		for(int i = 0; i<10; i++)
		{
			if (max< numbers[i]) //Highest num
				max = numbers[i];
			
			if (low> numbers[i]) //Lower num
				low = numbers[i];
			
			if(numbers[i]%2 == 0) //pair
			{
				pair[pairr] = numbers[i];
				pairr++;
			}
			if(numbers[i]%2 != 0) //odd
			{
				odd[oddd] = numbers[i];
				oddd++;
			}
				
		}
		asc = Arrays.stream(numbers).sorted().toArray(); //Ascendant array
		
		for(int i = 9; i>=0; i--) //I took ascendant array and enter the numbers from behind
		{
			
			desc[descc] = asc[i];
			descc++;
		}
		
		
		System.out.print("\n Highest Number: " + max);
		System.out.print("\n Lower Number: " + low);
		System.out.print("\n Pair Numbers: " );
		for(int i=0; i<pair.length; i++)
			if(pair[i] != 0)
			System.out.print("[" + pair[i] +"] ");
		System.out.print("\n Odd Numbers: ");
		for(int i=0; i<odd.length; i++)
			if(odd[i] != 0)
			System.out.print("["+odd[i]+"] ");
		
		System.out.println("\n Ascendant Numbers: ");
		for(int i=0; i<asc.length; i++)
			System.out.print("["+asc[i]+"] ");
		System.out.println("\n Descendant Numbers: ");
		for(int i=0; i<desc.length; i++)
			System.out.print("["+desc[i]+"] ");
	}
	
	
	//Excercise 4
	
	

}

