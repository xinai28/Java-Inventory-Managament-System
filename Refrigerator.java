
public class Refrigerator extends Product {
	private String doorDesign;
	private String color;
	private double capacity;
	
	public Refrigerator(String name, int quantity, double price, int itemNumber, String design, String color, double capacity) {
		super(name, quantity, price, itemNumber);
		doorDesign = design;
		this.color = color;
		this.capacity = capacity;
	}

	public String getDoorDesign() {
		return doorDesign;
	}

	public void setDoorDesign(String doorDesign) {
		this.doorDesign = doorDesign;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
	    String str = "--------------------------------------------------\n";
	    str += String.format("| Item number           : %-22d |\n", getItem_number());
	    str += "--------------------------------------------------\n";
	    str += String.format("| Product name          : %-22s |\n", getName());
	    str += String.format("| Door design           : %-22s |\n", doorDesign);
	    str += String.format("| Color                 : %-22s |\n", color);
	    str += String.format("| Capacity (in Litres)  : %-22.1f |\n", getCapacity());
	    str += String.format("| Quantity available    : %-22d |\n", getQuantityAvailable());
	    str += String.format("| Price (RM)            : %-22.2f |\n", getPrice());
	    str += String.format("| Inventory value (RM)  : %-22.2f |\n", getInventoryValue());
	    str += String.format("| Product status        : %-22s |\n", getStatus() ? "Active" : "Inactive");
	    str += "--------------------------------------------------\n";
	    return str;
	}

}
