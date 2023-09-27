package MyProgrammingLabs;

public class RecursiveSyntaxWithBNF {

    static private final String[] conjuctions = { "and", "or", "but", "because", "for", "yet", "nor", "so", "while",
            "unless", "whereas", "although", "if", "in addition to", "though", "as soon as", "in case", "even if",
            "rather than", "so that", "as if", "or else", "before", "after", "until", "till", "still" };

    static private final String[] properNouns = { "Fred", "Jane", "Richard Nixon", "Miss America", "Miss Uganda",
            "Samuel", "Moureen", "Berith", "Moriah", "Katongole", "Sabbath", "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };
    static private final String[] commonNouns = { "man", "woman", "vehicle", "fish", "elephant", "unicorn", "teacher",
            "politician", "engineer", "animal", "police officer", "preacher", "delivery driver", "boyfriend",
            "girlfriend", "grandma", "cousin", "barista" };

    static private final String[] determiner = {"a", "the", "every","some", "any"};
    static private final String[] adjectives = { "big", "tiny", "pretty", "bald", "smart", "excellent", "forgetful",
            "loving", "joyful", "cheerful" };
    static private final String[] intransitiveVerbs = { "runs", "jumps", "talks", "sleeps", "eats", "laughs", "makes",
            "prays", "sings", "writes", "reads", "cries" };
    static private final String[] transitiveVerbs = { "loves", "hates", "sees", "knows", "finds", "looks for" };

    

    /**
     * This method picks and returns a string from a list of strings randomly. 
     * @param listOfStrings
     * @return a string
     */
    public static String randomStringItem(String[] listOfStrings) {
        int randIdx = (int) (Math.random() * listOfStrings.length);        
        return listOfStrings[randIdx];        
    } // end of randomStringItem(String[] listOfStrings)

    // ================ noun phrase =========================

    public static String nounPhrase() {
       
        String noun_phrase = ""; // this is our final noun phrase output

        if (Math.random() >= 0.5) {
             noun_phrase = randomStringItem(properNouns);
        } else {
             noun_phrase = randomStringItem(determiner);
        }

        if (Math.random() < (0.4)) { // optionally add an adjective
            noun_phrase += " " + randomStringItem(adjectives);
        }
        
        noun_phrase += ". " + randomStringItem(commonNouns); // add a common noun

        if (Math.random() < (0.2)) { // optionally add a verb phrase.
            noun_phrase += " " + verbPhrase(); // need to add a verb phrase ....
        }       
        return  noun_phrase; // output the noun phrase here...
    } // end of nounPhrase();

    // ================ verb phrase =========================

    public static String verbPhrase() {
        String verb_phrase = ""; // initialize verb phrase as empty string

        if (Math.random() >= 0.5) {
            verb_phrase = randomStringItem(intransitiveVerbs);            
        } else {
            verb_phrase = randomStringItem(transitiveVerbs);
        }
        verb_phrase += " " + chooseWhatToAppendToVerbPhrase(); /*
                                                                          append noun phrase (over 60% of the times) or
                                                                          "is " <adjective> (30-59% of the times) or
                                                                          "belives that"+<simple sentence> (<30% of the 
                                                                          times).
                                                                          */
        return verb_phrase;        
    }// end of verbPhrase()

    public static String chooseWhatToAppendToVerbPhrase() {
        String appendThis = ""; // what to append to verb phrase in verbPhrase() method
        if (Math.random() >= 0.6) {
            appendThis = nounPhrase();
        } else if (Math.random() > 0.3 && Math.random() <= 0.59) {
            appendThis = "is "+ randomStringItem(adjectives);
        } else {
            appendThis = "believes that " + " " + simpleSentence();
        }
        
        return appendThis;
    }




    // ================ simple sentence =========================

    public static String simpleSentence() {
        return nounPhrase()+" "+ verbPhrase();
    }// end of simpleSentence()

    // ================ sentence =========================   

    public static String sentence() {
        String sentence = "";
        sentence = simpleSentence();
        if (Math.random() >= 0.5) {
            sentence += " "+ randomStringItem(conjuctions) + " " + sentence();
        }

        return sentence;
        
    } // end of sentence();

    // ================ testing =========================

    public static void main(String[] args) {
        while (true) {
            System.out.println(sentence());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {   }            
        }
        
    }

}
