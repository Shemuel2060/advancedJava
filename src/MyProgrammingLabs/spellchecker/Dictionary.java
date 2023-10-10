package MyProgrammingLabs.spellchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The dictionary class manages the list of words used for spell checking. It
 * can add words to the dictionary and retrieve the list of words. It also sorts
 * the words alphabetically.
 */
public class Dictionary {

    private static HashSet<String> dictionary = new HashSet<>();


    /**
     * The Dictionary constructor constructs the dictionary which will
     * be used as a basis for checking for spelling... 
     */
    public Dictionary() {
        try (Scanner filein = new Scanner(new File("src/MyProgrammingLabs/spellchecker/word.txt"))) {
            while (filein.hasNext()) {
                String tk = filein.next();
                tk.toLowerCase(); // convert each word to lower case
                dictionary.add(tk); // do something with the token
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } // end of dictionary constructor method

    /**
     * This method checks and compares all the words a user-selected file
     * with words in the dictionary; and prints out all the words that are
     * in the user file but not in the dictionary. 
     */
    public void printWordNotInDictionary() {
        
        try {
            File userFile = FileHandler.readFileFromUser();
            
            Scanner scanUserFile = new Scanner(userFile);
            scanUserFile.useDelimiter("[^a-zA-Z]+");

            while (scanUserFile.hasNext()) {
                String wordInUserFile = scanUserFile.next().toLowerCase();
                if (!dictionary.contains(wordInUserFile)) {
                    System.out.println(wordInUserFile);
                }
            }
            scanUserFile.close();

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }        
        
    } // end of printWordNotInDictionary() method

    public static boolean checkIfWordInDictionary(String word) {
        if (dictionary.contains(word)) {
            return true; // word in dictionary
        } else {
             return false;
        }        
    }
    

    /**
     * This method returns a dictionary HashShet. The dictionary
     * is created by the constructor...
     * @return
     */
    public HashSet<String> getDictionary() {
        return dictionary;
    }





    // ============== other implementations ==============

    public boolean addWord(String word) {
        return false;

    }

    public void getWord(String word){

    }

    public void sortWordsAlphabetically(){

    }
    
}
