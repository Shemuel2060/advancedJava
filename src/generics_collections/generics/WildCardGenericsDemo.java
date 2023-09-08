package generics_collections.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Wildcards are used to define generic types, methods and classes
 * that work with any type. 
 */
public class WildCardGenericsDemo {

    // unbounded wildcards ? == ? extends Object

    /**
     * This method will only accept types of List<Object> and if it is intended
     * to print lists of any type, it fails to do that job. Look at the next method 
     * to see what works for that situation.
     * @param list
     */
    // public static void printList(List<Object> list) {
    //     for (Object elem : list)
    //         System.out.println(elem + " ");
    //     System.out.println();
    // }

    /**
     * This method can be used to print any type. 
     * @param list
     */
    public static void printList(List<?> list) {
        System.out.println();
        for (Object elem : list) // elem can only be Object
            System.out.println(elem + " ");
        System.out.println();
    }

    public static String getListSize(List<?> list) {
        int s = list.size();
        return "Size of list is: " + s;

    }
    
    // upper bounded wildcards

    /**
     * The acceptable inputs for the method are of Lists of type 
     * Number or any of its subtypes
     * @param list
     * @return
     */
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) // use Number to accomodate any type used
            s += n.doubleValue(); // compute sum to be in double type
        return s;
    }


    // lower bounded wildcards

    /**
     * The method adds Integer or any supertype of Integer to a list
     * @param list
     */
    public static void addNumberstoList(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i*4);
        }
    }








    // lower bounded wildcards

    public static void main(String[] args) {
        List<Integer> li = java.util.Arrays.asList(1, 2, 3);
        List<String> ls = java.util.Arrays.asList("one", "two", "three");

        // add more numbers to li
        // WildCardGenericsDemo.addNumberstoList(li);
         /*
         * retunrs the error UnsupportedOperationEzception since Arrays.asList()
         * returns a list of a fixed size, and therefore cannot be added to, set
         * or removed from.
         */
        
         List<Integer> newLi = new ArrayList<>(); /*
                                                     * creating a modifiable list, instead
                                                     * of an unmodifiable list
                                                     */ 
         WildCardGenericsDemo.addNumberstoList(newLi); // UnSupportedOperationException
         printList(newLi);

         /*
          * Alternatively, we can convert an unmodifiable list to a modifiable list
          */

         List<Integer> modifiableList = new ArrayList<>(li);/* li is an unmodifiable list
                                                            created with Arrays.asList() since
                                                            it has a fixed size.
                                                            */

         printList(modifiableList); // now we can print it out.


        // printList(li);
        // printList(ls);
        // System.out.println(getListSize(li));
        
        // System.out.println(sumOfList(li));
        // printList(li);

    }
    
}
