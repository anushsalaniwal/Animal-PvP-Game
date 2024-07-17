//////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment8.java
// File:               Leopard.java
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


/* This class includes the 2 constructers and 6 methods needed 
for Leopard in CSE11 Spring quarter 2024. The constructors are listed
here: Leopard and Leopard.
The methods are listed here: getName, sameSpecies, sleep, isPoisonous, 
eatAnimal, toString.
*/
/**
 * This is a subclass of Animal and implements Carnivore. This class creates a 
 * Leopard that will be one of the players in the game.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/
public class Leopard extends Animal implements Carnivore {
    private static final String NAME = "Leopard";
    private static final double SLEEPMULTIPLIER = 1.5;
    private static final double CARCASSMULTIPLIER = 0.55;
    // no-arg constructor
    public Leopard() {
        super();
    }
    // This constructor sets the age, health, and strength in its superclass
    public Leopard(int age, double health, double strength) {
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
    // returns true only when the current Leopard has the same NAME as the input 
    // animal. Otherwise, it returns false. This method takes in an Animal and 
    // returns a boolean type
    @Override
    public boolean sameSpecies(Animal animal) {
        return animal instanceof Leopard && NAME.equals(animal.getName());
    }
    // This method overrides the sleep() method in Animal. When a Leopard sleeps
    // their strength increases by 1.5 times. This method tkaes in no parameters
    // and returns nothing
    @Override
    public void sleep() {
        setStrength(getStrength() * SLEEPMULTIPLIER);
    }
    // This method overrides the isPoisonous() method in Animal. Leopards aren't
    // poisonous, so it returns false. This method tkaes in no parameters
    // and returns a boolean type
    @Override
    public boolean isPoisonous() {
        return false;
    }
    // When a Leopard eats another animal, it gains 60% of that animal's
    // strength. This method takes in an Animal and returns nothing
    @Override
    public void eatAnimal(Animal animal) {
        setStrength(getStrength() + (animal.getStrength() * CARCASSMULTIPLIER));
    }
    // This method will give you the String representation of a Leopard.
    // This method takes in no parameters and returns a String
    @Override
    public String toString() {
    return super.toString() + "; species: Leopard";
    }
}
