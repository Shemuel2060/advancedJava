package conceptPractices.sorting.interfaces.cards;

public class PlayingCard implements Card {

    private Suit suit;
    private Rank rank;

    PlayingCard(Suit s, Rank r) {
        this.suit = s;
        this.rank = r;
    }
    
    public int hashCode() {
        return ((suit.value() - 1) * 13) + rank.value();
    }


    @Override
    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public Suit getSuit() {
        return this.suit;
    }
    
    @Override
    public Rank getRank() {
        return this.rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }


    public void setRank(Rank rank) {
        this.rank = rank;
    }


   
    
} // end ot the PlayingCard class.
