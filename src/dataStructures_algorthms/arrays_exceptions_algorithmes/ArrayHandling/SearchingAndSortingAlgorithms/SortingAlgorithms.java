package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.SearchingAndSortingAlgorithms;

import MultiDimensionalArrays.MultiDimArrays;

public class SortingAlgorithms {

    private int[] arrayOfInts; // array to work with

    // the insertion sort algorithm
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) { // outer loop of the unsorted part of the array
            int temp = arr[i]; // store value to compare with the sorted array
            int j = i - 1; // looping variable for the sorted array

            while (j >= 0 && arr[j] > temp) { // array not sorted, then sort...
                // inner loop to compare the temp with the sorted array values
                arr[j + 1] = arr[j]; // move item to next position
                j--; // decrease the inner loop counter
            }
            arr[j+1] = temp; //
        }
    }
    
    public static void selectionSort(int[] arr) {
        for (int lastPlace = arr.length - 1; lastPlace >= 0; lastPlace--) { /*keep changing the last place
                                                                            from behind the array */
            int maxLoc = 0; // the maximum value so far found here in the array

            for (int i = 1; i <= lastPlace; i++) {
                /* Is the value arr[maxLoc]>=arr[i]. If yes
                put value in lastPlace and if no, let maxLoc = i                                        */

                if (arr[i] > arr[maxLoc]) {
                    maxLoc = i; // update maxLoc to i...
                }
                int temp = arr[maxLoc]; // the max value so far found kept in temp variable...
                arr[maxLoc] = arr[lastPlace]; //
                arr[lastPlace] = temp;
            }
        }
    }
     
    /**
     * This implementation is based on comparing the last place in the array
     * and the current position. 
     * @param arr
     * @Author Samuel Katongole
     * @copyright Copyright (June 8, 2023)
     */
    public static void selectionSort2(int[] arr) {
        int fp = 0; // current position
        int lp = arr.length - 1; // last position
        for (int i = fp; i < arr.length; i++) {
            if (arr[fp] > arr[lp]) {
                int temp = arr[lp];
                arr[lp] = arr[fp];
                arr[fp] = temp;
            }
            fp++; //
        }
        
    } // end of selectionSortv2

    /**
     * This rearranges the array in an unordered fashion. 
     * Not common in practice but useful for shuffling
     * cards and some other cases.
     * @param array
     */
    public static void shuffle(int[] array) {
        for (int lastPlace = array.length - 1; lastPlace >= 0; lastPlace--) {
            // set random location 
            int randLoc = (int) (Math.random() * (array.length));
            
            int temp = array[lastPlace];
            array[lastPlace] = array[randLoc];
            array[randLoc] = temp;            
        }
        
    }

    public static void mergeSort(int[] arr) {

    }
    
    public static void main(String[] args) {
        // create array of random numbers of length 1000
        int[] arr = new int[10]; // array to sort        
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (int) (Math.random() * 10 + 1);
        }

        System.out.println("Before SORTING array");
       
        MultiDimArrays.printArray(arr);
        System.out.println("\n");

        // insertionSort(arr);
        // System.out.println("after SORTING array using insertion sort");
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // System.out.println("\n");
        
        selectionSort(arr);
        System.out.println("after SORTING array using selection sort");
        MultiDimArrays.printArray(arr);
       

        // System.out.println("\n");

        // selectionSort2(arr);
        // System.out.println("after SORTING array using selection sort v.2");      
        // MultiDimArrays.printArray(arr);
        System.out.println("\n");

        System.out.println("After SHUFFLING the array");
        shuffle(arr);
        MultiDimArrays.printArray(arr);
        System.out.println("\n");

    }
        
    }

