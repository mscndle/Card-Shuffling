/**
 * This class attempts to represent a deck of cards in a better way than in SimpleShuffleRandom
 * Suits and Ranks are written as 2 separate enums
 */

public class Card {

    private Ranks rank;
    private Suits suit;


    public enum Suits {
        SPADES, CLUBS, DIAMONDS, HEARTS
    }

    public enum Ranks {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING
    }


    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }


    //Test driver
    public static void main(String[] args) {
        Card card1 = new Card(Ranks.TWO, Suits.DIAMONDS);

        System.out.println(card1);
    }
}
