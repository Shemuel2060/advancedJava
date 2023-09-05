package generics_collections.generics;

public class Utils {
    /**
     * This is a generic static method with a generic type <K,V>. This
     * type is replaced with actual types when the method is being invoked.
     * The method compares both key and value, and they should be the same
     * for it to return true. 
     * @param <K>
     * @param <V>
     * @param p1
     * @param p2
     * @return true if pairs of objs are equal, false otherwise
     */
    public static  <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return (p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue()));
    } // end of the compare() method.

    /**
     * This generic method compares the keys of two Pair objects, and if
     * the same, returns true. Otherwise, it returns false.
     * @param <K>
     * @param <V>
     * @param p1
     * @param p2
     * @return true if the keys are equal, and false otherwise.
     */
    public static <K, V> boolean compareKeys(Pair<K, V> p1, Pair<K, V> p2) {
        return (p1.getKey().equals(p2.getKey()));
    } // end of the compareKey() method.

    /**
     * This method compares the values of two generic pairs or even two
     * objects that implement the Pair<K,V> interface. 
     * @param <K>
     * @param <V>
     * @param p1
     * @param p2
     * @return true if the values are equal and false, otherwise.
     */
    public static <K, V> boolean compareValues(Pair<K, V> p1, Pair<K, V> p2) {
        return (p1.getValue().equals(p2.getValue()));
    } // end of the compareKey() method.
}// end of the util class.
