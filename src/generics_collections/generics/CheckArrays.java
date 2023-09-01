package generics_collections.generics;

/**
 * This class has some operations on arrays but done with concepts in
 * generics. 
 */
public class CheckArrays {

    /**
     * This method has three parameters. The parameter T basically
     * specifies a restriction on the kind of parameters the methods
     * accepts as arguments: they should all be of the type T and since
     * it extends the interface Comparable, then also acceptable are any
     * other types that implement the interface. 
     * 
     * The methods increments a count whenever it finds some element greater
     * than elem in the arr. It uses the compareTo() from the Comparable 
     * interface to achieve this. 
     * @param <T>
     * @param arr
     * @param elem
     * @return count of elements greater than elem in the arr
     */
    public static <T extends Comparable<T>> int countGreaterThan(T[] arr, T elem) {
        int count = 0;
        for (T e : arr) {
            if (e.compareTo(elem) > 0) {
                ++count; // increment the count
            }
        }
        return count;
    }// end of countGreaterThan() method

    public static void main(String[] args) {
        // Integer[] intArray = new Integer[] { 3, 4, 7, 9, 1, 5 };
        // System.out.println(CheckArrays.<Integer>countGreaterThan(intArray, 1));
        // // System.out.println(CheckArrays.<Integer>countGreaterThan(intArray, 1));

        // trying it out strings 
        String[] p7 = new String[] { "Melvin", "Esther", "Brian", "Dan", "Philipa", "Reyon" };
        System.out.println(CheckArrays.countGreaterThan(p7,"Dan"));
    }
    
}
