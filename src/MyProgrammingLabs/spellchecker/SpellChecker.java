package MyProgrammingLabs.spellchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * This class represents the main spell checker application. It checks the
 * spelling of words, suggests corrections, and adds words to the dictionary if
 * needed.
 */
public class SpellChecker {

    // A dictionary is instantiated with words from the file, word.txt
    static Dictionary dictionary = new Dictionary();
    static TreeSet<String> badWordsOutPutSet = new TreeSet<>();

    /**
     * A bad word is considered as a word not in the dictionary. 
     * @return a bad word - word not in dictionary
     */
    public static String getBadWord() {
        String badword = null;
         try {
            File userFile = FileHandler.readFileFromUser();
            
            Scanner scanUserFile = new Scanner(userFile);
            scanUserFile.useDelimiter("[^a-zA-Z]+");

            while (scanUserFile.hasNext()) {
                String wordInUserFile = scanUserFile.next().toLowerCase();
                // if (!dictionary.getDictionary().contains(wordInUserFile)) {
                //     badword = wordInUserFile;
                // }
                if (!Dictionary.checkIfWordInDictionary(wordInUserFile)) {
                    badword = wordInUserFile;
                }
                
            } // end of while-loop   
            scanUserFile.close();       

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return badword;              
    }


    /**
     * This takes a bad word, that is, a word either not in the dictionary or wrongly 
     * spelt. The method produces a set of possible corrections for the bad word. 
     * @param badword - a misspelt word
     * @param dict - a set of legal correct words
     * @return TreeSet - a set of corrections of the bad word
     */
    public static TreeSet<String> suggestCorrections(String badword, HashSet<String> dict) {
        dict = dictionary.getDictionary();
        TreeSet<String> suggestions = new TreeSet<>();
        String correction = null;
        // suggest corrections

        // change any letter
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < badword.length(); i++) {
                correction = badword.substring(0, i) + ch + badword.substring(i + 1);
                if (Dictionary.checkIfWordInDictionary(correction)) {
                    suggestions.add(badword + ": " + correction);
                }

            }
        }

        // deleting any letter
        
        
        // insert any letter at any point in the misspelt word

        // swap any two neighbouring characters

        // insert a space at any point 

        // print out suggestions
        for (String suggestion : suggestions) {
            System.out.println(suggestion);
        }
        

        
        
        return null;

    }
    
    public static boolean addToDictionary(String word) {
        return false;
    }

     public static boolean checkSpellings(String word) {
        return false;
    }
}
