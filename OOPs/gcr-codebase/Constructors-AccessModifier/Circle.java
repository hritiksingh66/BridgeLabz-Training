import java.util.*;
// Circle area calculation with default and parameterized constructors
class Radius{
	// Circle radius
	int radius;
	
	// Default constructor with preset radius
	Radius(){
		this.radius = 14;
	}
	
	// Parameterized constructor for custom radius
	Radius(int radius){
		this.radius = radius;
	}
	
	// Calculate circle area
	public double Area() {
		this.radius = radius;
		double a = 3.14 * radius * radius;
		return a;
	}
	
	// Display radius value
	void Display() {
		System.out.println("The Radius is: " + radius);
	}
}
public class Circle {
	public static void main(String[] args) {
		Radius r1 = new Radius();
		System.out.println("Default Constructor");
		r1.Display();
		System.out.println("The Area is: " + r1.Area());
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Radius: ");
		int radius = sc.nextInt();
		Radius r2 = new Radius(radius);
		System.out.println("Parameterized Constructor");
		r2.Display();
		System.out.println("The Area is: " + r2.Area());
	}
}
