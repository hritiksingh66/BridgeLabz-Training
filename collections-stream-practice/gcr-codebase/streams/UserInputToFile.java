import java.io.*;

public class UserInputToFile {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = null;
        
        try {
            // Get user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            
            System.out.print("Enter output file name: ");
            String fileName = reader.readLine();
            
            // Write to file
            writer = new FileWriter(fileName);
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            
            System.out.println("Data saved to " + fileName + " successfully!");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}