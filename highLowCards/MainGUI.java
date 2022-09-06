package highLow;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;



import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainGUI {
	
	
	
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainGUI window = new MainGUI();
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
		final String imgPath = "/highLow/cardImages/";
		Game game = new Game();
		
		shell = new Shell();
		shell.setSize(444, 461);
		shell.setText("Higher/Lower");
		
		Label lblWins = new Label(shell, SWT.NONE);
		lblWins.setBounds(323, 176, 55, 15);
		lblWins.setText("Wins: ");
		
		Label lblLosses = new Label(shell, SWT.NONE);
		lblLosses.setBounds(323, 206, 55, 15);
		lblLosses.setText("Losses: ");
		
		Label lblTies = new Label(shell, SWT.NONE);
		lblTies.setText("Ties: ");
		lblTies.setBounds(323, 236, 55, 15);
		
		Label lblCardImage = new Label(shell, SWT.NONE);
		Card currentCard = game.getCurrentCard();
		lblCardImage.setImage(SWTResourceManager.getImage(MainGUI.class, imgPath + currentCard.getFilename()));
		lblCardImage.setBounds(38, 33, 250, 350);
		
		Button btnHigher = new Button(shell, SWT.NONE);
		btnHigher.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				game.nextIsHigher();
				Card currentCard = game.getCurrentCard();
				lblCardImage.setImage(SWTResourceManager.getImage(MainGUI.class, imgPath + currentCard.getFilename()));
				lblWins.setText(String.format("Wins: %s", game.getWins()));
				lblLosses.setText(String.format("Losses: %s", game.getLosses()));
				lblTies.setText(String.format("Ties: %s", game.getTies()));
				
			}
		});
		btnHigher.setBounds(323, 84, 75, 25);
		btnHigher.setText("Higher");
		
		Button btnLower = new Button(shell, SWT.NONE);
		btnLower.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				game.nextIsLower();
				Card currentCard = game.getCurrentCard();
				lblCardImage.setImage(SWTResourceManager.getImage(MainGUI.class, imgPath + currentCard.getFilename()));
				lblWins.setText(String.format("Wins: %s", game.getWins()));
				lblLosses.setText(String.format("Losses: %s", game.getLosses()));
				lblTies.setText(String.format("Ties: %s", game.getTies()));
			}
		});
		btnLower.setBounds(323, 130, 75, 25);
		btnLower.setText("Lower");
		
		
		
		
		
		Button btnNewGame = new Button(shell, SWT.NONE);
		btnNewGame.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				game.newGame();
				Card currentCard = game.getCurrentCard();
				lblCardImage.setImage(SWTResourceManager.getImage(MainGUI.class, imgPath + currentCard.getFilename()));
				lblWins.setText("Wins: ");
				lblLosses.setText("Losses: ");
				lblTies.setText("Ties: ");
			}
		});
		btnNewGame.setBounds(323, 273, 75, 25);
		btnNewGame.setText("New Game");
		
		Button btnAddDiscards = new Button(shell, SWT.NONE);
		btnAddDiscards.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnAddDiscards.setBounds(323, 304, 75, 25);
		btnAddDiscards.setText("Add Discards");
		
		

	}

}
