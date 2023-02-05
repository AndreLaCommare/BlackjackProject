package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	@Override
	public boolean isBlackjack() {
		if (getHandValue() == 21 && handOfCards.size() == 2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

	public int getHandValue() {
		int sum = 0;
		int aces = 0;
		for (int i = 0; i < handOfCards.size(); i++) {
			Card currentCard = handOfCards.get(i);
			if (currentCard.getValue() == 11) {
				aces++;
			}
			sum += currentCard.getValue();
		}
		while (aces > 0) {
			if (sum > 21) {
				sum -= 10;
			}
			aces--;
		}
		return sum;
	}

	@Override
	public void displayPlayerHand() {
		// TODO Auto-generated method stub
		System.out.println("Player Hand");
		for (int i = 0; i < handOfCards.size(); i++) {
			System.out.println(handOfCards.get(i).toString());
		}
		System.out.println();
	}

	@Override
	public void displayDealerHand() {
		// TODO Auto-generated method stub
		System.out.println("Dealer Hand:");
		System.out.println("The dealer has one card faced down.");
		for (int i = 1; i < handOfCards.size(); i++) {
			System.out.println(handOfCards.get(i).toString());
		}
		System.out.println();
	}

	@Override
	public void displayFullDealerHand() {
		// TODO Auto-generated method stub
		System.out.println("Dealer Hand");
		for (int i = 0; i < handOfCards.size(); i++) {
			System.out.println(handOfCards.get(i).toString());
		}
		System.out.println();
	}

}
