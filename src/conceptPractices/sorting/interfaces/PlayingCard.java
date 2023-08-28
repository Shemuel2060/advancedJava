package conceptPractices.sorting.interfaces;

public class PlayingCard implements Card {

    private Suit suit;
    private Rank rank;
    
    public int hashCode() {
        return ((suit.value() - 1) * 13) + rank.rankVal();
    }


    @Override
    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public Suit getSuit() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rank getRank() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
