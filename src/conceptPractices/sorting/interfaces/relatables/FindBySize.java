package conceptPractices.sorting.interfaces.relatables;

/**
 * This class defines three methods, which help compare two objects
 * by size. 
 */
public class FindBySize {

    public Object findLargest(Object object1, Object object2) {
        Irelatable obj1 = (Irelatable) object1;
        Irelatable obj2 = (Irelatable) object2;
        if ((obj1).isLargerThan(obj2) > 0)
            return object1;
        else
            return object2;
    } // end of findLargest()

    public Object findSmallest(Object object1, Object object2) {
        Irelatable obj1 = (Irelatable) object1;
        Irelatable obj2 = (Irelatable) object2;
        if ((obj1).isLargerThan(obj2) < 0)
            return object1;
        else
            return object2;
    }
    
    public boolean isEqual(Object object1, Object object2) {
        Irelatable obj1 = (Irelatable) object1;
        Irelatable obj2 = (Irelatable) object2;
        if ((obj1).isLargerThan(obj2) == 0)
            return true;
        else
            return false;
    }
}
