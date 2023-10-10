package MyProgrammingLabs.spellchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import java.util.Scanner;

/**
 * This class handles reading and writing files. It reads words from the
 * "word.txt" file and writes the sorted list to a new file provided by the
 * user.
 */
public class FileHandler {
    Scanner userFileIn; // used to access a file from a directory...

    /**
     Lets the user select an input file using a standard file
     selection dialog box. If the user cancels the dialog
     without selecting a file, the return value is null.
     */
    public static File readFileFromUser() {

        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileDialog.getSelectedFile();
    }

    /**
     * This method reads a particular word from the file the user has chosen.  
     */        
    public String readWordsFromUserFile(String wordInFile) {
        
        try {
            userFileIn = new Scanner(readFileFromUser());
            userFileIn.useDelimiter("[^a-zA-Z]+"); /* avoid all 
                                                   non-letter characters*/
            while (userFileIn.hasNext()) {
                String word = userFileIn.next();
                if (word == wordInFile) {
                    return word;
                } else {
                    return null;  // word not in file
                }
                               
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
        
    }
    
        public void writeFile() {
            
        
        
    }
}
