package dataStructures_algorthms.arrays_exceptions_algorithmes.MultiDimensionalArrays;

/**
 * This class implements a symmetric array using the idea that for the
 * array M, M[row,col]=M[col,row]. Moreover, since Java supports arrays
 * of different row lengths, the symmetric array can be implemented by
 * creating a triangular array. Then for all row<col, M[row,col]=M[col,row]
 * is true with a triangular array.
 * 
 */
public class SymmetricMatrix {

    private double[][] symArray;

    /**
     * This subroutine creates a symmetric array of size n, 
     * but does so by creating a triangular array instead of
     * n rows. 
     * @param n
     */
    public SymmetricMatrix(int n) {
        symArray = new double[n][]; // no row lengths specified
        for (int i = 0; i < symArray.length; i++) {
            symArray[i] = new double[i + 1];
        }
    } // end of constructor.
    
    public double[][] getSymArray() {
        return symArray;
    } // getter method
    public void setSymArray(double[][] symArray) {
        this.symArray = symArray;
    } // setter method

    /**
     * Returns the element in the array at row r and
     * column c. If r<c, then M[r,c]=M[c,r]
     * @param n
     * @param m
     * @return element at M[r,c]
     */
    public double get(int r, int c) {
        double val = 0.0;
            if (r >= c) {
                val = symArray[r][c];
            } else {
                val = symArray[c][r];
            }
        return val;
    }
    
    /**
     * This inserts the given value into the specified (row,col)
     * index. If row<col, then then M[r,c]=M[c,r] which is true
     * for symmetrical array.     * 
     * @param r
     * @param c
     * @param val
     */
    public void set(int r, int c, double val) {
            if (r >= c) {
                symArray[r][c]=val;
            } else {
                symArray[c][r]=val;
            }        
    }

    

    /**
     * The method prints out 2D arrays of baseType double[][]
     * @param array
     */
    public void printArray(double[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.print(array[row][column] + " ");
            }
            System.out.println(); // newline for next row
        }
    } // end of printArray.



    
    



} // end of SymmetricMatrix class
