# Animal-PvP-Game

## Overview

The Animal Kingdom Game is a text-based simulation of a simple animal fighting game. This project leverages advanced object-oriented programming concepts such as inheritance, polymorphism, abstract classes, and interfaces. The game involves two animals engaging in combat over multiple rounds until one or both animals run out of health. Additionally, the project includes various functionalities to simulate the behavior and interactions of different animal species within an animal kingdom.

## Project Structure

The project is organized into several classes and interfaces as illustrated in the provided UML diagram:

### Abstract Class: `Animal`

- **Fields:**
  - `private int age`
  - `private double health`
  - `private double strength`

- **Constructors:**
  - `protected Animal()`: Initializes `age`, `health`, and `strength` to 0.
  - `protected Animal(int age, double health, double strength)`: Initializes fields with provided values.

- **Methods:**
  - `public int getAge()`
  - `public double getHealth()`
  - `public double getStrength()`
  - `public String getName()`
  - `public void setHealth(double health)`
  - `public void setStrength(double strength)`
  - `public double attack(Animal animal)`: Generates a random attack value and decreases the health of the target animal.
  - `public abstract boolean sameSpecies(Animal animal)`
  - `public abstract void sleep()`
  - `public abstract boolean isPoisonous()`
  - `public boolean poisonAnimal()`: Default returns `false`.
  - `public String toString()`: Returns a string representation of the animal.

### Interfaces

- **`Carnivore`**
  - `public void eatAnimal(Animal animal)`

- **`Herbivore`**
  - `public void eatPlant()`

### Concrete Classes

- **`Wolf`** (Implements `Carnivore`)
  - Specific fields, constructors, and methods tailored to the wolf species.
  - Overrides methods like `getName()`, `sameSpecies()`, `sleep()`, `isPoisonous()`, and `eatAnimal()`.

- **`Zebra`** (Implements `Herbivore`)
  - Specific fields, constructors, and methods tailored to the zebra species.
  - Overrides methods like `getName()`, `sameSpecies()`, `sleep()`, `isPoisonous()`, and `eatPlant()`.

- **Other Animal Classes** (e.g., `Leopard`, `Panda`, `Toad`, `Cobra`)
  - Follow a similar structure to `Wolf` and `Zebra`, implementing specific behaviors and characteristics.

### Utility Class: `AnimalActivities`

- **Constructor:**
  - `private AnimalActivities()`: Prevents instantiation.

- **Methods:**
  - `public static int fight(Animal animal1, Animal animal2)`: Simulates a fight between two animals, printing the results to the terminal.
  - `public static void reproduce(Animal animal1, Animal animal2)`: Simulates the reproduction of animals, creating new instances if applicable.

## How to Run

1. **Setup Environment:**
   - Ensure Java development environment is properly set up.
   - Navigate to your project directory.

2. **Compile the Code:**
   ```sh
   javac *.java
