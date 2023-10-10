package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class tries to set out some operations to be done on 
 * a linked list. Well, I am aware the LinkedList class already
 * exists in java, and I seek to mimic some of its operations
 * but in my way or some different ways. I am going to write
 * equivalence testing classes for this. 
 * 
 * @author Samuel Katongole
 */
public class LinkedListsOps {
    
    /**
     * A generic method that prints linked lists of any type.
     * EQUIVALENCE TEST ON printLinedList() method:
     * <ul>
     *  <li>
     *      <ul>
     *          <li>valid inputs: {@link LinkedList} </li>
     *          <li>valid inputs: any type other than a {@link LinkedList}</li>
     *      </ul>
     *  </li>
     * </ul>
     *  
     * 
     * @param <E>
     * @param list
     * 
     * @author Samuel Katongole
     */
    public static <E> void printLinkedList(LinkedList<E> list) {
        Iterator<E> i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("========end of list========");
        
    } // end of printLinkedList() method.

    // add a new city in order
    /**
     * A generic method that adds an item to a linked list and maintains
     * the order of the list. The method is designed to do so with any 
     * {@link #LinkedList} having any parameterised type. 
     * TODO: Let this method first ensure that the items are in a right order
     * before adding the new item. It will call the reorderItems() methods.
     * 
     * @param <E>
     * @param list
     * @param city
     * @return {@code void}
     * 
     *  @author Samuel Katongole
     */
    public static <E extends Comparable<E>> boolean addItemInOrderToLinkedList(LinkedList<E> list, E newItem) {
        // first reoder items
        reorderItems(list);

        // create iterator 
        ListIterator<E> i = list.listIterator(); /*ListItrator provides more functions */
        boolean bol = false;
        while (i.hasNext()) {
            int compValue = i.next().compareTo(newItem);
            if(compValue==0){ // element to add is the same as an element in the list
                System.out.println(newItem +" already exists in the list");
                return bol;
            } else  if(compValue >  0) { // put new item before this item
                // go back to the previous since cursor position is ahead
                i.previous();                
                // add the new element now
                i.add(newItem);

                // update bol to true to show that item was added
                bol = true;
                return bol;
            } else { // compVal<0, put new item after this item
                // do nothing...          
            }
        } // end of loop

        // the newItem is now added to the end of the list
        i.add(newItem);        
        return bol;

    } // end of addItemInOrderToLinkedList()

    private static <E> void reorderItems(LinkedList<E> list) {
        // does not create a new list, but mutatates the one given...
    }
}
