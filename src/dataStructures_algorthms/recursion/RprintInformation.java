package dataStructures_algorthms.recursion;

import java.util.ArrayList;

/**
 * The class contains methods that print information recursively
 */
public class RprintInformation {

    /**
     * This subroutine prints the name given for a given number of
     * times recursively.
     * @param n
     */
    static void printName(String name, int n) {
        if (n <= 0) // base/terminating condition
            return;
        System.out.println(name); // business logic
        printName(name, n - 1); // method called recursively
    }

    /**
     * The method prints an array of any type of objects given to it if stored in an
     * ArrayList. 
     * @param arr
     * @param i
     */
    static void printArray(ArrayList<Object> arr, int i) {
        if (i > arr.size() - 1) // base/terminating conditions
            return;
        System.out.println(arr.get(i)); // business logic
        printArray(arr, i + 1); // method called recursively        
    }
    
    static void printArrayReverse(ArrayList<Object> arr, int i) {
        assert i != arr.size() : "Out of bounds"; // need to enable this to work
        
        if (i < 0) // base/terminating conditions
            return;
        System.out.println(arr.get(i)); // business logic
        printArrayReverse(arr, i - 1); // method called recursively
    }
    
    public static void main(String[] args) {
        // printName("Samuel", 0);

        ArrayList<Object> arr = new ArrayList<Object>();
        arr.add("Samuel");
    
        arr.add("Moureen");
        arr.add("Allan");
        arr.add(10);

        // System.out.println(arr.size());

        try {
            System.out.println("\nAscending order Printing\n");
            printArray(arr, 0);
            System.out.println("\nReversed order Printing\n");
            printArrayReverse(arr, arr.size()-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occured");
        }
    }

    
}
