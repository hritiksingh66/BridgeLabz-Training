import java.util.*;

public class MaxValueKey {
    
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map.isEmpty()) return null;
        
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    public static String findKeyWithMaxValueManual(Map<String, Integer> map) {
        if (map.isEmpty()) return null;
        
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("A", 10);
        scores.put("B", 20);
        scores.put("C", 15);
        
        System.out.println("Map: " + scores);
        System.out.println("Key with max value: " + findKeyWithMaxValueManual(scores));
    }
}