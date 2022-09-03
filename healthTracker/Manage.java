/**************************************************** 
Program Name: Manage.java 
Programmer's Name: Jared Sylvia 
Program Description: This class manages the creation and modification of members 
***********************************************************/
package healthTracker;
import java.util.*;

public class Manage {
	//Attributes / fields
	private static List<HealthProfile> members = new ArrayList<HealthProfile>(); //A list to store all the members. 
	private static Scanner scnr = new Scanner ( System.in );
	
	//methods
	public static void mainMenu() { // Generates the main menu
		String selectedOption = "";
		while(!selectedOption.equals("X")) {
			System.out.println("Welcome to HealthStatsRUs.");
			System.out.println("A health statistics tracking app by GymsRUs");
			System.out.println("Please choose from the following options:");
			System.out.println("(A)dd a new member.");
			System.out.println("(D)elete a member.");
			System.out.println("(V)iew/Edit a member.");
			System.out.println("(L)ist members.");
			System.out.println("E(x)it.");
			selectedOption = scnr.nextLine().toUpperCase();
			
			if(selectedOption.equals("A")) {addMember();}
			if(selectedOption.equals("D")) {delMember();}
			if(selectedOption.equals("V")) {viewMember();}
			if(selectedOption.equals("L")) {listMembers();}
			
		}
		return;
	}
	public static void addMember() { //Takes user input, constructs HealthProfile object, adds to list.
		
		String name;
		int age;
		int weight;
		int height;
		System.out.println("Name:");
		name = scnr.nextLine();
		System.out.println("Age:");
		age = Integer.parseInt(scnr.nextLine());
		System.out.println("Weight in pounds:");
		weight = Integer.parseInt(scnr.nextLine());
		System.out.println("Height in inches:");
		height = Integer.parseInt(scnr.nextLine());
		HealthProfile hp = new HealthProfile(name, age, weight, height);
		members.add(hp);
		System.out.println(String.format("%s has been added.",  hp.getName()));
		
		
	}
	
	public static void delMember() { //Calls list member method, deletes selected member
		listMembers();
		System.out.println("Enter member number to delete: ");
		int selectedMember = (Integer.parseInt(scnr.nextLine()) - 1);
		String name = members.get(selectedMember).getName();
		members.remove(selectedMember);
		System.out.println(String.format("%s has been deleted.", name));
		
		
	}
	
	public static void viewMember() { //Calls list member method, views, and allows for editing
		listMembers();
		System.out.println("Enter member number to view or edit: ");
		int selectedMember = Integer.parseInt(scnr.nextLine()) - 1;
		String selectedOption = "";
		while(!selectedOption.equals("R")) {
			System.out.println(members.get(selectedMember).toString());
			System.out.println("Edit (N)ame, (A)ge, (W)eight, (H)eight, (L)ookup new member, (R)eturn to main menu:");
			selectedOption = scnr.nextLine().toUpperCase();
			if(selectedOption.equals("N")) {
				System.out.println("Name: ");
				members.get(selectedMember).setName(scnr.nextLine());
				
			} 
			if (selectedOption.equals("A")) {
				System.out.println("Age: ");
				members.get(selectedMember).setAge(Integer.parseInt(scnr.nextLine()));
				
			}
			if (selectedOption.equals("W")) {
				System.out.println("Weight: ");
				members.get(selectedMember).setWeight(Integer.parseInt(scnr.nextLine()));
				
			}
			if (selectedOption.equals("H")) {
				System.out.println("Height: ");
				members.get(selectedMember).setHeight(Integer.parseInt(scnr.nextLine()));
			}
			if (selectedOption.equals("L")) {
				viewMember();
			}
			
		
			
		}
		
	}
	
	public static void listMembers() { // Lists all objects in list of HealthProfiles.
		int optNum = 1;
		for (HealthProfile i: members) {
			System.out.print(optNum + ") ");
			System.out.println(i.getName());
			optNum += 1;
		}
		
	}
	
	// getters and setters (nothing to set, just to get)
	public List<HealthProfile> getMembers() {
		return members;
	}
}
