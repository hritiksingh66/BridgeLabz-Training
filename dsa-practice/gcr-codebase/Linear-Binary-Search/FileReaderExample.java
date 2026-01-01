import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Program to read file using FileReader
public class FileReaderExample {
    
    // Main method to demonstrate file reading
    public static void main(String[] args) {
        String fileName = "sample.txt";
        
        // Try to read file line by line
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}