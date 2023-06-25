package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.SearchingAndSortingAlgorithms.AssoaciationLists;

import java.util.Arrays;

/**
 * A phone directory holds a list of phone contacts with the name
 * and number of a person. It is possible to do the get operation,
 * that is, find a number (value) associated with some name (key)
 * or the put operation insert into the directory a new name-number
 * pair which is a key-value pair.
 */
public class PhoneDirectory {

    /**
     * This is an inner/nested class which can only be used inside
     * the PhoneDirectory "parent" class. This creates a single
     * phone entry, that is, a single person.
     */
    private class PhoneEntry {
        private String name; // the name key
        private String number; // the associated phone number
    }

    private PhoneEntry[] data; // holds a list of names with associated numbers
    private int dataCount; // keep track of contacts amount.

    /**
     * Constructor creates an empty phone directory.
     */
    public PhoneDirectory() {
        data = new PhoneEntry[1];
        dataCount = 0;
    }

    /**
     * This is to find the index of a name in the phone directory and
     * return it. If not there, it returns -1.
     * @param name
     * @return index or -1
     */
    private int find(String name) {
        for (int i = 0; i < dataCount; i++) {
            if (data[i].name.equals(name))
                return i; // name found at this index i
        }
        // at this point it means name is not in the phone directory list
        return -1;
    } // end of the find()
    
    /**
     * Finds the number associated with a given name in the list. This is 
     * the get operation done in associated lists.
     * @param name
     * @return The phone number if in the list and null if not in
     * the list.
     */
    public String getNumber(String name) {
        int index = find(name);
        if (index == -1)
            return null; // name not in list
        return data[index].number; // the number got.        
    } // end of the getNumber()
    

    /**
     * This puts an associated number with a name into the list. If
     * the name alrady exists, then it replaces the old number with
     * the new number. However, if the name does not exist, it inserts
     * it into the list. 
     *      Precondition: name and number should be non-null
     * @param name
     * @param number
     */
    public void putNumber(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("name and/or number cannot be null");
        }

        int i = find(name); // check if name exists
        if (i >= 0) { // name exists
            data[i].number = number; // just replace the number            
        } else {
            // at this point the name does not exist in the list
            PhoneEntry newEntry = new PhoneEntry(); // new name-number pair
            if (dataCount == data.length) { // list is full
                // create larger list copying the old one into it
                data = Arrays.copyOf(data, 2 * data.length);
            }
            // list not full or full
            newEntry.name = name; // set name into the phone entry
            newEntry.number = number; // set number into the phone entry
            data[dataCount] = newEntry; // insert the new phone entry into the list
            dataCount++; // increment the data count.
        }
    }// end of the putNumber()
    


    public static void main(String[] args) {
        PhoneDirectory phoneDir = new PhoneDirectory();

        // put some name-number pairs
        phoneDir.putNumber("Samuel Katongole", "0772-698964");
        phoneDir.putNumber("Moureen Katongole", "0752-517227");
        phoneDir.putNumber("Allan Baliddawa", "0778-373829");
        phoneDir.putNumber("Josephine Kaggwa", "0772-184987");

        String number = phoneDir.getNumber("Samuel Katongole");
        System.out.println("My phone number: " +number);
    } // end of the main()

} // end of the PhoneDirectory class
