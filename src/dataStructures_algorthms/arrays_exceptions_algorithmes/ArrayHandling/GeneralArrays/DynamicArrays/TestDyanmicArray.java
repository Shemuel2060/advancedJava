package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.GeneralArrays.DynamicArrays;

public class TestDyanmicArray {

    // create a dynamic array of ints object
    static DynamicArrayOfInts arrayOfInts = new DynamicArrayOfInts();

    static int[] intsArray = arrayOfInts.getItems();

    public static void main(String[] args) {

       
        
        // fill the array with integers 
        for (int i = 0; i < intsArray.length; i++) {
            // add counting numbers from 1 to size of array
            arrayOfInts.add(i + 1);
        }
        
        System.out.println("\nChecking number of items in array\n");
        int num = arrayOfInts.getItemCt();
        System.out.println(num);

        System.out.println("\nPrinting items added to array\n");


        // print out the elements of the array
        arrayOfInts.printItems();
       

        // add element to end of this array

        System.out.println("\nPrinting again after"+ 
        "adding to the end of the array");
        arrayOfInts.add(99);
        System.out.println("\n");

        arrayOfInts.printItems();

        System.out.println("\nPrinting after setting an item\n");
        arrayOfInts.set(2, 150);
        arrayOfInts.printItems();

       
        
    }   
}
