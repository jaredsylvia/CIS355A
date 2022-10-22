/**************************************************** 
Program Name: Stock.java 
Programmer's Name: Jared Sylvia 
Program Description: Stock class 
***********************************************************/

package stocks4U;

public class Stock {
	//attributes
	private String sName;
	private String ticker;
	private double qty;
	private double purchPrice;
	private double curPrice;
	private double profitLoss;
	
	//constructors
	//default
	public Stock() {
		sName = "unknown";
		ticker = "unkn";
		qty = 0.0;
		purchPrice = 0.0;
		curPrice = 0.0;
		calcProfLoss();
	}
	//with String and double arrays.
	public Stock(String[] names, Double[] values) {
		//set parameters based on length
		if(names.length >= 1) {
			sName = names[0];
			ticker = "unkn";
			qty = 0.0;
			purchPrice = 0.0;
			curPrice = 0.0;
		}
		if(names.length >= 2) {
			ticker = names[1];
			qty = 0.0;
			purchPrice = 0.0;
			curPrice = 0.0;
		}
		if(values.length >= 1) {
			qty = values[0];
			purchPrice = 0.0;
			curPrice = 0.0;
		}
		if(values.length >= 2) {
			purchPrice = values[1];
			curPrice = 0.0;
		}
		if(values.length >= 3) {
			curPrice = values[2];
		}
		
		calcProfLoss();
	}
	
	//behaviors
	public void calcProfLoss() {
		double totalPurchase = purchPrice * qty;
		double totalCurrent = curPrice * qty;
		profitLoss = totalCurrent - totalPurchase;
	}
		
	@Override
	public String toString() {return String.format("%s/%s: %s shares.",sName,ticker,qty);} 
	
	//getters
	public String getStockName() {return sName;}
	public String getTickerSymbol() {return ticker;}
	public double getQuantity() {return qty;}
	public double getPurchPice() {return purchPrice;}
	public double getCurPrice() {return curPrice;}
	public double getProfitLoss() {return profitLoss;}
	
	//setters
	public void setStockName(String name) {sName = name;}
	public void setTickerSymbol(String symbol) {ticker = symbol;}
	public void setPurchPrice(double price) {
		purchPrice = price;
		calcProfLoss();
		}
	public void setCurPrice(double price) {
		curPrice = price;
		calcProfLoss();
		}
		
	
}
