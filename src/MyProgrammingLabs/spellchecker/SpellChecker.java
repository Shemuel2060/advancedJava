package MyProgrammingLabs.spellchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
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
    static TreeSet<String>mycorrections=new TreeSet<>();
   

    /**
     * A bad word is considered as a word not in the dictionary. This method
     * returns a TreeSet of badwords in the file of words provided by the 
     * user. 
     * @return a bad word - word not in dictionary
     */
    public static TreeSet<String> getBadWord() {
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
                    badWordsOutPutSet.add(badword);
                }
                
            } // end of while-loop   
            scanUserFile.close();       

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return badWordsOutPutSet;              
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
        
    
        // change any letter
        mycorrections = changeLettersInBadWord(badword);
        // ignore letters one at a time in the bad word
        mycorrections = addMoreCorrectionsWords(deleteAnyLettersInBadWord(badword));
        
        

        return mycorrections ;
    } // end of suggestedCorrection()

    /**
     * This method compares words brought from the operation of each correction
     * approach with correction words already in the corrections set. If there
     * already, it does not add it, otherwise, it adds it.
     * @param fromThisSet
     * @return TreeSet<String> with more correct words
     */
    public static TreeSet<String> addMoreCorrectionsWords(TreeSet<String> fromThisSet) {

        for (String word : fromThisSet) {            
                
                mycorrections.add(word);
                          
        }
        return mycorrections;
    }

    public static TreeSet<String> changeLettersInBadWord(String badword) {

        TreeSet<String> suggestions = new TreeSet<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < badword.length(); i++) {
                String correction = badword.substring(0, i) + ch + badword.substring(i + 1);
                if (Dictionary.checkIfWordInDictionary(correction)) {
                    suggestions.add(correction);
                }
            }
        }
        return suggestions;
    } // end of changeLettersInBadWord()
    
    public static TreeSet<String> deleteAnyLettersInBadWord(String badword) {

        TreeSet<String> suggestions = new TreeSet<>();
        String subStr;
        // ignore last letter
        subStr = badword.substring(0, badword.length() - 1);
        if (Dictionary.checkIfWordInDictionary(subStr)) {
            suggestions.add(subStr);
        }

        // ignore first letter
        subStr = badword.substring(1, badword.length());
        if (Dictionary.checkIfWordInDictionary(subStr)) {
            suggestions.add(subStr);
        }
        
        // delete the middle letters one at a time
        int lastmiddleletterIdx = badword.length()-2;
        for (int i = 2; i < lastmiddleletterIdx; i++) {
            subStr = badword.substring(i, lastmiddleletterIdx);
            if (Dictionary.checkIfWordInDictionary(subStr)) {
            suggestions.add(subStr);
        }            
        }                
        return suggestions;
    } // end of deleteAnyLettersInBadWord(String badword) 


    public static TreeSet<String> insertCharactersInBadWord(String badword) {
        return null;

    }
    
    public static TreeSet<String> swapNeighbourLettersInBadWord(String badword) {
        return null;

    }

    public static TreeSet<String> insertSpaceInBadWord(String badword) {
        // loop through the badword from index 1
        // insert a space at that curent index
        // check if any of the two substrings on each side of the space is a legal word
        // if yes, put it in the correction set
        // if not, ignore it...
        return null;

    }

    

    

    // ================== OTHER ==================
    
    public static boolean addToDictionary(String word) {
        return false;
    }

     public static boolean checkSpellings(String word) {
        return false;
    }
}
