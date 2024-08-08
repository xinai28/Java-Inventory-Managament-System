
public class WashingMachine extends Product{
	private double capacity;
	private String size;
	private int efficiencyRate; //1~5 star
	
	public WashingMachine(String name, int quantity, double price, int itemNumber, double capacity, String size, int efficiencyRate) {
		super(name,quantity,price,itemNumber);
		this.capacity = capacity;
		this.size = size;
		this.efficiencyRate = efficiencyRate;
	}
	
	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getEfficiencyRate() {
		return efficiencyRate;
	}

	public void setEfficiencyRate(int efficiencyRate) {
		this.efficiencyRate = efficiencyRate;
	}

	@Override
	public String toString() {
	    String str = "--------------------------------------------------\n";
	    str += String.format("| Item number           : %-22d |\n", getItem_number());
	    str += "--------------------------------------------------\n";
	    str += String.format("| Product name          : %-22s |\n", getName());
	    str += String.format("| Capacity (in KG)      : %-22.1f |\n", getCapacity());
	    str += String.format("| Size                  : %-22s |\n", getSize());
	    str += String.format("| Efficiency Rate       : %-22d |\n", getEfficiencyRate());
	    str += String.format("| Quantity available    : %-22d |\n", getQuantityAvailable());
	    str += String.format("| Price (RM)            : %-22.2f |\n", getPrice());
	    str += String.format("| Inventory value (RM)  : %-22.2f |\n", getInventoryValue());
	    str += String.format("| Product status        : %-22s |\n", getStatus() ? "Active" : "Inactive");
	    str += "--------------------------------------------------\n";
	    return str;
	}

}

