package payment;

public class Effective implements Strategy{
public Effective()
{
	
}
	public boolean  pay() {
		
		System.out.println("Total: $" + 10*0.9);
		return true;
	}

}
