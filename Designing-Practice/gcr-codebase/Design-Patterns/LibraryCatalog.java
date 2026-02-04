import java.util.*;

// Singleton Pattern - Library Catalog with Observer integration
public class LibraryCatalog {
    private static LibraryCatalog instance;
    private List<Book> books;
    private List<Observer> observers;
    
    private LibraryCatalog() {
        books = new ArrayList<>();
        observers = new ArrayList<>();
    }
    
    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }
    
    public void addBook(Book book) {
        books.add(book);
        newBookArrived(book.getTitle());
    }
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    private void newBookArrived(String bookTitle) {
        for (Observer observer : observers) {
            observer.update("New book available: " + bookTitle);
        }
    }
    
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
    
    public void displayCatalog() {
        System.out.println("\n=== Library Catalog ===");
        if (books.isEmpty()) {
            System.out.println("No books in catalog");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
        System.out.println("========================\n");
    }
}