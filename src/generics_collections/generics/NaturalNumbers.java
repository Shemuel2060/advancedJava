package generics_collections.generics;

public class NaturalNumbers<T extends Integer> {
    private T n;
    
    NaturalNumbers(T n) {
        this.n = n;
    }

    /*
     * The class can use methods defined in its Supertype Integer. 
     * Though this works, Integer is not a good supertype since
     * it is a final class and cannot be extended further. 
     * Instead T should be bounded by Number or Object...
     */

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }
    
    public boolean isOdd() {
        return n.intValue() % 2 != 0;
    }
    
}
