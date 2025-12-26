import java.util.*;

// Base class for all animals
class Animal{
	String name;
	int age;
	
	// Constructor to initialize animal properties
	Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	// Method to make sound - will be overridden by child classes
	void makeSound() {
		System.out.println("Animals Make Sound"); // Fixed typo
	}
	
	// Method to display animal information
	void Display() {
		System.out.println("Animal: " + name + " Age: " + age);
	}
}

// Dog class inherits from Animal
class Dog extends Animal{
	
	// Constructor calls parent constructor
	Dog(String name, int age){
		super(name, age);
	}
	
	// Override makeSound method for dog-specific behavior
	void makeSound() {
		System.out.println(name + " Barks");
	}
}

// Cat class inherits from Animal
class Cat extends Animal{
	
	// Constructor calls parent constructor
	Cat(String name, int age){
		super(name, age);
	}
	
	// Override makeSound method for cat-specific behavior
	void makeSound() {
		System.out.println(name + " Meows"); // Fixed typo
	}
}

// Bird class inherits from Animal
class Bird extends Animal{
	
	// Constructor calls parent constructor
	Bird(String name, int age){
		super(name, age);
	}
	
	// Override makeSound method for bird-specific behavior
	void makeSound() {
		System.out.println(name + " Chirps");
	}
}

// Main class to demonstrate animal hierarchy
public class AnimalHierarchy {
	public static void main(String[] args) {
		// Create different animals
		Dog d = new Dog("Sheru", 2);
		d.Display();
		d.makeSound();
		
		Cat c = new Cat("Joe", 1);
		c.Display();
		c.makeSound();
		
		Bird b = new Bird("Sparrow", 3);
		b.Display();
		b.makeSound();
	}
}
