package classes;

import java.util.ArrayList;

//Excercise 1
public class MyStack<t> {
	int capacity;
int top = -1;
ArrayList<t> array;


public MyStack(int capacity)
{
	array =new ArrayList();
	this.capacity = capacity;
}

public void push(t value)
{
	array.add(value);
	
}
public void pop()
{
	array.remove(top);
}
public int getTop()
{
	return top;
}
public t getTopValue()
{
	return array.get(top);
}
public boolean isEmpty()
{
	if(0 == array.size())
	return  true;
	
	return false;
}
public boolean isFull()
{
	if(capacity == array.size())
	return  true;
	
	return false;
}


}
