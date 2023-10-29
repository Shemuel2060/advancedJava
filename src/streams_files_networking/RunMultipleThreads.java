package streams_files_networking;

/**
 * The class demonstrates running more than one thread at the 
 * same time or in the same execution. It also demonstrates the
 * concept that threads have names - and thus can be identified
 * by their names. 
 * 
 * The class better demonstrates the unpredictability of the 
 * scheduler in a particulat JVM. 
 */
public class RunMultipleThreads implements Runnable{

    @Override
    public void run() {
        for(int i=1; i<25; i++){
            // get name of current thread
            String currThreadName = Thread.currentThread().getName();

            // print out it name indicating it is running
            System.out.println(currThreadName+ " is in running state!!!");
        }
    }
    

    public static void main(String[] args) {
        // create a thread job
        RunMultipleThreads threadJob = new RunMultipleThreads();
        
        // create two threads
        Thread alpha = new Thread(threadJob); // first thread
        Thread beta = new Thread(threadJob); // second thread

        // give the threads names
        alpha.setName("Alpha Thread");
        beta.setName("Beta Thread");

        // statrt the threads
        alpha.start();
        beta.start();

       
    }
    
}
