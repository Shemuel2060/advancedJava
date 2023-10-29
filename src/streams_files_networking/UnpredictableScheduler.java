package streams_files_networking;

public class UnpredictableScheduler implements Runnable{

    @Override
    public void run() {
        go();
    }

    private void go() {
        try {
            Thread.sleep(2000);/*
                                * This forces the new thread to leave the 
                                currently running state. The main thread should
                                run to completion, then after a 2-second pause
                                this thread re-emerges into the running state
                                and calls the doMore() to print out its message.
                               
                                However, this is how my thread scheduler has been
                                behaving even before inserting this sleep call. It
                                seems the JVM Head First Java used was not optimised
                                to behave like this. The only visible difference this
                                introduces is the pause. 
                                */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doMore();
    }

    private void doMore() {
        System.out.println("Top over the stack");
    }
    
}
