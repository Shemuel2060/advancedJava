package streams_files_networking.adviceguyprjt;

import java.io.*;
import java.net.*;

/**
 * This client connects to a server at port 4242 on this
 * localhost, and gets a message from there each time it
 * connects. 
 */
public class DailyAdviceClient {

    public void go() {
            // "190.165.1.103" - a remote server
            try (Socket s = new Socket("127.0.0.1", 4242)) {

            // link the low-level byte streams to high-level character streams
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
                
            // read from the high-level character stream which represents the low-level xter stream
            BufferedReader reader = new BufferedReader(streamReader); /*chains a buffered reader to 
                                                                      the low-level input stream reader.
                                                                      */
            
            // reader a message from the BufferedReader
            String message = reader.readLine(); // just read a single line - the first line.
            
            // print out the message on the console
            System.out.println(message);

            
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    } //end:: go()

    public static void main(String[] args) {
        DailyAdviceClient adviceClient = new DailyAdviceClient();
        adviceClient.go();
    }
    
    
}
