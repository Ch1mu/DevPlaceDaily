package app;

import java.util.Scanner;

import classes.Triangle;
import ownExcercises.*;

public class Program {

	public static void main(String[] args) {
		
		//Triangle triangle = new Triangle(5,5,5);
		//System.out.println(triangle.getType());
		
		//System.out.println(isPrimeIf());
		//System.out.println(isPrimeSwitch());
		
		
	}

	
	//2 exercise, prime numbers
	
	public static boolean isPrimeIf()
	{
		
		Scanner scan = new Scanner(System.in);
		int number;
		
		do 
		{ // do while because i need to check that is a number between 1 and 14
				
		System.out.println(" \n Enter a number beetwen 1 and 14: ");
		number = scan.nextInt();
		
		if(number >14 || number < 1)
			System.out.println("that number doesn't respect the conditions ");
		
		}while (number >14 || number < 1);
		
		if (number == 1) //this number isn't prime, but it's  only divisible between 1 and themself
		 {
			    return false;
		 }
		 for(int i = 2; i<number; i++) 
		 {
			 if(number%i == 0) //here I look if they are divisible by a number between 2 and the number
			 {
				 return false;
			 }
		 }
		
		return true;
	}
	
	
	public static boolean isPrimeSwitch()
	{
		
		Scanner scan = new Scanner(System.in);
		int number;
		
		do 
		{ // do while because i need to check that is a number between 1 and 14
				
		System.out.println(" \n Enter a number beetwen 1 and 14: ");
		number = scan.nextInt();
		if(number >14 || number < 1)
			System.out.println("that number doesn't respect the conditions ");
		
		}while (number >14 || number < 1);
		
		switch (number) {
  
        case 2: return true; //all cases for prime numbers
        case 3: return true;
        case 5: return true;
        case 7: return true;
        case 11: return true;
        case 13: return true;
        default:
            return false;
	}
	
}
}
