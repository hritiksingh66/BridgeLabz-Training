import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class TaskProcessorTest {
    
    private TaskProcessor taskProcessor = new TaskProcessor();
    
    @Test
    @Timeout(2) // Should fail - task takes 3 seconds
    public void testLongRunningTaskTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), 
            () -> taskProcessor.longRunningTask());
    }
    
    @Test
    @Timeout(1) // Should pass - quick task
    public void testQuickTask() {
        assertEquals("Quick task completed", taskProcessor.quickTask());
    }
}