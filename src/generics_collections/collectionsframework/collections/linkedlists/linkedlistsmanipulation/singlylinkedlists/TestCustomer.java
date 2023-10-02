package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

import java.util.ArrayList;

public class TestCustomer {
    

    public static void main(String[] args) {
        // create first cutomer instance
        Customer customer = new Customer("Samuel", 12.74);
        
        // create another customer
        Customer anotherCustomer;

        // make this customer point to the same memory as the first customer
        anotherCustomer = customer; /*
                                    Note that anotherCustomer and customer both
                                    point to the same memeory address now. Changes
                                    caused by any of the two affects the same memory
                                    */
        
        anotherCustomer.setBalance(18.24);

        System.out.println("The customer, " + customer.getName() + "'s balance is " + customer.getBalance());

        
        // With ArrayLists
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i : intList) {
            System.out.println(i);
        }
        
        intList.add(1, 2); // add 2 at index 1 - moves 3 and 4 down
        for (int i : intList) {
            System.out.println(i);
        }
    
        
    }
    
}
