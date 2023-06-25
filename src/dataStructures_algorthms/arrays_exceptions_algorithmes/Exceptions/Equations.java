package dataStructures_algorthms.arrays_exceptions_algorithmes.Exceptions;

/**
 * This class tests the solution to the three equations in
 * mathematics: linear, quadratic and cubic equations.
 */
public class Equations {

    double sol = 0; // found solution/root

    public static void main(String[] args) {
        double[] root = QuadraticEquations.root(2, 4, 1);
        for (int i=0; i < root.length; i++) {
            System.out.println("root_"+(i+1) +": "+ root[i]);
        }
    }
    
}
