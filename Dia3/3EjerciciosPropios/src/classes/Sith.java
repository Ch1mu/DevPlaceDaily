package classes;

import interfaces.CombatInterface;

public class Sith extends Character implements CombatInterface{
	
	protected String sableColor;
	protected double power;
	public Sith( double power, String name, String race) {
		
		super(name, race);
		this.sableColor = "Red";
		this.power = power;
	}
	
	public String getSableColor() {
		return sableColor;
	}

	public void setSableColor(String sableColor) {
		this.sableColor = sableColor;
	}

	public void setPower(double power) {
		this.power = power;
	}

	@Override
	public double getPower() {
		
		return power;
	}
	
}
