package multiTab;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MultiTab {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MultiTab window = new MultiTab();
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
		shell.setSize(450, 175);
		shell.setText("Dynamic Tabs");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 10, 411, 57);
		
		
		
		Button btnOne = new Button(shell, SWT.NONE);
		btnOne.setBounds(10, 85, 75, 25);
		btnOne.setText("Add");
		btnOne.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
				tbtmNewItem.setText(String.valueOf(tabFolder.getItemCount()));
			}
		});
		
		Button btnFour = new Button(shell, SWT.NONE);
		btnFour.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					tabFolder.getItem(tabFolder.getItemCount() - 1).dispose();
				}
				catch(IllegalArgumentException exc) {
					JOptionPane.showMessageDialog(null, "Can't remove a tab that's not there.", "Tab Removal Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnFour.setText("Remove");
		btnFour.setBounds(346, 85, 75, 25);

	}

}
