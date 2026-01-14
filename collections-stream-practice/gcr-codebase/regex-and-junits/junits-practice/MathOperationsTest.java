public class MathOperationsTest {
    
    private MathOperations mathOps = new MathOperations();
    
    public void testDivideByZeroThrowsException() {
        try {
            mathOps.divide(10, 0);
            assert false : "Should throw ArithmeticException";
        } catch (ArithmeticException e) {
            assert "Cannot divide by zero".equals(e.getMessage()) : "Wrong exception message";
            System.out.println("✓ testDivideByZeroThrowsException passed");
        }
    }
    
    public void testValidDivision() {
        assert mathOps.divide(5, 2) == 2.5 : "5 / 2 should equal 2.5";
        System.out.println("✓ testValidDivision passed");
    }
    
    public static void main(String[] args) {
        MathOperationsTest test = new MathOperationsTest();
        System.out.println("Running MathOperations tests...\n");
        test.testDivideByZeroThrowsException();
        test.testValidDivision();
        System.out.println("\nAll tests completed!");
    }
}