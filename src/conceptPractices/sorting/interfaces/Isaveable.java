package conceptPractices.sorting.interfaces;

import java.util.List;

/**
 * The interface allows saving an object to an ArrayList medium.
 */
public interface Isaveable {
    /**
     * This method writes or populates an object's fielsds of any
     * class that implements this interface.
     */
    List<String> write();

    /**
     * This method reads data saved in classes that implement this
     * intergace.
     */
    void read(List<String> src);

}
