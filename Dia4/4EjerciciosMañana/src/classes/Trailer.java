package classes;

public class Trailer {

	private int weight;

	public Trailer(int weight) {
	
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Trailer [weight=" + weight + "]";
	}
	
	
}
