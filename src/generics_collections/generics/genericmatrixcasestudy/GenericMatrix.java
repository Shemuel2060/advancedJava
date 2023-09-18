package generics_collections.generics.genericmatrixcasestudy;

import javax.management.RuntimeErrorException;

public abstract class GenericMatrix<E extends Number> {
    /*
     * the 3 abstract methods
     * These methods are abstract because we cannot implement them without knowing
     * the exact type of the elements. 
     */

    /**
     * This method adds two elements of a generic type, and returns an element of 
     * the same generic type. 
     * @param e1
     * @param e2
     * @return
     */
    abstract protected E add(E e1, E e2);

    /**
     * This method multiplies two elements of a generic type, and returns an element
     * of the same type. 
     * @param e1
     * @param e2
     * @return
     */
    protected abstract E multiply(E e1, E e2);

    protected abstract E zero();

    public E[][] addMatrices(E[][] matrix1, E[][] matrix2) {
        // check that matrices are of the same size
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeErrorException(null, "Matrices are not the same size");
        }
        E[][] result = (E[][]) new Number[matrix1.length][matrix2.length];/*
                                                                          This warning is due to
                                                                          one of the restrictions
                                                                          of using generic types.
                                                                          It is unchecked/ unavoidable.
                                                                          */

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    } // end of addMatrices() method. 

    public E[][] multiplyMatrices(E[][] matrix1, E[][] matrix2) {
        // check that matrices are of the same size
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeErrorException(null, "Matrices are not the same size");
        }
        E[][] result = (E[][]) new Number[matrix1.length][matrix2.length];/*
                                                                           * This warning is due to
                                                                           * one of the restrictions
                                                                           * of using generic types.
                                                                           * It is unchecked/ unavoidable.
                                                                           */

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiply(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    } // end of multiplyMatrices() method.

    /** Print matrices, the operator, and their operation result */
    public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op) {
        // for (int i = 0; i < m1.length; i++) {
        //     for (int j = 0; j < m1[0].length; j++)
        //         System.out.print(" " + m1[i][j]);

        //     if (i == m1.length / 2)
        //           System.out.print(" " + op + " ");
        //     else
        //           System.out.print(" ");

        //    for (int j = 0; j < m2.length; j++)
        //        System.out.print(" " + m2[i][j]);

        //     if (i == m1.length / 2)
        //         System.out.print(" = ");
        //     else
        //         System.out.print(" ");

        //     for (int j = 0; j < m3.length; j++)
        //       System.out.print(m3[i][j] + " ");

        //     System.out.println();
        // }

        printArray(m1);
        System.out.println(" " + op + " ");
        // System.out.print("  ");
        printArray(m2);
        System.out.println(" = ");
        printArray(m3);


    }

    /**
     * prints a 2d array.
     * @param m1
     */
    private static void printArray(Number[][] m1) {
        for (int row = 0; row < m1.length; row++) {
            for (int column = 0; column < m1[row].length; column++) {
                System.out.print(m1[row][column] + " ");
            }
            System.out.println(); // newline for next row
        }
    }
}
 
    

