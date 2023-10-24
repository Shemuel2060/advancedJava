package streams_files_networking;

public class TestMyRunnable {
    public static void main(String[] args) {

        // instantiate a Runnable object
        Runnable myRunnable = new MyRunnable();

        // pass the runnable object to the Thread constructor
        Thread thread = new Thread(myRunnable);

        thread.start(); // start the thread.

    }
}
