package com.skilldistillery.blackjack.testing;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DealingCards dealer = new DealingCards();
		dealer.deal();

	}
	
	public void deal() {
		Deck theDeck = new Deck();
		//System.out.println(theDeck.getDeck());
		System.out.println("How many cards?");
		
		Scanner scan = new Scanner (System.in);
		int numOfCards = scan.nextInt();
		scan.nextLine();
		theDeck.shuffleDeck();
		for (int numDealt = 0; numDealt < numOfCards; numDealt++) {
			Card aCard = theDeck.dealCard();
			System.out.println(theDeck.checkSize() + " cards left, just dealt " + aCard);
		}
		scan.close();
	}

}
