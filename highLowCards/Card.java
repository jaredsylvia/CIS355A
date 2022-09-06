package highLow;

public class Card {
	//attributes
	private String suit;
	private String rank;
	private String filename;
	
	//constructor
	public Card() {
		suit = "None";
		rank = "None";
		filename = "cardBack.png";
	}
	public Card(String s, String r, String f) {
		suit = s;
		rank = r;
		filename = f;
	}	
	
	//behaviors
	@Override
	public String toString() {
		return(String.format("Suit: %s\nRank: %s\nFilename: %s", suit, rank, filename));
	}
	
	//getters and setters
	public String getSuit() {return suit;}
	public String getRank() {return rank;}
	public String getFilename() {return filename;}
	public void setSuit(String s) {suit = s;}
	public void setRank(String r) {suit = r;}
	public void setFilename(String f) {filename = f;}
}
