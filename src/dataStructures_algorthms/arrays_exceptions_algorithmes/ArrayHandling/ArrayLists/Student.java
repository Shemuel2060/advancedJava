package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.ArrayLists;

/**
 * This class holds a student with their name and
 * their class name.
 */
public class Student {
    private String name;
    private String form; // the class

    // constructor
    /**
     * Creates a new student with the given name and class
     * @param name
     * @param form
     */
    public Student(String name, String form) {
        this.name = name;
        this.form = form;
    }

    /**
     * create a new student with the given name only
     * @param name
     */
    public Student(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }
    public String getform() {
        return form;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setform(String form) {
        this.form = form;
    }

    
}


