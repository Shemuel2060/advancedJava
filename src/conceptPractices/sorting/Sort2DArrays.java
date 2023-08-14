package conceptPractices.sorting;

import dataStructures_algorthms.recursion.RecursiveMethods;

/**
 * This class has several methods that sort 2D arrays using
 * some of the sorting methods in the RecursiveMethods class. 
 * Soring is done by rows and also by columns
 */
public class Sort2DArrays {

    /**
     * This method prints out an array in the row-column
     * matrix...
     * 
     * @param array
     */
    public static void printArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.print(array[row][column] + " ");
            }
            System.out.println(); //  newline for next row
        }
    }

    /**
     * This methods takes up an array and sorts it by the 
     * rows. 
     * @param arr
     */
    static void mergeSortByRows(int[][] arr) {

        int row;
        for (row = 0; row < 2; row++) {
            RecursiveMethods.mergesort(arr[row], 0, arr[row].length - 1);
        }
    }
    
    /**
     * This sorts the array by columns. It loops through the rows
     * and sorts the elements in each column of the row. 
     * @param arr
     */
    static void mergeSortByColumns(int[][] arr) {

        for (int row = 0; row < arr.length; row++) {
            RecursiveMethods.mergesort(arr[row], 0, arr[row].length - 1);
        }
    }


    // -----------------------testing ------------------------------

    public static void main(String[] args) {
        int[][] list = { { 2, 4, 3, 1 }, { 4, 3, 2, 1 }, { 2, 4, 3, 5 } };
        System.out.println("\n");
        printArray(list);
        // mergeSortByRows(list);
        System.out.println("\nSorted by Columns");
        mergeSortByColumns(list);
        printArray(list);

        System.out.println("\nSorted by Rows");
        mergeSortByColumns(list);
        printArray(list);
    }

    
}
