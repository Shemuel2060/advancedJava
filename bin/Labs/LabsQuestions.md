# Questions and Exercises: Generics

1.	Write a generic method to count the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes).

2.	Will the following class compile? If not, why?
    	public final class Algorithm {
4.	    public static <T> T max(T x, T y) {
5.	        return x > y ? x : y;
6.	    }
7.	}

8.	Write a generic method to exchange the positions of two different elements in an array.

9.	If the compiler erases all type parameters at compile time, why should you use generics?

10.	What is the following class converted to after type erasure?

11.	public class Pair<K, V> {
12.	
13.	    public Pair(K key, V value) {
14.	        this.key = key;
15.	        this.value = value;
16.	    }
17.	
18.	    public K getKey() { return key; }
19.	    public V getValue() { return value; }
20.	
21.	    public void setKey(K key)     { this.key = key; }
22.	    public void setValue(V value) { this.value = value; }
23.	
24.	    private K key;
25.	    private V value;
26.	}

27.	What is the following method converted to after type erasure?
28.	public static <T extends Comparable<T>>
29.	    int findFirstGreaterThan(T[] at, T elem) {
30.	    // ...
31.	}
32.	Will the following method compile? If not, why?
33.	public static void print(List<? extends Number> list) {
34.	    for (Number n : list)
35.	        System.out.print(n + " ");
36.	    System.out.println();
37.	}
38.	Write a generic method to find the maximal element in the range [begin, end) of a list.
39.	Will the following class compile? If not, why?
40.	public class Singleton<T> {
41.	
42.	    public static T getInstance() {
43.	        if (instance == null)
44.	            instance = new Singleton<T>();
45.	
46.	        return instance;
47.	    }
48.	
49.	    private static T instance = null;
50.	}
51.	Given the following classes:
52.	class Shape { /* ... */ }
53.	class Circle extends Shape { /* ... */ }
54.	class Rectangle extends Shape { /* ... */ }
55.	
56.	class Node<T> { /* ... */ }
Will the following code compile? If not, why?
Node<Circle> nc = new Node<>();
Node<Shape>  ns = nc;
57.	Consider this class:
58.	class Node<T> implements Comparable<T> {
59.	    public int compareTo(T obj) { /* ... */ }
60.	    // ...
61.	}
Will the following code compile? If not, why?
Node<String> node = new Node<>();
Comparable<String> comp = node;
62.	How do you invoke the following method to find the first integer in a list that is relatively prime to a list of specified integers?
63.	public static <T>
64.	    int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p)
Note that two integers a and b are relatively prime if gcd(a, b) = 1, where gcd is short for greatest common divisor.

