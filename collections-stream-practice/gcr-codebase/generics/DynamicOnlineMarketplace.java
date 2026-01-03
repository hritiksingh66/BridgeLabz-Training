import java.util.*;

// Category interfaces
interface Category {
    String getCategoryName();
}

// Book category implementation
class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

// Clothing category implementation
class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

// Gadget category implementation
class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

// Generic product class with type parameter
class Product<T extends Category> {
    private String name;
    private double price;
    private String productId;
    private T category;
    private double minPrice;
    private double maxPrice;
    
    public Product(String name, double price, String productId, T category, double minPrice, double maxPrice) {
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.category = category;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getProductId() { return productId; }
    public T getCategory() { return category; }
    public double getMinPrice() { return minPrice; }
    public double getMaxPrice() { return maxPrice; }
    
    // Setter for price (used in discount application)
    public void setPrice(double price) {
        if (price >= minPrice && price <= maxPrice) {
            this.price = price;
        } else {
            System.out.println("Price out of valid range for " + name);
        }
    }
    
    @Override
    public String toString() {
        return category.getCategoryName() + ": " + name + 
               " (ID: " + productId + ", Price: $" + String.format("%.2f", price) + ")";
    }
}

// Generic product catalog class
class ProductCatalog<T extends Category> {
    private List<Product<T>> products;
    private String catalogName;
    
    public ProductCatalog(String catalogName) {
        this.products = new ArrayList<>();
        this.catalogName = catalogName;
    }
    
    // Add product to catalog
    public void addProduct(Product<T> product) {
        products.add(product);
        System.out.println("Added product: " + product.getName() + " to " + catalogName);
    }
    
    // Get all products
    public List<Product<T>> getAllProducts() {
        return new ArrayList<>(products);
    }
    
    // Get catalog size
    public int getSize() {
        return products.size();
    }
}

// Dynamic Online Marketplace
public class DynamicOnlineMarketplace {
    
    // Generic method to apply discount with bounded type parameter
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid discount percentage: " + percentage);
            return;
        }
        
        double originalPrice = product.getPrice();
        double discountAmount = originalPrice * (percentage / 100);
        double newPrice = originalPrice - discountAmount;
        
        System.out.println("Applying " + percentage + "% discount to " + product.getName());
        System.out.println("Original Price: $" + String.format("%.2f", originalPrice));
        System.out.println("Discount: $" + String.format("%.2f", discountAmount));
        
        product.setPrice(newPrice);
        System.out.println("New Price: $" + String.format("%.2f", product.getPrice()));
        System.out.println();
    }
    
    // Generic method to find products by price range
    public static <T extends Category> List<Product<T>> findProductsByPriceRange(
            List<Product<T>> products, double minPrice, double maxPrice) {
        List<Product<T>> result = new ArrayList<>();
        for (Product<T> product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }
    
    // Method to display products using wildcards
    public static void displayProducts(List<? extends Product<? extends Category>> products) {
        System.out.println("=== Product Listing ===");
        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }
        
        for (Product<? extends Category> product : products) {
            System.out.println(product);
        }
        System.out.println();
    }
    
    // Main method to demonstrate the marketplace
    public static void main(String[] args) {
        System.out.println("=== Dynamic Online Marketplace ===\n");
        
        // Create different category catalogs
        ProductCatalog<BookCategory> bookCatalog = new ProductCatalog<>("Book Catalog");
        ProductCatalog<ClothingCategory> clothingCatalog = new ProductCatalog<>("Clothing Catalog");
        ProductCatalog<GadgetCategory> gadgetCatalog = new ProductCatalog<>("Gadget Catalog");
        
        // Create and add book products
        Product<BookCategory> book1 = new Product<>("Java Programming", 45.99, "B001", 
                                                   new BookCategory(), 10.0, 100.0);
        Product<BookCategory> book2 = new Product<>("Data Structures", 55.99, "B002", 
                                                   new BookCategory(), 10.0, 100.0);
        bookCatalog.addProduct(book1);
        bookCatalog.addProduct(book2);
        
        // Create and add clothing products
        Product<ClothingCategory> clothing1 = new Product<>("T-Shirt", 25.99, "C001", 
                                                           new ClothingCategory(), 5.0, 200.0);
        Product<ClothingCategory> clothing2 = new Product<>("Jeans", 79.99, "C002", 
                                                           new ClothingCategory(), 5.0, 200.0);
        clothingCatalog.addProduct(clothing1);
        clothingCatalog.addProduct(clothing2);
        
        // Create and add gadget products
        Product<GadgetCategory> gadget1 = new Product<>("Smartphone", 699.99, "G001", 
                                                       new GadgetCategory(), 100.0, 2000.0);
        Product<GadgetCategory> gadget2 = new Product<>("Headphones", 149.99, "G002", 
                                                       new GadgetCategory(), 100.0, 2000.0);
        gadgetCatalog.addProduct(gadget1);
        gadgetCatalog.addProduct(gadget2);
        
        // Display all products
        List<Product<? extends Category>> allProducts = new ArrayList<>();
        allProducts.addAll(bookCatalog.getAllProducts());
        allProducts.addAll(clothingCatalog.getAllProducts());
        allProducts.addAll(gadgetCatalog.getAllProducts());
        
        displayProducts(allProducts);
        
        // Apply discounts to different products
        System.out.println("=== Applying Discounts ===");
        applyDiscount(book1, 15.0);
        applyDiscount(clothing1, 20.0);
        applyDiscount(gadget1, 10.0);
        
        // Display products after discount
        System.out.println("=== Products After Discount ===");
        displayProducts(allProducts);
        
        // Find products in specific price range
        System.out.println("=== Products between $20-$100 ===");
        List<Product<? extends Category>> priceRangeProducts = new ArrayList<>();
        priceRangeProducts.addAll(findProductsByPriceRange(bookCatalog.getAllProducts(), 20.0, 100.0));
        priceRangeProducts.addAll(findProductsByPriceRange(clothingCatalog.getAllProducts(), 20.0, 100.0));
        priceRangeProducts.addAll(findProductsByPriceRange(gadgetCatalog.getAllProducts(), 20.0, 100.0));
        
        displayProducts(priceRangeProducts);
        
        // Display catalog statistics
        System.out.println("=== Catalog Statistics ===");
        System.out.println("Books: " + bookCatalog.getSize() + " products");
        System.out.println("Clothing: " + clothingCatalog.getSize() + " products");
        System.out.println("Gadgets: " + gadgetCatalog.getSize() + " products");
        System.out.println("Total Products: " + allProducts.size());
    }
}