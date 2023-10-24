package streams_files_networking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The class demonstrates reading from and writing to
 * a file using buffering. Buffering improves the speed
 * of these operations than using just input and output
 * classes like FileInputStream and FileOutputStream. 
 */
public class BufferedIODemo {

    // filepaths where to read and write files to.
    static String infileStr = "C:\\Users\\INTEL\\DESKTOP\\PROJECTS\\PRACTICES\\JAVA\\ADVANCED CONCEPTS\\AdvancedTopicsInJava\\src\\streams_files_networking\\img.png"; // original file to read from
    static String outfileStr = "C:\\Users\\INTEL\\DESKTOP\\PROJECTS\\PRACTICES\\JAVA\\ADVANCED CONCEPTS\\AdvancedTopicsInJava\\src\\streams_files_networking\\imgcopy.png"; // new file to write to.

    public static void main(String[] args) {
        copyFileWithBuffering();        
    } 

    public static void copyFileWithBuffering() {

        // just to get the length of the file
        File fileIn = new File(infileStr);
        System.out.println("File size is: "+fileIn.length()+" bytes");
    
        // try-with resources construct, automatically includes a finally clause which closes the streams.
        try(BufferedInputStream inbuf = new BufferedInputStream(new FileInputStream(infileStr));
                BufferedOutputStream outbuf = new BufferedOutputStream(new FileOutputStream(outfileStr));)
        {
            byte[] byteBuf = new byte[4000]; // set size of byte[] 
            int numBytesRead; // number of bytes read
            while ((numBytesRead = inbuf.read(byteBuf)) != -1) {
                outbuf.write(byteBuf, 0, numBytesRead); // write to new file...
            }
            System.out.println("File copied");
            
        }catch(IOException e){
            e.printStackTrace();
        }
            
        }
    
}
