package generics_collections.generics;

/**
 * This is a generic interface wiht two type parameters:
 * a key type and value type.
 */
public interface Pair<K, V> {

    // two abstract methods...
    public K getKey();

    public V getValue();
    
}
