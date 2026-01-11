public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String address;
    
    public Customer(String customerId, String name, String email, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
    }
    
    // Getters
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    
    @Override
    public String toString() {
        return String.format("Customer[ID=%s, Name=%s, Email=%s]", customerId, name, email);
    }
}