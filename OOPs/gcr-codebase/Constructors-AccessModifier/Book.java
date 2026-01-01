import java.util.*;
// Book management system demonstrating default and parameterized constructors
class BookDetails{
	// Book properties
	String title;
	String author;
	int price;
	
	// Default constructor with preset values
	BookDetails(){
		this.title = "Life's Amazing Secrets";
		this.author = "Gaur Gopal Das";
		this.price = 169;
	}
		
	// Parameterized constructor for custom book details
	BookDetails(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	// Display book information
	void Display() {
		System.out.println("Book Title: " + title);
		System.out.println("Book Author: " + author);
		System.out.println("Price: " + price);
	}
}
public class Book {
	public static void main(String[] args) {
		System.out.println("Default Constructor");
		BookDetails book1 = new BookDetails();
		book1.Display();
		System.out.println("Parameterized Constructor");
		BookDetails book2 = new BookDetails("The Great Gatsby", "F. Scott Fitzgerald", 151);
		book2.Display();
	}
}
