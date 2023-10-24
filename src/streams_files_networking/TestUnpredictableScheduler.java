package streams_files_networking;

public class TestUnpredictableScheduler {
    public static void main(String[] args) {
        Runnable can_tPredictScheduler = new UnpredictableScheduler();

        Thread thread = new Thread(can_tPredictScheduler);

        thread.start();

        System.out.println("Back to the main stack");
    }
    
}
