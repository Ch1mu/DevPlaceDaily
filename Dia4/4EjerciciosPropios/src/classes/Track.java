package classes;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.NegativeWindException;

public class Track {

	ArrayList<Plane> planes = new ArrayList<Plane>();
	int count;
	double wind;
	boolean favourable; //wind direction
	
	public Track(double wind, boolean favourable) throws NegativeWindException {
		
		this.favourable = favourable;
		
		if(wind >= 0)
		this.wind = wind;
		else
			new NegativeWindException();
	}
	
	public void setWind(double wind) throws NegativeWindException
	{
		if(wind >= 0)
			this.wind = wind;
			else
				new NegativeWindException();
	}
	
	public void addPlane(Plane plane) {
		
		planes.add(plane);
	}
	
	
	public boolean launchPlane(int i)
	{
	double velocity, time;
	Scanner scan = new Scanner(System.in);
	
		if(!planes.get(i-1).isLaunched())
		{
			System.out.println("Enter the initial velocity of your plane: ");
			velocity = scan.nextDouble();
			System.out.println("Enter the flight time of your plane: ");
			time = scan.nextDouble();
			
			
			double form = (velocity/2)*time;
			
			if(!favourable)
			form = form - this.wind * 0.1;
			else
				form = form + this.wind * 0.1;
			
			planes.get(i-1).launch();
			planes.get(i-1).setDistance(form);
			count++;
			
		}

	return	this.isFinished();
		
	}
	public boolean isFinished()
	{
		if(count == planes.size())
		{
			this.winner();
			return true;
		}
			
		
		return false;
	}
	
	public void listUnlanchedPlanes()
	{
		for(int i = 0; i<planes.size(); i++)
		{
			if(!planes.get(i).launched)
			{
				System.out.println((i+1)+"- " + planes.get(i).getPlaneName());
			}
		}
		
	}
	public void getOwnerName(String dni)
	{
		var dni2 = "";// VAR USE
		var name = ""; 
		for(int i = 0; i<planes.size(); i++)
		{
			
			dni2  = planes.get(i).getOwner().getDni();
			if(dni2.equals(dni))
			{
				
			System.out.println( planes.get(i).getOwner().getFirstName() + " " + planes.get(i).getOwner().getLastName());
			System.out.println("Plane: " + planes.get(i).getPlaneName());
			}
		}
		
	
	}
	public void listPlanes()
	{
		for(int i = 0; i<planes.size(); i++)
		{
			System.out.println(planes.get(i).toString());
		}
		
	}
	
	public void winner()
	{
		Plane winner = planes.get(0);
		
		for(int i = 0; i<planes.size(); i++)
		{
			if(winner.getDistance() < planes.get(i).getDistance())
			{
				winner = planes.get(i);
			}
		}
		if(winner.getDistance() != 0)
		System.out.println("The winner is: " + winner.getOwner().getFirstName() + " " + winner.getOwner().getLastName() + "\nPlane Name: " + winner.getPlaneName() + ", Distance: " + winner.getDistance());
	}
	
}
