package generics_collections.generics;

public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    // trying out bounded type paramaeters
    /**
     * This instance generic method limits that the only arguments that 
     * it takes should be any subclass of Number. Other than that, an 
     * error is shown at compile time. 
     * @param <E>
     * @param e
     */
    public <E extends Number> void checkClass(E e) {
        System.out.println("E: " + e.getClass());
        System.out.println("T: " + t.getClass());
    }
    
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("some text");        
        stringBox.<Double>checkClass(0.4);
    }
    
}
