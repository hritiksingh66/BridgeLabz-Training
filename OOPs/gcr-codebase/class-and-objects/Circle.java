// Circle geometry calculations - area and circumference
public class Circle {
	// Circle radius
	double radius;
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	// Calculate and display circle area
	public void areaCircle() {
		System.out.printf("Area of circle: %.4f", (Math.PI * radius * radius));
	}
	
	// Calculate and display circle circumference
	public void circumferenceCircle() {
		System.out.printf("\nCircumference of circle: %.4f ", (2 * Math.PI * radius));
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle(2.5);
		circle.areaCircle();
		circle.circumferenceCircle();
	}
}