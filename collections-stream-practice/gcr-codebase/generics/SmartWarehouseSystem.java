import java.util.*;

// Abstract base class for all warehouse items
abstract class WarehouseItem {
    protected String name;
    protected double price;
    protected String id;
    
    public WarehouseItem(String name, double price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }
    
    // Abstract method to get item category
    public abstract String getCategory();
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getId() { return id; }
    
    @Override
    public String toString() {
        return getCategory() + ": " + name + " (ID: " + id + ", Price: $" + price + ")";
    }
}

// Electronics item class
class Electronics extends WarehouseItem {
    private String brand;
    
    public Electronics(String name, double price, String id, String brand) {
        super(name, price, id);
        this.brand = brand;
    }
    
    @Override
    public String getCategory() {
        return "Electronics";
    }
    
    public String getBrand() { return brand; }
}

// Groceries item class
class Groceries extends WarehouseItem {
    private Date expiryDate;
    
    public Groceries(String name, double price, String id, Date expiryDate) {
        super(name, price, id);
        this.expiryDate = expiryDate;
    }
    
    @Override
    public String getCategory() {
        return "Groceries";
    }
    
    public Date getExpiryDate() { return expiryDate; }
}

// Furniture item class
class Furniture extends WarehouseItem {
    private String material;
    
    public Furniture(String name, double price, String id, String material) {
        super(name, price, id);
        this.material = material;
    }
    
    @Override
    public String getCategory() {
        return "Furniture";
    }
    
    public String getMaterial() { return material; }
}

// Generic storage class with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items;
    private String storageType;
    
    public Storage(String storageType) {
        this.items = new ArrayList<>();
        this.storageType = storageType;
    }
    
    // Add item to storage
    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getName() + " to " + storageType + " storage");
    }
    
    // Remove item from storage
    public boolean removeItem(String id) {
        return items.removeIf(item -> item.getId().equals(id));
    }
    
    // Get all items in storage
    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }
    
    // Get storage size
    public int getSize() {
        return items.size();
    }
}

// Smart Warehouse Management System
public class SmartWarehouseSystem {
    
    // Wildcard method to display all items regardless of type
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("\n=== All Warehouse Items ===");
        if (items.isEmpty()) {
            System.out.println("No items in storage");
            return;
        }
        
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
    
    // Generic method to find items by price range
    public static <T extends WarehouseItem> List<T> findItemsByPriceRange(
            List<T> items, double minPrice, double maxPrice) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
                result.add(item);
            }
        }
        return result;
    }
    
    // Main method to demonstrate the system
    public static void main(String[] args) {
        System.out.println("=== Smart Warehouse Management System ===\n");
        
        // Create different storage types
        Storage<Electronics> electronicsStorage = new Storage<>("Electronics");
        Storage<Groceries> groceriesStorage = new Storage<>("Groceries");
        Storage<Furniture> furnitureStorage = new Storage<>("Furniture");
        
        // Add electronics items
        electronicsStorage.addItem(new Electronics("Laptop", 999.99, "E001", "Dell"));
        electronicsStorage.addItem(new Electronics("Phone", 699.99, "E002", "Apple"));
        
        // Add groceries items
        groceriesStorage.addItem(new Groceries("Milk", 3.99, "G001", new Date()));
        groceriesStorage.addItem(new Groceries("Bread", 2.49, "G002", new Date()));
        
        // Add furniture items
        furnitureStorage.addItem(new Furniture("Chair", 149.99, "F001", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 299.99, "F002", "Metal"));
        
        // Combine all items using wildcards
        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.addAll(electronicsStorage.getAllItems());
        allItems.addAll(groceriesStorage.getAllItems());
        allItems.addAll(furnitureStorage.getAllItems());
        
        // Display all items using wildcard method
        displayAllItems(allItems);
        
        // Find items in price range
        System.out.println("\n=== Items between $100-$300 ===");
        List<WarehouseItem> priceRangeItems = findItemsByPriceRange(allItems, 100.0, 300.0);
        displayAllItems(priceRangeItems);
        
        // Display storage statistics
        System.out.println("\n=== Storage Statistics ===");
        System.out.println("Electronics Storage: " + electronicsStorage.getSize() + " items");
        System.out.println("Groceries Storage: " + groceriesStorage.getSize() + " items");
        System.out.println("Furniture Storage: " + furnitureStorage.getSize() + " items");
        System.out.println("Total Items: " + allItems.size());
    }
}