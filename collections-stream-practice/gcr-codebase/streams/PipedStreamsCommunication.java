import java.io.*;

public class PipedStreamsCommunication {
    
    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            // Create and start threads
            Thread writerThread = new Thread(new WriterTask(pos));
            Thread readerThread = new Thread(new ReaderTask(pis));
            
            writerThread.start();
            readerThread.start();
            
            // Wait for threads to complete
            writerThread.join();
            readerThread.join();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Writer thread that writes data to PipedOutputStream
class WriterTask implements Runnable {
    private PipedOutputStream pos;
    
    public WriterTask(PipedOutputStream pos) {
        this.pos = pos;
    }
    
    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(pos, true)) {
            
            // Write messages to pipe
            for (int i = 1; i <= 5; i++) {
                String message = "Message " + i + " from Writer Thread";
                writer.println(message);
                System.out.println("Writer: Sent - " + message);
                
                // Simulate some work
                Thread.sleep(1000);
            }
            
            writer.println("END"); // Signal end of data
            System.out.println("Writer: Finished sending messages");
            
        } catch (InterruptedException e) {
            System.out.println("Writer interrupted: " + e.getMessage());
        }
    }
}

// Reader thread that reads data from PipedInputStream
class ReaderTask implements Runnable {
    private PipedInputStream pis;
    
    public ReaderTask(PipedInputStream pis) {
        this.pis = pis;
    }
    
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
            
            String message;
            while ((message = reader.readLine()) != null) {
                if ("END".equals(message)) {
                    break; // End of data signal
                }
                
                System.out.println("Reader: Received - " + message);
                
                // Simulate processing time
                Thread.sleep(500);
            }
            
            System.out.println("Reader: Finished reading messages");
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}