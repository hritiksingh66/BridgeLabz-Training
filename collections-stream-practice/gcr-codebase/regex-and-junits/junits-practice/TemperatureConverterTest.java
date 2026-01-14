import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {
    
    private TemperatureConverter converter = new TemperatureConverter();
    
    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01);
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.01);
        assertEquals(98.6, converter.celsiusToFahrenheit(37.0), 0.01);
    }
    
    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.01);
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.01);
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.01);
    }
}