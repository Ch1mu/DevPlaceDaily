package classes;

import java.io.File;
import java.util.ArrayList;

public class GenArray <t>   {

	ArrayList<t> array;
	
	public GenArray()
	{
		array = new ArrayList();
	}
	
	public int getSize()
	{
		return array.size();
	}
	public t getElement(int i)
	{
		return array.get(i);
	}
	
	public void addElement( t element)
	{
		array.add(element);
	}
	public void remove (int pos)
	{
		array.remove(pos);
	}
	public ArrayList getArray()
	{
		return this.array;
	}
	
	
	
	@Override
	public String toString() {
		String list = "";
	for(int i = 0; i<this.getSize(); i++)
	{
		list +=(i+1) +"- " + this.getElement(i) + "\n" ;
	}
	return list;
	}
	
	

}

