package payment;

public class Effective implements Strategy{
	private boolean verif = false;
public Effective()
{
	
}
	public void  pay() {
		
		System.out.println("Total: $" + 10*0.9);
		verif = true;
	}
	public boolean getVerif()
	{
		return verif;
	}

}
