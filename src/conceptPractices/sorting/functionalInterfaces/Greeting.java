package conceptPractices.sorting.functionalInterfaces;

import java.util.Scanner;

@FunctionalInterface
public interface Greeting {
    String greeting(String name);
}
class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("May I know your name, please?");
        String name = scan.nextLine();
        Greeting hello = (String temp)-> "hello, " + temp;

        System.out.println(hello.greeting(name));
    }
    
}