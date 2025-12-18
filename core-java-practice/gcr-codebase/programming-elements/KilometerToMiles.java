public class KilometerToMiles {

  public static void main(String[] args) {

    // given distance in kilometers
    double dist_in_km = 10.8;

    // Converting km into miles using 1km = 1.6 miles
    double dist_in_miles  = dist_in_km * 1.6 ;


    // Print result as distance in miles

    System.out.println("The distance" + dist_in_km + " km in miles is " + dist_in_miles +" miles");
  }
}
