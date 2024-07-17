//////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment8.java
// File:               Assignment8.java
// Quarter:            Spring 2024
//
// Author:             CSE 11 Staff
// Instructor's Name:  Benjamin Ochoa
///////////////////////////////////////////////////////////////////////////////

// This is the class where the main method, 
// along with all applicable unit tests, 
// are executed in Assignment8 Spring quarter 2024.

/**
 * The Assignment8 class, simply runs the unit tests for Animal, Wolf, Leopard, 
 * Toad, Cobra, Panda, Zebra. Once all the unit tests are run, if they are all 
 * passed, the main method will return, "All unit tests passed". If not it will 
 * return "Some unit tests failed.".
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

public class Assignment8 {
    // This method confirms that all unit tests work. This method takes in no 
    // parameters and returns a boolean
    public static boolean unitTests() {
        // Test sleep() method
        if (!testSleep()) {
            System.out.println("testSleep failed");
            return false;
        }

        // Test eatAnimal() method
        if (!testEatAnimal()) {
            System.out.println("testEatAnimal failed");
            return false;
        }

        // Test poisonAnimal() method
        if (!testPoisonAnimal()) {
            System.out.println("testPoisonAnimal failed");
            return false;
        }

        // Test fight() method
        if (!testFight()) {
            System.out.println("testFight failed");
            return false;
        }

        // Test reproduce() method
        if (!testReproduce()) {
            System.out.println("testReproduce failed");
            return false;
        }

        return true;
    }
    // This method tests the sleep method. This method takes in no parameters 
    // and returns a boolean.
    private static boolean testSleep() {

    Animal animal = new Wolf(10, 100, 50);

    double initialStrength = animal.getStrength();

    animal.sleep();

    if (animal.getStrength() <= initialStrength) {
        System.out.println("testSleep failed: Strength did not increase after sleeping");
        return false;
    }

    return true;
    }
    // This method tests the eatAnimal method. This method takes in no parameters 
    // and returns a boolean.
    private static boolean testEatAnimal() {

        Animal wolf = new Wolf(5, 100, 60);
        Animal leopard = new Leopard(5, 100, 40);

        ((Carnivore) wolf).eatAnimal(leopard);

        int expectedStrength = 84;

        if (!(wolf.getStrength() == expectedStrength)) {
            System.out.println("testEatAnimal failed: Incorrect change in strength after eating");
            return false;
        }

        return true;
    }
    // This method tests the poisonAnimal method. This method takes in no parameters 
    // and returns a boolean.
    private static boolean testPoisonAnimal() {

        Animal snake = new Cobra(5, 100, 50);

        int trueCount = 0;
        int totalCalls = 10000; 

        for (int i = 0; i < totalCalls; i++) {
            if (snake.poisonAnimal()) {
                trueCount++;
            }
        }

        double probability = (double) trueCount / totalCalls;

        if (probability < 0.79 || probability > 0.81) {
            System.out.println("testPoisonAnimal failed: Probability out of expected range");
            return false;
        }

        return true;
    }
    // This method tests the fight method. This method takes in no parameters 
    // and returns a boolean.
    private static boolean testFight() {

        Animal wolf = new Wolf(5, 100, 60);
        Animal leopard = new Leopard(5, 100, 4);

        int winner = AnimalActivities.fight(wolf, leopard);

        if (winner != 1) {
            System.out.println("testFight failed: Incorrect winner determined");
            return false;
        }

        return true;
    }
    // This method tests the reproduce method. This method takes in no parameters 
    // and returns a boolean.
    private static boolean testReproduce() {

        Animal wolf1 = new Wolf(10, 100, 60);
        Animal wolf2 = new Wolf(8, 100, 50);
        Animal babyWolf = AnimalActivities.reproduce(wolf1, wolf2);

        if (babyWolf == null || !babyWolf.sameSpecies(wolf1) || !babyWolf.sameSpecies(wolf2)) {
            System.out.println("testReproduce failed: Incorrect reproduction");
            return false;
        }
        if (babyWolf.getAge() != 0 || babyWolf.getHealth() != 100 || babyWolf.getStrength() != 27.5) {
            System.out.println("testReproduce failed: Incorrect default characteristics for baby wolf");
            return false;
        }

        return true;
    }
   
    // This method prints out "All unit tests passed." if all the unit test 
    // passed and prints "Some unit tests failed." if not all the unit tests 
    // were passed. This method takes in a String array and returns nothing.
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.");
        } else {
            System.out.println("Some unit tests failed.");
        }
    }
}