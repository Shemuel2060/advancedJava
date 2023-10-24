package streams_files_networking;

public class UnpredictableScheduler implements Runnable{

    @Override
    public void run() {
        go();
    }

    private void go() {
        doMore();
    }

    private void doMore() {
        System.out.println("Top over the stack");
    }
    
}
