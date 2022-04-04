package ownExcercises;

//Excercise3: we are in a supermarket, and there is a nice offer buying Oreos,their price is $80 but
//if you buy more than 3 packs you gain a 5% disscount
//if you buy more than 5 packs you gain a 8% disscount
//and if u buy more than 10 packs you gain 20% disscount
public class Excercise3 {

	public static void main(String[] args) {
		int ammount=4;
      
        System.out.println( calculateFinalPrice(ammount));
       
        
    }
	public static double calculateFinalPrice(int ammount)
	{
		 
	
		double price = ammount * 80; //the price of the oreos without the disscount is 80 
		
		if(ammount >= 3 && ammount<5) 
			price = price*0.95;
		
		if(ammount >= 5 && ammount<10) 
			price = price*price*0.92;
		
		if(ammount >= 10) 
			price = price*0.80;
			
		
		
		return price;
	}
	
}
