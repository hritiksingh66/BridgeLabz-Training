import java.util.Scanner;

class Student {
  int rollno;
  String name;
  int age;
  double grade;
  Student next;

  Student(int rollno, String name, int age, double grade) {
    this.rollno = rollno;
    this.name = name;
    this.age = age;
    this.grade = grade;
    this.next = null;
  }
}
public class StudentRecordManagement {
  private Student head;

  public void addAtBeginning(int rollno, String name, int age, double grade) {
    Student newStudent = new Student(rollno, name, age, grade);
    newStudent.next = head;
    head = newStudent;
  }

  public void addAtEnd(int rollno, String name, int age, double grade) {
    Student newStudent = new Student(rollno, name, age, grade);
    if (head == null) {
      head = newStudent;
      return;
    }
    Student current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newStudent;
  }

  public void addAtPosition(int position, int rollno, String name, int age, double grade) {
    if (position == 0) {
      addAtBeginning(rollno, name, age, grade);
      return;
    }
    Student newStudent = new Student(rollno, name, age, grade);
    Student current = head;
    for (int i = 0; i < position - 1 && current != null; i++) {
      current = current.next;
    }
    if (current != null) {
      newStudent.next = current.next;
      current.next = newStudent;
    }
  }

  public void deleteByRollNumber(int rollno) {
    if (head == null) return;
    if (head.rollno == rollno) {
      head = head.next;
      return;
    }
    Student current = head;
    while (current.next != null && current.next.rollno != rollno) {
      current = current.next;
    }
    if (current.next != null) {
      current.next = current.next.next;
    }
  }

  public Student searchByRollNumber(int rollno) {
    Student current = head;
    while (current != null) {
      if (current.rollno == rollno) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  public void displayAll() {
    Student current = head;
    while (current != null) {
      System.out.println("Roll: " + current.rollno + ", Name: " + current.name + 
                        ", Age: " + current.age + ", Grade: " + current.grade);
      current = current.next;
    }
  }

  public void updateGrade(int rollno, double newGrade) {
    Student student = searchByRollNumber(rollno);
    if (student != null) {
      student.grade = newGrade;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentRecordManagement srm = new StudentRecordManagement();
    
    while (true) {
      System.out.println("\n1. Add at beginning\n2. Add at end\n3. Add at position\n4. Delete by roll\n5. Search by roll\n6. Display all\n7. Update grade\n8. Exit");
      System.out.print("Choice: ");
      int choice = sc.nextInt();
      
      switch (choice) {
        case 1:
          System.out.print("Roll, Name, Age, Grade: ");
          srm.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
          break;
        case 2:
          System.out.print("Roll, Name, Age, Grade: ");
          srm.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
          break;
        case 3:
          System.out.print("Position, Roll, Name, Age, Grade: ");
          srm.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
          break;
        case 4:
          System.out.print("Roll to delete: ");
          srm.deleteByRollNumber(sc.nextInt());
          break;
        case 5:
          System.out.print("Roll to search: ");
          Student s = srm.searchByRollNumber(sc.nextInt());
          if (s != null) System.out.println("Found: " + s.name + ", Grade: " + s.grade);
          else System.out.println("Not found");
          break;
        case 6:
          srm.displayAll();
          break;
        case 7:
          System.out.print("Roll, New Grade: ");
          srm.updateGrade(sc.nextInt(), sc.nextDouble());
          break;
        case 8:
          sc.close();
          return;
      }
    }
  }
}
