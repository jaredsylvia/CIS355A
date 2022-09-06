package highLow;

public class Game {
	//attributes / fields
	private Card currentCard;
	private Card lastCard;
	private Deck deck;
	private int winCounter;
	private int lossCounter;
	private int tieCounter;
	
	//constructor
	public Game() {
		deck = new Deck();
		deck.Shuffle();
		currentCard = deck.Deal();
		winCounter = 0;
		lossCounter = 0;
		tieCounter = 0;
	}
	
	//behaviors
	public void nextCard() {
		lastCard = currentCard;
		currentCard = deck.Deal();
		deck.Discard(lastCard);
	}
	
	public void nextIsHigher() {
		nextCard();
		
		if(deck.getRankValue(currentCard) > deck.getRankValue(lastCard)) {
			
			winCounter +=1;
		}
		else if(deck.getRankValue(currentCard) < deck.getRankValue(lastCard)) {
			lossCounter++;
		}
		else {
			tieCounter++;
		}
		
	}
	
	public void nextIsLower() {
		nextCard();
		if(deck.getRankValue(currentCard) < deck.getRankValue(lastCard)) {
			winCounter++;
		}
		else if(deck.getRankValue(currentCard) > deck.getRankValue(lastCard)) {
			lossCounter++;
		}
		else {
			tieCounter++;
		}
	}
	
	public void newGame() {
		deck.Reset();
		deck.Shuffle();
		currentCard = deck.Deal();
		winCounter = 0;
		lossCounter = 0;
		tieCounter = 0;
		
	}
	
	public void addDiscards() {
		deck.AddDiscards();
	}
	
	//getters
	public int getWins() {return winCounter;}
	public int getLosses() {return lossCounter;}
	public int getTies() {return tieCounter;}
	public Card getCurrentCard() {return currentCard;}
	public Card getLastCard() {return lastCard;}
	
}
