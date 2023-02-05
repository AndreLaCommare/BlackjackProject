package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected  List <Card> handOfCards;
	
	
	public Hand() {
		handOfCards = new ArrayList<>();
		
	}
	
	public void addCard(Card card) {
		handOfCards.add(card);
	}
	
	public void clear() {
		handOfCards.clear();
	}
	
	public abstract int getHandValue();
	public abstract boolean isBlackjack();
	public abstract boolean isBust();
	public abstract void displayPlayerHand();
	public abstract void displayDealerHand();
	public abstract void displayFullDealerHand();

	@Override
	public String toString() {
		return "Hand [" + (handOfCards != null ? "handOfCards=" + handOfCards : "") + "]";
	}
	
	
}
