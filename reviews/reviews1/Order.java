import java.util.*;

public class Order {
    private String orderId;
    private Customer customer;
    private LinkedList<OrderItem> orderItems; // LinkedList for order items
    private String status;
    private double totalAmount;
    private Date orderDate;
    
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = new LinkedList<>();
        this.status = "PENDING";
        this.totalAmount = 0.0;
        this.orderDate = new Date();
    }
    
    // Add item to order
    public void addItem(Product product, int quantity) {
        OrderItem item = new OrderItem(product, quantity);
        orderItems.add(item);
        calculateTotal();
    }
    
    // Calculate total amount
    private void calculateTotal() {
        totalAmount = 0.0;
        for (OrderItem item : orderItems) {
            totalAmount += item.getTotalPrice();
        }
    }
    
    // Getters
    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public LinkedList<OrderItem> getOrderItems() { return orderItems; }
    public String getStatus() { return status; }
    public double getTotalAmount() { return totalAmount; }
    public Date getOrderDate() { return orderDate; }
    
    // Set status
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return String.format("Order[ID=%s, Customer=%s, Items=%d, Total=$%.2f, Status=%s]", 
                           orderId, customer.getName(), orderItems.size(), totalAmount, status);
    }
}