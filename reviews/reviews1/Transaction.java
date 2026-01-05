package reviews.reviews1;
import java.time.LocalDateTime;

class Transaction {
    private String type;
    private double amount;
    private String description;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount, String description, LocalDateTime timestamp) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f - %s at %s", type, amount, description, timestamp);
    }
}
