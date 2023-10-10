package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

import java.util.LinkedList;

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
         LinkedListsOps.printLinkedList(ugCities);

        // add new city
        ugCities.add(1, "Mukono");
        LinkedListsOps.printLinkedList(ugCities);

        // try adding to the list and maintain order
        LinkedListsOps.addItemInOrderToLinkedList(ugCities, "Jinja");
        LinkedListsOps.printLinkedList(ugCities);

        LinkedListsOps.addItemInOrderToLinkedList(ugCities, "Mpigi");
        LinkedListsOps.printLinkedList(ugCities);

        LinkedListsOps.addItemInOrderToLinkedList(ugCities, "Coima");
        LinkedListsOps.printLinkedList(ugCities);

        

       



         
    } // end of main()
    

    
    
}
