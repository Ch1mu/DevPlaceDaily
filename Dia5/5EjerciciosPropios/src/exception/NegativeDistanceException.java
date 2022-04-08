package exception;

public class NegativeDistanceException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public NegativeDistanceException()
	{
	super("You can't insert negative distance");	
	}
}
