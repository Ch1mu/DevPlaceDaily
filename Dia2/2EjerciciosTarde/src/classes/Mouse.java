package classes;

import Interfaces.*;


public class Mouse implements ConectionInterface, SoundInterface {

	String model;
	int dpi;
	
	public Mouse(String model, int dpi) {
		
		this.model = model;
		this.dpi = dpi;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDpi() {
		return dpi;
	}

	public void setDpi(int dpi) {
		this.dpi = dpi;
	}
	
	

	@Override
	public boolean Connect() {
		
		return true;
	}

	@Override
	public String sound() {
		return "Click";
	}
	
	
}
