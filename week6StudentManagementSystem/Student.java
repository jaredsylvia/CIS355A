/********************************************************** 
Program Name: Student.java 
Programmer's Name: Jared Sylvia 
Program Description: Student class containing name and grades 
***********************************************************/
package studentManagementSystem;

import java.util.Random;

public class Student {
	//attributes
	String firstName, lastName;
	double[] grades = {0,0,0};
	
	//constructors
	public Student() {
		Random rand = new Random();
		int randInt = rand.nextInt(1);
		if(randInt == 0);
			firstName = "John";
		if(randInt == 1);
			firstName = "Jane";
		lastName = "Doe";		
		grades[0] = 0.00;
		grades[1] = 0.00;
		grades[2] = 0.00;
	}
	public Student(String fName, String lName, double grade1, double grade2, double grade3) {
		firstName = fName;
		lastName = lName;
		grades[0] = grade1;
		grades[1] = grade2;
		grades[2] = grade3;
	}
	
	//behaviors
	public double getCourseGradeNumeric() {return (grades[0] + grades[1] + grades[2])/3;}
	public String getCourseGradeLetter() {
		if(getCourseGradeNumeric() >= 90) {
			return "A";
		}
		else if(getCourseGradeNumeric() >= 80) {
			return "B";
		}
		else if(getCourseGradeNumeric() >= 70) {
			return "C";
		}
		else if(getCourseGradeNumeric() >= 60) {
			return "D";
		}
		else if(getCourseGradeNumeric() <= 60 ) {
			return "F";
		}
		else {
			return "N/A";
		}
	}
		
	@Override
	public String toString() {return String.format("%s, %s", lastName, firstName);}
	
	//getters and setters
	public void setGrade1(double grade) {grades[0] = grade;}
	public void setGrade2(double grade) {grades[1] = grade;}
	public void setGrade3(double grade) {grades[2] = grade;}
	public void setFirstName(String name) {firstName = name;}
	public void setLastName(String name) {lastName = name;}
	public double[] getGrades() { return grades;}
	public String getFirstName() { return firstName;}
	public String getLastName() { return lastName;}
	
	
	
	
	
}
