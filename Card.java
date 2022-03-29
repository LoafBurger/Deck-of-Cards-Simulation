package com.LoafBurger;

public class Card implements Comparable<Card> {
    private char suit;
    private String value;

    public Card(char suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public char getSuit() {
        return this.suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    private int getCardValue() {
        switch (this.value) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(this.value);
        }
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(getCardValue(), other.getCardValue());
    }

    @Override
    public String toString() {
        return this.suit + " " + this.value;
    }
}