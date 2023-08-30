package conceptPractices.sorting.interfaces.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import conceptPractices.sorting.interfaces.cards.Card.Rank;
import conceptPractices.sorting.interfaces.cards.Card.Suit;

public class StandardDeck implements Deck {

    private List<Card> entireDeck = new ArrayList<>();
    

    public void sort() {
        Collections.sort(entireDeck);
     }

    @Override
    public List<Card> getCards() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Deck deckFactory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return entireDeck.size();
    }

    @Override
    public void addCard(Suit s, Rank r) {
        PlayingCard card = new PlayingCard(s, r);
        entireDeck.add(card);
    }

    @Override
    public void addCards(List<Card> cards) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addDeck(Deck deck) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void shuffle() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);        
    }

    @Override
    public String deckToString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Card> getEntireDeck() {
        return entireDeck;
    }

    public void setEntireDeck(List<Card> entireDeck) {
        this.entireDeck = entireDeck;
    }
    
}
