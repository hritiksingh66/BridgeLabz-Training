import java.util.*;
// Hotel booking system demonstrating all three constructor types
class Hotel{
	// Booking details
	String name;
	String room;
	int night;
	
	// Default constructor with preset values
	Hotel(){
		this.name = "Guest";
		this.room = "Deluxe";
		this.night = 2;
	}
	
	// Parameterized constructor for custom booking
	Hotel(String name, String room, int night){
		this.name = name;
		this.room = room;
		this.night = night;
	}
	
	// Copy constructor to duplicate booking details
	Hotel(Hotel pb){
		this.name = pb.name;
		this.room = pb.room;
		this.night = pb.night;
	}
	
	// Display booking information
	void Display() {
		System.out.println("Booking Details");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Customer Name: " + name + " Room Type: " + room + " No. of Nights: " + night);
	}
}
public class HotelBookingSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String n = sc.nextLine();
		System.out.println("1. Deluxe");
		System.out.println("2. Super Deluxe");
		System.out.println("3. King");
		System.out.print("Which Room Type you want to book: ");
		String r = null;
		int rt = sc.nextInt();
		switch(rt) {
		case 1:
			r = "Deluxe";
			break;
			
		case 2:
			r = "Super Deluxe";
			break;
				
		case 3:
			r = "King";
			break;
				
		default:
			System.out.println("Not Valid room type");
		}
		System.out.print("Enter Nights: ");
		int ni = sc.nextInt();
		Hotel h1 = new Hotel();
		System.out.println("Default Constructor");
		h1.Display();
		Hotel h2 = new Hotel(n, r, ni);
		System.out.println("Parameterized Constructor");
		h2.Display();
		Hotel h3 = new Hotel(h2);
		System.out.println("Copy Constructor");
		h3.Display();
	}
}
