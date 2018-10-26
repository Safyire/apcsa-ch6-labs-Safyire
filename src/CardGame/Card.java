package CardGame;

/**
 * Name: Nathan Piedad
 * Date: 10/25/2018
 * Period: 1
 *
 * CardGame.Card.java
 *
 * Represents a Card with a face and a suit.
 */

public class Card {
    private String face;
    private String suit;

    public Card (String cardFace, String cardSuit) {
        face = cardFace;
        suit = cardSuit;
    }

    public String toString() {
        return face + " of " + suit;    
    }

    public String getFace() {
        return face;
    }
    
    public String getSuit() {
        return suit;
    }

    public int getValue() {
        switch (face) {
            case "Ace":
                return 1;
            case "Deuce":
                return 2;
            case "Three":
                return 3;
            case "Four":
                return 4;
            case "Five":
                return 5;
            case "Six":
                return 6;
            case "Seven":
                return 7;
            case "Eight":
                return 8;
            case "Nine":
                return 9;
            case "Ten":
                return 10;
            case "Jack":
                return 10;
            case "Queen":
                return 10;
            case "King":
                return 10;
            default:
                return 0;
        }
    }
}
