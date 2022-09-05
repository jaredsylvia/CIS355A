/**************************************************** 
Program Name: HealthProfile.java 
Programmer's Name: Jared Sylvia 
Program Description: Class to create health profile for gym customer 
***********************************************************/
package healthProfile;

public class HealthProfile {
	
	// attributes / fields
	private String name;
	private int age;
	private int weight;  //both these measurements could be float
	private int height;  //but when the doctor or the dmv records them they're ints

	//constructors
	public HealthProfile () {
		name = "Unknown";
		age = 0;
		weight = 0;
		height = 0;
	}
	
	public HealthProfile (String n, int a, int w, int h) {
		name = n;
		age = a;
		weight = w;
		height = h;
	}
		
	//behaviors
	@Override
	public String toString() { //Override to generate output as defined in rubric
		
		return String.format("Primary heealth statistics for %s:\nAge: %s\nWeight: %s\nHeight: %s\n\n"
				+ "Health Profile for %s:\nBMI: %s\nBMI Category: %s\nMax heart rate: %s",
				name, age, weight, getHeightString(), name, getBMI(), getCategory(), getMaxHR());
	}
	
	//getters and setters
	public void setName(String n) {name = n;}
	public void setAge(int a) {age = a;}
	public void setWeight(int w) {weight = w;}
	public void setHeight(int h) {height = h;}
	public String getName() {return name;}
	public int getAge() {return age;}
	public int getWeight() {return weight;}
	public int getHeight() {return height;}
	public String getHeightString() { return String.format("%s'%s\"", height / 12, height % 12);}
	public double getBMI() {
		double bmi = (weight * 703)/(height*height);
		return bmi;
	}
	
	public String getCategory() {
		if (getBMI() < 18.5) {return "Underweight";	}
		else if (getBMI() >= 18.5 && getBMI() <=24.9) {return "Normal";}
		else if (getBMI() >=25  && getBMI() <=29.9) {return "Overweight";}
		else if (getBMI() >= 30) {return "Obese";}
		else {return "Unknown";}
	}
	
	public int getMaxHR() {
		return 220 - age;
	}
}
