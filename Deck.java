package com.LoafBurger;

import java.util.ArrayList;

//This class contains all the methods needed for the deck creation

public class Deck {
    private final ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<>();
        this.build();
    }


    //Everything below creates a list of the suits and the values
    public void build() {
          char [] suits = new char[] {'◆', '♣', '❤', '♠'};
        String[] values = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                this.deck.add(new Card(suits[i], values[j]));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }


    private void swap(int i, int j){
        Card temp = this.deck.get(i);
        this.deck.set(i, this.deck.get(j));
        this.deck.set(j, temp);
    }

    public void shuffle(){
        int n = this.deck.size();
        for(int i = n - 1; i > 0; i--){
            int j = (int)(Math.random() * i);
            swap(i, j);
        }
    }

    public void bubbleSort(){
        int n = this.deck.size();
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 1; i < n; i++){
                if(this.deck.get(i-1).compareTo(this.deck.get(i)) > 0){
                    swap(i - 1, i);
                    swapped = true;
                }
            }
            n--;
        }
    }

    public Card[] draw(int n) throws IllegalArgumentException {
        if(n < 1){
            throw new IllegalArgumentException("Number of cards must be greater than 0");
        }
        Card[] cards = new Card[n];
        for(int i = 0; i < n; i++){
            int index = (int)(Math.random() * this.deck.size());
            Card card = this.deck.get(index);
            cards[i] = card;
            this.deck.remove(index);
        }
        return cards;
    }

    public int size(){
        return this.deck.size();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Card card : this.deck){
            str.append(card.toString());
            str.append(" ");
        }
        return str.toString();
    }
}
