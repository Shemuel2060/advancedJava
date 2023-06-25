package MultiDimensionalArrays;

import java.util.Scanner;

public class MultiDimArrays {
    // declare and create a twoD array of ints
    static int[][] twoDarray = {
            { 1, 2, 3, 4, 5 },
            { 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15 },
            { 16, 17, 18, 19, 20 }
    };
    static Scanner scan = new Scanner(System.in);

    // create array from console inputs
    /**
     * creates a 2D array with user input from the console.
     * 
     * @param n rows
     * @param m columns
     * @return an n-by-m 2D array
     */
    static int[][] getArray(int n, int m) {
        int[][] arr = new int[n][m];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = scan.nextInt();
            }

        }
        return arr;
    }

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
            System.out.println(); // newline for next row
        }
    }

    /**
     * This method is an overloaded method which here prints elements in
     * a 1D array...
     * 
     * @param array
     */
    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int row = 0; row < array.length; row++) {
            System.out.print(array[row] + " ");
        }
        System.out.println("] ");
    }

    /**
     * This method creates a random matrix of the specified
     * size with values ranging from 0 t0 999
     * 
     * @param n
     * @param m
     * @return an n-by-m random array
     */
    static int[][] randomArray(int n, int m) {
        int[][] arr = new int[n][m];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = (int) (Math.random() * 1000);
            }

        }
        return arr;
    }

    /**
     * The method sums up all the elements in the array and
     * returns the total
     * 
     * @param arr
     * @return total of all elements
     */
    static int arrayTotal(int[][] arr) {
        int total = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                total += arr[row][column];
            }
        }
        return total;
    }

    /**
     * This computes the total of arrays by each column and
     * stores the column totals in a 1D array.
     * 
     * @param arr
     * @return
     */
    static int[] arrayTotalbyColumns(int[][] arr) {
        int total[] = new int[arr[0].length];
        int sum = 0;

        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length; row++) {
                sum += arr[row][col];
            }
            total[col] = sum;
        }
        return total;
    }

    public static void main(String[] args) {
        // int[][] arr = getArray(3, 4);
        int[][] randArray = randomArray(4, 10);

        System.out.println("\n");
        printArray(randArray);
        int[] tot = arrayTotalbyColumns(randArray);
        System.out.println("\n");
        printArray(tot);
    }

}
