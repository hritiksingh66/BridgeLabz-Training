import java.util.Map;

public class IPLMatch {
    private int match_id;
    private String team1;
    private String team2;
    private Map<String, Integer> score;
    private String winner;
    private String player_of_match;

    // Constructors
    public IPLMatch() {}

    public IPLMatch(int match_id, String team1, String team2, Map<String, Integer> score, 
                   String winner, String player_of_match) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
        this.winner = winner;
        this.player_of_match = player_of_match;
    }

    // Getters and Setters
    public int getMatch_id() { return match_id; }
    public void setMatch_id(int match_id) { this.match_id = match_id; }

    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }

    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }

    public Map<String, Integer> getScore() { return score; }
    public void setScore(Map<String, Integer> score) { this.score = score; }

    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }

    public String getPlayer_of_match() { return player_of_match; }
    public void setPlayer_of_match(String player_of_match) { this.player_of_match = player_of_match; }

    @Override
    public String toString() {
        return "IPLMatch{" +
                "match_id=" + match_id +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", score=" + score +
                ", winner='" + winner + '\'' +
                ", player_of_match='" + player_of_match + '\'' +
                '}';
    }
}