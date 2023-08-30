package conceptPractices.sorting.interfaces.relatables;

public interface Irelatable {
    // constants
    // static methods
    // default methods


    
    // abstract methods

    /**
     * Compares two objects of the same class, and returns 1 if
     * this object is greater, 0 if both are equal and -1 if this 
     * object is less. The specificities of how to compare is 
     * dependent on the type of object that implements this 
     * interface.
     * @param other
     * @return 1, 0, -1
     */
    public int isLargerThan(Irelatable other);

    public int isSmallerThan(Irelatable other);

    public int isEqualTo(Irelatable other);
}
