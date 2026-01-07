import java.util.*;

// Patient class with severity-based priority
class Patient implements Comparable<Patient> {
    private String name;
    private int severity;
    
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    public String getName() { return name; }
    public int getSeverity() { return severity; }
    
    // Higher severity gets higher priority
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }
    
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    private PriorityQueue<Patient> triageQueue;
    
    public HospitalTriageSystem() {
        triageQueue = new PriorityQueue<>();
    }
    
    // Add patient to triage queue
    public void addPatient(String name, int severity) {
        triageQueue.offer(new Patient(name, severity));
    }
    
    // Treat next patient (highest severity first)
    public Patient treatNextPatient() {
        return triageQueue.poll();
    }
    
    public static void main(String[] args) {
        HospitalTriageSystem triage = new HospitalTriageSystem();
        
        triage.addPatient("John", 3);
        triage.addPatient("Alice", 5);
        triage.addPatient("Bob", 2);
        
        System.out.println("Treatment order:");
        while (!triage.triageQueue.isEmpty()) {
            System.out.println(triage.treatNextPatient());
        }
    }
}