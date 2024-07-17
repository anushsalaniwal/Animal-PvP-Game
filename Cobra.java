//////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment8.java
// File:               Cobra.java
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

import java.util.Random;

/* This class includes the 2 constructers and 7 methods needed 
for Cobra in CSE11 Spring quarter 2024. The constructors are listed
here: Cobra and Cobra.
The methods are listed here: getName, sameSpecies, sleep, isPoisonous, 
eatAnimal, poisonAnimal, toString.
*/
/**
 * This is a subclass of Animal and implements Carnivore. This class creates a 
 * Cobra that will be one of the players in the game.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

public class Cobra extends Animal implements Carnivore {
    private static final String NAME = "Cobra";
    private static final double SLEEPMULTIPLIER = 1.7;
    private static final double CARCASSMULTIPLIER = 0.9;
    private static final double POISONCHANCE = 0.8;
    // no-arg constructor
    public Cobra() {
        super();
    }
    // This constructor sets the age, health, and strength in its superclass
    public Cobra(int age, double health, double strength) {
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
    // returns true only when the current Cobra has the same NAME as the input 
    // animal. Otherwise, it returns false. This method takes in an Animal and 
    // returns a boolean type
    @Override
    public boolean sameSpecies(Animal animal) {
        return animal instanceof Cobra && NAME.equals(animal.getName());
    }
    // This method overrides the sleep() method in Animal. When a Cobra sleeps
    // their strength increases by 1.7 times. This method takes in no parameters
    // and returns nothing
    @Override
    public void sleep() {
        double currentStrength = getStrength();
        setStrength(currentStrength * SLEEPMULTIPLIER);
    }
    // This method overrides the isPoisonous() method in Animal. Cobras are
    // poisonous, so it returns true. This method tkaes in no parameters
    // and returns a boolean type
    @Override
    public boolean isPoisonous() {
        return true;
    }
    // When a Cobra eats another animal, it gains 90% of that animal's
    // strength. This method takes in an Animal and returns nothing
    @Override
    public void eatAnimal(Animal animal) {
        double eatenStrength = animal.getStrength() * CARCASSMULTIPLIER;
        double newStrength = getStrength() + eatenStrength;
        setStrength(newStrength);
    }
    // This method overrides the poisonAnimal() method in Animal. A Cobra has a
    // 80% chance to poison the other animal when fighting.
    // This method takes in no parameters and returns a boolean type
    @Override
    public boolean poisonAnimal() {
        Random random = new Random();
        return random.nextDouble() < POISONCHANCE;
    }
    // This method will give you the String representation of a Cobra.
    // This method takes in no parameters and returns a String
    @Override
    public String toString() {
    return super.toString() + "; species: Cobra";
    }
}
