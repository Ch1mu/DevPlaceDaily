package app;

import java.util.Scanner;

public class Program {

	

	public static void main(String[] args) {

		//KgCalculator(80, 1.80); //1
		
		//secondGradeEquation(1, -5, 6); //2
		
		//average(12,10,10); //3
		
		//HigherNum(2,1,5); //4
		
		//LowerNum(2,1,5);  //5
		
		//isPalindrome(); //6
	}

	//1
	public static void KgCalculator(double kg, double d)
	{
		
		
		double aux = kg/Math.pow(d, 2);
		
		if(aux < 20 ) //Comparations
			System.out.println("You have a bad shape");
		 if(20<=aux && aux<22)
			 System.out.println("You are underweight");
		 if(aux >= 22 && aux<25)
		System.out.println("You are in a normal weight");
		 if(aux >= 25 && aux<30)
				System.out.println("You are overweight");
		 if(aux >= 30 && aux<40)
				System.out.println("You have chronic  overweight");
		 if( aux>40)
				System.out.println("You must be Hospitalized");
	}
	
	//2
	public static void secondGradeEquation(int a, int b, int c)
	{
		double  x1, x2;
		double aux = Math.pow(b, 2) - 4*a*c;
		if(aux == 0)
			System.out.println("\n there is a double root ");
		if(aux > 0)
			System.out.println("\n the roots are differents ");
		if(aux < 0)
			System.out.println("\n there are a double imaginary roots ");
		
		x1 = ((-b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a); //Second grade equation form = (-b +- sqrt(pow(b, 2) - 4*a*c)) /2
		x2 = ((-b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		System.out.println("\n X1 = " +x1 + " X2 = " +x2);
		
	}
	
	//3
	public static void average(float a, float b, float c)
	{
		
		float  res;
	
		res = (a+b+c) /3;
		if(res< 10 )
			System.out.println("Reprobates");
		 if (res>=10 && res<15 )
			 System.out.println("Passed");
		 if(res>15)
			 System.out.println("Exempted");
			
		
	}
	
	//4
	public static void HigherNum(int a, int b, int c)
	{
	int  res;

		res = a;
		if(b>res) //if b higher tan A then b is the higher
			res =b;
		
		if(c>res)//but if C is higher than  b, then res = c
			res =c;
			
		System.out.println("\n  The highest number is: " + res);
		
	}
	
	//5
		public static void LowerNum(int a, int b, int c)
		{
			int res;
			
			res = a;
			if(b<res) //if b Lower  tan A then b is the Lower
				res =b;
			
			if(c<res)//but if C is Lower than  b, then res = c
				res =c;
				
			System.out.println("\n  The lower number is: " + res);
			
		}
		
		//6
		
		public static void isPalindrome()
		{
			int number, palindrome = 0, copy, aux;
			Scanner scan = new Scanner(System.in);
			System.out.println("\n Enter a number to check if is a palindromic one");
			number = scan.nextInt();
			
			 copy =number;    //i copy the original number to don't lose it
			  while(number>0)
			  {    
			   aux=number%10;  // getting the number
			   palindrome=(palindrome*10) + aux;    //multiply by 10 to after add the next number
			   number=number/10;    //passing to next number
			  }    
			  
			  if(copy == palindrome)    
			   System.out.println("is a  palindrome  ");    
			  else    
			   System.out.println("isn't a  palindrome");    
			}  
		
		
}
