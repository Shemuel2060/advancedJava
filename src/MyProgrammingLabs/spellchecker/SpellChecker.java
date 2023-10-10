package MyProgrammingLabs.spellchecker;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * This class represents the main spell checker application. It checks the
 * spelling of words, suggests corrections, and adds words to the dictionary if
 * needed.
 */
public class SpellChecker {

    // A dictionary is instantiated with words from the file, word.txt
    static Dictionary dictionary = new Dictionary();


    public static TreeSet<String> suggestCorrections(String badword, HashSet<String> dict) {
        dict = dictionary.getDictionary();
        
        return null;

    }
    
    public static boolean addToDictionary(String word) {
        return false;
    }

     public static boolean checkSpellings(String word) {
        return false;
    }
}
