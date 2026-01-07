import java.io.*;
import java.util.Scanner;

public class ImageToByteArray {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter source image path: ");
        String sourcePath = scanner.nextLine();
        
        System.out.print("Enter destination image path: ");
        String destPath = scanner.nextLine();
        
        convertImageToByteArrayAndBack(sourcePath, destPath);
        
        scanner.close();
    }
    
    // Convert image to byte array and write back to new file
    public static void convertImageToByteArrayAndBack(String sourcePath, String destPath) {
        try {
            // Read image into byte array
            byte[] imageBytes = readImageToByteArray(sourcePath);
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");
            
            // Write byte array back to new image file
            writeByteArrayToImage(imageBytes, destPath);
            System.out.println("Byte array converted back to image successfully!");
            
            // Verify files are identical
            if (areFilesIdentical(sourcePath, destPath)) {
                System.out.println("Verification: Files are identical!");
            } else {
                System.out.println("Verification: Files are different!");
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Read image file into byte array using ByteArrayOutputStream
    public static byte[] readImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            
            return baos.toByteArray();
        }
    }
    
    // Write byte array to image file using ByteArrayInputStream
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
    
    // Verify if two files are identical
    public static boolean areFilesIdentical(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            
            int byte1, byte2;
            do {
                byte1 = fis1.read();
                byte2 = fis2.read();
                if (byte1 != byte2) return false;
            } while (byte1 != -1);
            
            return true;
        }
    }
}