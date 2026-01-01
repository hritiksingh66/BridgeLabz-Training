// Performance comparison between String, StringBuilder, and StringBuffer
public class StringConcatenationPerformance {
    
    // Main method to compare string concatenation performance
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        String text = "hello";
        
        for (int size : sizes) {
            // String concatenation
            long startTime = System.nanoTime();
            String result = "";
            for (int i = 0; i < size; i++) {
                result += text;
            }
            long stringTime = System.nanoTime() - startTime;
            
            // StringBuilder
            startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(text);
            }
            long sbTime = System.nanoTime() - startTime;
            
            // StringBuffer
            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sbf.append(text);
            }
            long sbfTime = System.nanoTime() - startTime;
            
            System.out.println("Operations Count: " + size);
            System.out.println("String: " + (stringTime / 1_000_000.0) + " ms");
            System.out.println("StringBuilder: " + (sbTime / 1_000_000.0) + " ms");
            System.out.println("StringBuffer: " + (sbfTime / 1_000_000.0) + " ms");
            System.out.println();
        }
    }
}