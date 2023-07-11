package leetCodeProblems;

/**
 * Given two strings s and goal, return true if you can swap two letters in s so
 * the result is equal to goal, otherwise, return false.
 * 
 * Swapping letters is defined as taking two indices i and j (0-indexed) such
 * that i != j and swapping the characters at s[i] and s[j].
 * 
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is
 * equal to goal.
 * Example 2:
 * 
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b',
 * which results in "ba" != goal.
 * Example 3:
 * 
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is
 * equal to goal.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, goal.length <= 2 * 104
 * s and goal consist of lowercase letters.
 */
public class BuddyStrings {
 

    public static boolean buddyStrings(String s, String goal) {

        assert s.length() == goal.length(); // if not, then just return false...
        if (s.length() != goal.length()) {
            return false;            
        } else {
            goal = goal.toLowerCase();
            String newS = "";
            boolean out = false;

            int n = rfactorial(s.length()); // get number of times to shuffle the letters in s.

            int i = 0; // looping variables
            while (i != n) {
                // shuffle the letters in s
                newS = randSwap(s);
                // After each shuffle, check if s is equal to goal, return true if so
                if (newS.equals(goal)) {
                    out = true;
                    break;
                }
                i++; // increment looping variable
            }
            // at this point for all possible shuffles, s is not equal to goal, return
            // false.
            return out;            
        }        
    }
    
    /**
     * computes the factorial; to be used to get the number
     * of possibles shuffles. 
     * @param n
     * @return
     */
    public static int rfactorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * rfactorial(n - 1);
    }

    /**
     * swaps letters in the string randomly. Alternative, this can be done when returning a 
     * char[] whose elements can be printed out in a loop. 
     * The method first converts the string to lowercase.
     * @param s
     * @return swapped/ shuffled s
     */
    public static String randSwap(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();

        for (int k = 0; k < arr.length; k++) {
            int i = (int) (Math.random() * (arr.length - 1)); // ensures even the first letter is swapped
            int j = (int) (Math.random() * (arr.length - 1));
            if (i != j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // convert the character array to a string
        s = new String(arr); /*
                              * automatically uses the Arrays.copyOf() method
                              * https://www.geeksforgeeks.org/convert-character-array-to-string-in-java/
                              */
        System.out.println(s); // testing...
        return s;
    }

    public static void main(String[] args) {
        //    String str = randSwap("ABCDEF");
        //     for (int i = 0; i <= str.length() - 1; i++) {
        //         System.out.print(str.charAt(i));
        //     }
        boolean out = buddyStrings("gloa", "goal");
        System.out.println(out);
    }
    
}
