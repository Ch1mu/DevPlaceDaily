package classes;

public class Plane {

	Owner owner;
	String planeName;
	double distance = 0;
	boolean launched = false;
	public Plane(Owner owner, String planeName) {
		
		this.owner = owner;
		this.planeName = planeName;
	}
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getDistance() {
		return distance;
	}
	public String getPlaneName() {
		return planeName;
	}
	public boolean isLaunched() {
		return launched;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	public void launch()
	{
		launched = true;
		System.out.println(planeName + "  is flying");
	}
	
	@Override
	public String toString() {
		return "Owner=" + owner + ", Plane Name= " + planeName + ", Distance=" + distance + ", Launched="
				+ launched;
	}
	
	
	
}
