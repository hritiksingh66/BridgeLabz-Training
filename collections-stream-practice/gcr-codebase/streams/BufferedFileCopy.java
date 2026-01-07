import java.io.*;
import java.util.Scanner;

public class BufferedFileCopy {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter source file path: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination file path (buffered): ");
        String destBuffered = scanner.nextLine();
        System.out.print("Enter destination file path (unbuffered): ");
        String destUnbuffered = scanner.nextLine();
        
        // Test buffered copy
        long bufferedTime = copyWithBufferedStreams(sourcePath, destBuffered);
        
        // Test unbuffered copy
        long unbufferedTime = copyWithUnbufferedStreams(sourcePath, destUnbuffered);
        
        // Compare performance
        System.out.println("Buffered copy time: " + bufferedTime / 1_000_000 + " ms");
        System.out.println("Unbuffered copy time: " + unbufferedTime / 1_000_000 + " ms");
        System.out.println("Performance improvement: " + (unbufferedTime / bufferedTime) + "x faster");
        
        scanner.close();
    }
    
    // Copy using BufferedInputStream and BufferedOutputStream
    public static long copyWithBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            
            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        }
        
        return System.nanoTime() - startTime;
    }
    
    // Copy using regular FileInputStream and FileOutputStream
    public static long copyWithUnbufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            
        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        }
        
        return System.nanoTime() - startTime;
    }
}