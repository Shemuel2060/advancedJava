package generics_collections.collectionsframework.collections.linkedlists.recursivelinking;

public class Main {
    static Employee emp1 = new Employee("Maxi Brian", null);
    static Employee emp2 = new Employee("Hegin Mayor", emp1);
    static Employee emp3 = new Employee("Alexus Noxin", emp2);
    static Employee emp4 = new Employee("Amaga Gegu", emp3);
    static Employee emp5 = new Employee("Zaph Zack", emp4);

    public static void main(String[] args) {
        // emp2.printEmployeeName();

        // Employee.printEmployeeSupervisorName(emp3);

        Employee.countSupervisorLevelsBetweenEmployeeAndBoss(emp1);

    }
   

}
