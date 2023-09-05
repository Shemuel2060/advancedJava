package generics_collections.collectionsframework.collections.linkedlists.recursivelinking;

/**
 * An object of type Employee holds data about one employee.
 */
public class Employee {   
    
    String name; // Name of the employee.
    Employee supervisor; // The employee’s supervisor.

    Employee(String name, Employee sup) {
        this.name = name;
        this.supervisor = sup;
    }
        

    /**
     * The method prints the name of a given employee
     * object.
     * @param emp
     */
    public void printEmployeeName() {
        System.out.println(this.name);
    }

    /**
     * This prints out the name of the supervisor of an 
     * employee if the employee is not the boss.
     * @param emp
     */
    public static void printEmployeeSupervisorName(Employee emp) {
        if (emp.supervisor == null) {
            System.out.println(emp.name + " is the boss and has no supervisor!");
        } else {
            System.out.print("The supervisor of " + emp.name + " is ");
            System.out.println(emp.supervisor.name);
        }
    }

    public static void countSupervisorLevelsBetweenEmployeeAndBoss(Employee emp) {

        int count =0;

        if (emp.supervisor == null) { // this employee is the boss
            System.out.println(emp.name + " is the boss!");
        } else {
            Employee runner; // For "running" up the chain of command.
            runner = emp.supervisor; // runner to point to the supervisor of this particular employee
            if (runner.supervisor == null) { // the supervisor of this employee is the boss
                System.out.println(emp.name + " reports directly to the boss.");
            } else {
                
                while (runner.supervisor != null) {
                    count++; // Count the supervisor on this level.
                    runner = runner.supervisor; // Move up to the next level.
                }
                System.out.println("There are " + count
                        + " supervisors between " + emp.name
                        + " and the boss.");
            }
        }
        

    }
        
        
    } // end class Employee



