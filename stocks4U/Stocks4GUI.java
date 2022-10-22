/**************************************************** 
Program Name: Stocks4Gui.java 
Programmer's Name: Jared Sylvia 
Program Description: Generates GUI and handles some GUI logic 
***********************************************************/

package stocks4U;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.TabFolder;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class Stocks4GUI {

	protected Shell shlStocksuPortfolioManagement;
	private Text textTicker;
	private Text textName;
	private Text textProfitLoss;
	private Text textStockNameInput;
	private Text textTickerInput;
	private Text textQtyInput;
	private Text textPurPriceInput;
	private Text textCurPriceInput;
	private ArrayList<Stock> allStocks = new ArrayList<Stock>();
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Stocks4GUI window = new Stocks4GUI();
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
		shlStocksuPortfolioManagement.open();
		shlStocksuPortfolioManagement.layout();
		while (!shlStocksuPortfolioManagement.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStocksuPortfolioManagement = new Shell();
		shlStocksuPortfolioManagement.setMaximumSize(new Point(420, 300));
		shlStocksuPortfolioManagement.setMinimumSize(new Point(420, 300));
		shlStocksuPortfolioManagement.setSize(420, 300);
		shlStocksuPortfolioManagement.setText("Stocks4U Portfolio Management");
		
		TabFolder tabFolder = new TabFolder(shlStocksuPortfolioManagement, SWT.NONE);
		tabFolder.setBounds(7, 10, 391, 244);
		
		TabItem tbtmStockList = new TabItem(tabFolder, SWT.NONE);
		tbtmStockList.setText("Stock List");
		
		Composite compositeStockList = new Composite(tabFolder, SWT.NONE);
		tbtmStockList.setControl(compositeStockList);
		
		Label lblStockString = new Label(compositeStockList, SWT.NONE);
		lblStockString.setAlignment(SWT.CENTER);
		lblStockString.setBounds(10, 191, 353, 15);
		
		List listStocks = new List(compositeStockList, SWT.BORDER);
		listStocks.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				int tickerIndex = listStocks.getSelectionIndex();
				String tickerLookup = listStocks.getItem(tickerIndex);
				for(Stock stock : allStocks) {
					if (stock.getTickerSymbol().equals(tickerLookup)){
						textName.setText(stock.getStockName());
						textTicker.setText(stock.getTickerSymbol());
						textProfitLoss.setText(String.valueOf(stock.getProfitLoss()));
						if(stock.getProfitLoss() == 0) {
							textProfitLoss.setForeground(new Color(null, 0, 0, 0));
							lblStockString.setForeground(new Color(null, 0, 0, 0));
						}
						else if(stock.getProfitLoss() > 0) {
							textProfitLoss.setForeground(new Color(null, 0, 204, 0));
							lblStockString.setForeground(new Color(null, 0, 204, 0));
						}
						else if(stock.getProfitLoss() < 0) {
							textProfitLoss.setForeground(new Color(null, 204, 0, 0));
							lblStockString.setForeground(new Color(null, 204, 0, 0));
						}
						lblStockString.setText(stock.toString());
					}
				}
				
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				int tickerIndex = listStocks.getSelectionIndex();
				String tickerLookup = listStocks.getItem(tickerIndex);
				for(Stock stock : allStocks) {
					if (stock.getTickerSymbol().equals(tickerLookup)){
						textName.setText(stock.getStockName());
						textTicker.setText(stock.getTickerSymbol());
						textProfitLoss.setText(String.valueOf(stock.getProfitLoss()));
						if(stock.getProfitLoss() == 0) {
							textProfitLoss.setForeground(new Color(null, 0, 0, 0));
							lblStockString.setForeground(new Color(null, 0, 0, 0));
						}
						else if(stock.getProfitLoss() > 0) {
							textProfitLoss.setForeground(new Color(null, 0, 204, 0));
							lblStockString.setForeground(new Color(null, 0, 204, 0));
						}
						else if(stock.getProfitLoss() < 0) {
							textProfitLoss.setForeground(new Color(null, 204, 0, 0));
							lblStockString.setForeground(new Color(null, 204, 0, 0));
						}
						lblStockString.setText(stock.toString());
					}
				}
			}
		});
		
		listStocks.setBounds(10, 10, 221, 164);
		
		Label lblTicker = new Label(compositeStockList, SWT.NONE);
		lblTicker.setBounds(237, 68, 55, 15);
		lblTicker.setText("Ticker:");
		
		Label lblName = new Label(compositeStockList, SWT.NONE);
		lblName.setBounds(237, 20, 55, 15);
		lblName.setText("Name:");
		
		Label lblProfitloss = new Label(compositeStockList, SWT.NONE);
		lblProfitloss.setBounds(237, 116, 76, 15);
		lblProfitloss.setText("Profit/Loss:");
		
		textName = new Text(compositeStockList, SWT.BORDER);
		textName.setEditable(false);
		textName.setBounds(237, 41, 126, 21);
		
		textTicker = new Text(compositeStockList, SWT.BORDER);
		textTicker.setEditable(false);
		textTicker.setBounds(237, 89, 126, 21);
		
		textProfitLoss = new Text(compositeStockList, SWT.BORDER);
		textProfitLoss.setEditable(false);
		textProfitLoss.setBounds(237, 134, 126, 21);
		
		
		
		TabItem tbtmAddStock = new TabItem(tabFolder, SWT.NONE);
		tbtmAddStock.setText("Add Stock");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmAddStock.setControl(composite);
		
		Label lblStockName = new Label(composite, SWT.NONE);
		lblStockName.setBounds(10, 25, 90, 15);
		lblStockName.setText("Stock Name:");
		
		Label lblQuantity = new Label(composite, SWT.NONE);
		lblQuantity.setBounds(10, 75, 90, 15);
		lblQuantity.setText("Quantity:");
		
		Label lblPurchasePrice = new Label(composite, SWT.NONE);
		lblPurchasePrice.setBounds(10, 100, 90, 15);
		lblPurchasePrice.setText("Purchase Price:");
		
		Label lblCurrentPrice = new Label(composite, SWT.NONE);
		lblCurrentPrice.setBounds(10, 125, 90, 15);
		lblCurrentPrice.setText("Current Price:");
		
		textStockNameInput = new Text(composite, SWT.BORDER);
		textStockNameInput.setBounds(133, 25, 150, 21);
		
		textTickerInput = new Text(composite, SWT.BORDER);
		textTickerInput.setText("");
		textTickerInput.setBounds(133, 50, 150, 21);
		
		Label lblTickerInput = new Label(composite, SWT.NONE);
		lblTickerInput.setText("Ticker:");
		lblTickerInput.setBounds(10, 50, 90, 15);
		
		textQtyInput = new Text(composite, SWT.BORDER);
		textQtyInput.setText("");
		textQtyInput.setBounds(133, 75, 150, 21);
		
		textPurPriceInput = new Text(composite, SWT.BORDER);
		textPurPriceInput.setText("");
		textPurPriceInput.setBounds(133, 100, 150, 21);
		
		textCurPriceInput = new Text(composite, SWT.BORDER);
		textCurPriceInput.setText("");
		textCurPriceInput.setBounds(133, 125, 150, 21);
		
		Button btnAddStock = new Button(composite, SWT.NONE);
		btnAddStock.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					listStocks.add(textTickerInput.getText());
					String[] nameTicker = new String[2];
					Double[] qtyCosts = new Double[3];
					if(!textStockNameInput.getText().equals("") && !textStockNameInput.getText().equals("")) {
						nameTicker[0] = textStockNameInput.getText();
						nameTicker[1] = textTickerInput.getText();
					}
					else {
						JOptionPane.showMessageDialog(null, "Please ensure all fields contain values.", "Check input fields.", JOptionPane.ERROR_MESSAGE);
						return;
					}
					qtyCosts[0] = Double.parseDouble(textQtyInput.getText());
					qtyCosts[1] = Double.parseDouble(textPurPriceInput.getText());
					qtyCosts[2] = Double.parseDouble(textCurPriceInput.getText());
					allStocks.add(new Stock(nameTicker, qtyCosts));
					}
				catch(NumberFormatException exc) {
					JOptionPane.showMessageDialog(null, "Please ensure quantity and prices are numeric.", "Check input fields.", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAddStock.setBounds(208, 152, 75, 25);
		btnAddStock.setText("Add Stock");
		
		Menu menu = new Menu(shlStocksuPortfolioManagement, SWT.BAR);
		shlStocksuPortfolioManagement.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmSavectrls = new MenuItem(menu_1, SWT.NONE);
		mntmSavectrls.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String fileName = JOptionPane.showInputDialog("Enter file name: ");
				StockIO outputFileName = new StockIO(fileName);
				outputFileName.saveData(allStocks);
			}
		});
		mntmSavectrls.setText("Save (Ctrl+S)");
		
		MenuItem mntmOpenctrlo = new MenuItem(menu_1, SWT.NONE);
		mntmOpenctrlo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String fileName = JOptionPane.showInputDialog("Enter file name: ");
				StockIO inputFileName = new StockIO(fileName);
				allStocks = inputFileName.getData();
				for(Stock stock : allStocks) {
					listStocks.add(stock.getTickerSymbol());
				}
			}
		});
		mntmOpenctrlo.setText("Open (Ctrl+O)");
		
		MenuItem mntmExitctrlx = new MenuItem(menu_1, SWT.NONE);
		mntmExitctrlx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		mntmExitctrlx.setText("Exit (Ctrl+X)");
		
	}
}
