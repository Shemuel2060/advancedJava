package generics_collections.generics;

public class BoxDemo {
    public static <T> void addBox(T t, java.util.List<Box<T>> boxes) {
        Box<T> box = new Box<>(); // create empty box of T objects
        box.set(t); // add the T object to the box of Ts

        boxes.add(box); // add the new box of Ts to the boxes list
    } // end of addBoc()

    public static <T> void outputBoxes(java.util.List<Box<T>> boxes) {
        int counter = 0;
        for (Box<T> box : boxes) {
            T boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }// end of outputBoxes()

    public static void main(String[] args) {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>(); // uses type inference here
        BoxDemo.addBox(10, listOfIntegerBoxes); // this uses autoboxing of int to Integer and also type inference
        BoxDemo.<Integer>addBox(Integer.valueOf(20), listOfIntegerBoxes); // does not use autoboxing and type inference
        BoxDemo.addBox(30, listOfIntegerBoxes);

        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }
}
