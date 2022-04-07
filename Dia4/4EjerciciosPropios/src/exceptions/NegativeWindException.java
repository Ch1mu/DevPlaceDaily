package exceptions;

public class NegativeWindException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public NegativeWindException()
	{
		super("You can't enter a negative wind value");
	}
	
}
