package Labs;

import java.util.Collection;

public interface CountInCollections {
    /**
     * This method takes a collection ans is used to count
     * elements in it that have a specific behaviour, e.g.
     * they can be odd numbers, even numbers, prime
     * numbers, palindromes, etc..    
     * @param <E>
     * @param c
     * @return
     */
    public abstract <E> int countElementsInCollection(Collection<E> c);
}
