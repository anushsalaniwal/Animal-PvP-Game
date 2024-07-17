// Main Class File:    Assignment8.java
// File:               Carnivore.java
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


/* This interface includes the 1 methods needed 
for Carnivore in CSE11 Spring quarter 2024.
The methods are listed here: eatAnimal.
*/
/**
 * This is the interface which lets the animals be carnivores and lets them be 
 * able to eat another animal.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/
public interface Carnivore {
    // method that gets overrided in subclass. 
    // This method takes in an Animal and returns nothing
    void eatAnimal(Animal animal);
}
