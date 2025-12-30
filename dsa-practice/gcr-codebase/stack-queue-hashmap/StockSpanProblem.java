import java.util.Stack;

// Calculate stock span for each day (number of consecutive days with price <= current day)
public class StockSpanProblem {
    
    // Calculate span for each day using stack
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();  // Store indices of prices
        
        for (int i = 0; i < n; i++) {
            // Pop elements while current price is greater
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            
            // Calculate span: if stack empty, span is i+1, else i - previous greater element index
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);  // Push current index
        }
        
        return span;
    }
    
    // Test the stock span algorithm
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);
        
        System.out.println("Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        
        System.out.println("\nSpan: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}