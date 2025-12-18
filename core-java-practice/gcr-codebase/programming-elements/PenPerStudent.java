public class PenPerStudent {

  public static void main(String[] args) {
    
    // given number of  pens 
    int no_of_pens = 14;

    // given number of students
    int no_of_students = 3;

    // calculating no of pens distributed equally to each student 
    int pen_per_student = no_of_pens / no_of_students;

    // calculating no of pens which remains not distributed among any stundent
    int remaining_pens = no_of_pens % no_of_students ; 

    //  Displaying result 
    System.out.println("The Pen Per Student is "+pen_per_student+" and the remaining pen not distributed is "+remaining_pens);

  }
  
}
