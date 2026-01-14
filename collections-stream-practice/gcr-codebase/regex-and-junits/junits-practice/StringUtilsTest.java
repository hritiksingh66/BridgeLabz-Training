public class StringUtilsTest {
    
    private StringUtils stringUtils = new StringUtils();
    
    public void testReverse() {
        assert "olleh".equals(stringUtils.reverse("hello")) : "Reverse failed";
        assert "".equals(stringUtils.reverse("")) : "Empty string reverse failed";
        assert stringUtils.reverse(null) == null : "Null reverse failed";
        System.out.println("✓ testReverse passed");
    }
    
    public void testIsPalindrome() {
        assert stringUtils.isPalindrome("racecar") : "racecar should be palindrome";
        assert stringUtils.isPalindrome("A man a plan a canal Panama") : "Should be palindrome";
        assert !stringUtils.isPalindrome("hello") : "hello should not be palindrome";
        assert !stringUtils.isPalindrome(null) : "null should not be palindrome";
        System.out.println("✓ testIsPalindrome passed");
    }
    
    public void testToUpperCase() {
        assert "HELLO".equals(stringUtils.toUpperCase("hello")) : "toUpperCase failed";
        assert "WORLD".equals(stringUtils.toUpperCase("WORLD")) : "Already uppercase failed";
        assert stringUtils.toUpperCase(null) == null : "Null toUpperCase failed";
        System.out.println("✓ testToUpperCase passed");
    }
    
    public static void main(String[] args) {
        StringUtilsTest test = new StringUtilsTest();
        System.out.println("Running StringUtils tests...\n");
        test.testReverse();
        test.testIsPalindrome();
        test.testToUpperCase();
        System.out.println("\nAll tests completed!");
    }
}