package generics_collections.generics;

import java.util.ArrayList;
import java.util.List;

public class EvenNumber extends NaturalNumber{
    public EvenNumber(int n) {
        super(n);
    }


    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>(); // create list of even numbers
        for (int i = 0; i <= 10; i++) {
            le.add(new EvenNumber(i));
        }
        List<? extends NaturalNumber> ln = le;/*
                                              This is possible because List<EvenNumber> is
                                              a subtype of List<? extends NaturalNumber> where
                                              ? extends NaturalNumber implies NaturalNumber and
                                              all its subtypes...
                                              */
        
        // ln.add(new NaturalNumber(35));
                                        /* compile-time error -- since ln
                                       * his now EvenNumber limited, and 
                                       * cannot accomodate its supertype
                                       * objects.             
                                       */
        /*
         * The following operations are possible:
         * 
         * You can add null.
         * You can invoke clear().
         * You can get the iterator and invoke remove().
         * You can capture the wildcard and write elements that you have read from the
         * list.
         * 
         * This shows that List<? extends NaturalNumber> might be taken as read-only
         * because you cannot store a new element or change an existing element in the
         * list.
         * 
         * But how do you do them?
         */

        System.out.println(ln.isEmpty()); // output - false

        ln.clear();

        System.out.println(ln.isEmpty()); // expected - true




    }
}
