package generics_collections.generics;

public class Main {
    Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
    OrderedPair<String, String> p2 = new OrderedPair<>("hello", "world");

    // with a parameterized type argument
    OrderedPair<String, Box<Integer>> primeIntegers = new OrderedPair<>("primes", new Box<Integer>());
}
