import java.util.*;

// Abstract base class for food items - demonstrates encapsulation
abstract class FoodItem {
    // Private fields - encapsulated data
    private String itemName;
    private int price;
    private int quantity;

    // Constructor to initialize food item
    FoodItem(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter methods for accessing private fields
    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter methods for modifying private fields
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to get item details
    public String getItemDetails() {
        return "Item: " + itemName + " | Price: " + price + " | Quantity: " + quantity;
    }

    // Abstract method - must be implemented by child classes
    public abstract double calculateTotalPrice();
}

// Interface for discount functionality
interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

// Vegetarian item class extends FoodItem and implements Discountable
class VegItem extends FoodItem implements Discountable {
    private final double discountRate = 0.1; // 10% discount for veg items

    // Constructor calls parent constructor
    VegItem(String itemName, int price, int quantity) {
        super(itemName, price, quantity);
    }

    // Implementation of abstract method
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Implementation of interface method
    @Override
    public void applyDiscount() {
        double totalPrice = calculateTotalPrice();
        double discount = totalPrice * discountRate;
        System.out.println("Discount Applied: " + discount);
    }

    // Implementation of interface method
    @Override
    public String getDiscountDetails() {
        return "Veg items get a 10% discount.";
    }
}

// Non-vegetarian item class extends FoodItem and implements Discountable
class NonVegItem extends FoodItem implements Discountable {
    private final double discountRate = 0.05; // 5% discount for non-veg items

    // Constructor calls parent constructor
    NonVegItem(String itemName, int price, int quantity) {
        super(itemName, price, quantity);
    }

    // Implementation of abstract method - adds extra charge for non-veg
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 20; // Extra charge for non-veg
    }

    // Implementation of interface method
    @Override
    public void applyDiscount() {
        double totalPrice = calculateTotalPrice();
        double discount = totalPrice * discountRate;
        System.out.println("Discount Applied: " + discount);
    }

    // Implementation of interface method
    @Override
    public String getDiscountDetails() {
        return "Non-Veg items get a 5% discount.";
    }
}

// Utility class to process orders - demonstrates polymorphism
class OrderProcessor {
    public static void processOrder(FoodItem foodItem) {
        System.out.println(foodItem.getItemDetails());
        System.out.println("Total Price: " + foodItem.calculateTotalPrice());
        
        // Check if item implements Discountable interface
        if (foodItem instanceof Discountable) {
            Discountable discountable = (Discountable) foodItem;
            discountable.applyDiscount();
            System.out.println(discountable.getDiscountDetails());
        }
    }
}

// Main class to demonstrate online food delivery system
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // Create different food items
        FoodItem vegItem1 = new VegItem("Veg Pizza", 150, 2);
        FoodItem nonVegItem1 = new NonVegItem("Chicken Burger", 120, 3);

        // Process orders using polymorphism
        System.out.println("Processing Veg Item Order:");
        OrderProcessor.processOrder(vegItem1);

        System.out.println("\nProcessing Non-Veg Item Order:");
        OrderProcessor.processOrder(nonVegItem1);
    }
}

