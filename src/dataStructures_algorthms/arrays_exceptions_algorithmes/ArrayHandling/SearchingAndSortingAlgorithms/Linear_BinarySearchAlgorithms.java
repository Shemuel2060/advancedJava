package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.SearchingAndSortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class implements the linear search  and binary
 * search algorithms for searching in a dynamic array of integers.
 */
public class Linear_BinarySearchAlgorithms {

  private static int[] intsArray = new int[10];

  /**
   * Searches the array A for the integer N using linear search algorithm.
   * If N is not in the array, then -1 is returned. If N is in the array,
   * then the return value is the first integer i that satisfies A[i] == N.
   *
   * @param arr
   * @param N
   * @return value of the first integer or -1 if N is not in the list
   */
  public static int findLinearly(int[] arr, int N) {
    int there = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == N) there = N; // found it
    }
    return there; // not found
  }

  /**
   * Searches the array A for the integer N using binary search algorithm.
   * Precondition: A must be sorted into increasing order.
   * Postcondition: If N is in the array, then the return value, i,
   * satisfies A[i] == N. If N is not in the array, then the
   * return value is -1.
   *
   * @param arr
   * @param N
   * @return value of the first integer or -1 if N is not in the list
   */
  public static int findBinary(int[] arr, int N) {
    int find = -1;
    // first sort the array
    Arrays.sort(arr);

    // the binary search algorithm
    int lowestPossibleLoc = 0;
    int highestPossibleLoc = arr.length - 1;
    for (int i = lowestPossibleLoc; i < highestPossibleLoc; i++) {
      int middle = ((lowestPossibleLoc + highestPossibleLoc) / 2);
      if (arr[middle] == N) {
        find = N; // found it
      } else if (N < arr[middle]) {
        highestPossibleLoc = middle - 1;
      } else {
        lowestPossibleLoc = middle + 1;
      }
    }
    return find;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // add elements to the array of integers

    for (int i = 0; i < intsArray.length; i++) {
      intsArray[i] = in.nextInt();
    }

    // search for an element in the dynamic array of integers
    System.out.println("\n Linear Search Algorithm");
    System.out.println("  \n result: " + findLinearly(intsArray, 16));

    // testing binary search
    System.out.println("\n Binary Search Algorithm");
    System.out.println("  \n result: " + findBinary(intsArray, 16));

    // close the scanner
    in.close();
  }
}
