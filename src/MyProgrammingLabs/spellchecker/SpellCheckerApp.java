package MyProgrammingLabs.spellchecker;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * This is the main entry of the SpellChecker class.
 */
public class SpellCheckerApp {

    static Dictionary dictionary = new Dictionary();


    public static void main(String[] args) {

        // test adding words from word.txt to HashSet

        // Dictionary dic = new Dictionary();
        // HashSet<String> dictionary = dic.getDictionary();
        // Iterator<String> it = dictionary.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());            
        // } /*Dictionary test that words from word.txt are added to a HashSet */

        // test readFileFromUser()

        // File userFile = FileHandler.readFileFromUser(); // works...

        // testing printWordNotInDictionary // dictionary.printWordNotInDictionary(); 

        // testing getBadWord()   System.out.println(SpellChecker.getBadWord()); - works

        // testing check word if in dictionary - works fine //  System.out.println(Dictionary.checkIfWordInDictionary("eta"));

        // TreeSet<String> misspeltWordsSet = SpellChecker.getBadWord();
        // for (String word : misspeltWordsSet) {
        //     System.out.println(word);
        // }

        // test change any letter suggestions

        TreeSet<String> misspeltWordsSet = SpellChecker.getBadWord();
        TreeSet<String> corrected = new TreeSet<>();
        for (String word : misspeltWordsSet) {
            corrected = SpellChecker.suggestCorrections(word, dictionary.getDictionary());
            // for (String word2 : corrected) {
            //     System.out.print(word + ": ");
            //     System.out.print(word2+", ");
            // }
            if (corrected.isEmpty()) {
                System.out.print(word + ": " + "no suggestions\n");                    
            } else {
                Iterator<String> iter = corrected.iterator();
                System.out.print(word + ": ");
                while (iter.hasNext()) {
                    System.out.print(iter.next() + ", ");
                }
                System.out.println();
            }
                

            
        }

        
    }
}
