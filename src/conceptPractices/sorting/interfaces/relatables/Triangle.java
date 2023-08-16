package conceptPractices.sorting.interfaces.relatables;

import java.awt.Point;

public class Triangle implements Irelatable {
    public int base = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public Triangle() {
        origin = new Point(0, 0);
    }
    public Triangle(Point p) {
        origin = p;
    }
    public Triangle(int b, int h) {
        origin = new Point(0, 0);
        base = b;
        height = h;
    }
    public Triangle(Point p, int b, int h) {
        origin = p;
        base = b;
        height = h;
    }

    // a method for moving the Triangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing
    // the area of the Triangle
    public int getArea() {
        return base * height;
    }
    
    // a method required to implement
    // the Relatable interface
    public int isLargerThan(Irelatable other) {
        Triangle otherRect = (Triangle)other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;               
    }
}
