package streams_files_networking.chatclientprjt;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JTextField;

public class SimpleChatClientA {

    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public void go() {
        // make gui and register listener with the send button
        JFrame frame = new JFrame("Simple chat client");

        JPanel mainPanel = new JPanel();

        outgoing = new JTextField(20);
        
        JButton sendButton = new JButton("Send");

        // add an ActionListener to the sendButton
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(outgoing); // put textfield on the panel
        mainPanel.add(sendButton); // put button on the panel

        // add the panel to the window/frame and center it.
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        setUpNetwork(); // call the setUpNetwork() method

        frame.setSize(400, 200);
        frame.setVisible(true);        

    } // end:: go()

    public void setUpNetwork() {
        // make a Socket, then make a PrintWriter
        try {
            sock = new Socket("127.0.0.1", 5000);/*Using localhost to
                                                        be able to test client and
                                                        server on one machine */

            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("NETWORK ESTABLISHED");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    } // end: setUpNetwork()



    public class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //get text from text field
            String chat = outgoing.getText();
            // send it to the server using the PrintWriter (writer)
            writer.println(chat);

            // close/flush the writer
            writer.flush();
        }        
        
    } // end::SendButtonListener

    public static void main(String[] args) {
        SimpleChatClientA sendMessage = new SimpleChatClientA();
        sendMessage.go();
    }
    
} // end::SimpleChatClientA
