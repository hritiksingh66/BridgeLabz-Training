import java.util.*;
// Person details management with parameterized and copy constructors
class PersonDetails{
	// Person attributes
	String name;
	double height;
	double weight;
	
	// Parameterized constructor for person details
	PersonDetails(String name, double height, double weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	// Copy constructor to duplicate person details
	PersonDetails(PersonDetails pp){
		this.name = pp.name;
		this.height = pp.height;
		this.weight = pp.weight;
	}
	// Display person information
	void Display() {
		System.out.println("Name: " + name + " Height: " + height + " Weight: " + weight);
	}
}
public class Person {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter height: ");
		double height = sc.nextDouble();
		System.out.print("Enter weight: ");
		double weight = sc.nextDouble();
		PersonDetails person1 = new PersonDetails(name, height , weight);
		System.out.println("Parameterized Constructor");
		person1.Display();
		PersonDetails person2 = new PersonDetails(person1);
		System.out.println("Copy Constructor");
		person2.Display();
	}
}
