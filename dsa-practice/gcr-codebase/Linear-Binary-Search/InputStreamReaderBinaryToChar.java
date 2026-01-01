import java.io.*;
import java.nio.charset.StandardCharsets;

// Program to read file using InputStreamReader
public class InputStreamReaderBinaryToChar {
    
    // Main method to demonstrate InputStreamReader
    public static void main(String[] args) {
        String fileName = "data.txt";
        
        // Try to read file using InputStreamReader with UTF-8 encoding
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}