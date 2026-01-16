package Reflections;
import java.lang.reflect.Field;

class Product {
    private String name = "Laptop";
    private double price = 999.99;
    private int quantity = 5;
}

public class ObjectToJSON {
    
    // Convert object to JSON-like string using reflection
    public static String toJSON(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        
        // Get all fields
        Field[] fields = obj.getClass().getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            
            // Get field name and value
            String fieldName = field.getName();
            Object fieldValue = field.get(obj);
            
            // Add to JSON string
            json.append("\"").append(fieldName).append("\":");
            
            // Handle different types
            if (fieldValue instanceof String) {
                json.append("\"").append(fieldValue).append("\"");
            } else {
                json.append(fieldValue);
            }
            
            // Add comma if not last field
            if (i < fields.length - 1) {
                json.append(",");
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) {
        try {
            Product product = new Product();
            String json = toJSON(product);
            System.out.println("JSON representation: " + json);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}