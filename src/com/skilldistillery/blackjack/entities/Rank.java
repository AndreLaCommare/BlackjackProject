package com.skilldistillery.blackjack.entities;

public enum Rank {
	TWO(2,"two"), THREE(3,"three"), FOUR(4,"four"), FIVE(5,"five"), SIX(6, "six"), SEVEN(7, "seven"), EIGHT(8,"eight"), NINE(9,"nine"), TEN(10,"ten"), JACK(10, "Jack"), QUEEN(10, "Queen"), KING(10, "King"), ACE(11, "Ace");
	private int value;
	private String name;
	
	Rank(int value, String name){
		this.value = value;
		this.name = name;
		}
	
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
	
	

