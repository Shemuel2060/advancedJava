package conceptPractices.sorting.interfaces.relatables;

public class Main {
    static Irelatable rect1 = new Rectangle(3,4);
    static Irelatable rect2 = new Rectangle(2,3);

    public static void main(String[] args) {
        FindBySize find = new FindBySize();
        Object largestRect = find.findLargest(rect1, rect2);
       System.out.println(((Rectangle) largestRect).getArea());
    }
}
