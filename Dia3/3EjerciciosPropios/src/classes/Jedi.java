package classes;

import interfaces.CombatInterface;

public class Jedi extends Character implements CombatInterface{
	
protected String sableColor;
protected double power;
public Jedi(String sableColor, double power, String name, String race) {
	
	super(name, race);
	this.sableColor = sableColor;
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

@Override
public String toString() {
	return "Jedi [" + super.toString() +"sableColor=" + sableColor + ", power=" + power + "]";
}



	
}
