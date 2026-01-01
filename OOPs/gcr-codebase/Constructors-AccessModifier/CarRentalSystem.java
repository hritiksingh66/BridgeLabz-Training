import java.util.*;
// Car rental system with parameterized constructor
class CarRental{
	// Rental details
	String name;
	String car;
	int days;
	int price;
	int tp = 1;
	
	// Constructor to initialize rental details
	CarRental(String name, String car, int days, int price){
		this.name = name;
		this.car = car;
		this.days = days;
		this.price = price;
	}
	
	// Calculate total rental cost
	public int Total() {
		tp = days * price;
		return tp;
	}
	
	// Display rental confirmation details
	void Display() {
		System.out.println("Car Rented out successfully");
		System.out.println("Customer Name: " + name + " | Rented Car: " + car + " | Rental Days: " + days + " | Total Cost: " + tp);
	}
}
public class CarRentalSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Car Rental System");
		System.out.println("1. Suzuki Vitara Brezza - ₹1,500 per day");
		System.out.println("2. Hyundai i20 - ₹1,200 per day");
		System.out.println("3. Honda City - ₹2,000 per day");
		System.out.println("4. Tata Harrier - ₹2,500 per day");
		System.out.println("5. Mahindra Scorpio - ₹2,200 per day");
		System.out.print("Which car do you want to rent out: ");
		int d;
		String n;
		int c1 = sc.nextInt();
		sc.nextLine();
		switch(c1) {
		case 1:
			System.out.print("Enter your name: ");
			n = sc.nextLine();
			System.out.print("How many days to you want to rent out: ");
			d = sc.nextInt();
			CarRental c = new CarRental(n, "Suzuki Vitara Brezza", d, 1500);
			c.Total();
			c.Display();
			break;
			
		case 2:
			System.out.print("Enter your name: ");
			n = sc.nextLine();
			System.out.print("How many days to you want to rent out: ");
			d = sc.nextInt();
			CarRental c2 = new CarRental(n, "Hyundai i20", d, 1200);
			c2.Total();
			c2.Display();
			break;
			
		case 3:
			System.out.print("Enter your name: ");
			n = sc.nextLine();
			System.out.print("How many days to you want to rent out: ");
			d = sc.nextInt();
			CarRental c3 = new CarRental(n, "Honda City", d, 2000);
			c3.Total();
			c3.Display();
			break;
			
		case 4:
			System.out.print("Enter your name: ");
			n = sc.nextLine();
			System.out.print("How many days to you want to rent out: ");
			d = sc.nextInt();
			CarRental c4 = new CarRental(n, "Tata Harrier", d, 2500);
			c4.Total();
			c4.Display();
			break;
			
		case 5:
			System.out.print("Enter your name: ");
			n = sc.nextLine();
			System.out.print("How many days to you want to rent out: ");
			d = sc.nextInt();
			CarRental c5 = new CarRental(n, "Mahindra Scorpio", d, 2200);
			c5.Total();
			c5.Display();
			break;
			
		default:
			System.out.println("Invalid Choice");
		}
	}
}
