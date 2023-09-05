package generics_collections.generics;

public class NaturalNumbers<T extends Number> {
    private T n;
    
    NaturalNumbers(T n) {
        this.n = n;
    }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }
    
    public boolean isOdd() {
        return n.intValue() % 2 != 0;
    }
    
}
