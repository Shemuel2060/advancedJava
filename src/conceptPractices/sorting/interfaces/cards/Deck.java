package conceptPractices.sorting.interfaces.cards;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import conceptPractices.sorting.interfaces.cards.Card.Rank;
import conceptPractices.sorting.interfaces.cards.Card.Suit;

public interface Deck {

    /**
     * gets a list of cards
     * 
     * @return list of cards
     */    
    List<Card> getCards(); 

    /**
     * Creates a deck of cards.
     * @return a deck of cards
     */    
    Deck deckFactory();

    /**
     * gets the size of a deck
     * @return size of a deck 
     */   
    int size();

    /**
     * adds a card to a deck
     * @param card
     */    
    void addCard(Suit s, Rank r);

    /**
     * adds a list of cards to a deck
     * @param cards
     */    
    void addCards(List<Card> cards);

    /**
     * adds a deck
     * @param deck
     */    
    void addDeck(Deck deck);

    /**
     * shuffles cards in a deck
     */    
    void shuffle();

       
    /**
     * arranges cards in a deck in natural ordering
     */
    void sort();

    /**
     * arranges cards in a deck on a certain specified ordering
     * @param c
     */    
    void sort(Comparator<Card> c);

    
    /**
     * converts a deck to a string.
     * @return a string representation of a deck.
     */
    String deckToString();

    
    /**
     * maps players with number of cards they have.
     * @param players
     * @param numberOfCards
     * @return map object
     * @throws IllegalArgumentException
     */
    Map<Integer, Deck> deal(int players, int numberOfCards)
                throws IllegalArgumentException;

}
