package highLow;

import java.util.*;

public class Deck {
	//attributes / fields
	private String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
	private String[] suit = {"diamond", "club", "heart", "spade"};
	
	private List<Card> cards = new ArrayList<Card>();
	private List<Card> dealtCards = new ArrayList<Card>();
	private List<Card> discardPile = new ArrayList<Card>();
	//constructor
	public Deck() {
		for (String s: suit) {
			for(String r: rank) {
				String f = String.format("%s_of_%ss.png", r, s);
				cards.add(new Card(s, r, f));
				
			}
		}
	}
	
	//behaviors
	public Card Deal() {
		if(cards.size() > 0) {
			Card dealtCard = cards.get(0);
			cards.remove(0);
			return dealtCard;	
		}
		else {
			Card dealtCard = new Card("0", "0", "cardBack.png");
			return dealtCard;
		}
		
	}
	
	public void Shuffle() {
		Collections.shuffle(cards);
	}
			
	public void Discard(Card card) {
		if(cards.contains(card)) {cards.remove(card);}
		discardPile.add(card);
	}
	
	public void AddDiscards() {
		cards.addAll(discardPile);
		Collections.shuffle(cards);
		discardPile.clear();
	}
	
	public void Reset() {
		cards.clear();
		dealtCards.clear();
		discardPile.clear();
		for (String s: suit) {
			for(String r: rank) {
				String f = String.format("%s_of_%ss.png", r, s);
				cards.add(new Card(s, r, f));
				
			}
		}
		
	}
	
	//getters
	public List<Card> getRemainingCards() {return cards;}
	public List<Card> getDealtCards(){return dealtCards;}
	public List<Card> getDiscardPile() {return discardPile;}
	public int getRankValue(Card card) {
		int rankValue = Arrays.asList(rank).indexOf(card.getRank());
		return rankValue;
	}

}
	

