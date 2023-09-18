package generics_collections.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardsSubtyping {
    List<Integer> intList = new ArrayList<>();

    List<? extends Number> numList = intList;

    

    void wildcardError(List<?> i) {
        // i.set(0, i.get(0)); // has the widlcard capture error
        fooHelper(i); // eliminates the wildcard capture error
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number temp = l1.get(0);
        l1.set(0, l2.get(0)); /*expected a CAP#1 extends Number,
                              got a CAP#2 extends Number;same bound, but 
                              different types l2.set(0, temp); expected a CAP#1 extends Number,
                              got a Number */
    }


    
}
