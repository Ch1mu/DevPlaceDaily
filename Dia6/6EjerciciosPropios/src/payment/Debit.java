package payment;

public class Debit implements Strategy{

	public Debit() {
		
	}
	
	public boolean pay() {
		
		System.out.println("Total: " + "$10");
		return true;
	}

}
