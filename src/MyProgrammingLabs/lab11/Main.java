package MyProgrammingLabs.lab11;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
    



    private static final SocketImpl LISTENING_PORT = null;

    public static void main(String[] args) {
        ServerSocket serverSocket;

        try{
            serverSocket= new ServerSocket(LISTENING_PORT);
        }
        catch (Exception e) {
            System.out.println("Failed to create listening socket.");
            return;
        }
        System.out.println("Listening on port: " + LISTENING_PORT);
        try{
            while(true){
                Socket connection = serverSocket.accept();
                System.out.println("\nconnection from "+
                connection.getRemoteSocketAddress());
                handleConnection(connection);
            }
        } catch (Exception e) {
            System.out.println("Server socket shut down unexpectedly");
            System.out.println("Error: " + e);
            System.out.println("EXITING...");
        }

    }

    private static void handleConnection(Socket connection) {
    }
}
