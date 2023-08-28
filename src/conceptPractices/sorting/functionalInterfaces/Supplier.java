package conceptPractices.sorting.functionalInterfaces;

/**
 * The Supplier interface takes no argument and returns the type. 
 */
public interface Supplier<T> {
    T get(); // the only abstract method 
}
