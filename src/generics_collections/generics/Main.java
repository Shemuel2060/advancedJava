package generics_collections.generics;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        OrderedPair<String, String> p2 = new OrderedPair<>("hello", "world");

        // with a parameterized type argument
        OrderedPair<String, Box<Integer>> primeIntegers = new OrderedPair<>("primes", new Box<Integer>());

        OrderedPair<String, String> p3 = new OrderedPair<>("hello", "Uganda");

        // compare both key and value
        // boolean out = Utils.<String, String>compare(p2, p3);
        // boolean out = Utils.compare(p2, p3); // the compiler detects the type parameters automatically.
        // System.out.println(out);

        // compare only key
        boolean outforkey = Utils.compareKeys(p2, p3);
        // compare values only
        boolean outforvalues = Utils.compare(p2, p3);

        if (outforkey && outforvalues) {
            System.out.println("Both keys and values are not the same.");
        } else {
            if (outforkey && outforvalues==false) {
                System.out.println("Only the keys are the same");
            } else {
                System.out.println("Only values are the same.");
            } 
        }

        
    }
    
    
}
