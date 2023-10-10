package MyProgrammingLabs.spellchecker;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

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
        
        // testing changing any letter - works fine
        
        // String misspeltWord = SpellChecker.getBadWord();
        // SpellChecker.suggestCorrections(misspeltWord,dictionary.getDictionary());    
        
    }
}
