package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;

import java.util.Scanner;

public class BlackjackApp {
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackApp bjA = new BlackjackApp();
		bjA.run();
	}

	public void run() {
		game();
	}

	public void game() {
		boolean wantToPlay = true;
//		for(Card card : blackJackDeck.getDeck()) {
//			System.out.println(card.toString());
//		}
		while (wantToPlay) {
			Deck blackJackDeck = new Deck();

			blackJackDeck.shuffleDeck();
			System.out.println("The deck is shuffled");
			Hand dealerHand = new BlackjackHand();
			Hand playerHand = new BlackjackHand();

			playerHand.addCard(blackJackDeck.dealCard());
			dealerHand.addCard(blackJackDeck.dealCard());
			playerHand.addCard(blackJackDeck.dealCard());
			dealerHand.addCard(blackJackDeck.dealCard());
			System.out.println("The cards have been dealt.");
			System.out.println();
			playerHand.displayPlayerHand();
			dealerHand.displayDealerHand();

			boolean notStaying = true;
			if (playerHand.isBlackjack() && (!(dealerHand.isBlackjack()))) {
				notStaying = false;
				System.out.println("You got Blackjack! You win! ");
			}

			if (!(playerHand.isBlackjack()) && dealerHand.isBlackjack()) {
				notStaying = false;
				System.out.println("Dealer has Blackjack. Better luck next time.");
			}

			if (playerHand.isBlackjack() && dealerHand.isBlackjack()) {
				notStaying = false;
				System.out.println("You both have Blackjack. A push is  a win. Congrats.");

			}

			while (notStaying) {
				menu();
				String userInput = kb.nextLine().toLowerCase();
				if (userInput.equals("1") || userInput.equals("hit")) {
					playerHand.addCard(blackJackDeck.dealCard());
					playerHand.displayPlayerHand();
					if (playerHand.isBust()) {
						System.out.println("You busted!");
						notStaying = false;
					}
					if (playerHand.isBlackjack()) {
						System.out.println("You have 21!");
						notStaying = false;
					}
				} else if (userInput.equals("2") || userInput.equals("stay")) {
					notStaying = false;
				} else {
					System.out.println("Invalid Input, select again.");
				}

			}

			while (dealerHand.getHandValue() < 17 && (!(playerHand.isBust()))) {
				System.out.println("The dealer must hit less than 17. The dealer hits.");
				dealerHand.addCard(blackJackDeck.dealCard());

				dealerHand.displayDealerHand();
				if (dealerHand.getHandValue() > 21) {
					System.out.println("The dealer has busted. Their cards were:");
					dealerHand.displayFullDealerHand();
				}

			}

			if (!(playerHand.isBust()) && !(dealerHand.isBust()) && !(playerHand.isBlackjack())
					&& !(dealerHand.isBlackjack())) {

				playerHand.displayPlayerHand();

				dealerHand.displayFullDealerHand();
				if (playerHand.getHandValue() > dealerHand.getHandValue()) {
					System.out.println("You win!");
				} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
					System.out.println("Dealer wins, bet more next time.");
				} else {
					System.out.println("You tie. A push is a win.");
				}

			}

			boolean promptPlayAgain = true;
			while (promptPlayAgain) {
				keepPlaying();
				String userInput = kb.nextLine().toLowerCase();
				if (userInput.equals("1") || userInput.equals("yes")) {
					promptPlayAgain = false;
				} else if (userInput.equals("2") || userInput.equals("no")) {
					promptPlayAgain = false;
					wantToPlay = false;
					System.out.println("Goodbye");
				} else {
					System.out.println("Invalid Input, select again.");
				}

			}

		}
	}

	public void menu() {
		System.out.println("Select what you wish to do:");
		System.out.println("1.)Hit");
		System.out.println("2.)Stay");

	}

	public void keepPlaying() {
		System.out.println("Do you want to play again?");
		System.out.println("1.) Yes");
		System.out.println("2.) No");
	}

}
