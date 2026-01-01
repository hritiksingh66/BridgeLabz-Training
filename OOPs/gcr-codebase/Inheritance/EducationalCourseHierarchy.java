import java.util.*;

// Base class for all courses
class Course{
	String courseName;
	int duration;
	
	// Constructor to initialize course properties
	Course(String courseName, int duration){
		this.courseName = courseName;
		this.duration = duration;
	}
	
	// Method to display basic course information
	void Display() {
		System.out.print("Course Name: " + courseName + " | Duration (in hours): " + duration);
	}
}

// Online course inherits from Course
class OnlineCourse extends Course{
	String platform;
	boolean isRecorded;
	
	// Constructor calls parent constructor and adds online-specific properties
	OnlineCourse(String courseName, int duration, String platform, boolean isRecorded){
		super(courseName, duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}
	
	// Override Display to add platform and recording info
	void Display() {
		super.Display(); // Call parent method
		System.out.print(" | Platform: " + platform + " | Recorded: " + isRecorded);
	}
}

// Paid online course inherits from OnlineCourse (multi-level inheritance)
class PaidOnlineCourse extends OnlineCourse{
	int fee;
	int discount;
	
	// Constructor calls parent constructor and adds payment properties
	PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, int fee, int discount){
		super(courseName, duration, platform, isRecorded);
		this.fee = fee;
		this.discount = discount;
	}
	
	// Override Display to add fee and discount info
	void Display() {
		super.Display(); // Call parent method
		System.out.print(" | Fees: " + fee + " | Discount(%): " + discount);
	}
}

// Main class to demonstrate course hierarchy
public class EducationalCourseHierarchy {
	public static void main(String[] args) {
		// Create different types of courses
		OnlineCourse oc1 = new OnlineCourse("Java Programming Masterclass", 40, "Udemy", true);
		PaidOnlineCourse poc2 = new PaidOnlineCourse("Full Stack Web Development", 60, "Coursera", false, 300, 75);
		
		// Display course information
		System.out.println("Online Course");
		oc1.Display();
		System.out.println();
		
		System.out.println("Paid Online Course");
		poc2.Display();
	}
}
