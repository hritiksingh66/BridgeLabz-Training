import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, Integer> itemsAdded;
    private TreeMap<Double, String> itemsByPrice;
    
    public ShoppingCart() {
        productPrices = new HashMap<>();
        itemsAdded = new LinkedHashMap<>();
        itemsByPrice = new TreeMap<>();
        
        // Initialize some products
        productPrices.put("Laptop", 999.99);
        productPrices.put("Mouse", 25.50);
        productPrices.put("Keyboard", 75.00);
        productPrices.put("Monitor", 299.99);
    }
    
    public void addItem(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            itemsAdded.put(product, itemsAdded.getOrDefault(product, 0) + quantity);
            itemsByPrice.put(productPrices.get(product), product);
            System.out.println("Added " + quantity + " " + product + "(s) to cart");
        } else {
            System.out.println("Product not found: " + product);
        }
    }
    
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : itemsAdded.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }
    
    public void displayCart() {
        System.out.println("Items in order added: " + itemsAdded);
        System.out.println("Items sorted by price: " + itemsByPrice);
        System.out.println("Total: $" + String.format("%.2f", getTotalPrice()));
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addItem("Laptop", 1);
        cart.addItem("Mouse", 2);
        cart.addItem("Keyboard", 1);
        
        cart.displayCart();
    }
}