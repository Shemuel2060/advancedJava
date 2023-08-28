package conceptPractices.sorting.functionalInterfaces;

import java.util.function.Consumer;

public interface BiConsumer<T, U> extends Consumer<T>{
    void accept(Integer T, String U);    
}
