import java.util.*;

// Abstract base class for different job roles
abstract class JobRole {
    protected String roleName;
    protected List<String> requiredSkills;
    protected int minExperience;
    protected String department;
    
    public JobRole(String roleName, List<String> requiredSkills, int minExperience, String department) {
        this.roleName = roleName;
        this.requiredSkills = new ArrayList<>(requiredSkills);
        this.minExperience = minExperience;
        this.department = department;
    }
    
    // Abstract method for role-specific evaluation criteria
    public abstract double calculateRoleSpecificScore(Map<String, Object> candidateData);
    
    // Getters
    public String getRoleName() { return roleName; }
    public List<String> getRequiredSkills() { return new ArrayList<>(requiredSkills); }
    public int getMinExperience() { return minExperience; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return roleName + " (" + department + ") - Min Experience: " + minExperience + " years";
    }
}

// Software Engineer job role
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", 
              Arrays.asList("Java", "Python", "SQL", "Git", "Problem Solving"),
              2, "Engineering");
    }
    
    @Override
    public double calculateRoleSpecificScore(Map<String, Object> candidateData) {
        double score = 0.0;
        
        // Check programming languages (40% weight)
        List<String> programmingLanguages = (List<String>) candidateData.get("programmingLanguages");
        if (programmingLanguages != null) {
            int matchedLanguages = 0;
            for (String lang : Arrays.asList("Java", "Python", "JavaScript", "C++")) {
                if (programmingLanguages.contains(lang)) {
                    matchedLanguages++;
                }
            }
            score += (matchedLanguages / 4.0) * 40;
        }
        
        // Check projects (30% weight)
        Integer projects = (Integer) candidateData.get("projects");
        if (projects != null) {
            score += Math.min(projects / 5.0, 1.0) * 30;
        }
        
        // Check certifications (30% weight)
        List<String> certifications = (List<String>) candidateData.get("certifications");
        if (certifications != null && !certifications.isEmpty()) {
            score += 30;
        }
        
        return score;
    }
}

// Data Scientist job role
class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", 
              Arrays.asList("Python", "R", "Machine Learning", "Statistics", "SQL"),
              3, "Data Science");
    }
    
    @Override
    public double calculateRoleSpecificScore(Map<String, Object> candidateData) {
        double score = 0.0;
        
        // Check data science skills (50% weight)
        List<String> skills = (List<String>) candidateData.get("skills");
        if (skills != null) {
            int matchedSkills = 0;
            for (String skill : Arrays.asList("Machine Learning", "Statistics", "Data Analysis", "Python", "R")) {
                if (skills.contains(skill)) {
                    matchedSkills++;
                }
            }
            score += (matchedSkills / 5.0) * 50;
        }
        
        // Check education (25% weight)
        String education = (String) candidateData.get("education");
        if (education != null && (education.contains("Masters") || education.contains("PhD"))) {
            score += 25;
        }
        
        // Check publications (25% weight)
        Integer publications = (Integer) candidateData.get("publications");
        if (publications != null && publications > 0) {
            score += Math.min(publications / 3.0, 1.0) * 25;
        }
        
        return score;
    }
}

// Product Manager job role
class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", 
              Arrays.asList("Product Strategy", "Market Analysis", "Leadership", "Communication"),
              4, "Product");
    }
    
    @Override
    public double calculateRoleSpecificScore(Map<String, Object> candidateData) {
        double score = 0.0;
        
        // Check leadership experience (40% weight)
        Integer teamSize = (Integer) candidateData.get("teamSize");
        if (teamSize != null) {
            score += Math.min(teamSize / 10.0, 1.0) * 40;
        }
        
        // Check product management skills (35% weight)
        List<String> skills = (List<String>) candidateData.get("skills");
        if (skills != null) {
            int matchedSkills = 0;
            for (String skill : Arrays.asList("Product Strategy", "Market Analysis", "Agile", "Scrum")) {
                if (skills.contains(skill)) {
                    matchedSkills++;
                }
            }
            score += (matchedSkills / 4.0) * 35;
        }
        
        // Check MBA or relevant education (25% weight)
        String education = (String) candidateData.get("education");
        if (education != null && education.contains("MBA")) {
            score += 25;
        }
        
        return score;
    }
}

// Generic resume class with bounded type parameter
class Resume<T extends JobRole> {
    private String candidateName;
    private String email;
    private T targetRole;
    private Map<String, Object> candidateData;
    private double overallScore;
    private boolean isQualified;
    private String screeningResult;
    
    public Resume(String candidateName, String email, T targetRole, Map<String, Object> candidateData) {
        this.candidateName = candidateName;
        this.email = email;
        this.targetRole = targetRole;
        this.candidateData = new HashMap<>(candidateData);
        this.overallScore = calculateOverallScore();
        this.isQualified = overallScore >= 60.0; // 60% threshold
        this.screeningResult = generateScreeningResult();
    }
    
