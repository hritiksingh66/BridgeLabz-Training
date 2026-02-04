import java.util.*;
import java.util.stream.Collectors;

class Movie {
    private String title;
    private double rating;
    private int releaseYear;
    
    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    
    public String getTitle() { return title; }
    public double getRating() { return rating; }
    public int getReleaseYear() { return releaseYear; }
    
    @Override
    public String toString() {
        return String.format("%s (%.1f) - %d", title, rating, releaseYear);
    }
}

public class Top5TrendingMovies {
    
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Avengers: Endgame", 8.4, 2019),
            new Movie("The Dark Knight", 9.0, 2008),
            new Movie("Inception", 8.8, 2010),
            new Movie("Parasite", 8.6, 2019),
            new Movie("Joker", 8.4, 2019),
            new Movie("Spider-Man: No Way Home", 8.2, 2021),
            new Movie("Dune", 8.0, 2021),
            new Movie("Top Gun: Maverick", 8.3, 2022),
            new Movie("Everything Everywhere All at Once", 7.8, 2022),
            new Movie("The Batman", 7.8, 2022)
        );
        
        System.out.println("=== Top 5 Trending Movies ===");
        
        // Filter recent movies (2019+), sort by rating desc, then by year desc, limit to 5
        List<Movie> top5 = movies.stream()
            .filter(movie -> movie.getReleaseYear() >= 2019)
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                   .thenComparing(Comparator.comparingInt(Movie::getReleaseYear).reversed()))
            .limit(5)
            .collect(Collectors.toList());
        
        top5.forEach(System.out::println);
    }
}