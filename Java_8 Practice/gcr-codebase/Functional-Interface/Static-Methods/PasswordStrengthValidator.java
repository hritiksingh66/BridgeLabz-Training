// Security utilities interface with static methods
interface SecurityUtils {
    
    // Static method to check password strength
    static String checkPasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            return "WEAK - Password must be at least 8 characters";
        }
        
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(ch -> "!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(ch) >= 0);
        
        int score = 0;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;
        if (password.length() >= 12) score++;
        
        return switch (score) {
            case 0, 1, 2 -> "WEAK - Add uppercase, lowercase, numbers, and special characters";
            case 3 -> "MEDIUM - Consider adding more character types or length";
            case 4 -> "STRONG - Good password strength";
            case 5 -> "VERY STRONG - Excellent password";
            default -> "WEAK";
        };
    }
    
    // Static method to generate password requirements
    static void displayPasswordRequirements() {
        System.out.println("Password Requirements:");
        System.out.println("• Minimum 8 characters");
        System.out.println("• At least one uppercase letter");
        System.out.println("• At least one lowercase letter");
        System.out.println("• At least one number");
        System.out.println("• At least one special character");
        System.out.println("• Recommended: 12+ characters for maximum security");
        System.out.println();
    }
}

public class PasswordStrengthValidator {
    
    public static void validatePassword(String password) {
        System.out.println("Password: " + "*".repeat(password.length()));
        String strength = SecurityUtils.checkPasswordStrength(password);
        System.out.println("Strength: " + strength);
        System.out.println();
    }
    
    public static void main(String[] args) {
        SecurityUtils.displayPasswordRequirements();
        
        String[] passwords = {
            "123",
            "password",
            "Password123",
            "MyStr0ng@Pass",
            "VerySecure#Password123!"
        };
        
        for (String password : passwords) {
            validatePassword(password);
        }
    }
}