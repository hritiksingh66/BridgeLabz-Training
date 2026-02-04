import java.util.*;
import java.util.stream.Collectors;

class Doctor {
    private String name;
    private String specialty;
    private boolean availableWeekends;
    
    public Doctor(String name, String specialty, boolean availableWeekends) {
        this.name = name;
        this.specialty = specialty;
        this.availableWeekends = availableWeekends;
    }
    
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public boolean isAvailableWeekends() { return availableWeekends; }
    
    @Override
    public String toString() {
        return String.format("Dr. %s - %s", name, specialty);
    }
}

public class HospitalDoctorAvailability {
    
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Smith", "Cardiology", true),
            new Doctor("Johnson", "Emergency", true),
            new Doctor("Williams", "Neurology", false),
            new Doctor("Brown", "Emergency", true),
            new Doctor("Davis", "Orthopedics", true),
            new Doctor("Miller", "Cardiology", false),
            new Doctor("Wilson", "Pediatrics", true),
            new Doctor("Moore", "Dermatology", false),
            new Doctor("Taylor", "Orthopedics", true),
            new Doctor("Anderson", "Neurology", true)
        );
        
        System.out.println("=== Weekend Available Doctors (Sorted by Specialty) ===");
        
        // Filter weekend available doctors and sort by specialty
        List<Doctor> weekendDoctors = doctors.stream()
            .filter(Doctor::isAvailableWeekends)
            .sorted(Comparator.comparing(Doctor::getSpecialty)
                   .thenComparing(Doctor::getName))
            .collect(Collectors.toList());
        
        weekendDoctors.forEach(System.out::println);
        
        System.out.println("\n=== Grouped by Specialty ===");
        
        // Group weekend available doctors by specialty
        Map<String, List<Doctor>> doctorsBySpecialty = doctors.stream()
            .filter(Doctor::isAvailableWeekends)
            .collect(Collectors.groupingBy(Doctor::getSpecialty));
        
        doctorsBySpecialty.forEach((specialty, doctorList) -> {
            System.out.println(specialty + ":");
            doctorList.forEach(doctor -> System.out.println("  " + doctor));
        });
    }
}