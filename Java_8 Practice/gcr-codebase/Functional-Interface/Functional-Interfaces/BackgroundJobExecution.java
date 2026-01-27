public class BackgroundJobExecution {
    
    // Background job using Runnable functional interface
    private static Runnable dataBackupJob = () -> {
        System.out.println("🔄 Starting data backup job...");
        try {
            Thread.sleep(2000); // Simulate backup process
            System.out.println("✅ Data backup completed successfully");
        } catch (InterruptedException e) {
            System.out.println("❌ Backup job interrupted");
        }
    };
    
    private static Runnable emailNotificationJob = () -> {
        System.out.println("📧 Sending email notifications...");
        try {
            Thread.sleep(1000); // Simulate email sending
            System.out.println("✅ Email notifications sent");
        } catch (InterruptedException e) {
            System.out.println("❌ Email job interrupted");
        }
    };
    
    private static Runnable reportGenerationJob = () -> {
        System.out.println("📊 Generating daily reports...");
        try {
            Thread.sleep(3000); // Simulate report generation
            System.out.println("✅ Daily reports generated");
        } catch (InterruptedException e) {
            System.out.println("❌ Report generation interrupted");
        }
    };
    
    public static void executeJob(Runnable job, String jobName) {
        System.out.println("Starting background job: " + jobName);
        Thread thread = new Thread(job);
        thread.start();
    }
    
    public static void main(String[] args) {
        // Execute background jobs asynchronously
        executeJob(dataBackupJob, "Data Backup");
        executeJob(emailNotificationJob, "Email Notifications");
        executeJob(reportGenerationJob, "Report Generation");
        
        System.out.println("All background jobs started. Main thread continues...");
        
        // Wait for all jobs to complete
        try {
            Thread.sleep(4000);
            System.out.println("All background jobs completed!");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}