package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class UgandaCitiesLinkedList {
    public static void main(String[] args) {
        // create linkedlist of cities in Uganda and populate it with cities
        LinkedList<String> ugCities = new LinkedList<>();
        ugCities.add("Kampala");
        ugCities.add("Bushenyi");
        ugCities.add("Arua");
        ugCities.add("Lira");
        ugCities.add("Mbarara");
       

        // print all the cities
         printLinkedList(ugCities);

        // add new city
        ugCities.add(1, "Mukono");
        printLinkedList(ugCities);

       



         
    } // end of main()
    /**
     * A generic method that prints linked lists of any type. 
     * @param <E>
     * @param list
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
     * @param <E>
     * @param list
     * @param city
     * @return {@code void}
     */
    public static <E extends Comparable<E>> boolean addItemInOrder(LinkedList<E> list, E newItem) {
        // create iterator 
        ListIterator<E> i = list.listIterator(); /*ListItrator provides more functions */
        boolean bol = false;
        while (i.hasNext()) {
            
            int compValue = i.next().compareTo(newItem);
            if(compValue>0)
                bol = true;
        }
        
        return bol;

    }
    
}
