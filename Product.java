public abstract class Product {
	private String name;
	private double price;
	private int quantityAvailable;
	private int item_number;
	private boolean status;
	
	public Product () {
		status = true;
		quantityAvailable = 0;
		price = 0.0;
	}
	
	public Product(String name, int quantity, double price, int itemNumber) {
		quantityAvailable = quantity;
		this.name = name;
		this.price = price;
		this.status = true;
		this.item_number = itemNumber;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public int getItem_number() {
		return item_number;
	}

	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getInventoryValue() {
		return price * quantityAvailable;
	}
	
	public void addQuantityAvailable(int quantity) {
		if(status) quantityAvailable += quantity; // we can only add quantity for active product
		else System.out.println("Cannot add new quantity into discontinued product");
	}
	
	public void deductQuantityAvailable(int quantity) {
		quantityAvailable -= quantity;
	}
	
	
	public String toString() {
		String str = "";
		str += "Item number            :" + getItem_number();
		str += "\nProduct name         :" + getName();
		str += "\nQuantity available   :" + getQuantityAvailable();
		str += "\nPrice (RM)           :" + String.format("%.2f", getPrice());
		str += "\nInventory value (RM) :" + String.format("%.2f", getInventoryValue());
		str += "\nProduct status       :" + (getStatus() ? "Active" : "Inactive");
		
		return str;
	}
}
