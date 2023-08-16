package conceptPractices.sorting.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Level implements Isaveable {

    private String levelStatus; // include: candidate, semi-candidate, non-candidate
    private int levelNumber; // e.g. 1,2,3,4,5,6,7

    Level(String lStatus, int lNumber) {
        this.levelStatus = lStatus;
        this.levelNumber = lNumber;
    }

    public String getLevelStatus() {
        return levelStatus;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    @Override
    public void read(List<String> savedData) {
        if(savedData!=null && savedData.size()>0){
            this.levelStatus = savedData.get(0);
            this.levelNumber = Integer.parseInt(savedData.get(1));
        }else{
            System.out.println("No data for the class of pupil");
        }

    }

    @Override
    public List<String> write() {
        List<String> levelInfo = new ArrayList<String>();
        levelInfo.add(this.levelStatus);
        levelInfo.add(""+ this.levelNumber);
        
        return levelInfo;
    }

    @Override
    public String toString() {
        return "Status: " + levelStatus + ", Class: " + levelNumber + "";
    }

}
