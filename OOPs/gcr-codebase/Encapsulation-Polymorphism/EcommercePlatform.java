import java.util.*;

// Abstract base class for all products - demonstrates encapsulation
abstract class Product{
	// Private fields - encapsulated data
	private int productId;
	private String name; 
	private int price;
	
	// Constructor to initialize product
	Product(int productId, String name, int price){
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	
	// Setter method for product ID
	void SetID(int productId) {
		this.productId = productId;
	}
	
	// Getter method for product ID
	int GetID() {
		return productId;
	}
	
	// Setter method for name
	void SetN(String name) {
		this.name = name;
	}
	
	// Getter method for name
	String GetN() {
		return name;
	}
	
	// Setter method for price
	void SetP(int price) {
		this.price = price;
	}
	
	// Getter method for price
	int GetP() {
		return price;
	}
	
	// Abstract method - must be implemented by child classes
	abstract double calculateDiscount();
}

// Interface for tax calculation
interface Taxable{
	void calculateTax();
	double getTaxDetails();
}

// Electronics class extends Product and implements Taxable
class Electronics extends Product implements Taxable{
	double discount;
	double tax;
	double finalPrice;
	
	// Constructor calls parent constructor
	Electronics(int productId, String name, int price, double discount){
		super(productId, name, price);
		this.discount = discount;
	}
	
	// Implementation of abstract method
	public double calculateDiscount() {
		double discountAmount = GetP() * (discount/100);
		return discountAmount;
	}
	
	// Implementation of interface method
	public void calculateTax() {
		double taxAmount = (GetP() * 0.18);
		this.tax = taxAmount;
	}
	
	// Implementation of interface method
	public double getTaxDetails() {
		return tax;
	}
	
	// Method to calculate final price
	public void Final() {
		finalPrice = GetP() + getTaxDetails() - calculateDiscount();
		System.out.println("The Final Price is: " + finalPrice);
	}
	
	// Method to display product details
	void Display() {
		System.out.println("Product ID: " + GetID() + " | Name: " + GetN() + " | Price: " + GetP() + " | Discount (%): " + discount + " | Tax: " + getTaxDetails());
	}
}

// Clothing class extends Product and implements Taxable
class Clothing extends Product implements Taxable{ 
	double discount;
	double tax;
	double finalPrice;
	
	// Constructor calls parent constructor
	Clothing(int productId, String name, int price, double discount){
		super(productId, name, price);
		this.discount = discount;
	}
	
	// Implementation of abstract method
	public double calculateDiscount() {
		double discountAmount = GetP() * (discount/100);
		return discountAmount;
	}
	
	// Implementation of interface method
	public void calculateTax() {
		double taxAmount = (GetP() * 0.18);
		this.tax = taxAmount;
	}
	
	// Implementation of interface method
	public double getTaxDetails() {
		return tax;
	}
	
	// Method to calculate final price
	public void Final() {
		finalPrice = GetP() + getTaxDetails() - calculateDiscount();
		System.out.println("The Final Price is: " + finalPrice);
	}
	
	// Method to display product details
	void Display() {
		System.out.println("Product ID: " + GetID() + " | Name: " + GetN() + " | Price: " + GetP() + " | Discount (%): " + discount + " | Tax: " + getTaxDetails());
	}
}

// Groceries class extends Product and implements Taxable
class Groceries extends Product implements Taxable{
	double discount;
	double tax;
	double finalPrice;
	
	// Constructor calls parent constructor
	Groceries(int productId, String name, int price, double discount){
		super(productId, name, price);
		this.discount = discount;
	}
	
	// Implementation of abstract method
	public double calculateDiscount() {
		double discountAmount = GetP() * (discount/100);
		return discountAmount;
	}
	
	// Implementation of interface method
	public void calculateTax() {
		double taxAmount = (GetP() * 0.18);
		this.tax = taxAmount;
	}
	
	// Implementation of interface method
	public double getTaxDetails() {
		return tax;
	}
	
	// Method to calculate final price
	public void Final() {
		finalPrice = GetP() + getTaxDetails() - calculateDiscount();
		System.out.println("The Final Price is: " + finalPrice);
	}
	
	// Method to display product details
	void Display() {
		System.out.println("Product ID: " + GetID() + " | Name: " + GetN() + " | Price: " + GetP() + " | Discount (%): " + discount + " | Tax: " + getTaxDetails());
	}
}

// Main class to demonstrate polymorphism and encapsulation
public class EcommercePlatform {
	public static void main(String[] args) {
		// Create different product objects
		Electronics e = new Electronics(101, "Smartphone", 50000, 10.0);
        Clothing c = new Clothing(202, "T-Shirt", 1500, 5.0);
        Groceries g = new Groceries(303, "Rice Bag", 1000, 2.5);
        
        // Calculate and display for Electronics
        e.calculateTax();
        e.Display();
        e.Final();
        
        // Calculate and display for Clothing
        c.calculateTax();
        c.Display();
        c.Final();
        
        // Calculate and display for Groceries
        g.calculateTax();
        g.Display();
        g.Final();
	}
}