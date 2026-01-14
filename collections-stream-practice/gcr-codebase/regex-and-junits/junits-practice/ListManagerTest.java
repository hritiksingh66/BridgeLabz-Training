import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
    
    private ListManager listManager;
    private List<Integer> testList;
    
    public void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>();
    }
    
    public void testAddElement() {
        setUp();
        listManager.addElement(testList, 5);
        assert testList.size() == 1 : "Size should be 1";
        assert testList.contains(5) : "List should contain 5";
        System.out.println("✓ testAddElement passed");
    }
    
    public void testRemoveElement() {
        setUp();
        testList.add(10);
        testList.add(20);
        
        assert listManager.removeElement(testList, 10) : "Should remove element";
        assert testList.size() == 1 : "Size should be 1";
        assert !testList.contains(10) : "Should not contain 10";
        System.out.println("✓ testRemoveElement passed");
    }
    
    public void testGetSize() {
        setUp();
        assert listManager.getSize(testList) == 0 : "Initial size should be 0";
        
        testList.add(1);
        testList.add(2);
        assert listManager.getSize(testList) == 2 : "Size should be 2";
        System.out.println("✓ testGetSize passed");
    }
    
    public static void main(String[] args) {
        ListManagerTest test = new ListManagerTest();
        System.out.println("Running ListManager tests...\n");
        test.testAddElement();
        test.testRemoveElement();
        test.testGetSize();
        System.out.println("\nAll tests completed!");
    }
}