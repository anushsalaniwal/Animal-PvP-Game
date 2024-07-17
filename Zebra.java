//////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment8.java
// File:               Zebra.java
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

/* This class includes the 2 constructers and 6 methods needed 
for Zebra in CSE11 Spring quarter 2024. The constructors are listed
here: Zebra and Zebra.
The methods are listed here: getName, sameSpecies, sleep, isPoisonous, 
eatPlant, toString.
*/
/**
 * This is a subclass of Animal and implements Herbivore. This class creates a 
 * Zebra that will be one of the players in the game.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/
public class Zebra extends Animal implements Herbivore{
    private static final String NAME = "Zebra";
    private static final double SLEEPMULTIPLIER = 1.3;
    private static final int PLANTUPPERLIMIT = 41;
    // no-arg constructor
    public Zebra() {
        super();
    }
    // This constructor sets the age, health, and strength in its superclass
    public Zebra(int age, double health, double strength) {
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
    // returns true only when the current Zebra has the same NAME as the input 
    // animal. Otherwise, it returns false. This method takes in an Animal and 
    // returns a boolean type
    @Override
    public boolean sameSpecies(Animal animal) {
        return animal instanceof Zebra && NAME.equals(animal.getName());
    }
    // This method overrides the sleep() method in Animal. When a Zebra sleeps
    // their strength increases by 1.3 times. This method takes in no parameters
    // and returns nothing
    @Override
    public void sleep() {
        double currentStrength = getStrength();
        setStrength(currentStrength * SLEEPMULTIPLIER);
    }
    // This method overrides the isPoisonous() method in Animal. Zebras aren't
    // poisonous, so it returns false. This method tkaes in no parameters
    // and returns a boolean type
    @Override
    public boolean isPoisonous() {
        return false;
    }
    // A Zebra instance is an herbivore, so they don’t eat animals. Instead, 
    // they feed on some plants and will randomly gain between 0 and 40 strength
    // This method takes in no parameters nad returns nothing
    public void eatPlant() {
        Random random = new Random();
        double strengthGained = random.nextInt(PLANTUPPERLIMIT);
        double newStrength = getStrength() + strengthGained;
        setStrength(newStrength);
    }
    // This method will give you the String representation of a Zebra
    // This method takes in no parameters and returns a String
    @Override
    public String toString() {
    return super.toString() + "; species: Zebra";
    }
}
