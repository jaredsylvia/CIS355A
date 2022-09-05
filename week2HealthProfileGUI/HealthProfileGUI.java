package healthProfile;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

//import healthTracker.HealthProfile;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HealthProfileGUI {

	protected Shell shlHealthProfile;
	private Text textName;
	private Text textAge;
	private Text textWeight;
	private Text textHeightFt;
	private Text textHeightIn;
	private Text textBMI;
	private Text textMaxHeartRate;
	private Text textBMICat;
	private List<HealthProfile> members = new ArrayList<HealthProfile>(); //A list to store all the members. 
	private int currentSelectedMember;
	
	//Method to clear textboxes
	public void clearTextBoxes() {
				textName.setText("");
				textAge.setText("");
				textWeight.setText("");
				textHeightFt.setText("");
				textHeightIn.setText("");
				textBMI.setText("");
				textMaxHeartRate.setText("");
				textBMICat.setText("");
				
			}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HealthProfileGUI window = new HealthProfileGUI();
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
		shlHealthProfile.open();
		shlHealthProfile.layout();
		while (!shlHealthProfile.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHealthProfile = new Shell();      
		shlHealthProfile.setSize(513, 309);
		shlHealthProfile.setText("Health Profile");
		
		
		//Labels
		Label lblName = new Label(shlHealthProfile, SWT.NONE);
		lblName.setBounds(36, 30, 35, 15);
		lblName.setText("Name:");
		
		Label lblAge = new Label(shlHealthProfile, SWT.NONE);
		lblAge.setBounds(36, 75, 70, 15);
		lblAge.setText("Age:");
		
		Label lblHeightft = new Label(shlHealthProfile, SWT.NONE);
		lblHeightft.setBounds(36, 120, 70, 15);
		lblHeightft.setText("Height (ft.):");
		
		Label lblHeightin = new Label(shlHealthProfile, SWT.NONE);
		lblHeightin.setBounds(194, 120, 70, 15);
		lblHeightin.setText("Height (in.)");
		
		Label lblWeightlbs = new Label(shlHealthProfile, SWT.NONE);
		lblWeightlbs.setBounds(194, 75, 70, 15);
		lblWeightlbs.setText("Weight (lbs.)");
		
		Label lblBmi = new Label(shlHealthProfile, SWT.NONE);
		lblBmi.setBounds(36, 165, 55, 15);
		lblBmi.setText("BMI:");
		
		Label lblBmiCategory = new Label(shlHealthProfile, SWT.NONE);
		lblBmiCategory.setBounds(36, 210, 81, 15);
		lblBmiCategory.setText("BMI Category:");
		
		Label lblMaxHeartRate = new Label(shlHealthProfile, SWT.NONE);
		lblMaxHeartRate.setBounds(194, 165, 92, 15);
		lblMaxHeartRate.setText("Max Heart Rate:");
		
		
		//Textboxes
		textName = new Text(shlHealthProfile, SWT.BORDER);
		textName.setBounds(80, 27, 266, 21);
		
		textAge = new Text(shlHealthProfile, SWT.BORDER);
		textAge.setBounds(112, 72, 76, 21);
		
		textWeight = new Text(shlHealthProfile, SWT.BORDER);
		textWeight.setBounds(270, 72, 76, 21);
		
		textHeightFt = new Text(shlHealthProfile, SWT.BORDER);
		textHeightFt.setBounds(112, 114, 76, 21);
		
		textHeightIn = new Text(shlHealthProfile, SWT.BORDER);
		textHeightIn.setBounds(270, 114, 76, 21);
		
		textBMI = new Text(shlHealthProfile, SWT.BORDER);
		textBMI.setBounds(112, 165, 76, 21);
		textBMI.setEditable(false);
		
		textMaxHeartRate = new Text(shlHealthProfile, SWT.BORDER);
		textMaxHeartRate.setBounds(287, 165, 59, 21);
		textMaxHeartRate.setEditable(false);
		
		textBMICat = new Text(shlHealthProfile, SWT.BORDER);
		textBMICat.setBounds(112, 204, 234, 21);
		textBMICat.setEditable(false);
		
		
		//Buttons
		Button btnAdd = new Button(shlHealthProfile, SWT.NONE);
		btnAdd.setBounds(385, 70, 75, 25);
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				boolean userExists = false;
				String error = "";
				int height = 0;
				for (HealthProfile i: members) { // check if name exists on another object, set boolean to trigger dialog
					if(i.getName().toLowerCase().trim().equals(textName.getText().toLowerCase().trim())) {
						userExists = true;
					}
				}
				
				if(textName.getText().equals("")) { //compile all empty fields into single string
					error = "Name";
				}
				
				if(textAge.getText().equals("")) {
					if(!error.equals("")) {
						error = error + ", Age";
					}
					else {
						error = "Age";
					}
				}
				
				if(textWeight.getText().equals("")) {
					if(!error.equals("")) {
						error = error + ", Weight";
					}
					else {
						error = "Weight";
					
					}
				}
					
				if(textHeightFt.getText().equals("")) {
					if(!error.equals("")) {
						error = error + ", Height (ft.)";
					}
					else {
						error = "Height (ft.)";
					
					}
				}
					
				if(textHeightIn.getText().equals("")) {
					if(!error.equals("")) {
						error = error + ", Height (in.)";
					}
					else {
						error = "Height (in.)";					
					}
				}
					
				if(error.equals("") && userExists == false) { // if no empty fields add member object to list
					height = Integer.parseInt(textHeightIn.getText()) + (Integer.parseInt(textHeightFt.getText()) * 12);
					HealthProfile hp = new HealthProfile(textName.getText(), 
							Integer.parseInt(textAge.getText()), 
							Integer.parseInt(textWeight.getText()), 
							height);
					members.add(hp);
					
					JOptionPane.showMessageDialog(null, String.format("%s has been added.", hp.getName()));
					textBMI.setText(String.valueOf(members.get(currentSelectedMember).getBMI()));
					textBMICat.setText(members.get(currentSelectedMember).getCategory());
					textMaxHeartRate.setText(String.valueOf(members.get(currentSelectedMember).getMaxHR()));
					currentSelectedMember = members.indexOf(hp);
				}
				else if(!error.equals("")) {
					JOptionPane.showMessageDialog(null, String.format("The following fields cannot be left blank: %s", error)); //display error with string containing all empty fields
				}
				else if (userExists == true) {
					JOptionPane.showMessageDialog(null, "Member already exists.\nPlease search and update existing record if needed."); // display error if attempting to duplicate member
				}
				
			
			}
			});
				
		
		
		Button btnSearch = new Button(shlHealthProfile, SWT.NONE);
		btnSearch.setBounds(385, 25, 75, 25);
		btnSearch.setText("Search");
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean found = false;
				for (HealthProfile i: members) { //loop through member list
					
					if(i.getName().toLowerCase().trim().equals(textName.getText().toLowerCase().trim())) { // if member object is found display information in text fields
						textName.setText(i.getName());
						textAge.setText(String.valueOf(i.getAge()));
						textWeight.setText(String.valueOf(i.getWeight()));
						textHeightIn.setText(String.valueOf(i.getHeight() % 12));
						textHeightFt.setText(String.valueOf(i.getHeight() / 12));
						textBMI.setText(String.valueOf(i.getBMI()));
						textBMICat.setText(i.getCategory());
						textMaxHeartRate.setText(String.valueOf(i.getMaxHR()));
						found = true;
						currentSelectedMember = members.indexOf(i);
						;
					}
					
				}
				if(found == false) {
					JOptionPane.showMessageDialog(null, "Member not found.");
				}
			}
		
		});
		

		

		
		Button btnUpdate = new Button(shlHealthProfile, SWT.NONE);
		btnUpdate.setBounds(385, 115, 75, 25);
		btnUpdate.setText("Update");
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { //uses object found in search method and updates said object in list
				try {
					if(!textName.getText().equals("")) {
						members.get(currentSelectedMember).setName(textName.getText());	
					}
					
					if(!textAge.getText().equals("")) {
						members.get(currentSelectedMember).setAge(Integer.parseInt(textAge.getText()));				
					}
					
					if(!textWeight.getText().equals("")) {
						members.get(currentSelectedMember).setWeight(Integer.parseInt(textWeight.getText()));	
					}
					
					if(!textHeightFt.getText().equals("") && !textHeightIn.getText().equals("")) {
						int height = Integer.parseInt(textHeightIn.getText()) + (Integer.parseInt(textHeightFt.getText()) * 12);
						members.get(currentSelectedMember).setHeight(height);	
					}
									
					JOptionPane.showMessageDialog(null, String.format("%s has been upated.",members.get(currentSelectedMember).getName()));
					textBMI.setText(String.valueOf(members.get(currentSelectedMember).getBMI()));
					textBMICat.setText(members.get(currentSelectedMember).getCategory());
					textMaxHeartRate.setText(String.valueOf(members.get(currentSelectedMember).getMaxHR()));
				}
				catch(IndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Update failed, no member or invalid member currently selected.", "Warning!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		Button btnDelete = new Button(shlHealthProfile, SWT.NONE);
		btnDelete.setBounds(385, 161, 75, 25);
		btnDelete.setText("Delete");
		btnDelete.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { //removes object found in search method from list
				try {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, String.format("You are about to delete the member \"%s?\"\nThis action is not reversible.\nAre you sure you want to delete %s?",
							members.get(currentSelectedMember).getName(),
							members.get(currentSelectedMember).getName()),
							"Warning",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION) {
						members.remove(currentSelectedMember);
					}
					clearTextBoxes();
				}
				catch(IndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Update failed, no member or invalid member currently selected.", "Warning!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		Button btnClear = new Button(shlHealthProfile, SWT.NONE);
		btnClear.setBounds(385, 204, 75, 25);
		btnClear.setText("Clear");
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clearTextBoxes();
			}
		});

	}
}
