import java.util.Scanner;

public class SpaceReplacer {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text with multiple spaces: ");
        String text = scanner.nextLine();
        
        String result = replaceMultipleSpaces(text);
        
        System.out.println("Original: \"" + text + "\"");
        System.out.println("Result: \"" + result + "\"");
        
        scanner.close();
    }
    
    // Replace multiple spaces with single space
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }
}