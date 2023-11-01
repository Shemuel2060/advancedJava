package streams_files_networking.areaserver;


import java.util.Date;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AreaServer extends Application {
    DataInputStream fromClient = null;
    DataOutputStream toClient = null;

    static final int  LISTENING_PORT = 8000;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        // the javafx application
        TextArea ta = new TextArea();
        ScrollPane pane = new ScrollPane(ta);

        Scene scene = new Scene(pane, 300, 200);

        stage.setTitle("Area Server");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


        // don't run networking in the javafx thread
        new Thread(() -> {
            try {
                ServerSocket serve = new ServerSocket(LISTENING_PORT);
                Platform.runLater(() -> {
                    ta.appendText("Server started at: "+new Date()+"\n");
                });

                while (true) {
                    Socket clientSocket = serve.accept();
                    fromClient = new DataInputStream(clientSocket.getInputStream());
                    toClient = new DataOutputStream(clientSocket.getOutputStream());

                    // read radius from client
                    Double radius = fromClient.readDouble();

                    // send area to client
                    Double area = radius * radius * Math.PI;
                    toClient.writeDouble(area);
                    Platform.runLater(() -> {
                        ta.appendText("Radius from client: " + radius + "\n");
                        ta.appendText("Area to client: " + area + "\n");
                    });
                }
                

            } catch (Exception e) {
                System.err.println(e.toString());
            }

        }).start();


        
    }
    
}
