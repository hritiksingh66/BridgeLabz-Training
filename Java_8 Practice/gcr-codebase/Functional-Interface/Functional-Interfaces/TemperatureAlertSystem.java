import java.util.function.Predicate;

public class TemperatureAlertSystem {
    
    // Predicate to check if temperature crosses threshold
    private static Predicate<Double> isHighTemperature = temp -> temp > 35.0;
    private static Predicate<Double> isLowTemperature = temp -> temp < 10.0;
    private static Predicate<Double> isCriticalTemperature = temp -> temp > 40.0 || temp < 5.0;
    
    public static void checkTemperature(double temperature) {
        System.out.println("Current temperature: " + temperature + "°C");
        
        if (isCriticalTemperature.test(temperature)) {
            System.out.println("🚨 CRITICAL ALERT: Extreme temperature detected!");
        } else if (isHighTemperature.test(temperature)) {
            System.out.println("⚠️ HIGH TEMPERATURE ALERT: Temperature above normal");
        } else if (isLowTemperature.test(temperature)) {
            System.out.println("❄️ LOW TEMPERATURE ALERT: Temperature below normal");
        } else {
            System.out.println("✅ Temperature is normal");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        double[] temperatures = {25.0, 38.0, 8.0, 42.0, 15.0, 3.0};
        
        for (double temp : temperatures) {
            checkTemperature(temp);
        }
    }
}