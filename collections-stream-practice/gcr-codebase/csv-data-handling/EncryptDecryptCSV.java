import java.io.*;
import java.util.*;

public class EncryptDecryptCSV {
    
    // Simple Caesar cipher for demonstration
    private static final int SHIFT = 3;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Encrypt CSV");
        System.out.println("2. Decrypt CSV");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        if (choice == 1) {
            System.out.print("Enter input CSV file: ");
            String inputFile = sc.nextLine();
            System.out.print("Enter encrypted output file: ");
            String outputFile = sc.nextLine();
            encryptCSV(inputFile, outputFile);
        } else if (choice == 2) {
            System.out.print("Enter encrypted CSV file: ");
            String inputFile = sc.nextLine();
            System.out.print("Enter decrypted output file: ");
            String outputFile = sc.nextLine();
            decryptCSV(inputFile, outputFile);
        }
        
        sc.close();
    }
    
    // Encrypt sensitive fields in CSV
    public static void encryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    pw.println(line); // Keep header as is
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                
                // Encrypt sensitive fields (assuming salary at index 3, email at index 2)
                if (data.length > 2) {
                    data[2] = encrypt(data[2]); // Encrypt email
                }
                if (data.length > 3) {
                    data[3] = encrypt(data[3]); // Encrypt salary
                }
                
                pw.println(String.join(",", data));
            }
            
            System.out.println("CSV encrypted: " + outputFile);
            
        } catch (IOException e) {
            System.out.println("Error encrypting CSV: " + e.getMessage());
        }
    }
    
    // Decrypt sensitive fields in CSV
    public static void decryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    pw.println(line); // Keep header as is
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                
                // Decrypt sensitive fields
                if (data.length > 2) {
                    data[2] = decrypt(data[2]); // Decrypt email
                }
                if (data.length > 3) {
                    data[3] = decrypt(data[3]); // Decrypt salary
                }
                
                pw.println(String.join(",", data));
            }
            
            System.out.println("CSV decrypted: " + outputFile);
            
        } catch (IOException e) {
            System.out.println("Error decrypting CSV: " + e.getMessage());
        }
    }
    
    // Simple Caesar cipher encryption
    private static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + SHIFT) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    // Simple Caesar cipher decryption
    private static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base - SHIFT + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}