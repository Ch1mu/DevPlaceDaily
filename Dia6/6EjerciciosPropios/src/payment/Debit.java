package payment;

public class Debit implements Strategy{
	private boolean verif = false;
	public Debit() {
		
	}
	
	public void pay() {
		
		System.out.println("Total: " + "$10");
		verif = true;
	}
public boolean getVerif()
{
	return verif;
}


}
