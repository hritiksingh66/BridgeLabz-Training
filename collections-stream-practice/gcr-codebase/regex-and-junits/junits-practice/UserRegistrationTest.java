import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    
    private UserRegistration registration = new UserRegistration();
    
    @Test
    public void testValidRegistration() {
        assertTrue(registration.registerUser("john_doe", "john@example.com", "password123"));
    }
    
    @Test
    public void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("", "john@example.com", "password123"));
        assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser(null, "john@example.com", "password123"));
    }
    
    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("john", "invalid-email", "password123"));
        assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("john", null, "password123"));
    }
    
    @Test
    public void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("john", "john@example.com", "123"));
        assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("john", "john@example.com", null));
    }
}