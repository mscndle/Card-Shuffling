import java.util.Arrays;
import java.util.Random;

/**
 * Method to shuffle a deck of cards based on Donald Knuth's algorithm
 * to swap the ith card with a random card between 0 and is
 */

public class KnuthShuffle {

    //Main Driver
    public static void main(String[] args) {

        Card[] cards = new Card[52];

        int i = 0;
        for (Card.Suits suit : Card.Suits.values()) {
            for (Card.Ranks rank : Card.Ranks.values()) {
                cards[i] = new Card(rank, suit);
                i++;
            }
        }

        System.out.println(Arrays.toString(cards));

        knuthShuffle(cards);

        System.out.println(Arrays.toString(cards));
    }

    /**
     * Method that performs knuth Shuffle
     * @param cards cards array
     */
    public static void knuthShuffle(Card[] cards) {

        int j = 0;
        Random rand = new Random(Double.doubleToLongBits(System.currentTimeMillis()));

        for (int i = 51; i > 0; i--) {
            j = rand.nextInt(i);
            swapCards(cards, i, j);
        }
    }

    /**
     * Helper method to swap cards in indexes i and j
     * @param cards cards array
     * @param i     index 1
     * @param j     index 2
     */
    private static void swapCards(Card[] cards, int i, int j) {

        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

}
