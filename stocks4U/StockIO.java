package stocks4U;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.ibm.icu.util.StringTokenizer;

public class StockIO {

	//attributes
	private String fileName;
	private ArrayList<Stock> stocks;
	
	//constructors
	public StockIO() {
		fileName = "stocks.csv";
	}
	
	public StockIO(String fName) {
		setFilename(fName);
	}
	
	//behaviors
	public ArrayList<Stock> getData(){
		ArrayList<Stock> data = new ArrayList<Stock>();
		try {
			BufferedReader inFile = new BufferedReader (new FileReader(fileName));
			String inputLine = "";
			StringTokenizer tokens;
			
			inputLine = inFile.readLine();
			while(inputLine != null) {
				tokens = new StringTokenizer(inputLine, ",");
				String[] nameTicker = new String[2];
				Double[] qtyCosts = new Double[3];
				nameTicker[0] = tokens.nextToken();
				nameTicker[1] = tokens.nextToken();
				qtyCosts[0] = Double.parseDouble(tokens.nextToken());
				qtyCosts[1] = Double.parseDouble(tokens.nextToken());
				qtyCosts[2] = Double.parseDouble(tokens.nextToken());
				data.add(new Stock(nameTicker, qtyCosts));
				inputLine = inFile.readLine();
			}
			inFile.close();
		}
		catch(IOException ex){
			JOptionPane.showMessageDialog(null, "Error: Unable to open file:\n" + ex.getMessage(), fileName, JOptionPane.ERROR_MESSAGE);
		}
		
		
		return data;
	}
	
	public void saveData(ArrayList<Stock> data) {
		try {
			BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
			for(Stock stock: data) {
				outFile.write(String.format("%s,%s,%s,%s,%s\n", 
						stock.getStockName(), stock.getTickerSymbol(), 
						stock.getQuantity(), stock.getPurchPice(), stock.getCurPrice()));
			}
			outFile.close();
		}
		catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: Unable to write to the file:\n" + ex.getMessage(), fileName, JOptionPane.ERROR_MESSAGE);
		}
	}
	//setters and getters
	public String getFilename() {return fileName;}
	public void setFilename(String fName) {
		if(fName.length() > 0) {
			fileName = fName;
		}
		else {
			fileName = "stocks.csv";
		}
	}
	
	
}
