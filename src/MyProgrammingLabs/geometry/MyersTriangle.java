package MyProgrammingLabs.geometry;

/**
 * The class implements tests on the Myer's triangle 
 * problem. 
 * 
 * @author Samuel Katongole
 */
public class MyersTriangle {

    public static void main(String[] args) {
        String type = triangleType(0, 3, 2);
        System.out.println("The triangle is: "+ type);
    }
    
    /**
     * The method checks whether these sides of a triange make
     * a scalene, isosceles or equilateral triangle and returns
     * a message indicating the type of triangle they make. 
     * @param a one of the triangle sides
     * @param b one of the triangle sides
     * @param c one of the triangle sides
     * @return
     */
    public static String triangleType(int a, int b, int c) {
        String type = null;
        if (a == b && a == c) {
            type= "Equilateral";
        } else if (a != b && a != c && b != c) {
            type= "Scalene";
        } else if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
            type= "Isosceles";            
        }
        return type;
    }
    
}
