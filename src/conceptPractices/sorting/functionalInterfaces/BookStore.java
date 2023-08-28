package conceptPractices.sorting.functionalInterfaces;

import java.util.List;
/**
 * This interface cannot be extended by a FI since it has
 * many abstract emthods. However, it can extend a FI as
 * shown in its header. Library is a FI.
 */
public interface BookStore extends Library{
    int sell();
    int buy();
    List<String> customers();
//    boolean issue_book();
}

