package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.GeneralArrays;

/**
 * This class shows several ways of working with arrays, from indexing 
 * to copying arrays and other sophisticated array operations
 */
public class ArrayHandling {

    /**
     * prints out all the elements of a character array
     * @param word
     */
    public static void printAll(char[] word) {
        // print out each letter
        for (int i = 0; i < word.length; i++) {
            System.out.println(word[i]);
        }
    }

   /**
    * takes a character array and checks whether it contains consecutive elements
    * @param word
    * @return boolean
    */
    public static boolean consecutiveLetters(char[] word) {
        boolean contains = false;
        for (int i = 0; i < word.length-1; i++) {
            if (word[i] == word[i + 1]) {
                contains = true;
                // System.out.println(contains); // for testing
                break;
            }
        }
        return contains;

    }

    /**
     * checks an array of single letter strings if it has any consecutive letters in it 
     * @param word
     */
    public static boolean consecutiveLetters(String[] word) {
        boolean found = false;
        for (int i = 0; i < word.length - 1; i++) {
            if (word[i].equals(word[i + 1])) {
                found = true;
                break;
            }

        }
        // System.out.println(found);
        return found;

    }

    /**
     * method checks if a an array of strings contains any strings
     * with consecutive letters and then prints them out.
     * @param words
     */
    public static void containsWordsWithConsecutiveLetters(String[] words) {

        for (String string : words) {
            // convert string to character array
            char[] chars = string.toCharArray();
        
            // loop through it check it contains consecutive elements
            if (ArrayHandling.consecutiveLetters(chars)) {
                System.out.println("String with consecutive letters: " + string);

            } else {
                System.out.println("String with no consecutive letters: " + string);
            }
        }

    }
}

