// Main Class File:    Assignment8.java
// File:               Animal.java
// Quarter:            CSE 11 Spring 2024
//
// Author:             Anush Salaniwal.
// Email:              ansalaniwal@ucsd.edu
// Instructor's Name:  Professor Ochoa.
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          None.
//
// Online sources:   None.


/* This class includes the 2 constructers and 9 methods needed 
for Animal in CSE11 Spring quarter 2024. The constructors are listed
here: Animal and Animal.
The methods are listed here: getAge, getHealth, getStrength, getName, setHealth,
setStrength, attack, poisonAnimal, toString.
*/
/**
 * This is the superclass for most of the other classes in this assignment. 
 * The abstract Animal class initializes the core characteristics of an Animal 
 * and defines the default behavior of specific methods.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

public abstract class Animal {
    // Private data fields
    private int age;
    private double health;
    private double strength;
    private static final String NAME = "Animal";
    
    // no-arg constructor; default constructor
    protected Animal() {
        this.age = 0;
        this.health = 0;
        this.strength = 0;
    }
    // This constructor sets the corresponding instance variables of the object 
    // to what the caller of the constructor passed in as arguments.
    protected Animal(int age, double health, double strength) {
        this.age = age;
        this.health = health;
        this.strength = strength;
    }
    
    // Getter method for age. This method takes in no parameters and returns an 
    // integer
    public int getAge() {
        return age;
    }
    // Getter method for health. This method takes in no parameters and returns 
    // a double
    public double getHealth() {
        return health;
    }
    // Getter method for strength. This method takes in no parameters and returns 
    // a double
    public double getStrength() {
        return strength;
    }
    // Getter method for NAME. This method takes in no parameters and returns 
    // a String
    public String getName() {
        return NAME;
    }
    
    // Setter method for health. This method takes in a double and returns 
    // nothing
    public void setHealth(double health) {
        this.health = health;
    }
    // Setter method for strength. This method takes in a double and returns 
    // nothing
    public void setStrength(double strength) {
        this.strength = strength;
    }
    
    // Attack method: This method creates a random double with a value between 
    // 1 and the maximum strength of the animal. It then does damage to the 
    // other animal. This method takes in an Animal and returns a double.
    public double attack(Animal animal) {
        double damage = 1 + (Math.random() * (this.strength - 1));
        animal.setHealth(animal.getHealth() - damage);
        return damage;
    }
    
    // Abstract methods to be overridden by subclasses
    public abstract boolean sameSpecies(Animal animal);
    public abstract void sleep();
    public abstract boolean isPoisonous();
    
    // Default implementation of poisonAnimal. This method takes in no 
    // parameters and returns a boolean
    public boolean poisonAnimal() {
        return false;
    }
    
    // This method will give you the String representation of an Animal
    // This method takes in no parameters nad returns a String
    @Override
    public String toString() {
        return "(Animal)" + "age:" + getAge() + "; health: " + getHealth() + 
        "; strength:" + getStrength();
    }
}
