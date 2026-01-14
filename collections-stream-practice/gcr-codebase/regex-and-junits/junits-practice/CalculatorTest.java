public class CalculatorTest {
    
    private Calculator calculator = new Calculator();
    
    public void testAdd() {
        assert calculator.add(2, 3) == 5 : "2 + 3 should equal 5";
        assert calculator.add(-1, 1) == 0 : "-1 + 1 should equal 0";
        System.out.println("✓ testAdd passed");
    }
    
    public void testSubtract() {
        assert calculator.subtract(3, 2) == 1 : "3 - 2 should equal 1";
        assert calculator.subtract(-1, 1) == -2 : "-1 - 1 should equal -2";
        System.out.println("✓ testSubtract passed");
    }
    
    public void testMultiply() {
        assert calculator.multiply(2, 3) == 6 : "2 * 3 should equal 6";
        assert calculator.multiply(0, 5) == 0 : "0 * 5 should equal 0";
        System.out.println("✓ testMultiply passed");
    }
    
    public void testDivide() {
        assert calculator.divide(6, 3) == 2.0 : "6 / 3 should equal 2.0";
        assert calculator.divide(5, 2) == 2.5 : "5 / 2 should equal 2.5";
        System.out.println("✓ testDivide passed");
    }
    
    public void testDivideByZero() {
        try {
            calculator.divide(5, 0);
            assert false : "Should throw ArithmeticException";
        } catch (ArithmeticException e) {
            System.out.println("✓ testDivideByZero passed");
        }
    }
    
    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        System.out.println("Running Calculator tests...\n");
        test.testAdd();
        test.testSubtract();
        test.testMultiply();
        test.testDivide();
        test.testDivideByZero();
        System.out.println("\nAll tests completed!");
    }
}