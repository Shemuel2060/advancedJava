package streams_files_networking.adviceguyprjt;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    
    // advice content
    String[] adviceList = {"Take smaller bite",
            "Never put on tight jeans. They don't allow blood flow",
            "One word: inappropriate",
            "Be thankful to God all through life",
            "Don't forget a smile- it keeps young",
            "The obvious are not worth investigating simply because they are obvious" };

    public void go() {
        try{
            // create ServerSocket to listen for client requests..
            ServerSocket serverSocket = new ServerSocket(4242);/* ServerSocket makes 
                                                        this server application listen to
                                                        client requests on port 4242 on the 
                                                        machine this code is running. */
            while (true) {
                Socket sock = serverSocket.accept();/*The accept() blocks(sits there)  unitl
                                                    a request comes in. When the request comes in
                                                    it returns an anonymous socket on which to 
                                                    connect the client to - and frees the original 
                                                    port to listen to other clients*/

                PrintWriter writer = new PrintWriter(sock.getOutputStream());/*We use the socket 
                                                                             connection to the client to get a writer
                                                                             that will write or send the messages 
                                                                             to the client
                                                                             */

                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice); // print to console
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    } // end:: go()

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    } // end:: getAdvice();

    public static void main(String[] args) {
        DailyAdviceServer advisor = new DailyAdviceServer();
        advisor.go();
    }
}
