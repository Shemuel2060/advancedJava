package generics_collections.generics;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        OrderedPair<String, String> p2 = new OrderedPair<>("hello", "world");

        // with a parameterized type argument
        OrderedPair<String, Box<Integer>> primeIntegers = new OrderedPair<>("primes", new Box<Integer>());

        OrderedPair<String, String> p3 = new OrderedPair<>("hello", "world");

        boolean out = Utils.<String, String>compare(p2, p3);
        // boolean out = Utils.compare(p2, p3); // the compiler detects the type parameters automatically.

        System.out.println(out);
        
    }
    
    
}
