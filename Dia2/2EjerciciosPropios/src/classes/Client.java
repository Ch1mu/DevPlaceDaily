package classes;

public class Client {

	private String name;
	private int productsAmmount;
	private int line;
	
	public Client(String name, int productsAmmount) {
		
		this.name = name;
		this.productsAmmount = productsAmmount;
		line = -1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getLine() {
		return line;
	}
	public int getProductsAmmount() {
		return productsAmmount;
	}
	public void setProductsAmmount(int productsAmmount) {
		this.productsAmmount = productsAmmount;
	}
	
	
}
