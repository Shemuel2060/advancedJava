package conceptPractices.sorting.interfaces;

/**
 * This example is to demonstrate the use of default methods
 * in existing libraries, and how they can be used to add
 * functionalities.
 */
public interface Card extends Comparable<Card> {
    
    /**
     * The suit enum type defines the card suites by 
     * value and by text.
     */
    public enum Suit {
        DIAMONDS(1, "Diamonds"),
        CLUBS(2, "Clubs"),
        HEARTS(3, "Hearts"),
        SPADES(4, "Spades");

        private final int value;
        private final String text;

        Suit(int val, String txt) {
            this.value = val;
            this.text = txt;
        }

        public int value() {
            return value;
        }

        public String text() {
            return text;
        }        
    } // end of the suit enum "type"

    public enum Rank{

        DEUCE  (2 , "Two"  ),
        THREE  (3 , "Three"), 
        FOUR   (4 , "Four" ), 
        FIVE   (5 , "Five" ), 
        SIX    (6 , "Six"  ), 
        SEVEN  (7 , "Seven"),
        EIGHT  (8 , "Eight"), 
        NINE   (9 , "Nine" ), 
        TEN    (10, "Ten"  ), 
        JACK   (11, "Jack" ),
        QUEEN  (12, "Queen"), 
        KING   (13, "King" ),
        ACE    (14, "Ace"  );

    private final int val;
    private final String txt;

    Rank(int value, String text){
        this.val = value;
        this.txt = text;            
        } // end of Rank constructor

    public int rankVal(){
            return val;
        }

    public String rankText(){
            return txt;
        }

    }// end of Rank enum "type"

    // define two abstract methods....getSuit() and getRank()

    public Card.Suit getSuit();

    public Card.Rank getRank();

    
}
