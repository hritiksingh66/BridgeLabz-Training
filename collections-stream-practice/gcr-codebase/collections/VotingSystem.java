import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> votes;
    private LinkedHashMap<String, Integer> voteOrder;
    private TreeMap<String, Integer> sortedResults;
    
    public VotingSystem() {
        votes = new HashMap<>();
        voteOrder = new LinkedHashMap<>();
        sortedResults = new TreeMap<>();
    }
    
    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedResults.put(candidate, sortedResults.getOrDefault(candidate, 0) + 1);
    }
    
    public void displayResults() {
        System.out.println("Vote counts: " + votes);
        System.out.println("Vote order: " + voteOrder);
        System.out.println("Sorted results: " + sortedResults);
    }
    
    public String getWinner() {
        return votes.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No votes");
    }
    
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");
        system.vote("Alice");
        
        system.displayResults();
        System.out.println("Winner: " + system.getWinner());
    }
}