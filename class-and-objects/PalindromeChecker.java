// Palindrome text checker utility
public class PalindromeChecker {
	// Text to check
	String text;
	
	PalindromeChecker(String text) {
		this.text = text;
	}
	
	// Check if text is palindrome (ignores spaces and case)
	public boolean isPalindrome() {
		String cleantext = text.replaceAll("\\s", "").toLowerCase();
		String reverseText = new StringBuilder(cleantext).reverse().toString();
		return cleantext.equals(reverseText);
	}
	
	// Display palindrome check result
	public void diplayResult() {
		if (isPalindrome()) {
			System.out.println(text + " is palindrome");
		} else {
			System.out.println(text + " is not Palindrome");
		}
	}
	
	public static void main(String[] args) {
		PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");
		checker1.diplayResult();
		
		PalindromeChecker checker2 = new PalindromeChecker("Hello");
		checker2.diplayResult();
	}
}