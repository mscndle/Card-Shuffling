/**
 * Simple shuffle using random numbers
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class SimpleShuffleRandom {

    //Naive representation of a deck of cards
    private enum Deck {
        SpadesA,
        Spades2,
        Spades3,
        Spades4,
        Spades5,
        Spades6,
        Spades7,
        Spades8,
        Spades9,
        Spades10,
        SpadesJ,
        SpadesQ,
        SpadesK,

        HeartsA,
        Hearts2,
        Hearts3,
        Hearts4,
        Hearts5,
        Hearts6,
        Hearts7,
        Hearts8,
        Hearts9,
        Hearts10,
        HeartsJ,
        HeartsQ,
        HeartsK,

        ClubsA,
        Clubs2,
        Clubs3,
        Clubs4,
        Clubs5,
        Clubs6,
        Clubs7,
        Clubs8,
        Clubs9,
        Clubs10,
        ClubsJ,
        ClubsQ,
        ClubsK,

        DiamondsA,
        Diamonds2,
        Diamonds3,
        Diamonds4,
        Diamonds5,
        Diamonds6,
        Diamonds7,
        Diamonds8,
        Diamonds9,
        Diamonds10,
        DiamondsJ,
        DiamondsQ,
        DiamondsK
    }

    public static void main(String[] args) {
        HashMap<Integer, Enum> cardMap = new HashMap<Integer, Enum>();
        int[] deck = new int[52];

        for (int j=0; j<52; j++) {
            deck[j] = j;
        }

        int i = 0;
        for (Deck D : Deck.values()) {
            cardMap.put(i, D);
            i++;
        }

        shuffleCards(deck, cardMap);
        printDeck(deck, cardMap);
    }


    public static void shuffleCards(int[] deck, HashMap<Integer, Enum> cardMap) {
        HashSet<Integer> cardSet = new HashSet<Integer>();  //declare a set to avoid repetitions
        for (int card = 0; card < 52; card++) {
            cardSet.add(card);
        }

        //random num generator using an awesome seed
        Random rand = new Random(Double.doubleToLongBits(System.currentTimeMillis()));

        for (int i = 0; i < deck.length; i++) {
            int card = rand.nextInt(52);

            while (!cardSet.contains(card)) {
                card = rand.nextInt(52);
            }

            cardSet.remove(card);
            deck[i] = card;
        }

    }

    public static void printDeck(int[] deck, HashMap<Integer, Enum> cardMap) {
        for (int i=0; i<deck.length; i++) {
            System.out.println(cardMap.get(deck[i]));
        }
    }
}
