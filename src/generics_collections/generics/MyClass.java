package generics_collections.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demos that it is possible for generic and non-generic
 * classes to have generic constructors. For generic classes, the
 * generic constructor can have a different formal type parameter
 * from that of the class itself.
 */
public class MyClass<X> {
    <T> MyClass(T t) {
        
    } // end of constructor.

    public static <T> List<T> emptyList() {
        List<T> li = new ArrayList<>();
        return li;        
    }

    public static void main(String[] args) {
        MyClass<Integer> myclass = new MyClass<>("use strings");
        /**
         * The Integer actual type represents X for MyClass while
         * the T  for the constructor is for string objects. 
         */

        List<String> listOne = java.util.Collections.emptyList();
    }
    
}
