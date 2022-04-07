package classes;

import exceptions.TooFastException;

public class CargoVehicle extends Vehicle {

	Trailer trailer;

	public CargoVehicle(String plate) {
		super(plate);
		this.trailer = null;
	}
	
	public void addTrailer(Trailer trailer)
	{
		this.trailer = trailer;
	}
	public void removeTrailer()
	{
		this.trailer=null;

	}
	
	
public void accelerate(double acc) throws TooFastException
	{
		if(this.trailer!=null)
		{
			if((this.getVelocity() + acc) >100)
			{
			throw new TooFastException();
			}
		}
		else
			super.accelerate(acc);
	}

	@Override
	public String toString() {
		return "CargoVehicle [Plate= "+ super.getPlate()+", trailer=" + trailer + "]";
	}
	
}
