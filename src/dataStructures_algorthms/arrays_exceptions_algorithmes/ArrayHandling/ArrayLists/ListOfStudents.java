package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.ArrayLists;

import java.util.ArrayList;

/**
 * This class creates an arraylist with the objects of 
 * the Student class. Essentially this class creates a 
 * dynamic list of students 
 */
public class ListOfStudents {

    private ArrayList<Student> studentList = new ArrayList<Student>();


    
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * add a student to the end of the list. Increment list size
     * by 1.
     * @param student
     */
    public void addStudent(Student student) {
        studentList.add(student);
    }
    
    /**
     * Inserts the specified element at the specified 
     * position in this list. Shifts the element 
     * currently at that position (if any) and any 
     * subsequent elements to the right (adds one to their
     * indices).
     * 
     * @param student
     * @param index
     */
    public void addStudentAtIdex(Student student, int index) {
        studentList.add(index, student);
    }

    
    /**
     * returns true or false depending on whether or not the
     * student list has any students.
     * @return boolean
     */
    public boolean isEmpty() {
        boolean empty = false;
        boolean size = studentList.isEmpty();
        if (size) {
            empty = true;
        } else {
            empty = false;
        }
        return empty;
    }


    
    /**
     * remove a student from the list
     * @param student
     */
    public void removeStudent(Student student) {
        studentList.remove(student);
    }
    
}
