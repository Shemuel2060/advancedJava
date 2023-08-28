package conceptPractices.sorting.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Pupil implements Isaveable {
    private String name;
    private int age;
    private Level level; // the class the pupil is in.

    Pupil(String name, int age, Level level) {
        this.name = name;
        this.age = age;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public List<String> write() {
        List<String> pupilInfo = new ArrayList<String>();
        pupilInfo.add(name);
        pupilInfo.add(Integer.toString(age));
        pupilInfo.add(level.toString());

        return null;

    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age + ", " + level + "]";
    }

    @Override
    public void read(List<String> savedData) {
        this.name = savedData.get(0);
        this.age = Integer.parseInt(savedData.get(1));
        // this.level = Level.valueOf(savedData.get(2));

    }

}
