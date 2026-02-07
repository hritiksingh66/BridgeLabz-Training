// Approach 2: Using Runnable interface
class FileDownloaderRunnable implements Runnable {
    private String fileName;

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        // Simulate download progress from 0% to 100%
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + progress + "%");
            
            try {
                // Random delay to simulate actual download time (100-500ms)
                Thread.sleep((long) (Math.random() * 400 + 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DownloadManagerRunnable {
    public static void main(String[] args) {
        // Create 3 file downloader runnables
        FileDownloaderRunnable task1 = new FileDownloaderRunnable("Document.pdf");
        FileDownloaderRunnable task2 = new FileDownloaderRunnable("Image.jpg");
        FileDownloaderRunnable task3 = new FileDownloaderRunnable("Video.mp4");

        // Create threads with runnable tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Start all downloads
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Main thread waits for all downloads to complete
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All downloads complete!");
    }
}
