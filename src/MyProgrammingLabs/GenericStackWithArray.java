package MyProgrammingLabs;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * It is not as straightforward to work with generics with arrays as
 * it is with ArrayLists. This class uses an instance method in the
 * java.lang.reflect.Array to achieve this. 
 */
public class GenericStackWithArray<E> {
    
  private E[] genericItems;
  private int top = 0; // the topmost index of the array
    
  /**
   * The constructor takes an instance of class Class and the size of the 
   * array to instantiate. The Class instance allows us to make it 
   * generic such that we can use it for any type in the future. 
   * We use java.lang.reflect.Array.newInstance() to create a new instance
   * of the generic class with a dimension which returns an object. We then
   * cast this object to the array of the generic type. 
   * @param clazz
   * @param size
   * @throws NullPointerException
   */
  public GenericStackWithArray(Class<E> clazz, int size) throws NullPointerException {
    genericItems = (E[]) Array.newInstance(clazz, size);

  }

    /**
     * 
     * @return number of elements in the stack
     */
    public int getSize() {
      return genericItems.length;
     }

  
     /**
      * 
      * @return the top element in the stack
      */
     public E peek() {
       return genericItems[top-1];
    }

  /**
    * Add an elementto the genericItems. Check if the array is full, 
   * and copy its contents into another array double its size.
   */
  public void push(E o) {
    // check if array is full
    if (top == genericItems.length) { // array is full
      genericItems = Arrays.copyOf(genericItems, 2 * genericItems.length); // make copy of the array      
    } else {
      genericItems[top] = o; // insert new item o into position top
      top++;
    }
   
    }

   public E pop() {
     E o = genericItems[top]; // get the item
     genericItems[top] = null; // remove the item
     return o;
    }

  /**
   * Returns true if stack contains some elements and
   * false otherwise.
   * @return true or false.
   */ 
  public boolean isEmpty() {
    return top == 0;
    }    

   @Override
   public String toString() {
     return "stack: " + genericItems.toString();
   }
     
   public static void main(String[] args) {
     GenericStackWithArray<String> list = new GenericStackWithArray<>(String.class,2);
    //  System.out.println(list.getSize());
    //  System.out.println(list.peek());
    list.push("Samuel");
    // System.out.println(list.peek());
    System.out.println(list.pop());
     
   }
} // end of GenericStackWithArray