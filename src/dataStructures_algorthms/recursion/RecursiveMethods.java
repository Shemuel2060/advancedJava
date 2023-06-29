package dataStructures_algorthms.recursion;

/**
 * contains several recursive algorithms including for
 * linked lists
 * 
 * @author INTEL
 *
 */
public class RecursiveMethods {
    

        /**
         * Search in the array A in positions numbered loIndex to hiIndex,
         * inclusive, for the specified value. If the value is found, return
         * the index in the array where it occurs. If the value is not found,
         * * return -1. Precondition: The array must be sorted into increasing
         * order.
         * 
         * @param A
         * @param loIndex
         * @param hiIndex
         * @param value
         * @return index of value if found or -1 if not found
         */
        int rbinarySearch(int[] A, int loIndex, int hiIndex, int value) {
            assert loIndex > hiIndex: "Invalid inputs";
            if (loIndex > hiIndex || A.length==0) {
                // The starting position comes after the final index,
                // so there are actually no elements in the specified
                // range. The value does not occur in this empty list!
                return -1;
            } else {
                // Look at the middle position in the list. If the
                // value occurs at that position, return that position.
                // Otherwise, search recursively in either the first
                // half or the second half of the list.
                int middle = (loIndex + hiIndex) / 2;
                if (value == A[middle])
                    return middle;
                else if (value < A[middle])
                    return rbinarySearch(A, loIndex, middle - 1, value);
                else // value must be > A[middle]
                    return rbinarySearch(A, middle + 1, hiIndex, value);
            }
        } // end rbinarySearch()

        /**
         * Solve the problem of moving the number of disks specified
         * by the first parameter from the stack specified by the
         * second parameter to the stack specified by the third
         * parameter. The stack specified by the fourth parameter
         * is available for use as a spare. Stacks are specified by
         * number: 0, 1, or 2.
         * 
         * @param disks
         * @param from
         * @param to
         * @param spare
         */

        void towersOfHanoi(int disks, int from, int to, int spare) {
            if (disks == 1) {
                // There is only one disk to be moved. Just move it.
                System.out.printf("Move disk 1 from stack %d to stack %d%n",
                        from, to);
            } else {
                // Move all but one disk to the spare stack, then
                // move the bottom disk, then put all the other
                // disks on top of it.
                towersOfHanoi(disks - 1, from, spare, to);
                System.out.printf("Move disk %d from stack %d to stack %d%n",
                        disks, from, to);
                towersOfHanoi(disks - 1, spare, to, from);
            }
        }// end of towerOfHanoi

        // .......................................................................................................

        /**
         * Apply QuicksortStep to the list of items in locations lo through hi
         * in the array A. The value returned by this routine is the final
         * position of the pivot item in the array.
         * 
         * @param A
         * @param lo
         * @param hi
         * @return
         */
        static int quicksortStep(int[] A, int lo, int hi) {
            int pivot = A[lo]; // Get the pivot value.
            // The numbers hi and lo mark the endpoints of a range
            // of numbers that have not yet been tested. Decrease hi
            // and increase lo until they become equal, moving numbers
            // bigger than pivot so that they lie above hi and moving
            // numbers less than the pivot so that they lie below lo.
            // When we begin, A[lo] is an available space, since its
            // value has been moved into the local variable, pivot.
            while (hi > lo) {
                // Loop invariant (See Subsection 8.2.3): A[i] <= pivot
                // for i < lo, and A[i] >= pivot for i > hi.
                while (hi > lo && A[hi] >= pivot) {
                    // Move hi down past numbers greater than pivot.
                    // These numbers do not have to be moved.
                    hi--;
                }
                if (hi == lo)
                    break;
                // The number A[hi] is less than pivot. Move it into
                // the available space at A[lo], leaving an available
                // space at A[hi].
                A[lo] = A[hi];
                lo++;
                while (hi > lo && A[lo] <= pivot) {
                    // Move lo up past numbers less than pivot.
                    // These numbers do not have to be moved.
                    lo++;
                }
                if (hi == lo)
                    break;
                // The number A[lo] is greater than pivot. Move it into
                // the available space at A[hi], leaving an available
                // space at A[lo].
                A[hi] = A[lo];
                hi--;
            } // end while
            // At this point, lo has become equal to hi, and there is
            // an available space at that position. This position lies
            // between numbers less than pivot and numbers greater than
            // pivot. Put pivot in this space and return its location.
            A[lo] = pivot;
            return lo; // or return hi;
        } // end QuicksortStep

        static void quicksort(int[] A, int lo, int hi) {
            if (hi <= lo) {
                // The list has length one or zero. Nothing needs
                // to be done, so just return from the subroutine.
                return;
            } else {
                // Apply quicksortStep and get the new pivot position.
                // Then apply quicksort to sort the items that
                // precede the pivot and the items that follow it.
                int pivotPosition = quicksortStep(A, lo, hi);
                quicksort(A, lo, pivotPosition - 1); // below the pivot
                quicksort(A, pivotPosition + 1, hi); // above the pivot
            }
        } // end of quicksort algorithm

        // Function for fibonacci
        static int fib(int n) {
            // Stop condition or base case
            if (n == 0)
                return 0;

            // Stop condition
            if (n == 1 || n == 2)
                return 1;

            // Recursion function
            else
                return (fib(n - 1) + fib(n - 2));
        }

    } // end RecursiveMethods class


