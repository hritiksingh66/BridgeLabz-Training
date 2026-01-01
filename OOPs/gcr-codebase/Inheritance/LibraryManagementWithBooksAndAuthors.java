import java.util.*;

// Base class for books
class Book{
	String title;
	int year;
	
	// Constructor to initialize book properties
	Book(String title, int year){
		this.title = title;
		this.year = year;
	}
	
	// Method to display book information
	void Display() {
		System.out.print("Book Title: " + title + " | Publication Year: " + year);
	}
}

// Author class inherits from Book (adds author information)
class Author extends Book{
	String name;
	String bio;
	
	// Constructor calls parent constructor and adds author details
	Author(String title, int year, String name, String bio){
		super(title, year);
		this.name = name;
		this.bio = bio;
	}
	
	// Override Display to include author information
	void Display() {
		super.Display(); // Call parent method
		System.out.print(" | Author: " + name + " | Bio: " + bio);
	}
}

// Main class to demonstrate book and author hierarchy
public class LibraryManagementWithBooksAndAuthors {
	public static void main(String[] args) {
		// Create book without author details
		Book b = new Book("Harry Potter", 1997); // Fixed typo
		
		// Create books with author information
		Author a1 = new Author("Harry Potter", 1997, "J.K. Rowling", "British author best known for the Harry Potter series.");
		Author a2 = new Author("The Casual Vacancy", 2012, "J.K. Rowling", "British author of the Harry Potter series.");
		
		// Display book information
		a1.Display();
		System.out.println();
		
		a2.Display();
		System.out.println();
	}
}
