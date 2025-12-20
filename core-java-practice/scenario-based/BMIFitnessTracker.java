import java.util.Scanner;

public class BMIFitnessTracker {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Taking user input
     System.out.print("Enter your height in metre :  ");
     double height = sc.nextDouble(); 

     System.out.print("Enter your weight in Kg :  ");
     double weight = sc.nextDouble(); 

     // Calculating BMI using formulae  BMI = Weight (in Kg) / {Height (in metre) * Height (in metre)}
     if(height <= 0 ){
      System.out.println("Height can't be lesser or equal to zero");
     }else{
       double bmi = weight / (height * height);
       // displaying result
       System.out.printf("Your BMI is %.2f%n", bmi);
     }

    sc.close();
  } 
}
