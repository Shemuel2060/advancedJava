package MultiDimensionalArrays;

public class TestSymMatrix {
    static SymmetricMatrix mat = new SymmetricMatrix(4);
    static double[][] arr;

    public static void main(String[] args) {
        arr = mat.getSymArray();
        mat.set(1, 2, 10.5);
        mat.set(3, 2, 10.5);
        
        mat.printArray(arr);
        
    }
}