    // Calculate overall score combining basic and role-specific criteria
    private double calculateOverallScore() {
        double basicScore = calculateBasicScore();
        double roleSpecificScore = targetRole.calculateRoleSpecificScore(candidateData);
        
        // 40% basic criteria, 60% role-specific criteria
        return (basicScore * 0.4) + (roleSpecificScore * 0.6);
    }
    
    // Calculate basic score (experience, education, skills match)
    private double calculateBasicScore() {
        double score = 0.0;
        
        // Experience check (40% of basic score)
        Integer experience = (Integer) candidateData.get("experience");
        if (experience != null) {
            if (experience >= targetRole.getMinExperience()) {
                score += 40;
            } else {
                score += (experience / (double) targetRole.getMinExperience()) * 40;
            }
        }
        
        // Skills match (40% of basic score)
        List<String> candidateSkills = (List<String>) candidateData.get("skills");
        if (candidateSkills != null) {
            int matchedSkills = 0;
            for (String requiredSkill : targetRole.getRequiredSkills()) {
                if (candidateSkills.contains(requiredSkill)) {
                    matchedSkills++;
                }
            }
            score += (matchedSkills / (double) targetRole.getRequiredSkills().size()) * 40;
        }
        
        // Education (20% of basic score)
        String education = (String) candidateData.get("education");
        if (education != null && !education.isEmpty()) {
            score += 20;
        }
        
        return score;
    }
    
    // Generate screening result
    private String generateScreeningResult() {
        if (overallScore >= 80) {
            return "HIGHLY RECOMMENDED";
        } else if (overallScore >= 60) {
            return "RECOMMENDED";
        } else if (overallScore >= 40) {
            return "MAYBE";
        } else {
            return "NOT RECOMMENDED";
        }
    }
    
    // Getters
    public String getCandidateName() { return candidateName; }
    public String getEmail() { return email; }
    public T getTargetRole() { return targetRole; }
    public double getOverallScore() { return overallScore; }
    public boolean isQualified() { return isQualified; }
    public String getScreeningResult() { return screeningResult; }
    public Map<String, Object> getCandidateData() { return new HashMap<>(candidateData); }
    
    @Override
    public String toString() {
        return "Resume: " + candidateName + " (" + email + ")\n" +
               "  Target Role: " + targetRole.getRoleName() + "\n" +
               "  Overall Score: " + String.format("%.1f", overallScore) + "%\n" +
               "  Result: " + screeningResult + "\n" +
               "  Qualified: " + (isQualified ? "✓" : "✗");
    }
}

// AI-Driven Resume Screening System
public class AIResumeScreeningSystem {
    
    // Generic method to screen resumes with bounded type parameter
    public static <T extends JobRole> List<Resume<T>> screenResumes(
            List<Resume<T>> resumes, double minScore) {
        
        List<Resume<T>> qualifiedResumes = new ArrayList<>();
        
        System.out.println("Screening " + resumes.size() + " resumes for " + 
                         (resumes.isEmpty() ? "unknown role" : resumes.get(0).getTargetRole().getRoleName()));
        
        for (Resume<T> resume : resumes) {
            if (resume.getOverallScore() >= minScore) {
                qualifiedResumes.add(resume);
                System.out.println("✓ " + resume.getCandidateName() + " - Score: " + 
                                 String.format("%.1f", resume.getOverallScore()) + "%");
            } else {
                System.out.println("✗ " + resume.getCandidateName() + " - Score: " + 
                                 String.format("%.1f", resume.getOverallScore()) + "%");
            }
        }
        
        System.out.println("Qualified: " + qualifiedResumes.size() + "/" + resumes.size());
        System.out.println();
        
        return qualifiedResumes;
    }
    
    // Wildcard method to handle multiple job roles in screening pipeline
    public static void processScreeningPipeline(List<? extends Resume<? extends JobRole>> allResumes) {
        System.out.println("=== AI-Driven Resume Screening Pipeline ===");
        
        // Group resumes by job role
        Map<String, List<Resume<? extends JobRole>>> resumesByRole = new HashMap<>();
        
        for (Resume<? extends JobRole> resume : allResumes) {
            String roleName = resume.getTargetRole().getRoleName();
            resumesByRole.computeIfAbsent(roleName, k -> new ArrayList<>()).add(resume);
        }
        
        // Process each role group
        for (Map.Entry<String, List<Resume<? extends JobRole>>> entry : resumesByRole.entrySet()) {
            System.out.println("\n--- Processing " + entry.getKey() + " Applications ---");
            
            List<Resume<? extends JobRole>> roleResumes = entry.getValue();
            int qualified = 0;
            double totalScore = 0;
            
            for (Resume<? extends JobRole> resume : roleResumes) {
                if (resume.isQualified()) {
                    qualified++;
                }
                totalScore += resume.getOverallScore();
            }
            
            double averageScore = roleResumes.isEmpty() ? 0 : totalScore / roleResumes.size();
            
            System.out.println("Total Applications: " + roleResumes.size());
            System.out.println("Qualified Candidates: " + qualified);
            System.out.println("Average Score: " + String.format("%.1f", averageScore) + "%");
        }
    }
    
