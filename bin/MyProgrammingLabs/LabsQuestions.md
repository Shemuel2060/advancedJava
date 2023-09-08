Lab 06 - Classes
Introduction
What are Classes and Objects?

Classes are simply blueprints that define how to create and use an object.

Classes can contain public or private instance variables that an object and an its methods can use.

Public instance variables are accessible both within and outside of the class they are contained in.
Private instance variables are only accessible within the class, such as in a class’s methods.
A class also contains methods that can be called either statically or dynamically.

Dynamic methods must be called on an object.
Static methods do not require the instantiation of an object, and instead are called on the class itself.
How to Initialize Objects
At this point, you have already initialized objects. For example, you’ve seen the initialization of a Scanner object, like below.

Scanner scnr = new Scanner(System.in);
The first step when initializing an object is similar to initializing a variable:

Type variableName =
In the Scanner shown above, the Type is Scanner and the variableName is scnr.

Objects differ from variables in the following ways:

Rather than initializing the variable directly with a value, objects use the new keyword in their initialization, followed by the constructor, which we will talk about below. The new keyword tells the program that we want to allocate memory for an object to exist in.

The object’s constructor follows the new keyword. A constructor is a special method that instantiates an object from a class, and it sometimes defines certain aspects of the object at the time of initialization.

Remember that a class can be thought of as a blueprint. Think of a constructor as a builder inside of a class that is in charge of actually creating the object.

Constructors often accept arguments as input to initialize instance variables. Just like other methods, constructors can have any number of arguments. When calling the constructor, the number of arguments passed in must match the number of parameters in the constructor’s definition.

Constructors are unique in that the name of the constructor is exactly the same name as the class, with no return type. As shown in the class below, the class name is “Dog”, and the constructor name is also “Dog”. YES, capitalization does matter!

Let’s look at an example of a constructor.

Here is a class called Dog.

1
2
3
4
5
6
7
8
9
10
11
12
13
public class Dog {
    //These are instance variables
     private String name;
     private String breed;
     private int age;
    
     //This is the Constructor
     public Dog(String name, String breed, int age){
         this.name = name;
         this.breed = breed;
         this.age = age;
     }
}
Here, the constructor takes a String for a name of a dog, another String for a breed of a dog, and finally an int for the age of a dog. The constructor’s purpose is to initialize the instance variables, as seen in the constructor’s body.

Notice that the instance variables have the same name as the constructor arguments. This could cause some confusion for the compiler.

That confusion from naming conflicts is resolved by the this keyword, which references the current object. In this case, since the instance variables and the constructor arguments have the same name, the this keyword must be used.

In the constructor’s body, the this.variable elements represent the instance variables, whereas the other variables not attached to this are the arguments passed into the constructor.

Variables Review
As a quick review, remember there are two common access modifiers for variables in a class: public and private. Public variables are visible and modifiable by anyone. Private are visible and modifiable only within the class, unless you are using Mutators and Accessors.

Mutators and Accessors
Mutators and Accessors are also referred to as setters and getters. They are public methods that allow the user to mutate/set, or access/get the values of private or public instance variables.

Mutators and Accessors allow for control over which variables can be seen and changed by other users, programs, or classes.

Mutator
A mutator, often called a setter, is a public method that allows the user to change the value stored in a variable. Setters are typically public methods that return nothing. They are commonly named in the style set/*Variable Name*/ and take an input that is of the same type as the variable being modified.

For example, here is a sample setter for the Dog class we saw above to change the value stored in the name variable.

public void setName(String newName){
    //name is an instance variable
    name = newName;
}
Accessor
An accessor, or often called a getter, is a public method that allows the user to access information from an instance variable. Almost all getters will be public methods that return a variable of the same type as the variable being accessed. A typical naming convention for getters is get/*Variable Name*/, and takes no variables as an input.

For example, here is a getter for the above Dog class to see what the current value of the name variable is.

public String getName(){
    //name is an instance variable
    return name;
}
Initializing an Object and Using Methods
Initializing Objects
Below is an example of how to call a constructor and make an object with the Dog class.

public static void main(String args[]){
    Dog sampson = new Dog("Sampson", "English Retriever", 3);
}
As stated earlier, the initialization is similar to that of a Scanner object. In this case, the object type is Dog and variable name is sampson. On the right side of the assignment operator, the constructor is called with the necessary arguments.

A more general object initialization is shown below:

objectType variableName = new objectType_Constructor();
Calling Methods with Objects
Once an object is created, methods can be called to do all sorts of things, such as change instance variables.

Methods that are non-static are called with an object.

Below, we call a method on an object that returns a string representing the name, all contained within a print statement.

public static void main(String args[]){
    Dog sampson = new Dog("Sampson", "English Retriever", 3);
    System.out.println(sampson.getName());
}

