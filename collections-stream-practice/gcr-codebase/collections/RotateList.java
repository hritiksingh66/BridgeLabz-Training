import java.util.*;

public class RotateList {
    
    // Rotate list left by specified positions using Collections.rotate
    public static void rotateLeft(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size;
        Collections.rotate(list, -positions);
    }
    
    // Manual rotation by creating sublist and rearranging
    public static void rotateLeftManual(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size;
        List<Integer> temp = new ArrayList<>(list.subList(positions, size));
        temp.addAll(list.subList(0, positions));
        list.clear();
        list.addAll(temp);
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original: " + numbers);
        
        rotateLeftManual(numbers, 2);
        System.out.println("Rotated by 2: " + numbers);
    }
}