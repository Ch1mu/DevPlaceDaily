package app;

import classes.MyStack;

public class Main {

	public static void main(String[] args) {
	System.out.println("a");
	}



	//Excercise 2
	public  static int plusList(int list[] )
	{
		int ans = 0;
		
		for(int i = 0; i<list.length; i++)
		{
			ans+= list[i];
		}
		return ans;
	}
	//Excercise 3
	public static void ShowWithPos(int pos, MyStack stack)
	{
		MyStack aux = new MyStack(stack.getTop());
		for (int i = pos; i>0; i--)
		{
			System.out.println(" [ " + stack.getTopValue() + " ]");
			aux.push(stack.getTopValue());
			stack.pop();
		}
		for (int i = 0; i<aux.getTop(); i++)
		{
			stack.push(aux.getTopValue());
			aux.pop();
		}
	
	}
}