    // Method to display top candidates using wildcards
    public static void displayTopCandidates(List<? extends Resume<? extends JobRole>> resumes, int topN) {
        System.out.println("\n=== Top " + topN + " Candidates ===");
        
        // Sort by score in descending order
        List<Resume<? extends JobRole>> sortedResumes = new ArrayList<>(resumes);
        sortedResumes.sort((r1, r2) -> Double.compare(r2.getOverallScore(), r1.getOverallScore()));
        
        int count = Math.min(topN, sortedResumes.size());
        for (int i = 0; i < count; i++) {
            Resume<? extends JobRole> resume = sortedResumes.get(i);
            System.out.println((i + 1) + ". " + resume);
            System.out.println();
        }
    }
    
    // Main method to demonstrate the system
    public static void main(String[] args) {
        System.out.println("=== AI-Driven Resume Screening System ===\n");
        
        // Create sample resumes for Software Engineer
        List<Resume<SoftwareEngineer>> seResumes = new ArrayList<>();
        
        Map<String, Object> candidate1Data = new HashMap<>();
        candidate1Data.put("experience", 3);
        candidate1Data.put("skills", Arrays.asList("Java", "Python", "SQL", "Git"));
        candidate1Data.put("education", "Bachelor's in Computer Science");
        candidate1Data.put("programmingLanguages", Arrays.asList("Java", "Python", "JavaScript"));
        candidate1Data.put("projects", 8);
        candidate1Data.put("certifications", Arrays.asList("AWS Certified"));
        
        seResumes.add(new Resume<>("Alice Johnson", "alice@email.com", new SoftwareEngineer(), candidate1Data));
        
        Map<String, Object> candidate2Data = new HashMap<>();
        candidate2Data.put("experience", 1);
        candidate2Data.put("skills", Arrays.asList("Java", "HTML", "CSS"));
        candidate2Data.put("education", "Bachelor's in IT");
        candidate2Data.put("programmingLanguages", Arrays.asList("Java"));
        candidate2Data.put("projects", 3);
        
        seResumes.add(new Resume<>("Bob Smith", "bob@email.com", new SoftwareEngineer(), candidate2Data));
        
        // Create sample resumes for Data Scientist
        List<Resume<DataScientist>> dsResumes = new ArrayList<>();
        
        Map<String, Object> candidate3Data = new HashMap<>();
        candidate3Data.put("experience", 4);
        candidate3Data.put("skills", Arrays.asList("Python", "Machine Learning", "Statistics", "SQL"));
        candidate3Data.put("education", "Masters in Data Science");
        candidate3Data.put("publications", 5);
        
        dsResumes.add(new Resume<>("Carol Davis", "carol@email.com", new DataScientist(), candidate3Data));
        
        // Create sample resumes for Product Manager
        List<Resume<ProductManager>> pmResumes = new ArrayList<>();
        
        Map<String, Object> candidate4Data = new HashMap<>();
        candidate4Data.put("experience", 5);
        candidate4Data.put("skills", Arrays.asList("Product Strategy", "Market Analysis", "Agile"));
        candidate4Data.put("education", "MBA");
        candidate4Data.put("teamSize", 12);
        
        pmResumes.add(new Resume<>("David Wilson", "david@email.com", new ProductManager(), candidate4Data));
        
        // Screen resumes for each role
        System.out.println("=== Individual Role Screening ===");
        List<Resume<SoftwareEngineer>> qualifiedSE = screenResumes(seResumes, 60.0);
        List<Resume<DataScientist>> qualifiedDS = screenResumes(dsResumes, 60.0);
        List<Resume<ProductManager>> qualifiedPM = screenResumes(pmResumes, 60.0);
        
        // Combine all resumes for pipeline processing
        List<Resume<? extends JobRole>> allResumes = new ArrayList<>();
        allResumes.addAll(seResumes);
        allResumes.addAll(dsResumes);
        allResumes.addAll(pmResumes);
        
        // Process screening pipeline
        processScreeningPipeline(allResumes);
        
        // Display top candidates
        displayTopCandidates(allResumes, 3);
        
        // Display detailed results
        System.out.println("=== Detailed Screening Results ===");
        for (Resume<? extends JobRole> resume : allResumes) {
            System.out.println(resume);
            System.out.println();
        }
    }
}