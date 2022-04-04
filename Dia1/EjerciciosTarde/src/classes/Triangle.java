package classes;



public class Triangle {

	private float a,b,c;
	
	public  Triangle(float a, float b, float c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String getType()
	{
		int ammount = 0;
		if(a == b )
			ammount++;
		if(a==c)
			ammount++;
		if(c==b)
			ammount++;
		
		if(ammount ==3)
		return	"it's an equilateral triangle";
		if(ammount ==2)
			return "it's an isoceles triangle";
		else
			return "it's an scalene triangle";
	}
	 //Excercise 1: Calculate triangle perimeter 
	   public float  PerimetroTriangulo(){
	        return a+b+c;
	    }
	
}
