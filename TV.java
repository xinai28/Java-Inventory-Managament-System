
public class TV extends Product {
	private String screenType;
	private int resolution;
	private int displaySize;
	
	public TV(String name, int quantity, double price, int itemNumber, String screenType, int resolution, int displaySize) {
		super(name, quantity, price, itemNumber);
		this.screenType = screenType;
		this.resolution = resolution;
		this.displaySize = displaySize;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public int getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}
	@Override
	public String toString() {
	    String str = "--------------------------------------------------\n";
	    str += String.format("| Item number           : %-23d|\n", getItem_number());
	    str += "--------------------------------------------------\n";
	    str += String.format("| Product name          : %-23s|\n", getName());
	    str += String.format("| Screen type           : %-23s|\n", getScreenType());
	    str += String.format("| Resolution            : %-23d|\n", getResolution());
	    str += String.format("| Display size          : %-23d|\n", getDisplaySize());  
	    str += String.format("| Quantity available    : %-23d|\n", getQuantityAvailable());
	    str += String.format("| Price (RM)            : %-23.2f|\n", getPrice());
	    str += String.format("| Inventory value (RM)  : %-23.2f|\n", getInventoryValue());
	    str += String.format("| Product status        : %-23s|\n", getStatus() ? "Active" : "Inactive");
	    str += "--------------------------------------------------\n";
	    return str;
	}


	
}