Output:
Sampson
The syntax for calling an object is the object’s name followed by a ‘.’ and then the method name.

objectName.methodName();
One of the advantages of objects is reusable code. As shown below, two different objects are initialized but have the same methods called. Since the instance variables of each object contain different values, this causes different results with the same method.

public static void main(String args[]){
    Dog sampson = new Dog("Sampson", "English Retriever", 3);
    Dog maggie = new Dog("Maggie", "German Shepard", 5);
    System.out.println(sampson.getName());
    System.out.println(maggie.getName());
}

Output:
Sampson
Maggie
ZyLabs Assignment
In this assignment, you are given two files. The goal is to finish a Class’s Constructor, Accessors, Mutators, methods and test your code.

The details of the files are as follows:

CarMain.java
This file contains your main method (public static void main(String[] args)), which also means it is an entry point into your program. Looking through this file, you will see a number of methods designed to help you test your code. It is very common practice that for every method you write, you write a secondary method to test it.

Car.java
This is the heart of your program logic. You will code all of the methods and the constructor in this class. This Class stores information about a car in its instance variables. The variables include a cars’ year, model, miles and fuel tank level. Since this is the majority of the coding, let’s start here! Select the file Car.java in the drop down.

Part 1: Car’s Constructor
In part 1, you are going to write the constructor body for the Car class. This will initialize the instance variables. The instance variables have been provided for you. Notice that the instance variables and arguments of the constructor have the same variable names. How can you distinguish between these variables?

Part 2: getYear(), getModel(), getMiles(), getFuelTankLevel()
In part 2, you will finish writing the accessors for each of the instance variables. Return the information for each respective instance variable.

Testing getYear(), getModel(), getMiles(), getFuelTankLevel()
When you run the program, it will automatically test the method by calling gettersTests(). You should find that method in CarMain.java. You should add your own tests, as we only have a limited amount of tests.

Part 3: addMiles(int milesToAdd)
The addMiles method is a method that will add to the current amount of miles already driven by a car. The miles instance variable holds the total amount of miles for a given car. For example, with the following code the miles variable for the car should end up being 200,150.

public static void main(String args[]){
    Car vw = new Car(1969, "Volkswagon Beetle", 200000, 100);
    vw.addMiles(150);
}
Testing addMiles(int milesToAdd)
There is a prewritten method called addMilesTests() method found in CarMain.java. You should add your own tests, as we only have a limited amount of tests. Think about what happens if addMiles is called more than once on a car?

Part 4: isFuelTankEmpty()
This method returns true or false based on if a given cars fuel tank level is 0.

Hint: Which instance variable can give information on a fuel tank level?
Testing isFuelTankEmpty()
After writing this method check the method isFuelTankEmptyTests() in CarMain.java. There are prewritten test here. Make sure to add your own tests as well.

Part 5: milesToFuelLevel(int miles)
For this next method, you will write a conversion from miles to fuel level percentage. Since the fuelTankLevel variable represents a percentage, you will need to convert accordingly. For this method, assume that every car fuel tank has a maximum capacity of 400 miles. Return a ratio between miles and the fuel tank capacity as a percentage. (i.e. 62.5)

Testing milesToFuelLevel(int miles)
After writing this method check the method milesToFuelLevelTests() in CarMain.java. There are prewritten tests here. Make sure to check if you are returning a percentage or a decimal representation.

Part 6: modifyFuelTankLevel(int miles)
For this method, you will write a method that changes a car’s fuel tank level depending on the amount of miles inputted. Only change the fuel tank level if the fuel tank is not empty. If the miles inputted causes the fuel tank level to be negative, make the fuel tank level 0.

Hint: What previous methods could help with this?
Testing modifyFuelTankLevel(int miles)
After writing this method check the method modifyFuelTankLevelTests() in CarMain.java. Make sure to add your own tests. If a fuel tank becomes negative is it set appropriately? Do your previous methods reflect the same information?

Part 7: drive(int miles)
For the last part of this assignment, you will write a that method “drives” a car. This method returns a string with a status of either the cars total mileage and fuel tank level, or if the fuel tank is empty. This method will also change a cars miles and fuel tank level. For example, calling drive with an input of 150, with a car that is a 2019 Honda CRV with 11,000 miles and a fuel tank level of 100%, will result in the following output.

The 2019 Honda CRV drove 150 miles, for a total mileage of 11150 and a fuel tank level of 62.5%.
If the Car object’s fuel tank level is empty, then the following would be outputted.

The 2019 Honda CRV's fuel tank is empty!
Hint: Take a look at the previous written methods. Could these help?
Testing drive(int miles)
Since this method is returning two different strings depending on a cars instance variables, it would be best to test for each string separately. For example, first write the code for if a cars fuel tank is empty. Is it returning the correct string and format? Next, write the code for a fuel tank that is not empty. Is this string returned correctly?