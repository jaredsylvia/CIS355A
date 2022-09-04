package wBuilderTest;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWindow {

	protected Shell shlButtonPresser;
	int buttonPressCount = 0;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
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
		shlButtonPresser.open();
		shlButtonPresser.layout();
		while (!shlButtonPresser.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlButtonPresser = new Shell();
		shlButtonPresser.setSize(441, 170);
		shlButtonPresser.setText("Button Presser");
		
		Label theText = new Label(shlButtonPresser, SWT.NONE);
		theText.setFont(SWTResourceManager.getFont("Calibri", 18, SWT.NORMAL));
		theText.setBounds(10, 33, 382, 48);
		theText.setText("The button has been clicked 0 times.");
		
		Button theButton = new Button(shlButtonPresser, SWT.NONE);
		theButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonPressCount ++;
				theText.setText(String.format("The button has been pressed %s times.", buttonPressCount));
			}
		});
		theButton.setBounds(317, 87, 75, 25);
		theButton.setText("The button.");

	}
}
