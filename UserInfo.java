import java.util.Scanner;

public class UserInfo {
	private String name;
	private String userId;
	
	public void promptName() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your full name: ");
		
		name = input.nextLine();
		
		generateUserId();
	}
	
	public boolean containsSpaces() {
		return name.contains(" ");
	}

	public void generateUserId() {
		if(!containsSpaces()) {
			userId = "guest";
			return;
		}
			
		String[] _name = name.split(" "); //split the name with spaces
		userId = _name[0].charAt(0) + _name[_name.length - 1]; //index 0 is the firstname, the last index (length - 1) is the surname
	}
	

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}
	
	public String toString() {
		String str = "";
		str += "User ID\t: " + getUserId();
		str += "\nName\t: " + getName();
		
		return str;
	}
}


