package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.GeneralArrays;

public class testArrayHandling {

    // for test case 1: array to testi printing out all array elements
    static char[] word = { 's', 't', 'a', 't', 'e', 'm', 'e', 'n', 't' };
    static String[] array = { "Berith", "Milcah", "Iona", "Truth", "Berisheth" };

    // test case 2: character array with consecutive elements
    static char[] XtersRepeat = { 'S', 'm', 'o', 'o', 't', 'h' };
    static char[] XtersNotRepeat = { 'S', 'a', 'm', 'u', 'e', 'l' };

    // for testcase 2: arrays with consecutive repeated elements
    static String[] repeatedXters = { "S", "m", "o", "o", "t", "h" };
    static String[] noRepeatedXters = { "S", "a", "m", "u", "e", "l" };

    // for testcase 3: words in a array with consecutive repeated elements
    static String[] manyWords = { "Berith", "Iona", "Truth", "Berisheth", "Smooth" };

    public static void main(String[] args) {

        // // testcase 1: print out all array elements
        // ArrayHandling.printAll(word); // print out all array elements
        // // ArrayHandling.printAll(array); // NOT applicable for String arrays

        // // testcase 2: repeat character array elements
        // ArrayHandling.consecutiveLetters(XtersRepeat);
        // ArrayHandling.consecutiveLetters(XtersNotRepeat);

        // // testcase 2: consecutive repeated elements
        // ArrayHandling.consecutiveLetters(repeatedXters); //prints true
        // // ArrayHandling.consecutiveLetters(noRepeatedXters); // prints false


        // testcase 3: words in array with consecutive repeated letters
        ArrayHandling.containsWordsWithConsecutiveLetters(manyWords);



    }
    
}
