package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

/**
 * This class is for simple demonstration purposes on how Java handles
 * data in the memory...see it being tested in TestCustomer.java.
 */
public class Customer {
    
    private String name;
    private double balance;

    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
}
