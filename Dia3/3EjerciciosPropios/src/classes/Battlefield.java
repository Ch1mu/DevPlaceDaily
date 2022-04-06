package classes;

import java.util.ArrayList;

public class Battlefield {
	private ArrayList<Sith> siths; //row
	private ArrayList<Jedi> jedi; //row
	int sithpoints = 0, jedipoints = 0;
	String name;
	public Battlefield()
	{
		siths = new ArrayList<Sith>();
		jedi = new ArrayList<Jedi>();
	}
	public Battlefield(String name)
	{
		this.name = name;
		siths = new ArrayList<Sith>();
		jedi = new ArrayList<Jedi>();
	}
	
	public void addSith(Character character)
	{
		siths.add((Sith) character);
	}
	public void addJedi(Character character) //we wanted to use InstanceOf but we didn't see it yet
	{
		jedi.add((Jedi) character);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList getAllJedis()
	{
		return this.jedi;
	}
	public ArrayList getAllSith()
	{
		return this.siths;
	}
	public void nextJedi()
	{
		jedi.remove(0);
	}
	public void nextSith()
	{
		siths.remove(0);
	}
	public void fight()
	{
		if(siths.get(0).getPower()>jedi.get(0).getPower())
		{
			System.out.println(siths.get(0).getName() +" Wins");
			sithpoints++;
		}
		else if(siths.get(0).getPower()<jedi.get(0).getPower())
		{
			System.out.println(jedi.get(0).getName() +" Wins");
			jedipoints++;
		}
		else
			System.out.println("TIE");
		
		nextJedi();
		nextSith();
	}

	public void showPoints()
	{
		System.out.println("Jedi: " + jedipoints + "\n Siths: " + sithpoints);
	}
	public void winner()
	{
		if(jedipoints>sithpoints)
		{
			System.out.println("Jedis Wins");
		}
		if(jedipoints<sithpoints)
		{
			System.out.println("Siths Wins");
		}
		if(jedipoints==sithpoints)
		{
			System.out.println("It's a Tie");
		}
		System.out.println("                      .-.\r\n"
				+ "                      |_:_|\r\n"
				+ "                     /(_Y_)\\\r\n"
				+ ".                   ( \\/M\\/ )\r\n"
				+ " '.               _.'-/'-'\\-'._\r\n"
				+ "   ':           _/.--'[[[[]'--.\\_\r\n"
				+ "     ':        /_'  : |::\"| :  '.\\\r\n"
				+ "       ':     //   ./ |oUU| \\.'  :\\\r\n"
				+ "         ':  _:'..' \\_|___|_/ :   :|\r\n"
				+ "           ':.  .'  |_[___]_|  :.':\\\r\n"
				+ "            [::\\ |  :  | |  :   ; : \\\r\n"
				+ "             '-'   \\/'.| |.' \\  .;.' |\r\n"
				+ "             |\\_    \\  '-'   :       |\r\n"
				+ "             |  \\    \\ .:    :   |   |\r\n"
				+ "             |   \\    | '.   :    \\  |\r\n"
				+ "             /       \\   :. .;       |\r\n"
				+ "            /     |   |  :__/     :  \\\\\r\n"
				+ "           |  |   |    \\:   | \\   |   ||\r\n"
				+ "          /    \\  : :  |:   /  |__|   /|\r\n"
				+ "      snd |     : : :_/_|  /'._\\  '--|_\\\r\n"
				+ "          /___.-/_|-'   \\  \\\r\n"
				+ "                         '-'");
	}
	@Override
	public String toString() {
		return "Battlefield [jedi=" + jedi + "]";
	}
	
}
