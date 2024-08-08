import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StockManagement {
	// Get integer input with certain range only
	public static int getInput(Scanner input, String message, int min, int max) {
		while(true) {
			try {
				System.out.print(message);
				int value = Integer.parseInt(input.nextLine());
				if(value < min || value > max) {
					System.out.println("Please only enter valid value!");
				}else {
					return value;
				}
			}
			catch(Exception e) {
				System.out.println("Please only enter Integers!");
			}
		}
	}
	
	//get input and validate their type and throw error
	public static String getInput(Scanner input, String type) {
		while(true) {
			String value;
			try {
				if(type.toLowerCase() == "int") {
					value = String.valueOf(input.nextInt()); //get int value
					input.nextLine();
				}
				else if(type.toLowerCase() == "double") {
					value = String.valueOf(input.nextDouble()); //get double value
					input.nextLine();
				}
				else {
					return input.nextLine(); //get string by default
				}
				return value;
			}
			catch (Exception e){
				System.out.println("Invalid input. Please reenter a " + type + " value!");
				input.nextLine(); //clear the buffer
			}
		}
	}
	
	
	public static int getMaxProduct(Scanner input) {
		System.out.println("How many products to store? : ");
		int value = Integer.parseInt(getInput(input, "int"));
		
		if(value < 0) { //value must be more than 0
			System.out.println("Enter only positive values!");
			return 0;
		}
		return value;
	}
	
	public static int selectProduct(Product[] arr, Scanner input) {
		for(int i = 0; i < arr.length; i++) { //loop through all the product
			System.out.println(i + ". " + arr[i].getName());
		}
		return getInput(input, "Please select a product: ", 0, arr.length - 1); //return the choice of the user
	}
	
	public static int displayMenu(Scanner input) {
		System.out.println("----------------------------");
		System.out.println("|          Menu            |");
		System.out.println("----------------------------");
		System.out.println("|1.| View products         |");
		System.out.println("|2.| Add stock             |");
		System.out.println("|3.| Deduct stock          |");
		System.out.println("|4.| Discontinue Product   |");
		System.out.println("|0.| Exit                  |");
		System.out.println("----------------------------");
		return getInput(input, "Please enter a menu option: ", 0, 4); // allow users to select only 0-4
	}
	
	
	public static void addStock(Product [] arr, Scanner input) {
		int productSelected = selectProduct(arr, input);
		int value = getInput(input,"How many quantity to add: ", 0, Integer.MAX_VALUE); //allow any positive value only
		arr[productSelected].addQuantityAvailable(value);
	}
	
	public static void deductStock(Product [] arr, Scanner input) {
		int productSelected = selectProduct(arr, input);
		int value = getInput(input,"How many quantity to deduct: ", 0, Integer.MAX_VALUE); //allow positive value only
		arr[productSelected].deductQuantityAvailable(Math.min(value, arr[productSelected].getQuantityAvailable())); //math.min to choose the minimum deduct value incase the given value is larger than the stock
	}
	
	
	public static void setStatus(Product [] arr, Scanner input) {
		int productSelected = selectProduct(arr, input);
		arr[productSelected].setStatus(false);
	}
	
	public static void handleMenu(int choice, Product [] arr, Scanner input) {
		switch(choice) {
			case 0:
				break;
			case 1:
				displayContents(arr);
				break;
			case 2:
				addStock(arr, input);
				break;
			case 3:
				deductStock(arr, input);
				break;
			case 4:
				setStatus(arr, input);
				break;
			default:
				break;
		};
	}
	
	public static void addProduct(Product [] arr, Scanner input, int index) {
		System.out.println("1. Refrigerator");
		System.out.println("2. TV");
		System.out.println("3. Washing Machine");
		int choice = getInput(input, "Choose a product to add: ", 1, 3);

		if(choice == 1) addRefrigerator(arr, input, index);
		else if(choice == 2) addTV(arr, input, index);
		else if(choice == 3) addWashMachine(arr , input , index );
	}
	
	public static void addRefrigerator(Product [] arr, Scanner input, int index) {
		String name, design, color;
		double capacity, price;
		int quantityAvailable, itemNumber;

		System.out.println("Enter the product name: ");
		name = input.nextLine();

		System.out.println("Enter the door design: ");
		design = input.nextLine();

		System.out.println("Enter the color: ");
		color = input.nextLine();

		System.out.println("Enter the capacity (in Litres): ");
		capacity = Double.parseDouble(getInput(input, "double"));

		System.out.println("Enter the quantity available: ");
		quantityAvailable = Integer.parseInt(getInput(input, "int"));

		System.out.println("Enter the price: ");
		price = Double.parseDouble(getInput(input, "double"));

		System.out.println("Enter the item number: ");
		itemNumber = Integer.parseInt(getInput(input, "int"));
		
		Refrigerator temp = new Refrigerator(name, quantityAvailable, price, itemNumber, design, color, capacity);
		
		arr[index] = temp; //assign the new product in the array
	}
	
	public static void addTV(Product [] arr, Scanner input, int index) {
		String name, screenType;
		double price;
		int resolution, displaySize, quantityAvailable, itemNumber;
		
		System.out.println("Enter the product name: ");
		name = input.nextLine();

		System.out.println("Enter the screen type: ");
		screenType = input.nextLine();

		System.out.println("Enter the resolution: ");
		resolution = Integer.parseInt(getInput(input, "int"));

		System.out.println("Enter the display size: ");
		displaySize = Integer.parseInt(getInput(input, "int"));

		System.out.println("Enter the quantity available: ");
		quantityAvailable = Integer.parseInt(getInput(input, "int"));

		System.out.println("Enter the price: ");
		price = Double.parseDouble(getInput(input, "double"));

		System.out.println("Enter the item number: ");
		itemNumber = Integer.parseInt(getInput(input, "int"));
		
		TV temp = new TV(name, quantityAvailable, price, itemNumber, screenType, resolution, displaySize);
		
		arr[index] = temp; //assign the new product in the array
	}
	
	public static void addWashMachine(Product [] arr, Scanner input, int index){
		String name , size;
		double price, capacity;
		int quantityAvailable, itemNumber , efficiencyRate;

		System.out.println("Enter the product name: ");
		name = input.nextLine();

		System.out.println("Enter the capacity (in KG): ");
		capacity = Double.parseDouble(getInput(input, "double"));

		while (true) {
            System.out.println("Enter the size (S/M/L/XL): ");
            size = input.nextLine();
        
            if (size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter only S, M, L, or XL.");
            }
        }
		
		while(true) {
			System.out.println("Enter the efficiency rate (1~5 star): ");
			efficiencyRate = Integer.parseInt(getInput(input, "int"));
			
			if(efficiencyRate >= 1 && efficiencyRate<=5) break;
			else
				System.out.println("Invalid Input. Please enter in range 1~5.");
		}

		System.out.println("Enter the quantity available: ");
		quantityAvailable = Integer.parseInt(getInput(input, "int"));

		System.out.println("Enter the price: ");
		price = Double.parseDouble(getInput(input, "double"));

		System.out.println("Enter the item number: ");
		itemNumber = Integer.parseInt(getInput(input, "int"));
		
		WashingMachine temp = new WashingMachine(name, quantityAvailable, price, itemNumber, capacity, size, efficiencyRate);
		
		arr[index] = temp; //assign the new product in the array

	}
	
	public static void displayContents(Product [] arr) {
		for(Product product : arr) {
			System.out.println(product.getClass().getName()); //prints the type of product
			System.out.println(product.toString()); //print product details
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm").format(Calendar.getInstance().getTime());
		Scanner input = new Scanner(System.in);
		UserInfo user = new UserInfo();
		System.out.println("Current date and time: " + timeStamp);
		System.out.println("------------------------------------------------------------");
        System.out.println("         Welcome to the Stock Management System (SMS)        ");
        System.out.println("------------------------------------------------------------");
        System.out.println("We're here to streamline your inventory and stock operations.");
        System.out.println("Our team is dedicated to providing efficient solutions.");
        System.out.println("Feel free to explore and manage your products with ease.");
		
		String[] groupMembers = {"BONG XIN AI", "CHIA AN", "LEE JING YONG", "WONG JENN SEN"};
		Arrays.sort(groupMembers);
		System.out.println("\n-------------------------------------------------------------");
        System.out.println("                         Members                            ");
		System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < groupMembers.length; i++) {
            System.out.println((i + 1) + ". " + groupMembers[i]);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Feel free to contact us if you have any inquiry.");
        System.out.println("-------------------------------------------------------------");

		user.promptName();
		
		
		int choice;
		do {
			System.out.println("\n--------------------");
			System.out.println("|1.| Add product   |");
			System.out.println("|0.| Exit          |");
			System.out.println("--------------------");

			choice = getInput(input, "Please enter a menu option: ", 0, 1);
			
			if(choice == 0) break;
			
			int count = getMaxProduct(input);
			
			Product arr[] = new Product[count];
			
			for(int i = 0; i < count; i++) {
				System.out.println("Item " + (i+1));
				addProduct(arr, input, i);
			}
			
			int menuChoice = displayMenu(input);
			
			while(menuChoice != 0) {
				handleMenu(menuChoice, arr, input);
				menuChoice = displayMenu(input);
			}
			choice = 0;
		}
		while(choice != 0);
		
		System.out.println("Goodbye user, here are your details!");
		System.out.println("Name: " + user.getName());
		System.out.println("UserId: " + user.getUserId());		
	}
}
