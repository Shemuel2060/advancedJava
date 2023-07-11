package dataStructures_algorthms.recursion;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * This class tests the methods in the RecursiveMethods class on different
 * inputs. I am using it to study that code and understand it well...
 */
public class TestRecursiveMethods {

    static RecursiveMethods rMethods = new RecursiveMethods();

    public static void main(String[] args) {
        /* ------------testing rbinarysearch() method ---------------------- */
        // int[] arr = new int[] { 1, 2, 3, 4, 5 };

        // findInIntArray(arr, 0, 4, 2);

        /* -------- testing the quicksort algoritm -------------- */
        
        int[] list = { 5, 3, 2, 6 };

       int[] list2= {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

       RecursiveMethods.quicksort(list2,0,list2.length-1);
       for (int i = 0; i < list2.length; i++)
            System.out.print(list2[i] + " ");

   }
       
        
    

   /**
    * This method finds the value in an array of integers.
    * @param A
    * @param loIndex
    * @param hiIndex
    * @param value
    */
    private static int findInIntArray(int[] A, int loIndex, int hiIndex, int value) {
        int idx = rMethods.rbinarySearch(A, loIndex, hiIndex, value);
        if (idx > 0) {
            System.out.printf("value found at index %d: ", idx);
            return idx;
        }           
        else {
            System.out.println("Value not Found in array");
            return -1;
        }
      
    }

   
        


    
}
