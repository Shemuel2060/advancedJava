package conceptPractices.sorting.interfaces;

public class Candidate implements Comparable<Candidate> {
    int id;
    int year;
    String name;
    String College;
    
    // constructor method
    public Candidate(int id, int yr, String name, String College){
        this.id = id;
        this.year = yr;
        this.name = name;
        this.College = College;
    }

    @Override
    public int compareTo(Candidate o) {
        if(this.year == o.year){
            return this.name.compareTo(o.name);
        }
        else{
            if(this.year < o.year) return 1;
            if(this.year > o.year) return -1;
            else return 0;
        }
    }  
    
}
