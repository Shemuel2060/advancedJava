package conceptPractices.sorting.interfaces.cards;

import java.util.Comparator;
import java.util.List;

import conceptPractices.sorting.interfaces.cards.Card.Rank;
import conceptPractices.sorting.interfaces.cards.Card.Suit;

public class TestCards {
    static StandardDeck myDeck = new StandardDeck();


    public static void main(String[] args) {

        myDeck.addCard(Suit.DIAMONDS, Rank.EIGHT);
        myDeck.addCard(Suit.CLUBS, Rank.SIX);
        myDeck.addCard(Suit.HEARTS, Rank.FOUR);
        myDeck.addCard(Suit.SPADES, Rank.EIGHT);

        List<Card> addedCards = myDeck.getEntireDeck();

        // myDeck.shuffle();
        // System.out.println("\nCards in the deck at the moment\n");
        // for (Card c : addedCards) {
        //     System.out.println("Suit: " + c.getSuit() + "    " + "Rank: " + c.getRank());
        // }                                   

        // // sort the deck by rank only
        // myDeck.sort((firstcard, secondcard) -> firstcard.getRank().value() - secondcard.getRank().value());
        // System.out.println("\n------sorted by rank only------\n");
        // for (Card c : addedCards) {
        //     System.out.println("Rank: " + c.getRank());
        // }
        // System.out.println("                            ------------------\n");

        // myDeck.sort((firstcard, secondcard) -> firstcard.getSuit().value() - secondcard.getSuit().value());
        // System.out.println("\n------sorted by suit only------\n");
        // for (Card c : addedCards) {
        //     System.out.println("Suit " + c.getSuit());
        // }
        // System.out.println("                            ------------------\n");



        /*
         * Sorting anything with a comparator instance
         */
        // get a comparator instance that sorts by rank of a card.
        // Comparator<Card> cmp = Comparator.comparing(card -> card.getRank()); // using lambda expression
        // Comparator<Card> cmps = Comparator.comparing(Card::getRank); // using method reference
        // myDeck.sort(cmps);
        
        // System.out.println("\n------sorted by rank only through a comparator instance------\n");
        // for (Card c : addedCards) {
        //     System.out.println("Rank: " + c.getRank());
        // }
        // System.out.println("                            ------------------\n");

        // Comparing with a series of Comparator instances

        myDeck.sort(Comparator
                .comparing(Card::getRank) // compare first by rank
                .thenComparing(Comparator.comparing(Card::getSuit))); // compare next by suit.

        System.out.println("\n------sorted by rank then by suit------\n");
        for (Card c : addedCards) {
            System.out.println("Rank: " + c.getRank());
        }
        System.out.println("                            ------------------\n");
        for (Card c : addedCards) {
            System.out.println("Rank: " + c.getRank());
        }
        System.out.println("                            check the reversing------------------\n");
        for (Card c : addedCards) {
            System.out.println("Suit: " + c.getSuit());
        }
        System.out.println("                            ------------------\n");


        // reverse() - default method in the Comparator interface
        myDeck.sort(Comparator.
                comparing(Card::getRank)
                .reversed()
        .thenComparing(Card::getSuit)        
        );

        System.out.println("\n------sorted by rank, reversed and then sorted by suit------\n");
        for (Card c : addedCards) {
            System.out.println("Rank: " + c.getRank());
        }
        System.out.println("                            ------------------\n");
        for (Card c : addedCards) {
            System.out.println("Suit: " + c.getSuit());
        }
        System.out.println("                            ------------------\n");


    
    }
    


    } // end of TestCards class
    
    
    

