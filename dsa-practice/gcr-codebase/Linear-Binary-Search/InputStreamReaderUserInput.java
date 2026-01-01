import java.io.*;

// Program to read user input and save to file
public class InputStreamReaderUserInput {
    
    // Main method to read user input and write to file
    public static void main(String[] args) {
        String fileName = "user_input.txt";
        
        // Read user input and write to file
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(fileName)) {
            
            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            
            while (!(input = bufferedReader.readLine()).equals("exit")) {
                fileWriter.write(input + "\n");
            }
            
            System.out.println("Input saved to " + fileName);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}