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
import java.util.Scanner;

public class DeckOfCardsTest {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();
        ArrayList<Card> dealerHand = new ArrayList<>();
        ArrayList<Card> playerHand = new ArrayList<>();
        int dealerHandValue = 0;
        int playerHandValue = 0;
        String playerState;

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

        //Prints dealer's hand and value
        System.out.println("Dealer's hand: " + dealerHand.get(0).getFace() + " (??)");

        //Ends game if dealer has blackjack
        if (dealerHandValue == 21) {
            System.out.println("Dealer has Blackjack (21), dealer wins.");
            System.exit(0);
        }

        //Prints player's hand and value
        System.out.println("Player's hand: " + playerHand.get(0).getFace() + ", " +
                playerHand.get(1).getFace() + " (" + playerHandValue + ")");

        //Ends game if player has blackjack
        if (playerHandValue == 21) {
            System.out.println("Player has Blackjack (21), player wins.");
            System.exit(0);
        }

        //Hit or stay section
        System.out.print("Would you like to hit or stay? ");
        playerState = s.next();
        while (playerState.equalsIgnoreCase("hit")) {
            playerHand.add(deck.dealCard());
            playerHandValue += playerHand.get(playerHand.size()-1).getValue();
            System.out.print("Player's current hand: ");
            for (int i = 0; i < playerHand.size(); i++) {
                System.out.print(playerHand.get(i).getFace() + ", ");
            }
            System.out.println("(" + playerHandValue + ") ");
            if (playerHandValue > 21) {
                System.out.println("Bust!");
                break;
            }
            System.out.print("Would you like to hit or stay? ");
            playerState = s.next();
        }

        /**
        5. The dealer must continue to deal himself cards UNTIL the total is 17 or over. Once the total is 17 or over, he stops
        dealing cards. Display the total value of the hand or “bust” if the hand is over 21.
        6. Compare the values of the dealer and player’s hand and display the winner.
         */
    }
}
