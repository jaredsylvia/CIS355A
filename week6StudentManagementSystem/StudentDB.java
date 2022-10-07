/********************************************************** 
Program Name: StudentDB.java 
Programmer's Name: Jared Sylvia 
Program Description: MySQL connection and data manipulation 
***********************************************************/

package studentManagementSystem;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDB {
	//attributes
	String server, database, port, user, password;
	Connection conn;
	ArrayList<Student> students;
	
	
	//constructors
	public StudentDB() {
		server = "localhost";
		database = "students";
		port = "3306";
		user = "cis355a";
		password = "cis355a";
		conn = null;
		createTables();
	}
	
	public StudentDB(String server, String database, String port, String user, String password) {
		this.server = server;
		this.database = database;
		this.port = port;
		this.user = user;
		this.password = password;
		conn = null;
		createTables();
	}

	//behaviors
	private boolean openDB() {  //Opens the database.
		String url = String.format("jdbc:mysql://%s:%s/%s", server, port, database); //formats URL from supplied variables
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);  //connects to SQL server
			return true;			
		}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return false;
		}
	}
	
	private boolean closeDB() { // Closes the database.
		try {
			conn.close();
			return true;
		}
		catch (SQLException e) {
			return false;
		}
	}
	
	private boolean createTables() {
		openDB();
		String sql = "CREATE TABLE if not exists students " +
				"(studentid int NOT NULL AUTO_INCREMENT," +
				"firstName VARCHAR(32)," +
				"lastName VARCHAR(32)," +
				"grade1 DOUBLE," +
				"grade2 DOUBLE," +
				"grade3 DOUBLE," +
				"PRIMARY KEY(studentid)" +
				")";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			closeDB();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addStudent(Student student) {
		openDB();
		String sql = String.format("INSERT INTO students (firstName, lastName, grade1, grade2, grade3) VALUES (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", 
				student.getFirstName(),
				student.getLastName(),
				student.getGrades()[0],
				student.getGrades()[1],
				student.getGrades()[2]);
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			closeDB();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
				
	}
	
	private ArrayList<Student> queryServer(){ //do not call if you have unsaved information
		ArrayList<Student> students = new ArrayList<Student>();
		openDB();
		try {
			String sql = "SELECT * FROM students";   
			Statement stmt = conn.createStatement(); 
			ResultSet results = stmt.executeQuery(sql); // execute select all from table 
						
			while(results.next()) {						//while loop to iterate over each entry
				students.add(new Student(results.getString(2), results.getString(3), results.getDouble(4), results.getDouble(5), results.getDouble(6)));
			}
			closeDB();
			
			
		}
		catch (SQLException e){
			
		}
		this.students = students;
		return students;
	}
	
	//getters and setters
	public String getServer() { return server;}
	public String getDatabase() { return database;}
	public String getPort() {return port;}
	public String getUser() {return user;}
	public ArrayList<Student> getAll() {return queryServer();}
	public void setServer(String s) {
		if(!s.isBlank()) {
			server = s;
		}
		else {
			server = "localhost";
		}
	}
	
	public void setDatabase(String d) {
		if(!d.isBlank()) {
			database = d;
		}
		else {
			database = "students";
		}
	}
	
	public void setPort(String p) {
		if(!p.isBlank()) {
			port = p;
		}
		else {
			port = "3306";
		}
	}
	
	public void setUser(String u) {
		if(!u.isBlank()) {
			user = u;
		}
		else {
			user = "cis355a";
		}
	}
	
	public void setPass(String p) {
		if(!p.isBlank()) {
			password = p;
		}
		else {
			password = "cis355a";
		}
	}
	
}
