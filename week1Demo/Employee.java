package week1Demo;

public class Employee {
	
	//attributes/fields
	private String empName;
	private double hours;
	private double rate;
	
	//constructors
	public Employee() {
		empName = "Unknown";
		hours = 0.0;
		rate = 0.0;
	}
	
	public Employee(String empNameValue, double hoursValue, double rateValue) {
		empName = empNameValue;
		hours = hoursValue;
		rate = rateValue;
	}
	
	//methods
	@Override
	public String toString() {
		return String.format("Name: %s\nHours: %s\nRate: %s",
				this.empName, this.hours, this.rate);
	}
	
	//getters and setters
	public String Name() {return empName;}
	public void setName(String e) {empName = e;}
	public double Hours() {return hours;}
	public void setName(double h) {hours = h;}
	public double Rate() {return rate;}
	public void setRate(double r) {rate = r;}
	
}
