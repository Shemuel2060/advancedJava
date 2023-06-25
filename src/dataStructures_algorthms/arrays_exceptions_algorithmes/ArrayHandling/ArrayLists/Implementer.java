package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.ArrayLists;


// the Gson library to work with json objects
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This is an implementation class for the concept of
 * ArrayLists. It creates a list of students and uses
 * it to perform some operations. The students are got
 * from a Json file. 
 */
public class Implementer {
    static ListOfStudents list = new ListOfStudents();
    // static Gson gson = new Gson(); // gson object work with Json objects
    static Gson gson =new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        // create student object
        // need to create about 13 students.....
           
        /*conver a java object into a json object or a list of java objects
        to a list of json objects*/
            Student student1 = new Student("Naddumba Esther", "p.7");
            Student student2 = new Student("Kalungi Timothy", "p.6");
            Student student3 = new Student("Namigadde Assumpter", "p.6");

            list.addStudent(student1);
            list.addStudent(student2);
            list.addStudent(student3);

            
            var json = gson.toJson(student1); // single student to json
            var jsonMany = gson.toJson(list); // multiple students to json

            // convert student object to json object
            System.out.println("\n---Single student to Json---\n");
            System.out.println(json);
            System.out.println("\n---Many students to Json---\n");
            System.out.println(jsonMany);   
        
            
            System.out.println(list.isEmpty()); // not yet added student to lis


            /*
             * conver a json object into a java object or a list of json objects
             * to a list of java objects
             */

            




        


    }
    
}
