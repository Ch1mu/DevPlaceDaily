package app;

import java.util.Scanner;

import classes.Triangle;

public class Program {

	public static void main(String[] args) {
		Triangle triangle = new Triangle(5,5,5);
		System.out.println(triangle.getType());
		
	System.out.println(	isPrime() );

	}

	//2 exercise, prime numbers
	
	public static boolean isPrime()
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
		
		if (number == 1) //that numbers aren't prime, but they are only divisible between 1 and themself
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
	
}
