/********************************************************** 
Program Name: StudentDB.java 
Programmer's Name: Jared Sylvia 
Program Description: GUI Constructor 
***********************************************************/
package studentManagementSystem;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StudentGUI {

	protected Shell shlStudentManagementSystem;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtFirstName;
	private Text txtLastName;
	private Text txtGradeOne;
	private Text txtGradeTwo;
	private Text txtGradeThree;
	private Text txtStudentDetails;
	private StudentDB studentDB = new StudentDB();
	ArrayList<Student> students = new ArrayList<Student>(); 
			
	//private ArrayList<List> students = 

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StudentGUI window = new StudentGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlStudentManagementSystem.open();
		shlStudentManagementSystem.layout();
		while (!shlStudentManagementSystem.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStudentManagementSystem = new Shell();
		shlStudentManagementSystem.setSize(474, 401);
		shlStudentManagementSystem.setText("Student Management System");
		
		TabFolder tabFolder = new TabFolder(shlStudentManagementSystem, SWT.NONE);
		tabFolder.setBounds(10, 10, 447, 343);
		
		TabItem tbtmAddStudent = new TabItem(tabFolder, SWT.NONE);
		tbtmAddStudent.setText("Add Student");
		
		Composite compositeAddStudent = new Composite(tabFolder, SWT.NONE);
		tbtmAddStudent.setControl(compositeAddStudent);
		
		txtFirstName = formToolkit.createText(compositeAddStudent, "New Text", SWT.NONE);
		txtFirstName.setText("");
		txtFirstName.setBounds(195, 45, 190, 21);
		
		txtLastName = formToolkit.createText(compositeAddStudent, "New Text", SWT.NONE);
		txtLastName.setText("");
		txtLastName.setBounds(195, 90, 190, 21);
		
		txtGradeOne = formToolkit.createText(compositeAddStudent, "New Text", SWT.NONE);
		txtGradeOne.setText("");
		txtGradeOne.setBounds(195, 135, 190, 21);
		
		txtGradeTwo = formToolkit.createText(compositeAddStudent, "New Text", SWT.NONE);
		txtGradeTwo.setText("");
		txtGradeTwo.setBounds(195, 180, 190, 21);
		
		txtGradeThree = formToolkit.createText(compositeAddStudent, "New Text", SWT.NONE);
		txtGradeThree.setText("");
		txtGradeThree.setBounds(195, 225, 190, 21);
		
		Label lblFirstName = formToolkit.createLabel(compositeAddStudent, "First Name:", SWT.NONE);
		lblFirstName.setBounds(35, 45, 80, 15);
		
		Label lblLastName = formToolkit.createLabel(compositeAddStudent, "Last Name:", SWT.NONE);
		lblLastName.setBounds(35, 90, 80, 15);
		
		Label lblExamOne = formToolkit.createLabel(compositeAddStudent, "Exam One:", SWT.NONE);
		lblExamOne.setBounds(35, 135, 80, 15);
		
		Label lblExamTwo = formToolkit.createLabel(compositeAddStudent, "Exam Two:", SWT.NONE);
		lblExamTwo.setBounds(35, 180, 80, 15);
		
		Label lblExamThree = formToolkit.createLabel(compositeAddStudent, "Exam Three:", SWT.NONE);
		lblExamThree.setBounds(35, 225, 80, 15);
		
		Button btnAddStudent = formToolkit.createButton(compositeAddStudent, "Add Student", SWT.NONE);
		btnAddStudent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String emptyFields = "";
				if(txtFirstName.getText().isBlank()) {
					emptyFields = "First Name";
				}
				if(txtLastName.getText().isBlank()) {
					if(emptyFields.isBlank()) {
						emptyFields = "Last Name";
					}
					else {
						emptyFields = emptyFields + ", " + "Last Name";
					}
				}
				if(txtGradeOne.getText().isBlank()) {
					if(emptyFields.isBlank()) {
						emptyFields = "Exam One";
					}
					else {
						emptyFields = emptyFields + ", " + "Exam One";
					}
				}
				if(txtGradeTwo.getText().isBlank()) {
					if(emptyFields.isBlank()) {
						emptyFields = "Exam Two";
					}
					else {
						emptyFields = emptyFields + ", " + "Exam Two";
					}
				}
				if(txtGradeThree.getText().isBlank()) {
					if(emptyFields.isBlank()) {
						emptyFields = "Exam Three";
					}
					else {
						emptyFields = emptyFields + ", " + "Exam Three";
					}
				}
				if(!emptyFields.isBlank()) {
					emptyFields = "Please fill ou the following fields: " + emptyFields + ".";
					JOptionPane.showMessageDialog(null, emptyFields, "Check input fields.", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Student student = new Student(txtFirstName.getText(), txtLastName.getText(), 
							Double.parseDouble(txtGradeOne.getText()), 
							Double.parseDouble(txtGradeTwo.getText()),
							Double.parseDouble(txtGradeThree.getText())
							);
				studentDB.addStudent(student);
				txtFirstName.setText("");
				txtLastName.setText("");
				txtGradeOne.setText("");
				txtGradeTwo.setText("");
				txtGradeThree.setText("");
				}
			}
		});
		btnAddStudent.setBounds(310, 280, 75, 25);
		
		TabItem tbtmViewStudents = new TabItem(tabFolder, SWT.NONE);
		tbtmViewStudents.setText("View Students");
		
		Composite compositeViewStudents = new Composite(tabFolder, SWT.NONE);
		compositeViewStudents.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				for(Student student : students) {
					students = studentDB.getAll();
					System.out.println(student.toString());
				}
			}
		});
		tbtmViewStudents.setControl(compositeViewStudents);
		
		ListViewer listViewer = new ListViewer(compositeViewStudents, SWT.BORDER | SWT.V_SCROLL);
		List listStudents = listViewer.getList();
		listStudents.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int studentIndex = listStudents.getSelectionIndex();
				Student currentStudent = students.get(studentIndex);
				String studentDetails = String.format("%s\nExam 1: %s\nExam 2: %s\nExam 3: %s\nCurrent Score: %s\nCurrent Grade: %s", currentStudent.toString(), 
						currentStudent.getGrades()[0],
						currentStudent.getGrades()[1],
						currentStudent.getGrades()[2],
						currentStudent.getCourseGradeNumeric(),
						currentStudent.getCourseGradeLetter());
				txtStudentDetails.setText(studentDetails);
			}
		});
		listStudents.setBounds(10, 10, 420, 100);
		
		txtStudentDetails = formToolkit.createText(compositeViewStudents, "New Text", SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtStudentDetails.setText("");
		txtStudentDetails.setBounds(10, 116, 420, 155);
		
		Button btnUpdate = formToolkit.createButton(compositeViewStudents, "Update", SWT.NONE);
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listStudents.removeAll();
				txtStudentDetails.setText("");
				students = studentDB.getAll();
				for(Student student : students) {
					listStudents.add(student.toString());
				}
			}
		});
		btnUpdate.setBounds(355, 280, 75, 25);

	}
}
