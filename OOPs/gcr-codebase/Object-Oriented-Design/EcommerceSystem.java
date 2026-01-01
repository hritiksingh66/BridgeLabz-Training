import java.util.*;

// Product class
class Product {
    String name;
    double price;
    
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    void showInfo() {
        System.out.println(name + " - $" + price);
    }
}

// Order class - aggregates products
class Order {
    int orderId;
    List<Product> products; // Aggregation - order contains products
    double total;
    
    Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
        this.total = 0;
    }
    
    // Add product to order
    void addProduct(Product product) {
        products.add(product);
        total += product.price;
    }
    
    // Show order details
    void showOrder() {
        System.out.println("Order #" + orderId + ":");
        for (Product p : products) {
            System.out.println("  - " + p.name + " ($" + p.price + ")");
        }
        System.out.println("Total: $" + total);
    }
}

// Customer class
class Customer {
    String name;
    String email;
    List<Order> orders; // Association - customer has multiple orders
    
    Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }
    
    // Communication method - customer places order
    Order placeOrder(int orderId) {
        Order order = new Order(orderId);
        orders.add(order);
        System.out.println(name + " placed Order #" + orderId);
        return order;
    }
    
    // Show customer's orders
    void showOrders() {
        System.out.println(name + "'s Orders:");
        for (Order o : orders) {
            System.out.println("  Order #" + o.orderId + " - Total: $" + o.total);
        }
    }
}

// E-commerce Platform class
class EcommercePlatform {
    String name;
    List<Customer> customers;
    List<Product> availableProducts;
    
    EcommercePlatform(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.availableProducts = new ArrayList<>();
    }
    
    // Add customer
    void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    // Add product to catalog
    void addProduct(Product product) {
        availableProducts.add(product);
    }
    
    // Show platform info
    void showInfo() {
        System.out.println("Platform: " + name);
        System.out.println("Customers: " + customers.size());
        System.out.println("Products: " + availableProducts.size());
    }
}

// Main class to demonstrate the system
public class EcommerceSystem {
    public static void main(String[] args) {
        // Create platform
        EcommercePlatform platform = new EcommercePlatform("ShopEasy");
        
        // Create products
        Product laptop = new Product("Laptop", 999.99);
        Product mouse = new Product("Mouse", 25.50);
        Product keyboard = new Product("Keyboard", 75.00);
        
        // Add products to platform
        platform.addProduct(laptop);
        platform.addProduct(mouse);
        platform.addProduct(keyboard);
        
        // Create customers
        Customer john = new Customer("John Doe", "john@email.com");
        Customer alice = new Customer("Alice Smith", "alice@email.com");
        
        // Add customers to platform
        platform.addCustomer(john);
        platform.addCustomer(alice);
        
        // Show platform info
        platform.showInfo();
        System.out.println();
        
        // Customers place orders (Communication)
        Order order1 = john.placeOrder(1001);
        order1.addProduct(laptop);
        order1.addProduct(mouse);
        
        Order order2 = alice.placeOrder(1002);
        order2.addProduct(keyboard);
        order2.addProduct(mouse);
        
        Order order3 = john.placeOrder(1003);
        order3.addProduct(laptop);
        
        System.out.println();
        
        // Show order details
        order1.showOrder();
        System.out.println();
        order2.showOrder();
        System.out.println();
        order3.showOrder();
        System.out.println();
        
        // Show customer order history
        john.showOrders();
        alice.showOrders();
    }
}