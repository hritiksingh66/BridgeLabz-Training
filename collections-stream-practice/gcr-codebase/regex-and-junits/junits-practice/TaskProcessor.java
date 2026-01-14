public class TaskProcessor {
    
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task completed";
    }
    
    public String quickTask() {
        return "Quick task completed";
    }
}