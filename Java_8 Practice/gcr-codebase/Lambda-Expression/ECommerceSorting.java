import java.util.*;

class Product {
    private String name;
    private double price;
    private double rating;
    private double discount;
    
    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public double getDiscount() { return discount; }
    
    @Override
    public String toString() {
        return String.format("%s - Price: %.2f, Rating: %.1f, Discount: %.0f%%", 
                           name, price, rating, discount);
    }
}

public class ECommerceSorting {
    
    // Map to store different sorting strategies using lambdas
    private Map<String, Comparator<Product>> sortingStrategies = new HashMap<>();
    
    public ECommerceSorting() {
        // Define sorting strategies using lambda expressions
        
        // Sort by price (ascending)
        sortingStrategies.put("price", (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        
        // Sort by rating (descending - higher rating first)
        sortingStrategies.put("rating", (p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
        
        // Sort by discount (descending - higher discount first)
        sortingStrategies.put("discount", (p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount()));
    }
    
    // Sort products based on campaign type
    public void sortProducts(List<Product> products, String campaign) {
        Comparator<Product> comparator = sortingStrategies.get(campaign);
        if (comparator != null) {
            products.sort(comparator);
            System.out.println("Products sorted by " + campaign + ":");
            products.forEach(System.out::println);
        } else {
            System.out.println("Unknown sorting campaign: " + campaign);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ECommerceSorting ecommerce = new ECommerceSorting();
        
        // Create sample products
        List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99, 4.5, 10),
            new Product("Phone", 699.99, 4.8, 15),
            new Product("Tablet", 399.99, 4.2, 20),
            new Product("Watch", 299.99, 4.0, 5)
        );
        
        // Test different sorting campaigns
        ecommerce.sortProducts(new ArrayList<>(products), "price");
        ecommerce.sortProducts(new ArrayList<>(products), "rating");
        ecommerce.sortProducts(new ArrayList<>(products), "discount");
    }
}