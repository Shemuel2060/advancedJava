package testing;

import java.io.IOException;
import java.io.InputStream;
import java.util.TooManyListenersException;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;

import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;

public class HomeAccessControlSystem extends Thread
        implements SerialPortEventListener {

    protected Controller ctrler_; // entry point to the domain logic
    protected InputStream inputStream_; // from the serial port
    protected StringBuffer key_ = new StringBuffer(); // user key code
    public static final long keyCodeLen_ = 4; // key code of 4 chars

    public HomeAccessControlSystem(KeyStorage ks, SerialPort ctrlPort) {
        try {
            inputStream_ = ctrlPort.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LockCtrl lkc = new LockCtrl(ctrlPort);
        LightCtrl lic = new LightCtrl(ctrlPort);
        PhotoObsrv sns = new PhotoObsrv(ctrlPort);
        AlarmCtrl ac = new AlarmCtrl(ctrlPort);
        ctrler_ = new Controller(new KeyChecker(ks), lkc, lic, sns, ac);
        try {
            ctrlPort.addEventListener(this);
        } catch (TooManyListenersException e) {
            e.printStackTrace(); // limited to one listener per port
        }
        start(); // start the thread
    }

/** The first argument is the handle (filename, IP address, ...)
* of the database of valid keys.
* The second arg is optional and, if present, names
* the serial port. */

public static void main(String[] args) {
    KeyStorage ks = new KeyStorage(args[1]);
    SerialPort ctrlPort;
    String portName = "COM1";
    if (args.length > 1) portName = args[1];
    try { // initialize
    CommPortIdentifier cpi =
    CommPortIdentifier.getPortIdentifier(portName);
    if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
        ctrlPort = (SerialPort) cpi.open();
        // start the thread for reading from serial port
        new HomeAccessControlSystem(ks, ctrlPort);
    } catch (NoSuchPortException e) {
    System.err.println("Usage: ... ... port_name");
    try {
    ctrlPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
    SerialPort.PARITY_NONE);
    } 
    catch (UnsupportedCommOperationException e) {
            e.printStackTrace();
        }
    }


    /** Thread method; does nothing, just waits to be interrupted
    * by input from the serial port. */
    public void run() {
        while (true) { // alternate between sleep/awake periods
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                /* do nothing */ }
        }
    }

    /** Serial port event handler
    * Assume that the characters are sent one by one, as typed in. */
    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            byte[] readBuffer = new byte[5]; // 5 chars, just in case
            try {
                while (inputStream_.available() > 0) {
                    int numBytes = inputStream_.read(readBuffer);
                    // could check if "numBytes" == 1 ...
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // append the new char to the user key
            key_.append(new String(readBuffer));
            if (key_.length() >= keyCodeLen_) { // got the whole key?
                // pass on to the Controller
                ctrler_.enterKey(key_.toString());
                // get a fresh buffer for a new user key
                key_ = new StringBuffer();
            }
        }
    }
}
}



} // end of HomeAccessControlSystem class
