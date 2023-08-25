package conceptPractices.sorting.functionalInterfaces;

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T,T> {
    // automatically takes up the methods in Function<T,T>
}
