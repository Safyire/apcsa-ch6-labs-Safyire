package CardGame;

/**
 * Name: Nathan Piedad
 * Date: 10/25/2018
 * Period: 1
 *
 * CardGame.DeckOfCardsTest.java
 *
 * Tester program to shuffle and deal a deck of Card objects
 */

import java.util.ArrayList;

public class DeckOfCardsTest {
    public static void main (String[] args) {
        DeckOfCards deck = new DeckOfCards();
        ArrayList<Card> dealerHand = new ArrayList<>();
        ArrayList<Card> playerHand = new ArrayList<>();
        int dealerHandValue = 0;
        int playerHandValue = 0;

        deck.shuffle();

        //Initialize hands
        for (int i = 0; i < 2; i++) {
            dealerHand.add(i, deck.dealCard());
            playerHand.add(i, deck.dealCard());
        }

        //Calculate total value of each hand
        for (int i = 0; i < 2; i++) {
            dealerHandValue += dealerHand.get(i).getValue();
            playerHandValue += playerHand.get(i).getValue();
        }

        //Prints all current hands and value
        System.out.println("Dealer's hand: " + dealerHand.get(0).getFace() + " (??)");
        System.out.println("Player's hand: " + playerHand.get(0).getFace() + ", " +
                playerHand.get(1).getFace() + " (" + playerHandValue + ")");
    }
}
