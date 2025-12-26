import java.util.*;

// Product class demonstrating static, final, and this keywords
class Product{
	// static variable - shared across all Product instances
	static int discount = 20;
	
	// Instance variables - unique to each Product object
	String name;
	int price;
	int quant;
	
	// final variable - cannot be changed once initialized
	final int ID;
	
	// Constructor to initialize Product object
	Product(String name, int price, int quant, int ID){
		// 'this' keyword refers to current object instance
		this.name = name;     // Distinguishes parameter from instance variable
		this.price = price;
		this.quant = quant;
		this.ID = ID;         // final variable can only be assigned once
	}
	
	// Method to update static discount variable
	public void Update(int d) {
		// Accessing static variable through instance (not recommended)
		this.discount = d;
		System.out.println("The Updated Discount is: " + discount);
	}
	
	// Method to display product information
	void Display() {
		System.out.println("Product ID: " + ID + " | Name: " + name + " | Price: " + price + " | Quantity: " + quant + " | Discount(%): " + discount);
	}
}
// Main class demonstrating shopping cart system with Product objects
public class ShoppingCartSystem {
	public static void main(String[] args) {
		// Creating Product objects - each has unique instance variables but shares static discount
		Product p1 = new Product("Laptop", 1500, 50, 101);
		Product p2 = new Product("Smartphone", 800, 200, 102);
		Product p3 = new Product("Headphones", 150, 150, 103);
		Product p4 = new Product("Smartwatch", 250, 80, 104);
		Product p5 = new Product("Tablet", 400, 120, 105);
		
		// Creating a String object to test instanceof operator
		Object p6 = new String("Hello");
		
		int d; // Variable to store discount input
		Scanner sc = new Scanner(System.in);
		
		// Using instanceof operator to check object type before casting
		if(p1 instanceof Product) {
			System.out.println("Instance of Product");
			System.out.print("1. ");
			p1.Display();
		}
		if(p2 instanceof Product) {
			System.out.println("Instance of Product");
			System.out.print("2. ");
			p2.Display();
		}
		if(p3 instanceof Product) {
			System.out.println("Instance of Product");
			System.out.print("3. ");
			p3.Display();
		}
		if(p4 instanceof Product) {
			System.out.println("Instance of Product");
			System.out.print("4. ");
			p4.Display();
		}
		if(p5 instanceof Product) {
			System.out.println("Instance of Product");
			System.out.print("5. ");
			p5.Display();
		}
		
		// Testing with non-Product object
		if(p6 instanceof Product) {
			System.out.println("Instance of Product");
		}
		else {
			System.out.println("E6 Not an Instance of Product");
		}
		
		// Interactive menu for updating discount (static variable)
		while(true) {
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.print("Do you want to Update the Discount: ");
			int c1 = sc.nextInt();
			
			if(c1 == 2) {
				break; // Exit loop
			}
			
			switch(c1) {
			case 1:
				// Select which product to update discount for
				System.out.print("Which Product do you want to Update: ");
				int c2 = sc.nextInt();
				
				switch(c2) {
				case 1:
					System.out.print("Enter new Discount: ");
					d = sc.nextInt();
					p1.Update(d); // Updates static discount for all products
					p1.Display();
					break;
					
				case 2:
					System.out.print("Enter new Discount: ");
					d = sc.nextInt();
					p2.Update(d);
					p2.Display();
					break;
					
				case 3:
					System.out.print("Enter new Discount: ");
					d = sc.nextInt();
					p3.Update(d);
					p3.Display();
					break;
				
				case 4:
					System.out.print("Enter new Discount: ");
					d = sc.nextInt();
					p4.Update(d);
					p4.Display();
					break;
					
				case 5:
					System.out.print("Enter new Discount: ");
					d = sc.nextInt();
					p5.Update(d);
					p5.Display();
					break;
				}
			case 2:
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
