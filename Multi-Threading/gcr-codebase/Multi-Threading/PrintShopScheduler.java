// PrintJob class implementing Runnable
class PrintJob implements Runnable {
    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {
        // Determine priority label
        String priorityLabel = getPriorityLabel();
        
        // Print each page
        for (int page = 1; page <= pages; page++) {
            System.out.println("[" + priorityLabel + "] Printing " + jobName + " - Page " + page + " of " + pages);
            
            try {
                // Simulate printing time (100ms per page)
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(jobName + " completed!");
    }

    private String getPriorityLabel() {
        if (priority >= 7) return "High Priority";
        if (priority >= 5) return "Medium Priority";
        return "Low Priority";
    }

    public int getPriority() {
        return priority;
    }
}

class PrintShopScheduler {
    public static void main(String[] args) {
        System.out.println("Starting print jobs...\n");
        
        // Record start time
        long startTime = System.currentTimeMillis();
        
        // Create 5 print jobs with different specifications
        PrintJob job1 = new PrintJob("Job1", 10, 5);
        PrintJob job2 = new PrintJob("Job2", 5, 8);
        PrintJob job3 = new PrintJob("Job3", 15, 3);
        PrintJob job4 = new PrintJob("Job4", 8, 6);
        PrintJob job5 = new PrintJob("Job5", 12, 7);
        
        // Create threads for each job
        Thread t1 = new Thread(job1, "Job1");
        Thread t2 = new Thread(job2, "Job2");
        Thread t3 = new Thread(job3, "Job3");
        Thread t4 = new Thread(job4, "Job4");
        Thread t5 = new Thread(job5, "Job5");
        
        // Set thread priorities based on job priority
        t1.setPriority(5);
        t2.setPriority(8);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(7);
        
        // Start all print jobs
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        try {
            // Wait for all jobs to complete
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Calculate total time
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        System.out.println("\nAll jobs completed in " + totalTime + "ms");
    }
}
