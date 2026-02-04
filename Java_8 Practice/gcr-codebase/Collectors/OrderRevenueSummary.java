import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String orderId;
    private String customerId;
    private String customerName;
    private double total;
    private String status;
    
    public Order(String orderId, String customerId, String customerName, double total, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.total = total;
        this.status = status;
    }
    
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public double getTotal() { return total; }
    public String getStatus() { return status; }
    
    @Override
    public String toString() {
        return String.format("%s: ₹%.2f (%s)", orderId, total, status);
    }
}

public class OrderRevenueSummary {
    
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("ORD001", "CUST001", "John Doe", 1250.00, "Completed"),
            new Order("ORD002", "CUST002", "Jane Smith", 890.50, "Completed"),
            new Order("ORD003", "CUST001", "John Doe", 2100.75, "Completed"),
            new Order("ORD004", "CUST003", "Mike Johnson", 450.25, "Pending"),
            new Order("ORD005", "CUST002", "Jane Smith", 1680.00, "Completed"),
            new Order("ORD006", "CUST004", "Sarah Wilson", 320.80, "Cancelled"),
            new Order("ORD007", "CUST001", "John Doe", 750.30, "Completed"),
            new Order("ORD008", "CUST003", "Mike Johnson", 1200.00, "Completed"),
            new Order("ORD009", "CUST005", "David Brown", 980.45, "Completed"),
            new Order("ORD010", "CUST002", "Jane Smith", 540.20, "Pending")
        );
        
        System.out.println("=== Order Revenue Summary ===\n");
        
        // Sum order totals per customer using summingDouble
        Map<String, Double> revenueByCustomer = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomerName,
                Collectors.summingDouble(Order::getTotal)
            ));
        
        System.out.println("Total revenue by customer:");
        revenueByCustomer.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%-15s: ₹%,.2f%n", entry.getKey(), entry.getValue()));
        
        System.out.println("\n=== Additional Revenue Analysis ===");
        
        // Revenue by status
        Map<String, Double> revenueByStatus = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getStatus,
                Collectors.summingDouble(Order::getTotal)
            ));
        
        System.out.println("\nRevenue by order status:");
        revenueByStatus.forEach((status, revenue) -> 
            System.out.printf("%-12s: ₹%,.2f%n", status, revenue));
        
        // Only completed orders revenue
        Map<String, Double> completedRevenue = orders.stream()
            .filter(order -> "Completed".equals(order.getStatus()))
            .collect(Collectors.groupingBy(
                Order::getCustomerName,
                Collectors.summingDouble(Order::getTotal)
            ));
        
        System.out.println("\nCompleted orders revenue by customer:");
        completedRevenue.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%-15s: ₹%,.2f%n", entry.getKey(), entry.getValue()));
        
        // Customer order count and average
        Map<String, Long> orderCountByCustomer = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomerName,
                Collectors.counting()
            ));
        
        Map<String, Double> avgOrderByCustomer = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomerName,
                Collectors.averagingDouble(Order::getTotal)
            ));
        
        System.out.println("\nCustomer summary:");
        revenueByCustomer.keySet().forEach(customer -> {
            double totalRevenue = revenueByCustomer.get(customer);
            long orderCount = orderCountByCustomer.get(customer);
            double avgOrder = avgOrderByCustomer.get(customer);
            
            System.out.printf("%-15s: %d orders, ₹%,.2f total, ₹%,.2f avg%n",
                customer, orderCount, totalRevenue, avgOrder);
        });
        
        // Overall statistics
        double totalRevenue = orders.stream()
            .mapToDouble(Order::getTotal)
            .sum();
        
        double completedTotal = orders.stream()
            .filter(order -> "Completed".equals(order.getStatus()))
            .mapToDouble(Order::getTotal)
            .sum();
        
        System.out.println("\n=== Overall Statistics ===");
        System.out.printf("Total orders: %d%n", orders.size());
        System.out.printf("Total revenue: ₹%,.2f%n", totalRevenue);
        System.out.printf("Completed revenue: ₹%,.2f%n", completedTotal);
        System.out.printf("Average order value: ₹%,.2f%n", totalRevenue / orders.size());
    }
}