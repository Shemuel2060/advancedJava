package MyProgrammingLabs.lab11.webServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerMainApp {

    static final int LISTENING_PORT = 5000; // 5000;
     static String headerTokens;

    // use it to accept connections

    public static void main(String[] args) {
        // request sample:
        // http://localhost:5000/S:\Home\shemuel\www/index.html
        // http://localhost:5000/C:\Users\INTEL\Desktop\PROJECTS_2023\WORK\WEBSITES\Arola Tech\Arola Technologies\root\index.html
        // or http://localhost:5000/path/to/resource.html 
        // create server socket
        ServerSocket serverSocket;
          try {
              serverSocket = new ServerSocket(LISTENING_PORT);
          } 
          catch (Exception e) {
              System.out.println("Failed to create listening socket");
              return;
            }
            System.out.println("Listening on port: " + LISTENING_PORT);
            // accept incoming requests to the port
            try {
                while (true) {
                    Socket clientSocket = serverSocket.accept();/*server socket accepts
                                                                    a connection and returns a new socket
                                                                    from which the client can connect, while the 
                                                                    original port keeps listening to other incoming
                                                                    request. */
                    System.out.println("\nConnection from: " + clientSocket.getRemoteSocketAddress());
                    handleConnections(clientSocket);
                                        
                }
                
            }
            catch (Exception e) {
                System.out.println("Server socket shut down unexpectedly!");
                System.out.println("Error: " + e);
                System.out.println("Exiting.");
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    } // end:: main()

    private static void handleConnections(Socket clientSocket) {
       
        /*
         * 1. handle any exceptions that may occur
         * 2. close the socket at the end .. use try..catch...finally 
         */
        // System.out.println("Client reaching Server at port: " + LISTENING_PORT); // Testing 1
    
        try {
            // use socket to get InputStream
            InputStreamReader stream = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);

            headerTokens = reader.readLine(); // get header tokens from the client's request
            // testing the substringing - passed test...
            // System.out.println(headerTokens.substring(0,3));
            // System.out.println(headerTokens.substring(headerTokens.length() - 8));
            // System.out.println(headerTokens);
            // System.out.println(headerTokens.length());

            // check if header tokens are the legal ones
            
                 if(headerTokens.substring(0,3).equals("GET")&&
                    (headerTokens.substring(headerTokens.length() - 8).equals("HTTP/1.1")||
                    headerTokens.substring(headerTokens.length() - 8).equals("HTTP/1.0"))) {
                    String line = headerTokens;
                    while (line != null) {
                        System.out.println(line);
                        line = reader.readLine();
                        if (line.equals("")) {
                            break; // stop listening once all headers sent
                        }
                    }
                    
                    // send response....
                    String rootDirectory = "S:\\Home\\shemuel\\www"; /*
                    
                                                                    * root directory - where the
                                                                    * files to serve are found...
                                                                    */

                try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream())) {
                    String pathToFile = headerTokens.substring(4, headerTokens.length() - 9);/*
                                                                                            * that is
                                                                                            * from the first xter after the space
                                                                                            * that comes after GET to
                                                                                            * the last xter before the space that
                                                                                            * follows the pathToFile
                                                                                            */
                    System.out.println("Actual file: "+ pathToFile); // testing

                    // create a file object
                    File file = new File(pathToFile); //  File file = new File(rootDirectory + pathToFile);
                    System.out.println("File object" +file); // see what this is....

                    if (!file.isDirectory() && file.exists() && file.canRead()) {
                       
                        // send status line, some headers and an empty line
                        String fileType = getFileType(pathToFile);
                        System.out.println("We can write to file...."); // testing
                        sendHeaderStatus(file, writer, fileType);                       

                         // send response to the output stream
                        OutputStream outStream = clientSocket.getOutputStream();
                    
                        sendResponse(file, outStream);

                    } else {
                        // send error code to the web page...
                        System.out.println("We cannot write to the file....."); // testing
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                } 
        } 
        catch (Exception e) {
            // for now just return incase of an error
            return;
        }
        finally {
            // finally close the 
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    } // end: handleConnections()

    public static void sendResponse(File file, OutputStream socketOut) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        OutputStream out = new BufferedOutputStream(socketOut);

        while (true) {
            int x = in.read(); // read one byte from file-to-send
            if (x < 0) { // end of file (eof)
                break; // file end reached                
            }
            out.write(x); // write the byte to the output socket
        }
        in.close();
        out.close();
     
    } // end::sendResponse()


    public static String getFileType(String fileName) {
        int pos = fileName.lastIndexOf('.');
        if (pos < 0) {// no file extenstion in the name
            return "x-application/x-unknown";
        }
        String ext = fileName.substring(pos + 1).toLowerCase();
        if (ext.equals("txt")) {
              return "text/plain";
        }
        else if (ext.equals("html")) {
            return "text/html";
        }
        else if (ext.equals("htm")) {
            return "text/html";
        }
        else if (ext.equals("css")) {
            return "text/css";
        }
        else if (ext.equals("js")) {
            return "text/javascript";
        }
        else if (ext.equals("java")) {
            return "text/x-java";
        }
        else if (ext.equals("jpeg")) {
            return "image/jpeg";
        }
        else if (ext.equals("jpg")) {
            return "image/jpg";
        }
        else if (ext.equals("png")) {
            return "image/png";
        }
        else if (ext.equals("gif")) {
            return "image/gif";
        }
        else if (ext.equals("ico")) {
            return "image/x-icon";
        }
        else if (ext.equals("class")) {
            return "application/java-vm";
        }
        else if (ext.equals("jar")) {
            return "application/java-archive";
        }
        else if (ext.equals("zip")) {
            return "application/zip";
        }
        else if (ext.equals("xml")) {
            return "application/xml";
        }
        else if (ext.equals("xhtml")) {
            return "application/xhtml+xml";
        }
        else {
            return "x-application/x-unknown";
        }
    } // end:: getFileType()..

    private static void sendHeaderStatus(File file, PrintWriter writer, String fileType) {
        writer.print("HTTP/1.1 200 OK\n");
        switch (fileType){
            case "text/plain":
                writer.print("Content-Type: text/plain; charset=utf-8\n");
                break;
            case "text/html":
                writer.print("Content-Type: text/html; charset=utf-8\n");
                break;
            case "text/css":
                writer.print("Content-Type: text/css; charset=utf-8\n");
                break;
            case "text/javascript":
                writer.print("Content-Type: text/javascript; charset=utf-8\n");
                break;
            case "text/x-java":
                writer.print("Content-Type: text/x-java; charset=utf-8\n");
                break;
            case "image/jpeg":
                writer.print("Content-Type: image/jpeg; charset=utf-8\n");
                break;
            case "image/jpg":
                writer.print("Content-Type: image/jpg; charset=utf-8\n");
                break;
            case "image/png":
                writer.print("Content-Type: image/png; charset=utf-8\n");
                break;
            case "image/gif":
                writer.print("Content-Type: image/gif; charset=utf-8\n");
                break;
             case "image/x-icon":
                writer.print("Content-Type: image/x-icon; charset=utf-8\n");
                break;
             case "application/java-vm":
                writer.print("Content-Type: application/java-vm; charset=utf-8\n");
                break;
             case "application/java-archive":
                writer.print("Content-Type: application/java-archive; charset=utf-8\n");
                break;
             case "application/zip":
                writer.print("Content-Type: application/zip; charset=utf-8\n");
                break;
            case "application/xml":
                writer.print("Content-Type: application/xml; charset=utf-8\n");
                break;
            case "application/xhtml+xml":
                writer.print("Content-Type: application/xhtml+xml; charset=utf-8\n");
                break;
            default:
                writer.print("Content-Type:x-application/x-unknown ; charset=utf-8\n");

        }
        writer.print("Content-Length: " + file.length() + "\n");
        writer.print("Content-Type: text/html; charset=utf-8\n");
        writer.print("Date: Sunday, 29 Oct 2023\n"); // TODO: use the date class to get current date
        writer.print("\n");
        writer.flush();
    } // end:: sendHeaderStatus
    
} // end:: WebServerMainApp class
