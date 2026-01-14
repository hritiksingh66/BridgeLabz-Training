import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {
    
    private DateFormatter formatter = new DateFormatter();
    
    @Test
    public void testValidDateFormatting() {
        assertEquals("25-12-2023", formatter.formatDate("2023-12-25"));
        assertEquals("01-01-2024", formatter.formatDate("2024-01-01"));
    }
    
    @Test
    public void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, 
            () -> formatter.formatDate("25-12-2023"));
        assertThrows(IllegalArgumentException.class, 
            () -> formatter.formatDate("invalid-date"));
    }
}