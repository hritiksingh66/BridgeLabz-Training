import java.util.*;
import java.util.stream.Collectors;

public class TransformingNamesForDisplay {
    
    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList(
            "john doe",
            "jane smith",
            "mike johnson",
            "sarah wilson",
            "david brown",
            "lisa davis",
            "tom miller",
            "amy taylor",
            "chris anderson",
            "emma moore"
        );
        
        System.out.println("=== Original Customer Names ===");
        customerNames.forEach(System.out::println);
        
        System.out.println("\n=== Transformed Names (Uppercase & Sorted) ===");
        
        // Transform to uppercase and sort alphabetically
        List<String> transformedNames = customerNames.stream()
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());
        
        transformedNames.forEach(System.out::println);
        
        System.out.println("\n=== Additional Transformations ===");
        
        // Title case transformation
        System.out.println("\nTitle Case (Sorted):");
        customerNames.stream()
            .map(name -> Arrays.stream(name.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" ")))
            .sorted()
            .forEach(System.out::println);
        
        // Last name first format
        System.out.println("\nLast Name First Format (Sorted):");
        customerNames.stream()
            .map(name -> {
                String[] parts = name.split(" ");
                return parts.length >= 2 ? 
                    parts[1].toUpperCase() + ", " + parts[0].toUpperCase() : 
                    name.toUpperCase();
            })
            .sorted()
            .forEach(System.out::println);
        
        // Initials format
        System.out.println("\nInitials Format (Sorted):");
        customerNames.stream()
            .map(name -> Arrays.stream(name.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase())
                .collect(Collectors.joining(". ")) + ".")
            .sorted()
            .forEach(System.out::println);
        
        // Statistics
        System.out.println("\n=== Name Statistics ===");
        System.out.println("Total customers: " + customerNames.size());
        
        double avgLength = customerNames.stream()
            .mapToInt(String::length)
            .average()
            .orElse(0.0);
        System.out.printf("Average name length: %.1f characters%n", avgLength);
        
        String longestName = customerNames.stream()
            .max(Comparator.comparing(String::length))
            .orElse("");
        System.out.println("Longest name: " + longestName + " (" + longestName.length() + " chars)");
        
        String shortestName = customerNames.stream()
            .min(Comparator.comparing(String::length))
            .orElse("");
        System.out.println("Shortest name: " + shortestName + " (" + shortestName.length() + " chars)");
    }
}