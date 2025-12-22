import java.util.Random;

// Program to generate student score card with random scores
public class StudentScoreCard {

    // Generate random scores for students in 3 subjects
    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        
        // Generate scores between 60-100 for each subject
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(41) + 60; // 60 to 100
            }
        }
        return scores;
    }

    // Calculate total, average and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        int students = scores.length;
        double[][] results = new double[students][3];
        
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Calculate grades based on percentage
    public static String[] calculateGrades(double[][] results) {
        String[] grades = new String[results.length];
        
        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            
            // Assign grades based on percentage
            if (percentage >= 90) {
                grades[i] = "A+";
            } else if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }
        return grades;
    }

    // Display complete score card in table format
    public static void displayScoreCard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t\t");
            System.out.print(scores[i][0] + "\t\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t");
            System.out.print((int)results[i][0] + "\t");
            System.out.print(results[i][1] + "\t\t" + results[i][2] + "%\t\t");
            System.out.println(grades[i]);
        }
    }

    public static void main(String[] args) {
        // Generate score card for 10 students
        int students = 10;
        
        // Generate scores, calculate results and grades
        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrades(results);
        
        // Display complete score card
        displayScoreCard(scores, results, grades);
    }
}
