import java.util.*;

// Book class demonstrating static, final, and this keywords
class Book{
	// static variable - shared across all Book instances
	static String lname = "The Readers Library";
	
	// Instance variables - unique to each Book object
	String title;
	String author;
	
	// final variable - cannot be changed once initialized
	final int ISBN;
	
	// Constructor to initialize Book object
	Book(String title, String author, int ISBN){
		// 'this' keyword refers to current object instance
		this.title = title;   // Distinguishes parameter from instance variable
		this.author = author;
		this.ISBN = ISBN;     // final variable can only be assigned once
	}
	
	// Method to display library welcome message using static variable
	void DisplayL() {
		System.out.println("Welcome to " + lname);
	}
	
	// Method to display book information
	void Display() {
		System.out.println("Book Title: " + title + " | Author: " + author + " | ISBN: " + ISBN);
	}
}
// Main class demonstrating library management system
public class LibraryManagementSystem {
	public static void main(String[] args) {
		// Creating Book objects as Object references to demonstrate casting
		Object b1 = new Book("To Kill a Mockingbird", "Harper Lee", 978006112);
		Object b2 = new Book("1984", "George Orwell", 978045152);
		Object b3 = new Book("Pride and Prejudice", "Jane Austen", 978014143);
		Object b4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 978074327);
		Object b5 = new Book("The Catcher in the Rye", "J.D. Salinger", 978031676);
		
		// Creating a String object to test instanceof operator
		Object b6 = new String("Hello");
		
		// Using instanceof operator and casting to access Book methods
		if(b1 instanceof Book) {
			// Casting Object to Book to access Book-specific methods
			((Book) b1).DisplayL();
			System.out.println("Instance of Book");
			((Book) b1).Display();
		}
		
		// Direct casting without instanceof check (assumes objects are Book instances)
		((Book) b2).Display();
		((Book) b3).Display();
		((Book) b4).Display();
		((Book) b5).Display();
		
		// Testing with non-Book object
		if(b6 instanceof Book) {
			System.out.println("Instance of Book");
		}
		else {
			System.out.println("B6 Not an Instance of Book");
		}
	}
}
