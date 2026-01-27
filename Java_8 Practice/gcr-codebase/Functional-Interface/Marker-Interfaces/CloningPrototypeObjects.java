// Product prototype class implementing Cloneable marker interface
class ProductPrototype implements Cloneable {
    private String name;
    private double price;
    private String category;
    private String description;
    
    public ProductPrototype(String name, double price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
    
    // Clone method for creating copies
    @Override
    public ProductPrototype clone() {
        try {
            return (ProductPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
    
    // Setters for customization
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    
    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f, category='%s', description='%s'}", 
                           name, price, category, description);
    }
}

// User profile prototype
class UserProfilePrototype implements Cloneable {
    private String username;
    private String email;
    private String role;
    private boolean isActive;
    
    public UserProfilePrototype(String username, String email, String role, boolean isActive) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }
    
    @Override
    public UserProfilePrototype clone() {
        try {
            return (UserProfilePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
    
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
    public void setActive(boolean active) { isActive = active; }
    
    @Override
    public String toString() {
        return String.format("UserProfile{username='%s', email='%s', role='%s', active=%s}", 
                           username, email, role, isActive);
    }
}

// Prototype manager
class PrototypeManager {
    
    public static <T extends Cloneable> T cloneObject(T prototype) {
        if (prototype instanceof ProductPrototype) {
            return (T) ((ProductPrototype) prototype).clone();
        } else if (prototype instanceof UserProfilePrototype) {
            return (T) ((UserProfilePrototype) prototype).clone();
        } else {
            throw new IllegalArgumentException("Unsupported prototype type");
        }
    }
    
    public static void demonstrateCloning(Object prototype, String prototypeName) {
        System.out.println("=== " + prototypeName + " Cloning ===");
        System.out.println("Original: " + prototype);
        
        if (prototype instanceof Cloneable) {
            Object cloned = cloneObject((Cloneable) prototype);
            System.out.println("Cloned:   " + cloned);
            System.out.println("Same reference? " + (prototype == cloned));
            System.out.println("Equal content? " + prototype.toString().equals(cloned.toString()));
        } else {
            System.out.println("❌ Object is not cloneable");
        }
        System.out.println();
    }
}

public class CloningPrototypeObjects {
    
    public static void main(String[] args) {
        System.out.println("=== Prototype Cloning Demo ===\n");
        
        // Create prototypes
        ProductPrototype laptopPrototype = new ProductPrototype(
            "Generic Laptop", 50000.0, "Electronics", "High-performance laptop"
        );
        
        UserProfilePrototype adminPrototype = new UserProfilePrototype(
            "admin_template", "admin@company.com", "ADMIN", true
        );
        
        // Demonstrate cloning
        PrototypeManager.demonstrateCloning(laptopPrototype, "Product Prototype");
        PrototypeManager.demonstrateCloning(adminPrototype, "User Profile Prototype");
        
        // Create customized clones
        System.out.println("=== Customized Clones ===");
        
        ProductPrototype gamingLaptop = laptopPrototype.clone();
        gamingLaptop.setName("Gaming Laptop");
        gamingLaptop.setPrice(75000.0);
        gamingLaptop.setDescription("High-end gaming laptop with RTX graphics");
        
        ProductPrototype officeLaptop = laptopPrototype.clone();
        officeLaptop.setName("Office Laptop");
        officeLaptop.setPrice(35000.0);
        officeLaptop.setDescription("Business laptop for office work");
        
        System.out.println("Original:  " + laptopPrototype);
        System.out.println("Gaming:    " + gamingLaptop);
        System.out.println("Office:    " + officeLaptop);
        System.out.println();
        
        // User profile clones
        UserProfilePrototype manager = adminPrototype.clone();
        manager.setUsername("manager_001");
        manager.setEmail("manager@company.com");
        manager.setRole("MANAGER");
        
        UserProfilePrototype employee = adminPrototype.clone();
        employee.setUsername("emp_001");
        employee.setEmail("employee@company.com");
        employee.setRole("EMPLOYEE");
        
        System.out.println("Admin Template: " + adminPrototype);
        System.out.println("Manager:        " + manager);
        System.out.println("Employee:       " + employee);
    }
}