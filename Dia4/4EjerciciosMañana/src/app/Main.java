package app;

import classes.*;
import exceptions.TooFastException;

public class Main {

	public static void main(String[] args) {
		
		CargoVehicle cargo = new CargoVehicle("asd123");
		Trailer trailer = new Trailer(120);
		cargo.addTrailer(trailer);
		try {
			cargo.accelerate(120);
		} catch (TooFastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println(cargo.toString());
	}

}
