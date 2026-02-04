import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class SensorReading {
    private String sensorId;
    private String sensorType;
    private double value;
    private String unit;
    private LocalDateTime timestamp;
    
    public SensorReading(String sensorId, String sensorType, double value, String unit) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.timestamp = LocalDateTime.now();
    }
    
    public String getSensorId() { return sensorId; }
    public String getSensorType() { return sensorType; }
    public double getValue() { return value; }
    public String getUnit() { return unit; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s (%s): %.2f %s", 
                           timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                           sensorId, sensorType, value, unit);
    }
}

public class IoTSensorReadings {
    
    // Define thresholds for different sensor types
    private static final Map<String, Double> THRESHOLDS = Map.of(
        "Temperature", 35.0,
        "Humidity", 80.0,
        "Pressure", 1020.0,
        "Light", 1000.0,
        "Motion", 5.0
    );
    
    public static void main(String[] args) {
        // Simulate IoT sensor readings
        List<SensorReading> readings = generateSensorReadings();
        
        System.out.println("=== IoT Sensor Monitoring System ===");
        System.out.println("Timestamp: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Total readings: " + readings.size());
        System.out.println("=====================================\n");
        
        // Display all readings
        System.out.println("📊 All Sensor Readings:");
        readings.forEach(System.out::println);
        
        System.out.println("\n🚨 THRESHOLD ALERTS:");
        
        // Filter and display readings above threshold
        readings.stream()
            .filter(reading -> {
                Double threshold = THRESHOLDS.get(reading.getSensorType());
                return threshold != null && reading.getValue() > threshold;
            })
            .forEach(reading -> {
                Double threshold = THRESHOLDS.get(reading.getSensorType());
                System.out.printf("⚠️  ALERT: %s - %.2f %s (Threshold: %.2f %s)%n",
                    reading.getSensorId(), reading.getValue(), reading.getUnit(),
                    threshold, reading.getUnit());
            });
        
        System.out.println("\n📈 Readings by Sensor Type:");
        
        // Group readings by sensor type and display
        Map<String, List<SensorReading>> readingsByType = new HashMap<>();
        readings.forEach(reading -> {
            readingsByType.computeIfAbsent(reading.getSensorType(), k -> new ArrayList<>())
                         .add(reading);
        });
        
        readingsByType.forEach((type, sensorReadings) -> {
            System.out.println("\n" + type + " Sensors:");
            sensorReadings.forEach(reading -> System.out.println("  " + reading));
            
            // Calculate average for this sensor type
            double average = sensorReadings.stream()
                .mapToDouble(SensorReading::getValue)
                .average()
                .orElse(0.0);
            System.out.printf("  Average: %.2f%n", average);
        });
        
        // Critical alerts (significantly above threshold)
        System.out.println("\n🚨 CRITICAL ALERTS (>150% of threshold):");
        readings.stream()
            .filter(reading -> {
                Double threshold = THRESHOLDS.get(reading.getSensorType());
                return threshold != null && reading.getValue() > (threshold * 1.5);
            })
            .forEach(reading -> 
                System.out.println("🔴 CRITICAL: " + reading));
        
        // Summary statistics
        System.out.println("\n📋 Summary Statistics:");
        long alertCount = readings.stream()
            .filter(reading -> {
                Double threshold = THRESHOLDS.get(reading.getSensorType());
                return threshold != null && reading.getValue() > threshold;
            })
            .count();
        
        System.out.println("Total alerts: " + alertCount);
        System.out.println("Alert rate: " + String.format("%.1f%%", (alertCount * 100.0) / readings.size()));
        
        // Sensor status
        System.out.println("\n🔧 Sensor Status:");
        readingsByType.forEach((type, sensorReadings) -> {
            long activeCount = sensorReadings.size();
            System.out.println(type + " sensors active: " + activeCount);
        });
    }
    
    private static List<SensorReading> generateSensorReadings() {
        Random random = new Random();
        return Arrays.asList(
            new SensorReading("TEMP_001", "Temperature", 32.5 + random.nextDouble() * 10, "°C"),
            new SensorReading("TEMP_002", "Temperature", 28.0 + random.nextDouble() * 15, "°C"),
            new SensorReading("HUM_001", "Humidity", 65.0 + random.nextDouble() * 25, "%"),
            new SensorReading("HUM_002", "Humidity", 70.0 + random.nextDouble() * 20, "%"),
            new SensorReading("PRES_001", "Pressure", 1010.0 + random.nextDouble() * 20, "hPa"),
            new SensorReading("LIGHT_001", "Light", 800.0 + random.nextDouble() * 400, "lux"),
            new SensorReading("MOTION_001", "Motion", random.nextDouble() * 10, "units"),
            new SensorReading("TEMP_003", "Temperature", 40.0 + random.nextDouble() * 5, "°C"),
            new SensorReading("HUM_003", "Humidity", 85.0 + random.nextDouble() * 10, "%")
        );
    }
}