package generics_collections.generics;

public class Utils {
    /**
     * This is a generic static method with a generic type <K,V>. This
     * type is replaced with actual types when the method is being invoked.
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
}// end of the util class.
