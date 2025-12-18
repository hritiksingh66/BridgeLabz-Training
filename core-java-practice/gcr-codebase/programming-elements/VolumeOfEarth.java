public class VolumeOfEarth {
    public static void main(String[] args) {

        // Radius of Earth in kilometers
        double radius_in_km = 6378;

        // Value of PI
        double pi = Math.PI;

        // Volume of sphere formula: (4/3) * pi * r^3
        double vol_in_km = (4.0 / 3.0) * pi * radius_in_km * radius_in_km * radius_in_km;

        // Convert kilometers to miles (1 km = 0.621371 miles)
        double km_to_miles = 0.621371;

        // Convert volume from km^3 to miles^3
        double vol_in_miles = vol_in_km * km_to_miles * km_to_miles * km_to_miles;

        // Round values to 2 decimal places
        vol_in_km = Math.round(vol_in_km * 100.0) / 100.0;
        vol_in_miles = Math.round(vol_in_miles * 100.0) / 100.0;

        // Print the results
        System.out.println("The volume of earth in cubic kilometers is " + vol_in_km +
                " and cubic miles is " + vol_in_miles);
    }
}

