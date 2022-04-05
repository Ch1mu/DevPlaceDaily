package classes;

import Interfaces.ConectionInterface;
import Interfaces.SoundInterface;

public  class Keyboards  implements ConectionInterface, SoundInterface {

	int ammountKeycaps;
	String model;
	
	public Keyboards(int ammountKeycaps, String model) {
		
		this.ammountKeycaps = ammountKeycaps;
		this.model = model;
	}
	public int getAmmountKeycaps() {
		return ammountKeycaps;
	}
	public void setAmmountKeycaps(int ammountKeycaps) {
		this.ammountKeycaps = ammountKeycaps;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public boolean Connect() {
		
		return true;
	}
	@Override
	public String sound() {
		
		return "tack";
	}
	
	
}
