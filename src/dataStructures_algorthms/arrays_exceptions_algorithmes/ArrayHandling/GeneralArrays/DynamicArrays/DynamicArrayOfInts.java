package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.GeneralArrays.DynamicArrays;

import java.util.Arrays;

/**
 * This class implements partial arrays demonstrates
 * the concept of dynamic arrays. Dynamic arrays are are
 * partial arrays that can shrink and grow as
 * desired. A better approach to implement the 
 * dynamic array behaviour is using the ArrayList
 * class. 
 * The operations of dynamic arrays include: (1) adding
 * elements to the end of the array, (2) adding element
 * to any position in the array, (3) removing elements from
 * at any position in the array without changing the array
 * order.
 * The ArrayList class solves the problem of having
 * to create different dynamic arrays for each data
 * type. 
 */
public class DynamicArrayOfInts {
     private int itemCt = 0; // no element in the array
     private int[] items = new int[8]; // initial partial array size

    
     // getter methods
   public int getItemCt() {
        return itemCt;
    }

    public int[] getItems() {
        return items;
    }

    // setter/mutator methods
    public void setItemCt(int itemCt) {
        this.itemCt = itemCt;
    }

    public void setItems(int[] items) {
        this.items = items;
    } 



    // add an element to any position in the array

/**
   * The method adds an element to any position in the array. It
   first checks if the index is valid and if not throws an 
   ArrayIndexOutOfBoundsException. If the index is valid, it adds
   the element to the the specified position in the array. 
   * @param index
   * @param item
   * @return
   */
public void set(int index, int item) {
    if (index < 0 || index > items.length) {
        throw new IndexOutOfBoundsException("Invalid Index: " + index);
    }
    items[index] = item; // add the element to the position
}

/**
 * returns an element at the specified index
 * Throws IndexOutOfBoundsException 
 * @param idx
 */
public int get(int idx) {
    if (idx < 0 || idx >=itemCt) {
        throw new IndexOutOfBoundsException("Invalid Index: " + idx);
    }
    return items[idx];    
}
        
// add an element to the end of the array

/**
   * adds an element to the end of the array
   * 
   * @param item
   */
   public void add(int item) {
       if (itemCt == items.length) // full array
           items = Arrays.copyOf(items, 2 * items.length);
       items[itemCt] = item;
       itemCt++;
   }

   /**
   * This method returns the number of elements currently
   * in the array. 
   * @return number of elements in the array
   */
   public int size() {
    return itemCt; //
   }
    // remove any element from any position in the array


    // print all items in the array
    public void printItems() {
        for (int i = 0; i < items.length; i++) 
            System.out.println("item: "+items[i]);
    }   
    
}
