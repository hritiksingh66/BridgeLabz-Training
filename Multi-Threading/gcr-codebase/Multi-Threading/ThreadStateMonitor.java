import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

// TaskRunner class that performs operations
class TaskRunner extends Thread {
    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            // TIMED_WAITING state - sleep for 2 seconds
            Thread.sleep(2000);
            
            // RUNNABLE state - perform computation
            long sum = 0;
            for (int i = 0; i < 1000000; i++) {
                sum += i;
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// StateMonitor class that monitors thread states
class StateMonitor extends Thread {
    private Thread[] threads;
    private Map<String, Integer> stateCountMap;

    public StateMonitor(Thread[] threads) {
        this.threads = threads;
        this.stateCountMap = new HashMap<>();
        for (Thread t : threads) {
            stateCountMap.put(t.getName(), 0);
        }
    }

    @Override
    public void run() {
        boolean allTerminated = false;
        Map<String, Thread.State> lastState = new HashMap<>();

        while (!allTerminated) {
            allTerminated = true;
            
            for (Thread thread : threads) {
                Thread.State currentState = thread.getState();
                
                // Display state only if it changed
                if (!currentState.equals(lastState.get(thread.getName()))) {
                    String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    System.out.println("[Monitor] " + thread.getName() + " is in " + currentState + " state at " + timestamp);
                    
                    // Count state transitions
                    stateCountMap.put(thread.getName(), stateCountMap.get(thread.getName()) + 1);
                    lastState.put(thread.getName(), currentState);
                }
                
                // Check if thread is not terminated
                if (currentState != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }
            
            try {
                // Check every 500ms
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Display summary
        System.out.println("\n--- Summary ---");
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " went through " + stateCountMap.get(thread.getName()) + " states");
        }
    }
}

class ThreadStateMonitor {
    public static void main(String[] args) {
        // Create 2 TaskRunner threads
        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");
        
        // Display NEW state
        String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[Monitor] " + task1.getName() + " is in " + task1.getState() + " state at " + timestamp);
        System.out.println("[Monitor] " + task2.getName() + " is in " + task2.getState() + " state at " + timestamp);
        
        // Create StateMonitor
        Thread[] tasks = {task1, task2};
        StateMonitor monitor = new StateMonitor(tasks);
        
        // Start monitor first
        monitor.start();
        
        try {
            // Small delay to ensure monitor is running
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Start task threads
        task1.start();
        task2.start();
        
        try {
            // Wait for all threads to complete
            task1.join();
            task2.join();
            monitor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nMonitoring completed!");
    }
}
