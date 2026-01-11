import java.util.*;

public class ECommerceSystem {
    private HashMap<String, Product> productCatalog; // Product catalog
    private HashMap<String, Order> orders; // orderId → Order mapping
    private HashMap<String, Customer> customers; // Customer management
    private Stack<String> orderHistory; // Stack for undo last order
    private Scanner scanner;
    
    public ECommerceSystem() {
        productCatalog = new HashMap<>();
        orders = new HashMap<>();
        customers = new HashMap<>();
        orderHistory = new Stack<>();
        scanner = new Scanner(System.in);
        initializeProducts();
    }
    
    // Initialize sample products
    private void initializeProducts() {
        productCatalog.put("P001", new Product("P001", "Laptop", 999.99, 10));
        productCatalog.put("P002", new Product("P002", "Mouse", 25.50, 50));
        productCatalog.put("P003", new Product("P003", "Keyboard", 75.00, 30));
        productCatalog.put("P004", new Product("P004", "Monitor", 299.99, 15));
    }
    
    // Display product catalog
    public void displayProducts() {
        System.out.println("\n=== Product Catalog ===");
        for (Product product : productCatalog.values()) {
            System.out.println(product);
        }
    }
    
    // Register customer
    public void registerCustomer() {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        
        Customer customer = new Customer(customerId, name, email, address);
        customers.put(customerId, customer);
        System.out.println("Customer registered successfully!");
    }
    
    // Place order
    public void placeOrder() {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        
        Customer customer = customers.get(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        String orderId = "ORD" + System.currentTimeMillis();
        Order order = new Order(orderId, customer);
        
        // Add items to order
        while (true) {
            displayProducts();
            System.out.print("Enter product ID (or 'done' to finish): ");
            String productId = scanner.nextLine();
            
            if ("done".equalsIgnoreCase(productId)) break;
            
            Product product = productCatalog.get(productId);
            if (product == null) {
                System.out.println("Product not found!");
                continue;
            }
            
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (quantity > product.getStock()) {
                System.out.println("Insufficient stock!");
                continue;
            }
            
            order.addItem(product, quantity);
            product.setStock(product.getStock() - quantity);
            System.out.println("Item added to order!");
        }
        
        if (order.getOrderItems().isEmpty()) {
            System.out.println("No items in order!");
            return;
        }
        
        // Process payment
        if (processPayment(order)) {
            order.setStatus("CONFIRMED");
            orders.put(orderId, order);
            orderHistory.push(orderId); // Add to stack for undo
            System.out.println("Order placed successfully! Order ID: " + orderId);
        }
    }
    
    // Process payment with polymorphism
    private boolean processPayment(Order order) {
        System.out.println("\nOrder Total: $" + order.getTotalAmount());
        System.out.println("Select payment method:");
        System.out.println("1. Card Payment");
        System.out.println("2. UPI Payment");
        System.out.println("3. Wallet Payment");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Payment payment = null;
        
        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter card number: ");
                    String cardNumber = scanner.nextLine();
                    payment = new CardPayment(cardNumber);
                    break;
                case 2:
                    System.out.print("Enter UPI ID: ");
                    String upiId = scanner.nextLine();
                    payment = new UPIPayment(upiId);
                    break;
                case 3:
                    System.out.print("Enter wallet balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    payment = new WalletPayment(balance);
                    break;
                default:
                    System.out.println("Invalid payment method!");
                    return false;
            }
            
            // Polymorphic payment processing
            return payment.processPayment(order.getTotalAmount());
            
        } catch (PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
            return false;
        }
    }
    
    // Cancel order
    public void cancelOrder() {
        System.out.print("Enter order ID to cancel: ");
        String orderId = scanner.nextLine();
        
        Order order = orders.get(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }
        
        if ("CANCELLED".equals(order.getStatus())) {
            System.out.println("Order already cancelled!");
            return;
        }
        
        // Restore stock
        for (OrderItem item : order.getOrderItems()) {
            Product product = item.getProduct();
            product.setStock(product.getStock() + item.getQuantity());
        }
        
        order.setStatus("CANCELLED");
        System.out.println("Order cancelled successfully!");
    }
    
    // Track order
    public void trackOrder() {
        System.out.print("Enter order ID: ");
        String orderId = scanner.nextLine();
        
        Order order = orders.get(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }
        
        System.out.println("\n=== Order Details ===");
        System.out.println(order);
        System.out.println("Items:");
        for (OrderItem item : order.getOrderItems()) {
            System.out.println("  " + item);
        }
        System.out.println("Order Date: " + order.getOrderDate());
    }
    
    // Undo last order using Stack
    public void undoLastOrder() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders to undo!");
            return;
        }
        
        String lastOrderId = orderHistory.pop();
        Order order = orders.get(lastOrderId);
        
        if (order != null && !"CANCELLED".equals(order.getStatus())) {
            // Restore stock
            for (OrderItem item : order.getOrderItems()) {
                Product product = item.getProduct();
                product.setStock(product.getStock() + item.getQuantity());
            }
            
            order.setStatus("CANCELLED");
            System.out.println("Last order undone successfully! Order ID: " + lastOrderId);
        } else {
            System.out.println("Cannot undo last order!");
        }
    }
    
    // Display all orders
    public void displayOrders() {
        System.out.println("\n=== All Orders ===");
        if (orders.isEmpty()) {
            System.out.println("No orders found!");
            return;
        }
        
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }
    
    // Main menu
    public void showMenu() {
        while (true) {
            System.out.println("\n=== E-Commerce Order Management System ===");
            System.out.println("1. Register Customer");
            System.out.println("2. Display Products");
            System.out.println("3. Place Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. Track Order");
            System.out.println("6. Undo Last Order");
            System.out.println("7. Display All Orders");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1: registerCustomer(); break;
                case 2: displayProducts(); break;
                case 3: placeOrder(); break;
                case 4: cancelOrder(); break;
                case 5: trackOrder(); break;
                case 6: undoLastOrder(); break;
                case 7: displayOrders(); break;
                case 8: 
                    System.out.println("Thank you for using E-Commerce System!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        system.showMenu();
    }
}