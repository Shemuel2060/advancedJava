package conceptPractices.sorting.functionalInterfaces;

import java.util.HashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Function_FI{

    // map object to store pupils data
    static HashMap<Integer, String> students = new HashMap<>();

    /**
     * Adds a student to the hashmap students. The method checks
     * whether a given id is in the list, if yes, returns a 
     * message to show that, otherwise, adds the student into the 
     * list.
     * @param id
     * @param name
     */
    public static void addStudent(int id, String name){
        if(!students.containsKey(id)){
            students.put(id, name);
        }else{
            System.out.println("Student already exists");
        }        
    }

    /**
     * This method takes two names, and compares which is 
     * longer and returns that...
     * @param oneName
     * @param anotherName
     * @return
     */
    public static String longerName(String oneName, String anotherName) {
       
       BinaryOperator<String> longer =   (fname,sname)  ->{
        // String lName=sname; // initialize longer name as the second name
        if(fname.length() > sname.length()){
            return "\""+fname+"\"" + " is the longer than \""+sname+"\"";
        }else if(fname.length()==sname.length()){
            return "Both \"" +fname+"\" and \""+sname +"\" are of the same length";
        }else{
            return "\""+sname+"\"" + " is the longer than \""+fname+"\""; // te if-condition is false, longer name is the sname
        }
        
       };
       // invoke the apply() to use the lambda
       return longer.apply(oneName,anotherName);
    }

    /**
     * queries whether a given name exists in the candidate's
     * list or not. 
     * @param name
     * @return message showing that one is a candidate or not
     */
    public static String isCandidate(String name){
         UnaryOperator<String> not = (String anotherName)->{
            anotherName = name;
        if(students.containsValue(anotherName)){
            return anotherName.toUpperCase() + " is a candidate";
        }else    
            return anotherName.toUpperCase() + " is not a candidate";
      };// end of lambda 
      return not.apply(name);       
      } // end of isCandidate()

      /**
       * Extracts from the list of candidates one with the given id.
       * This method uses the get Lambda expression to implement the 
       * abstract method in the Function FI. 
       * @param id
       * @return candidate's name with given id
       */
      public static String getCandidate(Integer id){

        Function<Integer,String> get = (Integer idInteger)->{
            idInteger=id;
        if(students.containsKey(idInteger))
            return students.get(idInteger);
        else
            return idInteger +" is not in the candidates' list";
      };  
      return get.apply(id);
      }

      public static Integer numOfStudents(){
        Supplier<Integer> num = ()-> students.size();
        return num.get();        
      }

      /**
       * This method takes the index and name of a student, and
       * returns the student after that one in the list of students.
       */
    //   public static void nextStudentAfterThis(int idx, String stuName){
    //     BiConsumer<Integer, String> nextIn = (Integer idxNumber, String name)->{
    //         idx = idxNumber++; // index for next student...

    //     };
    //     nextIn.accept(34, "Samuel");
    //   }


    public static void main(String[] args) {

        // add students to the HashMap
      addStudent(29,"Melvin Muganyizi");
      addStudent(30, "Muwonge Sadat");
      addStudent(31, "Nsaddu Reyon");
      addStudent(32, "Nisha Kabalungi");
      addStudent(33, "Nsubuga Daniel Trevor");
      addStudent(34, "Shabirah Nakkazi");
      addStudent(35, "Viola Mwesigwa");
      addStudent(36, "Oyella Sohfi");
      addStudent(37, "Peter Kabenge");
      addStudent(38, "Philipa Mutebi Kimala");
      addStudent(39, "Male Johnson");
      addStudent(40, "Mubiru Brian");
      addStudent(41, "Nsamba Ashiraf");
      addStudent(42, "Naddumba Esther Rose");
      addStudent(43, "Kitiibwa Esther");
      addStudent(44, "Nalumansi Jane Babirye");

    //  String candidate = isCandidate("Meridith Katongole");
    //  String candi = getCandidate(349);
    //  System.out.println(candi +"\n");
    //  System.out.println(candidate);

    String longName = longerName("Esther", "Melviny");
    System.out.println("\n" + longName + "\n");

    System.out.println("Number of students in the class: "+numOfStudents());
    
    }    
}
