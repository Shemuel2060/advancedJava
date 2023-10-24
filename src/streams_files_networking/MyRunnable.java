package streams_files_networking;

/**
 * This is a class that implements Runnable interface
 * which should be passed to the Thread class constructor
 * to create a new thread of execution. 
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        callMeFirst();
    }

    private void callMeFirst() {
        System.out.println("Running: callMeFirst()");
        firstMethod();
    }

    private void firstMethod() {
        System.out.println("Calling: the firstMethod()");
    }
    
}
