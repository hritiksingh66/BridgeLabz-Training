// Approach 1: Using Thread class
class FileDownloaderThread extends Thread {
    private String fileName;

    public FileDownloaderThread(String fileName) {
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

public class DownloadManagerThread {
    public static void main(String[] args) {
        // Create 3 file downloaders for concurrent downloads
        FileDownloaderThread downloader1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread downloader2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread downloader3 = new FileDownloaderThread("Video.mp4");

        // Start all downloads
        downloader1.start();
        downloader2.start();
        downloader3.start();

        try {
            // Main thread waits for all downloads to complete
            downloader1.join();
            downloader2.join();
            downloader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All downloads complete!");
    }
}
