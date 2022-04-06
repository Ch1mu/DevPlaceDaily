package classesEx1;

public class PremiumUser extends User {


	
	public PremiumUser(String name)
	{
		super(name);
		super.premium = true;
	}
	
	public boolean isPremium() {
		return premium;
	}
	
	public boolean download() {
		return true;
	}
	public boolean advertisements()
	{
		return false;
	}
}
