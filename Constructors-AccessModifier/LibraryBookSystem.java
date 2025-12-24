import java.util.*;
// Library book management system with availability tracking
class Library{
	// Book details and availability
	String author;
	String title;
	int price;
	int availability;
	
	// Constructor to initialize book details
	Library(String author, String title, int price, int availability){
		this.author = author;
		this.title = title;
		this.price = price;
		this.availability = availability;
	}
	
	// Check and update book availability for borrowing
	public void Availability(int available){
		if(availability >= available) {
			availability = availability - available;
			System.out.println("Book borrowed successfully");
			System.out.println("Available Quantity: " + availability);
		}
		else {
			System.out.println("Not enough quantity");
		}
	}
	
	// Display book details and availability
	void Display() {
		System.out.println("Book Title: " + title + " | Author: " + author + " | Price: " + price + " | Availability: " + availability);
	}
}
public class LibraryBookSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Library book1 = new Library("Charles Dickens", "A Tale of Two Cities", 242, 4);
		Library book2 = new Library("Harper Lee", "To Kill a Mockingbird", 299, 5);
		Library book3 = new Library("George Orwell", "1984", 350, 3);
		Library book4 = new Library("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 400, 6);
		Library book5 = new Library("F. Scott Fitzgerald", "The Great Gatsby", 275, 2);
		while(true) {
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.print("Do you want to borrow a book: ");
			int c2 = sc.nextInt();
			if(c2 == 1) {
				System.out.print("1. ");
				book1.Display();
				System.out.print("2. ");
				book2.Display();
				System.out.print("3. ");
				book3.Display();
				System.out.print("4. ");
				book4.Display();
				System.out.print("5. ");
				book5.Display();
				System.out.print("Which book do you want to borrow: ");
				int c1 = sc.nextInt();
				int a = 0;
				switch(c1){
				case 1:
					System.out.print("How much quantity do you want to borrow: ");
					a = sc.nextInt();
					book1.Availability(a);
					break;
					
				case 2:
					System.out.print("How much quantity do you want to borrow: ");
					a = sc.nextInt();
					book2.Availability(a);
					break;
					
				case 3:
					System.out.print("How much quantity do you want to borrow: ");
					a = sc.nextInt();
					book3.Availability(a);
					break;
					
				case 4:
					System.out.print("How much quantity do you want to borrow: ");
					a = sc.nextInt();
					book4.Availability(a);
					break;
					
				case 5:
					System.out.print("How much quantity do you want to borrow: ");
					a = sc.nextInt();
					book5.Availability(a);
					break;
					
				default:
					System.out.println("Invalid choice");
				}
			}
			else if(c2 == 2) {
				break;
			}
			else {
				break;
			}
		}
	}
}
