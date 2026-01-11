public class Product {
    private String productId;
    private String name;
    private double price;
    private int stock;
    
    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    // Getters and setters
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    
    @Override
    public String toString() {
        return String.format("Product[ID=%s, Name=%s, Price=%.2f, Stock=%d]", 
                           productId, name, price, stock);
    }
}