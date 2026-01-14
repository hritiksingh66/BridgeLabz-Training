public class BankAccountTest {
    
    private SimpleBankAccount account;
    
    public void setUp() {
        account = new SimpleBankAccount(100.0);
    }
    
    public void testDeposit() {
        setUp();
        account.deposit(50.0);
        assert account.getBalance() == 150.0 : "Balance should be 150.0";
        System.out.println("✓ testDeposit passed");
    }
    
    public void testWithdraw() {
        setUp();
        account.withdraw(30.0);
        assert account.getBalance() == 70.0 : "Balance should be 70.0";
        System.out.println("✓ testWithdraw passed");
    }
    
    public void testInsufficientFunds() {
        setUp();
        try {
            account.withdraw(150.0);
            assert false : "Should throw IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testInsufficientFunds passed");
        }
    }
    
    public void testNegativeDeposit() {
        setUp();
        try {
            account.deposit(-10.0);
            assert false : "Should throw IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testNegativeDeposit passed");
        }
    }
    
    public static void main(String[] args) {
        BankAccountTest test = new BankAccountTest();
        System.out.println("Running BankAccount tests...\n");
        test.testDeposit();
        test.testWithdraw();
        test.testInsufficientFunds();
        test.testNegativeDeposit();
        System.out.println("\nAll tests completed!");
    }
}