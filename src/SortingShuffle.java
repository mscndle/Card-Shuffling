import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Shuffle by generating 52 random numbers between 0 and 1
 * and then sorting them
 */


public class SortingShuffle {


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
        sortShuffle(cards);
        System.out.println(Arrays.toString(cards));
    }

    public static void sortShuffle(Card[] cards) {
        Random rand = new Random(Double.doubleToLongBits(System.currentTimeMillis()));
        HashMap<Double, Card> cardMap = new HashMap<Double, Card>();

        for (Card card : cards) {
            cardMap.put(rand.nextDouble(), card);
        }

        Object[] cardSet = cardMap.keySet().toArray();
        Arrays.sort(cardSet);

        for (int i=0; i<cards.length; i++) {
            cards[i] = cardMap.get(cardSet[i]);
        }
    }

}
