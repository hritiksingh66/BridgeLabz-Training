import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class StockPrice {
    private String symbol;
    private double price;
    private double change;
    private LocalDateTime timestamp;
    
    public StockPrice(String symbol, double price, double change) {
        this.symbol = symbol;
        this.price = price;
        this.change = change;
        this.timestamp = LocalDateTime.now();
    }
    
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public double getChange() { return change; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    public String getChangeIndicator() {
        return change > 0 ? "📈" : change < 0 ? "📉" : "➡️";
    }
    
    @Override
    public String toString() {
        return String.format("%s %s: ₹%.2f (%.2f)", 
                           getChangeIndicator(), symbol, price, change);
    }
}

public class StockPriceLogger {
    
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    // Simulate live stock feed
    public static List<StockPrice> generateStockFeed() {
        Random random = new Random();
        return Arrays.asList(
            new StockPrice("RELIANCE", 2450.75, random.nextDouble() * 100 - 50),
            new StockPrice("TCS", 3890.20, random.nextDouble() * 100 - 50),
            new StockPrice("INFY", 1675.30, random.nextDouble() * 100 - 50),
            new StockPrice("HDFC", 2780.45, random.nextDouble() * 100 - 50),
            new StockPrice("ICICI", 945.60, random.nextDouble() * 100 - 50),
            new StockPrice("WIPRO", 425.80, random.nextDouble() * 100 - 50),
            new StockPrice("BAJAJ", 4250.90, random.nextDouble() * 100 - 50),
            new StockPrice("MARUTI", 9875.25, random.nextDouble() * 100 - 50)
        );
    }
    
    public static void main(String[] args) {
        System.out.println("=== Stock Price Logger - Live Feed ===");
        System.out.println("Time: " + LocalDateTime.now().format(TIME_FORMAT));
        System.out.println("----------------------------------------");
        
        List<StockPrice> stockFeed = generateStockFeed();
        
        // Basic forEach to display all stock prices
        stockFeed.forEach(stock -> 
            System.out.println(stock.getTimestamp().format(TIME_FORMAT) + " | " + stock));
        
        System.out.println("\n=== Filtered Updates ===");
        
        // Display only significant changes (>5% or <-5%)
        System.out.println("Significant Changes (>₹5 or <-₹5):");
        stockFeed.stream()
            .filter(stock -> Math.abs(stock.getChange()) > 5)
            .forEach(stock -> System.out.println("⚠️  " + stock));
        
        // Display gainers
        System.out.println("\nTop Gainers:");
        stockFeed.stream()
            .filter(stock -> stock.getChange() > 0)
            .sorted((s1, s2) -> Double.compare(s2.getChange(), s1.getChange()))
            .forEach(stock -> System.out.println("🟢 " + stock));
        
        // Display losers
        System.out.println("\nTop Losers:");
        stockFeed.stream()
            .filter(stock -> stock.getChange() < 0)
            .sorted((s1, s2) -> Double.compare(s1.getChange(), s2.getChange()))
            .forEach(stock -> System.out.println("🔴 " + stock));
        
        // Summary statistics
        System.out.println("\n=== Market Summary ===");
        long gainers = stockFeed.stream().filter(s -> s.getChange() > 0).count();
        long losers = stockFeed.stream().filter(s -> s.getChange() < 0).count();
        long unchanged = stockFeed.stream().filter(s -> s.getChange() == 0).count();
        
        System.out.println("Gainers: " + gainers);
        System.out.println("Losers: " + losers);
        System.out.println("Unchanged: " + unchanged);
        
        // Alert for high volatility stocks
        System.out.println("\n=== High Volatility Alert ===");
        stockFeed.stream()
            .filter(stock -> Math.abs(stock.getChange()) > 20)
            .forEach(stock -> System.out.println("🚨 HIGH VOLATILITY: " + stock));
    }
}