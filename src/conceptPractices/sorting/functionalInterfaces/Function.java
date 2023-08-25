package conceptPractices.sorting.functionalInterfaces;

@FunctionalInterface
public interface Function<T, R>{
    R apply(T t); // SAM that returns type R.    
}



