//////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment8.java
// File:               Toad.java
// Quarter:            Spring 2024
//
// Author:             CSE 11 Staff
// Instructor's Name:  Benjamin Ochoa
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          None.
//
// Online sources:   None.


/* This class includes the 2 constructers and 7 methods needed 
for Toad in CSE11 Spring quarter 2024. The constructors are listed
here: Toad and Toad.
The methods are listed here: getName, sameSpecies, sleep, isPoisonous, 
eatAnimal, poisonAnimal, toString.
*/
/**
 * This is a subclass of Animal and implements Carnivore. This class creates a 
 * Toad that will be one of the players in the game.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/
public class Toad extends Animal implements Carnivore {
    private static final String NAME = "Toad";
    private static final double SLEEPMULTIPLIER = 1.2;
    private static final double BUGMULTIPLIER = 0.3;
    private static final double POISONCHANCE = 0.3;
    private static final int BUGUPPERLIMIT = 11;
    // no-arg constructor
    public Toad() {
        super();
    }
    // This constructor sets the age, health, and strength in its superclass
    public Toad(int age, double health, double strength) {
        super(age, health, strength);
    }
    // This method overrides the getName() method in Animal. Simple getter 
    // method that returns the NAME static variable. This method takes in no 
    // parameters and returns a String
    @Override
    public String getName() {
        return NAME;
    }
    // This method overrides the sameSpecies() method in Animal. This method
    // returns true only when the current Toad has the same NAME as the input 
    // animal. Otherwise, it returns false. This method takes in an Animal and 
    // returns a boolean type
    @Override
    public boolean sameSpecies(Animal animal) {
        return animal instanceof Toad && NAME.equals(animal.getName());
    }
    // This method overrides the sleep() method in Animal. When a Toad sleeps
    // their strength increases by 1.2 times. This method takes in no parameters
    // and returns nothing
    @Override
    public void sleep() {
        setStrength(getStrength() * SLEEPMULTIPLIER);
    }
    // This method overrides the isPoisonous() method in Animal. Toads are
    // poisonous, so it returns true. This method tkaes in no parameters
    // and returns a boolean type
    @Override
    public boolean isPoisonous() {
        return true;
    }
    // A Toad will eat bugs off a dead animal carcass instead of the carcass 
    // itself. Each bug increases the Toad's strength by 30% of the carcass's 
    // strength. The number of bugs eaten is randomly chosen between 0 and 10. 
    // This method takes in an Animal and returns nothing
    @Override
    public void eatAnimal(Animal animal) {
        int bugsEaten = (int) (Math.random() * BUGUPPERLIMIT);
        double strengthIncrease = bugsEaten * (animal.getStrength() * BUGMULTIPLIER);
        setStrength(getStrength() + strengthIncrease);
    }
    // This method overrides the poisonAnimal() method in Animal. A Toad has a
    // 30% chance to poison the other animal when fighting. This method takes in
    // no parameters and returns a boolean type.
    @Override
    public boolean poisonAnimal() {
        return Math.random() < POISONCHANCE; 
    }
    // This method will give you the String representation of a Toad.
    // This method takes in no parameters and returns a String
    @Override
    public String toString() {
    return super.toString() + "; species: Toad";
    }
}
