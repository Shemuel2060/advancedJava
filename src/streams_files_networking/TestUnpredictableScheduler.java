package streams_files_networking;

public class TestUnpredictableScheduler {
    public static void main(String[] args) {
        Runnable can_tPredictScheduler = new UnpredictableScheduler();

        Thread thread = new Thread(can_tPredictScheduler);

        thread.start();
        // try {
        //     Thread.sleep(2000);/*This instead makes the main sleep to give
        //                        chance to the thread to run to completion. */
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println("Back to the main stack");
    }
    
}
