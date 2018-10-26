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
        ArrayList<Card> dealerHand = new ArrayList<>(2);
        ArrayList<Card> playerHand = new ArrayList<>(2);

        for (int i = 0; i < 2; i++) {
            dealerHand.set(i, deck.dealCard());
            playerHand.set(i, deck.dealCard());
        }

        System.out.println("Dealer's hand: " + dealerHand.get(0));
        System.out.println("Player's hand: " + playerHand.get(0) + ", " + playerHand.get(1));
    }
}
