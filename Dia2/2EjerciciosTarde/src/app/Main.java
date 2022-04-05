package app;

import classes.*;

public class Main {

	public static void main(String[] args) {
		
		//orderByALetters();
		Keyboards kb = new Keyboards(10, "RedDragon");
	}
	
	//Order by ammount of letters
	public static void orderByALetters()
	{
		
		 String words[] = {"coder", "devplace", "personas", "curso", "alumnado"};
		String aux;
	
		for (int i = 0; i<words.length; i++)
		{
			for(int j = 0; j<words.length;j++)
			{
				if(words[i].length() < words[j].length()) //Sort by the bubble method
				{
					aux = words[j];
					words[j] = words[i];
					words[i] = aux;
					
				}
					
			}
		}
		for(int i = 0; i<words.length; i++)
			System.out.println(words[i]);
	}

}
