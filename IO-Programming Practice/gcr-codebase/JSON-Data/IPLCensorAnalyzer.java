import java.io.*;
import java.util.*;

public class IPLCensorAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== IPL Censor Analyzer ===");
        System.out.println("1. Process JSON file");
        System.out.println("2. Process CSV file");
        System.out.println("3. Process both formats");
        System.out.print("Choose option: ");
        
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                processJSON();
                break;
            case 2:
                processCSV();
                break;
            case 3:
                processJSON();
                processCSV();
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }

    public static void processJSON() {
        try {
            List<IPLMatch> matches = readJSON("data/ipl_matches.json");
            
            System.out.println("Original JSON data:");
            matches.forEach(System.out::println);
            
            List<IPLMatch> censoredMatches = applyCensorship(matches);
            
            writeJSON("data/ipl_matches_censored.json", censoredMatches);
            
            System.out.println("\nCensored JSON data:");
            censoredMatches.forEach(System.out::println);
            System.out.println("Censored JSON saved to: data/ipl_matches_censored.json");
            
        } catch (Exception e) {
            System.out.println("Error processing JSON: " + e.getMessage());
        }
    }

    public static void processCSV() {
        try {
            List<IPLMatch> matches = readCSV("data/ipl_matches.csv");
            
            System.out.println("\nOriginal CSV data:");
            matches.forEach(System.out::println);
            
            List<IPLMatch> censoredMatches = applyCensorship(matches);
            
            writeCSV("data/ipl_matches_censored.csv", censoredMatches);
            
            System.out.println("\nCensored CSV data:");
            censoredMatches.forEach(System.out::println);
            System.out.println("Censored CSV saved to: data/ipl_matches_censored.csv");
            
        } catch (Exception e) {
            System.out.println("Error processing CSV: " + e.getMessage());
        }
    }

    private static List<IPLMatch> readJSON(String filePath) throws IOException {
        List<IPLMatch> matches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
            System.out.println("JSON file read successfully");
        }
        return matches;
    }

    private static void writeJSON(String filePath, List<IPLMatch> matches) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println("[");
            for (int i = 0; i < matches.size(); i++) {
                IPLMatch match = matches.get(i);
                pw.println("  {");
                pw.println("    \"match_id\": " + match.getMatch_id() + ",");
                pw.println("    \"team1\": \"" + match.getTeam1() + "\",");
                pw.println("    \"team2\": \"" + match.getTeam2() + "\",");
                pw.println("    \"winner\": \"" + match.getWinner() + "\",");
                pw.println("    \"player_of_match\": \"" + match.getPlayer_of_match() + "\"");
                pw.println(i < matches.size() - 1 ? "  }," : "  }");
            }
            pw.println("]");
        }
    }

    private static List<IPLMatch> applyCensorship(List<IPLMatch> matches) {
        List<IPLMatch> censoredMatches = new ArrayList<>();
        
        for (IPLMatch match : matches) {
            IPLMatch censored = new IPLMatch();
            censored.setMatch_id(match.getMatch_id());
            
            censored.setTeam1(maskTeamName(match.getTeam1()));
            censored.setTeam2(maskTeamName(match.getTeam2()));
            censored.setWinner(maskTeamName(match.getWinner()));
            
            Map<String, Integer> censoredScore = new HashMap<>();
            for (Map.Entry<String, Integer> entry : match.getScore().entrySet()) {
                censoredScore.put(maskTeamName(entry.getKey()), entry.getValue());
            }
            censored.setScore(censoredScore);
            
            censored.setPlayer_of_match("REDACTED");
            
            censoredMatches.add(censored);
        }
        
        return censoredMatches;
    }

    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return teamName;
    }

    private static List<IPLMatch> readCSV(String filePath) throws IOException {
        List<IPLMatch> matches = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                IPLMatch match = new IPLMatch();
                match.setMatch_id(Integer.parseInt(data[0]));
                match.setTeam1(data[1]);
                match.setTeam2(data[2]);
                
                Map<String, Integer> score = new HashMap<>();
                score.put(data[1], Integer.parseInt(data[3]));
                score.put(data[2], Integer.parseInt(data[4]));
                match.setScore(score);
                
                match.setWinner(data[5]);
                match.setPlayer_of_match(data[6]);
                
                matches.add(match);
            }
        }
        
        return matches;
    }

    private static void writeCSV(String filePath, List<IPLMatch> matches) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println("match_id,team1,team2,score_team1,score_team2,winner,player_of_match");
            
            for (IPLMatch match : matches) {
                pw.printf("%d,%s,%s,%d,%d,%s,%s%n",
                    match.getMatch_id(),
                    match.getTeam1(),
                    match.getTeam2(),
                    match.getScore().get(match.getTeam1()),
                    match.getScore().get(match.getTeam2()),
                    match.getWinner(),
                    match.getPlayer_of_match()
                );
            }
        }
    }
}