package conceptPractices.sorting.functionalInterfaces;


@FunctionalInterface
/**
 * This functional interface cannot extends a non-
 * functional interface. This makes it non functional. 
 * However, it can itself be extended by a non-functional
 * interface. (see BookStore)
 */
public interface Library {
    abstract boolean issue_book();  // the only abstract method.
}
