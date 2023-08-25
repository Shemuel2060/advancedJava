package conceptPractices.sorting.functionalInterfaces;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Function_FI{

    // map object to store pupils data
    static HashMap<Integer, String> students = new HashMap<>();

    /**
     * Adds a student to the hashmap students.
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
       * @param id
       * @return candidate's name with given id
       */
      public static String getCandidate(Integer id){
        /**
       * The get Lambda expression implements the abstract method in the 
       * Function FI. 
       */
        Function<Integer,String> get = (Integer idInteger)->{
            idInteger=id;
        if(students.containsKey(idInteger))
            return students.get(idInteger);
        else
            return idInteger +" is not in the candidates' list";
      };  
      return get.apply(id);
      }

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

     String candidate = isCandidate("Meridith Katongole");
     String candi = getCandidate(34);
     System.out.println(candi +"\n");
     System.out.println(candidate);
    
    }
    
    
}
