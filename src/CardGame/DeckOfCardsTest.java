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

        //Player hit or stay section
        System.out.print("Would you like to hit or stay? ");
        playerState = s.next();
        while (playerState.equalsIgnoreCase("hit")) {
            playerHand.add(deck.dealCard());
            playerHandValue += playerHand.get(playerHand.size()-1).getValue();
            System.out.print("Player's current hand: ");
            for (int i = 0; i < playerHand.size(); i++) {
                System.out.print(playerHand.get(i).getFace());
                if (i != playerHand.size()-1)
                    System.out.print(", ");
            }
            System.out.println(" (" + playerHandValue + ") ");
            if (playerHandValue > 21) {
                System.out.println("Bust!");
                break;
            }
            System.out.print("Would you like to hit or stay? ");
            playerState = s.next();
        }

        //Dealer hit or stay section
        while (dealerHandValue < 17) {
            dealerHand.add(deck.dealCard());
            dealerHandValue += dealerHand.get(dealerHand.size()-1).getValue();
            if (dealerHandValue >= 17)
                break;
        }

        //Judgement section
        System.out.print("Player's final hand: ");
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.print(playerHand.get(i).getFace());
            if (i != playerHand.size()-1)
                System.out.print(", ");
        }
        System.out.println(" (" + playerHandValue + ") ");
        System.out.print("Dealer's final hand: ");
        for (int i = 0; i < dealerHand.size(); i++) {
            System.out.print(dealerHand.get(i).getFace());
            if (i != dealerHand.size()-1)
                System.out.print(", ");
        }
        System.out.println(" (" + dealerHandValue + ") ");
        if (playerHandValue > 21) {
            System.out.println("Player busted!\nDealer wins!");
        } else if (dealerHandValue > 21) {
            System.out.println("Dealer busted!\nPlayer wins!");
        } else if (playerHandValue > dealerHandValue) {
            System.out.println("Player wins!");
        } else if (dealerHandValue > playerHandValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
