public class OrderItem {
    private Product product;
    private int quantity;
    
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    // Getters
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    
    // Calculate total price for this item
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
    
    @Override
    public String toString() {
        return String.format("%s x %d = $%.2f", 
                           product.getName(), quantity, getTotalPrice());
    }
}