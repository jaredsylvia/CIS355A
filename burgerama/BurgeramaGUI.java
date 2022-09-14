/**************************************************** 
Program Name: Burgerama.java 
Programmer's Name: Jared Sylvia 
Program Description: Generates orders of Burgers
***********************************************************/
package burgerama;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.custom.StyledText;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeListener;

import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BurgeramaGUI {

	protected Shell shell;  // add any item a method needs to change as a static per advice of Eclipse error messages
	static Text textItemPrice;
	static Text textTotal;
	static Text textQtyPrice;
	static Text textOrder;
	static Spinner spinnerQty;
	static Button btnSingle;
	static Button btnDouble;
	static Button btnCheese;
	static Button btnBacon;
	static Button btnMeal;
	static Burger currentBurger = new Burger();
	static List<Burger> burgerOrder = new ArrayList<Burger>();
	
	
	
	public static void updateItemQtyPrice() {    // Quick method to keep individual and qty prices update per line item in %.2f
		textItemPrice.setText(String.format("$%.2f", currentBurger.getCost()));
		textQtyPrice.setText(String.format("$%.2f", (currentBurger.getCost() * Double.parseDouble(spinnerQty.getText()))));
	}
	
	public static void clearSelections(boolean wholeOrder) { // Clear selections
		textItemPrice.setText("");
		textQtyPrice.setText("");
		btnSingle.setSelection(false);
		btnDouble.setSelection(false);
		btnCheese.setSelection(false);
		btnBacon.setSelection(false);
		btnMeal.setSelection(false);
		
		if(wholeOrder == true) {
			textOrder.setText("");
			textTotal.setText("");
		}
		
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BurgeramaGUI window = new BurgeramaGUI();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(900, 543);
		shell.setText("Burgerama Dude");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu fileMenu = new Menu(mntmFile);
		mntmFile.setMenu(fileMenu);
		
		MenuItem mntmExit = new MenuItem(fileMenu, SWT.CASCADE);
		
		mntmExit.setText("Exit");
		
		MenuItem mntmOrder = new MenuItem(menu, SWT.CASCADE);
		mntmOrder.setText("Order");
		
		Menu orderMenu = new Menu(mntmOrder);
		mntmOrder.setMenu(orderMenu);
		
		MenuItem mntmAdd = new MenuItem(orderMenu, SWT.NONE);
		
		mntmAdd.setText("Add To Order");
		
		MenuItem mntmClearForNext = new MenuItem(orderMenu, SWT.NONE);
		mntmClearForNext.setText("Clear For Next Item");
		
		MenuItem mntmNewOrder = new MenuItem(orderMenu, SWT.NONE);
		mntmNewOrder.setText("New Order");
		
		
		Label lblPatties = new Label(shell, SWT.NONE);
		lblPatties.setBounds(50, 30, 100, 15);
		lblPatties.setText("Patties:");
		
		btnSingle = new Button(shell, SWT.RADIO);
		btnSingle.setBounds(75, 50, 90, 16);
		btnSingle.setText("Single");
				
		btnDouble = new Button(shell, SWT.RADIO);
		btnDouble.setBounds(75, 80, 90, 16);
		btnDouble.setText("Double");
		
		
		Label lblFreeToppings = new Label(shell, SWT.NONE);
		lblFreeToppings.setBounds(50, 110, 100, 15);
		lblFreeToppings.setText("Free Toppings:");
		
		ComboViewer comboViewer = new ComboViewer(shell, SWT.NONE);
		Combo comboFreeToppings = comboViewer.getCombo();
		comboFreeToppings.setItems(new String[] {"Mayonnaise", "Mustard", "Ketchup", "Lettuce", "Tomato", "Onion", "Pickle"});
		comboFreeToppings.setBounds(75, 130, 165, 23);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.setBounds(75, 155, 75, 25);
		btnAdd.setText("Add");
		
		Button btnDelete = new Button(shell, SWT.NONE);
		btnDelete.setBounds(165, 155, 75, 25);
		btnDelete.setText("Delete");
		
		Label lblPaidToppings = new Label(shell, SWT.NONE);
		lblPaidToppings.setBounds(50, 200, 100, 15);
		lblPaidToppings.setText("Paid Toppings:");
		
		btnBacon = new Button(shell, SWT.CHECK);
		btnBacon.setBounds(75, 230, 93, 16);
		btnBacon.setText("Bacon");
		
		btnCheese = new Button(shell, SWT.CHECK);
		btnCheese.setBounds(75, 255, 93, 16);
		btnCheese.setText("Cheese");
		
		Label lblMeal = new Label(shell, SWT.NONE);
		lblMeal.setBounds(50, 287, 55, 15);
		lblMeal.setText("Meal:");
		
		btnMeal = new Button(shell, SWT.CHECK);
		btnMeal.setBounds(75, 310, 100, 16);
		btnMeal.setText("Make It A Meal");
		
		textItemPrice = new Text(shell, SWT.BORDER);
		textItemPrice.setBounds(75, 440, 76, 21);
		textItemPrice.setEditable(false);
		
		Label lblQty = new Label(shell, SWT.NONE);
		lblQty.setBounds(50, 345, 55, 15);
		lblQty.setText("Quantity:");
		
		spinnerQty = new Spinner(shell, SWT.BORDER);
		spinnerQty.setPageIncrement(1);
		spinnerQty.setMaximum(10);
		spinnerQty.setMinimum(1);
		spinnerQty.setSelection(1);
		spinnerQty.setBounds(75, 373, 75, 22);
		
				
		Label lblItemPrice = new Label(shell, SWT.NONE);
		lblItemPrice.setBounds(50, 410, 55, 15);
		lblItemPrice.setText("Item Price:");
		
		Label lblTotal = new Label(shell, SWT.NONE);
		lblTotal.setBounds(700, 440, 55, 15);
		lblTotal.setText("Total:");
		
		textTotal = new Text(shell, SWT.BORDER);
		textTotal.setBounds(775, 440, 76, 21);
		textTotal.setEditable(false);
		
		Label lblQuantityPrice = new Label(shell, SWT.NONE);
		lblQuantityPrice.setText("Quantity Price:");
		lblQuantityPrice.setBounds(165, 410, 101, 15);
		
		textQtyPrice = new Text(shell, SWT.BORDER);
		textQtyPrice.setBounds(190, 440, 76, 21);
		textQtyPrice.setEditable(false);
		
		textOrder = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textOrder.setBounds(300, 30, 550, 395);
		textOrder.setEditable(false);
		
		
		//Listeners for Menu items
		mntmAdd.addSelectionListener(new SelectionAdapter() { //add item to order
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnSingle.getSelection() == false && btnDouble.getSelection() == false) {
					JOptionPane.showMessageDialog(null, "Please select number of patties.", "Choose Patties", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					
					for(int i = 1; i <= Double.parseDouble(spinnerQty.getText()); i++) {
						burgerOrder.add(currentBurger);
						textOrder.append(currentBurger.toString());
						textOrder.append("**********\n");
						
					}
					double totalCost = 0.0;
					for(Burger b : burgerOrder) {
						totalCost += b.getCost();
					}
					textTotal.setText(String.format("$%.2f", totalCost));
			
					}
			}
		});
		
		mntmClearForNext.addSelectionListener(new SelectionAdapter() { // clear for next item
			@Override
			public void widgetSelected(SelectionEvent e) {
				currentBurger = new Burger();
				clearSelections(false);
				
			}
		});
		
		mntmNewOrder.addSelectionListener(new SelectionAdapter() { // clear entire order
			@Override
			public void widgetSelected(SelectionEvent e) {
				burgerOrder.clear();
				currentBurger = new Burger();
				clearSelections(true);
			}
		});
		
		mntmExit.addSelectionListener(new SelectionAdapter() { // exit program
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				shell.dispose();
				System.exit(0);
			}
		});
		
		
		//Listeners for object manipulation
		btnSingle.addSelectionListener(new SelectionAdapter() { // single patty
			@Override
			public void widgetSelected(SelectionEvent e) {
				currentBurger.setDouble(false);
				updateItemQtyPrice();
			}
		});
		
		btnDouble.addSelectionListener(new SelectionAdapter() { // double patty
			@Override
			public void widgetSelected(SelectionEvent e) {
				currentBurger.setDouble(true);
				updateItemQtyPrice();	
			}
		});
		
		btnBacon.addSelectionListener(new SelectionAdapter() { // with bacon
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnBacon.getSelection() == true) {
					currentBurger.setBacon(true);
					updateItemQtyPrice();
				}
				else {
					currentBurger.setBacon(false);
					updateItemQtyPrice();
				}
			}
		});
		btnCheese.addSelectionListener(new SelectionAdapter() { // with cheese
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnCheese.getSelection() == true) {
					currentBurger.setCheese(true);
					updateItemQtyPrice();
				}
				else {
					currentBurger.setCheese(false);
					updateItemQtyPrice();
				}
			}
		});
		btnMeal.addSelectionListener(new SelectionAdapter() { // is a meal
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnMeal.getSelection() == true) {
					currentBurger.setMeal(true);
					updateItemQtyPrice();
				}
				else {
					currentBurger.setMeal(false);
					updateItemQtyPrice();
				}
			}
		});
		
		btnAdd.addSelectionListener(new SelectionAdapter() { // add free topping
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(comboFreeToppings.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please select topping.", "Choose Topping", JOptionPane.ERROR_MESSAGE);
				}
				else {
					currentBurger.addTopping(comboFreeToppings.getText());
				}
			}
		});
		
		btnDelete.addSelectionListener(new SelectionAdapter() { // del free topping
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(comboFreeToppings.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please select topping.", "Choose Topping", JOptionPane.ERROR_MESSAGE);
				}
				else {
					currentBurger.delTopping(comboFreeToppings.getText());	
				}
			}
		});
		
		spinnerQty.addSelectionListener(new SelectionAdapter() { // update prices on spinner value change
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateItemQtyPrice();
			}
		});

	}
}
