package conceptPractices.sorting.interfaces.cards;

import conceptPractices.sorting.interfaces.cards.Card.Rank;
import conceptPractices.sorting.interfaces.cards.Card.Suit;

public class TestCards {
    static StandardDeck myDeck = new StandardDeck();


    public static void main(String[] args) {

        myDeck.addCard(Suit.DIAMONDS, Rank.EIGHT);
        myDeck.addCard(Suit.CLUBS, Rank.SIX);
        myDeck.addCard(Suit.HEARTS, Rank.FOUR);
        myDeck.addCard(Suit.SPADES, Rank.EIGHT);
        
        // myDeck.shuffle();
        for (Card c : myDeck.getEntireDeck()) {
            System.out.println(c);
        }
    }
    
    
}
