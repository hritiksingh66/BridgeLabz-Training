import java.util.function.Function;

public class StringLengthChecker {
    
    // Function to get string length
    private static Function<String, Integer> getLength = String::length;
    
    // Function to check if message exceeds limit
    private static Function<String, Boolean> exceedsLimit = message -> getLength.apply(message) > 100;
    
    // Function to get status message
    private static Function<String, String> getStatusMessage = message -> {
        int length = getLength.apply(message);
        if (length > 100) {
            return "❌ Message too long (" + length + "/100 characters)";
        } else {
            return "✅ Message within limit (" + length + "/100 characters)";
        }
    };
    
    public static void checkMessage(String message) {
        System.out.println("Message: \"" + (message.length() > 50 ? message.substring(0, 50) + "..." : message) + "\"");
        System.out.println(getStatusMessage.apply(message));
        System.out.println();
    }
    
    public static void main(String[] args) {
        String[] messages = {
            "Hello World!",
            "This is a medium length message that should be within the character limit for most applications.",
            "This is a very long message that definitely exceeds the 100 character limit and should trigger the length validation warning in our system.",
            "Short msg",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation."
        };
        
        for (String message : messages) {
            checkMessage(message);
        }
    }
}