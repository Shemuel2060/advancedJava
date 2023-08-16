package conceptPractices.sorting.interfaces.relatables;

import java.awt.Point;

public class Cuboid implements Irelatable {

    public int width = 0;
    public int height = 0;
    public int length = 0;
    public Point origin;

    // four constructors
    public Cuboid() {
        origin = new Point(0, 0);
    }
    public Cuboid(Point p) {
        origin = p;
    }
    public Cuboid(int w, int h, int l) {
        origin = new Point(0, 0);
        width = w;
        height = h;
        length = l;
    }
    public Cuboid(Point p, int w, int h, int l) {
        origin = p;
        width = w;
        height = h;
        length = l;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    /**
     * This method computes the volume of the cuboid
     * @return
     */
    public int getVolume() {
        return width * height*length;
    }
    
    // a method required to implement
    // the Relatable interface
    

    @Override
    public int isLargerThan(Irelatable other) {
        Cuboid otherRect = (Cuboid)other;
        if (this.getVolume() < otherRect.getVolume())
            return -1;
        else if (this.getVolume() > otherRect.getVolume())
            return 1;
        else
            return 0; 
    }
    
}
