package Exceptions;

public class QuadraticEquations {
    static double root[]; // array of the roots

    /**
     * This subroutine implements the quadratic method to compute the roots
     * of the quadratic equation. It returns the roots in an array of doubles.
     * It throws an exception if A == 0 and/or the discriminant is negative.
     * @param A
     * @param B
     * @param C
     * @return array of two roots
     * @throws IllegalArgumentException
     */
    public static double[] root(double A, double B, double C)
            throws IllegalArgumentException {
            
        if (A == 0) {
            throw new IllegalArgumentException("A cannot be zero");
        }
        double disc = B * B - 4 * A * C;
        assert (disc >=0) : ("Discriminant should be >0");
        // if (disc < 0) {
        //     throw new IllegalArgumentException("Discriminant < 0");
        // }
        double root1 = (-B + Math.sqrt(disc)) / (2 * A);
        double root2 = (-B - Math.sqrt(disc)) / (2 * A);
        root = new double[]{root1, root2};

        
        return root;
    }
}
