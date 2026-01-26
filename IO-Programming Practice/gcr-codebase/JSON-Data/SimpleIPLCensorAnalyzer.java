import java.io.*;
import java.util.*;

public class SimpleIPLCensorAnalyzer {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Simple IPL Censor Analyzer ===");
        System.out.println("1. Process CSV file");
        System.out.println("2. Generate sample files");
        System.out.print("Choose option: ");
        
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                processCSV();
                break;
            case 2:
                generateSampleFiles();
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }

    public static void processCSV() {
        try {
            System.out.println("\n=== Processing CSV File ===");
            
            // Read original CSV
            List<String[]> originalData = readCSV("data/ipl_matches.csv");
            System.out.println("Original CSV Data:");
            printCSVData(originalData);
            
            // Apply censorship
            List<String[]> censoredData = applyCensorshipToCSV(originalData);
            
            // Write censored CSV
            writeCSV("data/ipl_matches_censored.csv", censoredData);
            
            System.out.println("\nCensored CSV Data:");
            printCSVData(censoredData);
            System.out.println("Censored CSV saved to: data/ipl_matches_censored.csv");
            
        } catch (Exception e) {
            System.out.println("Error processing CSV: " + e.getMessage());
        }
    }

    private static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        }
        
        return data;
    }

    private static void writeCSV(String filePath, List<String[]> data) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                pw.println(String.join(",", row));
            }
        }
    }

    private static List<String[]> applyCensorshipToCSV(List<String[]> data) {
        List<String[]> censoredData = new ArrayList<>();
        
        // Add header
        censoredData.add(data.get(0));
        
        // Process data rows
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            String[] censoredRow = new String[row.length];
            
            censoredRow[0] = row[0]; // match_id
            censoredRow[1] = maskTeamName(row[1]); // team1
            censoredRow[2] = maskTeamName(row[2]); // team2
            censoredRow[3] = row[3]; // score_team1
            censoredRow[4] = row[4]; // score_team2
            censoredRow[5] = maskTeamName(row[5]); // winner
            censoredRow[6] = "REDACTED"; // player_of_match
            
            censoredData.add(censoredRow);
        }
        
        return censoredData;
    }

    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return teamName;
    }

    private static void printCSVData(List<String[]> data) {
        for (String[] row : data) {
            System.out.println(String.join(" | ", row));
        }
    }

    public static void generateSampleFiles() {
        try {
            // Generate sample JSON
            String jsonContent = "[\n" +
                "  {\n" +
                "    \"match_id\": 101,\n" +
                "    \"team1\": \"Mumbai Indians\",\n" +
                "    \"team2\": \"Chennai Super Kings\",\n" +
                "    \"score\": {\n" +
                "      \"Mumbai Indians\": 178,\n" +
                "      \"Chennai Super Kings\": 182\n" +
                "    },\n" +
                "    \"winner\": \"Chennai Super Kings\",\n" +
                "    \"player_of_match\": \"MS Dhoni\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"match_id\": 102,\n" +
                "    \"team1\": \"Royal Challengers Bangalore\",\n" +
                "    \"team2\": \"Delhi Capitals\",\n" +
                "    \"score\": {\n" +
                "      \"Royal Challengers Bangalore\": 200,\n" +
                "      \"Delhi Capitals\": 190\n" +
                "    },\n" +
                "    \"winner\": \"Royal Challengers Bangalore\",\n" +
                "    \"player_of_match\": \"Virat Kohli\"\n" +
                "  }\n" +
                "]";
            
            try (PrintWriter pw = new PrintWriter(new FileWriter("data/sample_ipl.json"))) {
                pw.print(jsonContent);
            }
            
            System.out.println("Sample files generated successfully!");
            System.out.println("- data/sample_ipl.json");
            
        } catch (IOException e) {
            System.out.println("Error generating sample files: " + e.getMessage());
        }
    }
}