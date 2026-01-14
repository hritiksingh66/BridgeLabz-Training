import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    
    private PasswordValidator validator = new PasswordValidator();
    
    @ParameterizedTest
    @ValueSource(strings = {"Password1", "MyPass123", "SecureP4ss"})
    public void testValidPasswords(String password) {
        assertTrue(validator.isValidPassword(password));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"pass", "password", "PASSWORD", "12345678", "Pass"})
    public void testInvalidPasswords(String password) {
        assertFalse(validator.isValidPassword(password));
    }
    
    @Test
    public void testNullPassword() {
        assertFalse(validator.isValidPassword(null));
    }
}