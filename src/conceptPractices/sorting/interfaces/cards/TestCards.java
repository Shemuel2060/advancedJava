package conceptPractices.sorting.interfaces.cards;

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
        System.out.println("\nCards in the deck at the moment\n");
        for (Card c : addedCards) {
            System.out.println("Suit: "+c.getSuit() + "    " + "Rank: "+ c.getRank());
        }
    }
    
    
}
