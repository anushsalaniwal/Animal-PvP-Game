//////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment8.java
// File:               AnimalActivities.java
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

/* This class includes the 1 constructers and 9 methods needed 
for AnimalActivities in CSE11 Spring quarter 2024. The constructors are listed
here: AnimalActivities.
The methods are listed here: fight, reproduce, printBothAnimals, calcSpacing, 
printRound, printAttach, printFinalStats, printTieGame, printWinner.
*/
/**
 * This is a class is essentially the game we're playing with 2 animals fighting 
 * or reproducing.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/
public class AnimalActivities {
    private final static int NUM_ANIMALS = 6;
    private final static double AVG = 2.0;
    private final static int OF_AGE = 5;
    private final static int DEFAULT_HEALTH = 100;
    private final static int SPACING = 17;
    private final static String LEFT = "Left";
    private final static String RIGHT = "Right";
    // Private constructor to prevent instantiation
    private AnimalActivities() {
    }
    // This method takes two animals as its parameters and returns an integer
    // signifying the winner. This method makes the 2 animals fight.
    public static int fight(Animal animal1, Animal animal2) {
        boolean animal1Poisoned = false;
        boolean animal2Poisoned = false;
        if (animal1.isPoisonous()) {
            animal1Poisoned = animal1.poisonAnimal();
        }
        if (animal2.isPoisonous()) {
            animal2Poisoned = animal2.poisonAnimal();
        }

        int roundNumber = 0;

        while (animal1.getHealth() > 0 && animal2.getHealth() > 0) {
            printRound(roundNumber);
            printBothAnimals(animal1, animal2);
            double damage1 = animal1.attack(animal2);
            double damage2 = animal2.attack(animal1);
            printAttack(LEFT, damage1);
            printAttack(RIGHT, damage2);
            roundNumber++;
        }

        boolean poisoned = animal1Poisoned || animal2Poisoned;
        printFinalStats(animal1, animal2, poisoned);

        if (animal1.getHealth() <= 0 && animal2.getHealth() <= 0) {
            printTieGame();
            return 0;
        }

        if (animal1.getHealth() > 0) {
        if (animal1Poisoned) {
            printTieGame();
            return 0;
        }
        if (animal1 instanceof Carnivore) {
            ((Carnivore) animal1).eatAnimal(animal2);
        } else if (animal1 instanceof Herbivore) {
            ((Herbivore) animal1).eatPlant();
        }
        printWinner(LEFT);
        return 1;
    }

    if (animal2.getHealth() > 0) {
        if (animal2Poisoned) {
            printTieGame();
            return 0;
        }
        if (animal2 instanceof Carnivore) {
            ((Carnivore) animal2).eatAnimal(animal1);
        } else if (animal2 instanceof Herbivore) {
            ((Herbivore) animal2).eatPlant();
        }
        printWinner(RIGHT);
        return 2;
    }
        return 0;
    }
    // This method reproduces two animals based on their age, and species
    // This method takes in 2 animals and returns an Animal.
    public static Animal reproduce(Animal animal1, Animal animal2) {
        // Check if both animals are older than 5 and of the same species
        if (animal1.getAge() > OF_AGE && animal2.getAge() > OF_AGE && animal1.sameSpecies(animal2)) {
            // Calculate the average strength of the parents
            double avgStrength = (animal1.getStrength() + animal2.getStrength()) / AVG;
            // Create a new baby animal with default characteristics based on the species
            Animal baby = null;
            if (animal1 instanceof Cobra && animal2 instanceof Cobra) {
                baby = new Cobra(0, DEFAULT_HEALTH, avgStrength / AVG);
            } else if (animal1 instanceof Panda && animal2 instanceof Panda) {
                baby = new Panda(0, DEFAULT_HEALTH, avgStrength / AVG);
            } else if (animal1 instanceof Zebra && animal2 instanceof Zebra) {
                baby = new Zebra(0, DEFAULT_HEALTH, avgStrength / AVG);
            } else if (animal1 instanceof Wolf && animal2 instanceof Wolf) {
                baby = new Wolf(0, DEFAULT_HEALTH, avgStrength / AVG);
            } else if (animal1 instanceof Leopard && animal2 instanceof Leopard) {
                baby = new Leopard(0, DEFAULT_HEALTH, avgStrength / AVG);
            } else if (animal1 instanceof Toad && animal2 instanceof Toad) {
                baby = new Toad(0, DEFAULT_HEALTH, avgStrength / AVG);
            }
            return baby;
        } else {
            // Conditions for reproduction not met
            return null;
        }
    }
    /* Below are helper methods to make fight() work */
    /**
    * Use this method in fight() to display the stats of both animals together
    *
    * @param (animal1) Animal on the left side to display stats
    * @param (animal2) Animal on the right side to display stats
    */
    public static void printBothAnimals(Animal animal1, Animal animal2) {
        int ageSpacing = calcSpacing(Integer.toString(animal1.getAge()));
        int healthSpacing = calcSpacing(String.format("%.2f",animal1.getHealth()));
        int strSpacing = calcSpacing(String.format("%.2f",animal1.getStrength()));
        int animalSpacing = calcSpacing(animal1.getName());
        String str = String.format( "(%s) %s (%s)\n" +
            "----------" + " " + "----------\n" +
            "A: %d %s A: %d\n" +
            "H: %.2f %s H: %.2f\n" +
            "S: %.2f %s S: %.2f\n", animal1.getName(),
            " ".repeat(animalSpacing),animal2.getName(),
            animal1.getAge()," ".repeat(ageSpacing),animal2.getAge(),
            animal1.getHealth(), " ".repeat(healthSpacing), animal2.getHealth(),
            animal1.getStrength(), " ".repeat(strSpacing), animal2.getStrength()
            );
        System.out.println(str);
    }
    /**
    * Helper method for printBothAnimals()
    *
    * @param (str) String on the left - used to calculate spacing
    * @return An int describing how many spaces to put between strings
    */
    public static int calcSpacing(String str) {
        int totalWidth = SPACING;
        int str1Width = str.length();
        int spacing = (totalWidth - str1Width);
        if (spacing < 0) {
        return 0;
        }
        return spacing;
    }
    /**
    * Use this method in fight() to display the current round.
    * @param (round) An int of the round (should start at 0)
    */
    public static void printRound(int round) {
        System.out.println();
        System.out.println("Round " + round + ":");
    }
    /**
    * Use this method in fight() to display the damage each round.
    *
    * @param (side) The side of the Animal that invoked the attack().
    * @param (damage) The int (damage) returned from an attack() call
    */
    public static void printAttack(String side, double damage) {
        System.out.printf("%s does %.2f damage!\n",side, damage);
    }
    /**
    * Use this method in fight() to display final stats and poison status.
    *
    * @param (animal1) Left animal
    * @param (animal2) Right animal
    * @param (poisoned) If either animal was poisoned
    */
    public static void printFinalStats(Animal animal1, Animal animal2,
    boolean poisoned) {
        System.out.println();
        printBothAnimals(animal1, animal2);
        if (poisoned) {
        System.out.println("An animal was poisoned.");
        }
    }
    /**
    * Use this method in fight() to display a tie game.
    */
    public static void printTieGame() {
        System.out.println("-------GAME OVER-------");
        System.out.println("TIE: Both animals died!");
    }
    /**
    * Use this method in fight() to display the winner.
    * @param (side) The side of the Animal that won.
    */
    public static void printWinner(String side) {
        System.out.println("-------GAME OVER-------");
        System.out.println(side + " animal wins!");
    }
}