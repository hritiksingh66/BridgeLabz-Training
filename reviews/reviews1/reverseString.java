package reviews.reviews1;

public class reverseString {
    public static void main(String[] args) {
        String str = "learnJava";
        String reverse = "";

        for (int i = str.length()-1; i >=0 ; i--) {
            reverse += str.charAt(i);
        }
        System.out.println(reverse);
    }
  
}
