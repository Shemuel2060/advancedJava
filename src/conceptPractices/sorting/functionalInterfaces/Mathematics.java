package conceptPractices.sorting.functionalInterfaces;

@FunctionalInterface // annotation to enforce a single abstract method in the interface
/**
 * The Mathematics interface is a functional interface or SAM that
 * implements some mathematical operations. 
 */
public interface Mathematics {
    abstract int doubling(int val); // the only abstract method

    // default and static methods

    /**
     * This method multiplies two integers. It is overloaded to 
     * multipy also doubles.
     */
    static int multiply(int val1, int val2){
        return val1*val2;        
    }

    static double multiply(double val1, double val2){
        return val1*val2;        
    }

    /**
     * The method adds two values....
     */
    static double add(double val1, double val2){
        return val1+val2;      
    }
    
}

/**
 * Implementation of the Mathematics interface...
 */
class Main{
    public static void main(String... args){
        Mathematics doubleOp = (int val)-> {            
            System.out.print(val+ "");     
           return val*2;       
        }; // end of lambda expression.
        System.out.println(" doubled to: "+ doubleOp.doubling(3));

        int multiple = Mathematics.multiply(3,4);
        System.out.println("\nUsing static method in Mathematics interface: "
         + multiple);

        // multiplying with the Multiplication class
        int multiple2 = Multiplication.multiply(3,4);
        System.out.println("\nUsing static method in Multiplication class which" + 
        " implements the Mathematics interface: "+ multiple2);
        
        
    }
    private class Multiplication implements Mathematics{

        @Override
        public int doubling(int val) {
            return val*2;            
        }
        static int multiply(int one, int two){
            int multiple = Mathematics.multiply(3,4);
            return multiple;
        }
        
    }

    
}
