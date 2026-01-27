// Unit conversion interface with static methods
interface UnitConverter {
    
    // Distance conversions
    static double kmToMiles(double km) {
        return km * 0.621371;
    }
    
    static double milesToKm(double miles) {
        return miles * 1.60934;
    }
    
    // Weight conversions
    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
    
    static double lbsToKg(double lbs) {
        return lbs * 0.453592;
    }
    
    // Temperature conversions
    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    // Utility method to format conversion result
    static void displayConversion(String fromUnit, double fromValue, String toUnit, double toValue) {
        System.out.printf("%.2f %s = %.2f %s%n", fromValue, fromUnit, toValue, toUnit);
    }
}

public class UnitConversionTool {
    
    public static void main(String[] args) {
        System.out.println("=== Logistics Unit Conversion Tool ===\n");
        
        // Distance conversions
        System.out.println("Distance Conversions:");
        double km = 100;
        double miles = UnitConverter.kmToMiles(km);
        UnitConverter.displayConversion("km", km, "miles", miles);
        
        double milesInput = 50;
        double kmOutput = UnitConverter.milesToKm(milesInput);
        UnitConverter.displayConversion("miles", milesInput, "km", kmOutput);
        
        System.out.println();
        
        // Weight conversions
        System.out.println("Weight Conversions:");
        double kg = 75;
        double lbs = UnitConverter.kgToLbs(kg);
        UnitConverter.displayConversion("kg", kg, "lbs", lbs);
        
        double lbsInput = 150;
        double kgOutput = UnitConverter.lbsToKg(lbsInput);
        UnitConverter.displayConversion("lbs", lbsInput, "kg", kgOutput);
        
        System.out.println();
        
        // Temperature conversions
        System.out.println("Temperature Conversions:");
        double celsius = 25;
        double fahrenheit = UnitConverter.celsiusToFahrenheit(celsius);
        UnitConverter.displayConversion("°C", celsius, "°F", fahrenheit);
        
        double fahrenheitInput = 77;
        double celsiusOutput = UnitConverter.fahrenheitToCelsius(fahrenheitInput);
        UnitConverter.displayConversion("°F", fahrenheitInput, "°C", celsiusOutput);
    }
}