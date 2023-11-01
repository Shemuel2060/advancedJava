package streams_files_networking.areaserver;

import java.net.*;
import java.util.Date;
import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class AreaClient extends Application {
    
    DataInputStream fromServer = null;
    DataOutputStream toServer = null;
    Socket clientSocket;

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        // create panes
        BorderPane mainPane = new BorderPane();
        BorderPane topPane = new BorderPane();
        
        // top pane contents
        Label radiusLabel = new Label("Radius: ");
        TextField tf = new TextField();
        Button subBtn = new Button("Submit");

        topPane.setLeft(radiusLabel);
        topPane.setCenter(tf);
        topPane.setRight(subBtn);

        // display pane contents
        TextArea ta = new TextArea();
        ScrollPane displayPane = new ScrollPane(ta);
        

        // add topPane and displayPane to the mainPane

        mainPane.setTop(topPane);
        mainPane.setCenter(displayPane);

        // add to scene
        Scene scene = new Scene(mainPane, 300, 200);
         
        primaryStage = new Stage();
        primaryStage.setTitle("Area Client");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        primaryStage.show();


        // response to action event
        tf.setOnAction(e -> { // set on action event in this field
                try{
                    // push request to server at port 8000 on another pc
                 Double radius = Double.parseDouble(tf.getText().trim());
        
                 // send to server;
                 toServer.writeDouble(radius);

                // get from server;
                Double area = fromServer.readDouble();

                // update the display field
                ta.appendText("Connected to server on: " + new Date() + "\n");
                ta.appendText("Radius sent to server: " + radius+"\n");
                ta.appendText("Computed area: " + area + "\n");
                
                clientSocket.close();

                } catch (IOException ex) {
                    ta.appendText(ex.toString());
                }

        });
        // the networking 
        
            try {
                clientSocket = new Socket("127.0.0.1", 8000);
                // Socket clientSocket = new Socket("localhost", 8000);
                toServer = new DataOutputStream(clientSocket.getOutputStream());
                fromServer = new DataInputStream(clientSocket.getInputStream());
            } catch (Exception e) {
            System.err.println(e);            
        } 
    }
    
}
