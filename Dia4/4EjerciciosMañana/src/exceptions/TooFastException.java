package exceptions;

public class TooFastException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	public TooFastException()
	{
	super("this vehicle it's too fast");

	}
}
