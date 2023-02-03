package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardDeck = new ArrayList<>();
	
	public Deck (){
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				cardDeck.add(card);
			}
		}
	}
	public int checkSize() {
		return cardDeck.size();
	}
	public List<Card> getDeck(){
		return cardDeck;
	}
	
	public void shuffleDeck(){
		Collections.shuffle(cardDeck);
	
	}
	
	public Card dealCard( ) {
		return cardDeck.remove(0);
	}


	
	public void setDeck(List<Card> deck) {
		cardDeck = deck;
	}
}
	
