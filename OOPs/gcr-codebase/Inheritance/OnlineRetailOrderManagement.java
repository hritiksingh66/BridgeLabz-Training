import java.util.*;

// Base class for all orders
class Order{
	int id;
	String date; // Better variable name
	
	// Constructor to initialize order properties
	Order(int id, String date){
		this.id = id;
		this.date = date;
	}
	
	// Method to display order information
	void Display() {
		System.out.print("Order ID: " + id + " Date: " + date);
	}
	
	// Method to get order status
	String getStatus(){
		return "Order Placed";
	}
}

// Shipped order inherits from Order
class ShippedOrder extends Order{
	int trackingNumber; // Better variable name
	
	// Constructor calls parent constructor and adds tracking number
	ShippedOrder(int id, String date, int trackingNumber){
		super(id, date);
		this.trackingNumber = trackingNumber;
	}
	
	// Override Display to include tracking information
	void Display() {
		System.out.println("Order Details");
		super.Display();
		System.out.print(" Tracking Number: " + trackingNumber);
		System.out.println();
	}
	
	// Override status for shipped orders
	String getStatus(){
		return "Order Shipped";
	}
}

// Delivered order inherits from ShippedOrder (multi-level inheritance)
class DeliveredOrder extends ShippedOrder{ 
	String deliveryDate; // Better variable name
	
	// Constructor calls parent constructor and adds delivery date
	DeliveredOrder(int id, String date, int trackingNumber, String deliveryDate){
		super(id, date, trackingNumber);
		this.deliveryDate = deliveryDate;
	}
	
	// Override Display to include delivery information
	void Display() {
		System.out.println("Order Details");
		System.out.println("Order ID: " + id + " Date: " + date + " Tracking Number: " + trackingNumber + " Delivered Date: " + deliveryDate);
	}
	
	// Override status for delivered orders
	String getStatus(){
		return "Order Delivered";
	}
}

// Main class to demonstrate order management hierarchy
public class OnlineRetailOrderManagement {
	public static void main(String[] args) {
		// Create different types of orders
		ShippedOrder s1 = new ShippedOrder(1001, "02-10-2025", 4562145);
		s1.Display();
		System.out.println("Order Status: " + s1.getStatus());
		
		DeliveredOrder d1 = new DeliveredOrder(1004, "03-10-2025", 4568945, "10-10-2025");
		d1.Display();
		System.out.println("Order Status: " + d1.getStatus());
	}
}
