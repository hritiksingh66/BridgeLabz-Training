import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private int publicationYear;
    
    public Book(String title, String author, String genre, int pages, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.publicationYear = publicationYear;
    }
    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
    public int getPublicationYear() { return publicationYear; }
    
    @Override
    public String toString() {
        return String.format("\"%s\" by %s (%d pages)", title, author, pages);
    }
}

public class LibraryBookStatistics {
    
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 180, 1925),
            new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 281, 1960),
            new Book("1984", "George Orwell", "Fiction", 328, 1949),
            new Book("Pride and Prejudice", "Jane Austen", "Romance", 432, 1813),
            new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 277, 1951),
            new Book("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1216, 1954),
            new Book("Harry Potter", "J.K. Rowling", "Fantasy", 309, 1997),
            new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 310, 1937),
            new Book("Dune", "Frank Herbert", "Science Fiction", 688, 1965),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 244, 1951),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 271, 1984),
            new Book("Jane Eyre", "Charlotte Brontë", "Romance", 507, 1847),
            new Book("Wuthering Heights", "Emily Brontë", "Romance", 416, 1847)
        );
        
        System.out.println("=== Library Book Statistics ===\n");
        
        // Summarizing statistics by genre using summarizingInt
        Map<String, IntSummaryStatistics> pageStatsByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summarizingInt(Book::getPages)
            ));
        
        System.out.println("Page statistics by genre:");
        pageStatsByGenre.forEach((genre, stats) -> {
            System.out.printf("\n%s:%n", genre);
            System.out.printf("  Total pages: %,d%n", stats.getSum());
            System.out.printf("  Average pages: %.1f%n", stats.getAverage());
            System.out.printf("  Maximum pages: %,d%n", stats.getMax());
            System.out.printf("  Minimum pages: %,d%n", stats.getMin());
            System.out.printf("  Number of books: %d%n", stats.getCount());
        });
        
        System.out.println("\n=== Detailed Genre Analysis ===");
        
        // Books grouped by genre
        Map<String, List<Book>> booksByGenre = books.stream()
            .collect(Collectors.groupingBy(Book::getGenre));
        
        booksByGenre.forEach((genre, bookList) -> {
            System.out.println("\n" + genre + " Books:");
            bookList.stream()
                .sorted(Comparator.comparingInt(Book::getPages).reversed())
                .forEach(book -> System.out.println("  " + book));
        });
        
        // Find longest and shortest books per genre
        Map<String, Optional<Book>> longestByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.maxBy(Comparator.comparingInt(Book::getPages))
            ));
        
        Map<String, Optional<Book>> shortestByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.minBy(Comparator.comparingInt(Book::getPages))
            ));
        
        System.out.println("\n=== Longest and Shortest Books by Genre ===");
        pageStatsByGenre.keySet().forEach(genre -> {
            String longest = longestByGenre.get(genre)
                .map(Book::getTitle)
                .orElse("None");
            String shortest = shortestByGenre.get(genre)
                .map(Book::getTitle)
                .orElse("None");
            
            System.out.printf("\n%s:%n", genre);
            System.out.printf("  Longest: %s%n", longest);
            System.out.printf("  Shortest: %s%n", shortest);
        });
        
        // Overall library statistics
        IntSummaryStatistics overallStats = books.stream()
            .collect(Collectors.summarizingInt(Book::getPages));
        
        System.out.println("\n=== Overall Library Statistics ===");
        System.out.printf("Total books: %d%n", overallStats.getCount());
        System.out.printf("Total pages: %,d%n", overallStats.getSum());
        System.out.printf("Average pages per book: %.1f%n", overallStats.getAverage());
        System.out.printf("Longest book: %,d pages%n", overallStats.getMax());
        System.out.printf("Shortest book: %,d pages%n", overallStats.getMin());
        
        // Books by page ranges
        Map<String, Long> booksByPageRange = books.stream()
            .collect(Collectors.groupingBy(
                book -> {
                    int pages = book.getPages();
                    if (pages < 200) return "Short (< 200)";
                    else if (pages < 400) return "Medium (200-399)";
                    else if (pages < 600) return "Long (400-599)";
                    else return "Very Long (600+)";
                },
                Collectors.counting()
            ));
        
        System.out.println("\nBooks by page range:");
        booksByPageRange.forEach((range, count) -> 
            System.out.printf("  %-20s: %d books%n", range, count));
        
        // Publication year statistics by genre
        Map<String, IntSummaryStatistics> yearStatsByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summarizingInt(Book::getPublicationYear)
            ));
        
        System.out.println("\nPublication year range by genre:");
        yearStatsByGenre.forEach((genre, stats) -> 
            System.out.printf("  %-15s: %d - %d%n", genre, stats.getMin(), stats.getMax()));
    }
}