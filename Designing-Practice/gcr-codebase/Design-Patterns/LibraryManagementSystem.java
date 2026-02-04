// Main Application - Integration of all Design Patterns
public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        System.out.println("=== Smart University Library Management System ===\n");
        
        // Singleton - Get single instance of catalog
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        
        // Factory - Create different types of users
        User student = UserFactory.createUser("student", "Alice");
        User faculty = UserFactory.createUser("faculty", "Dr. Bob");
        User librarian = UserFactory.createUser("librarian", "Carol");
        
        // Display user roles
        student.showRole();
        faculty.showRole();
        librarian.showRole();
        System.out.println();
        
        // Observer - Subscribe users to notifications
        catalog.addObserver(student);
        catalog.addObserver(faculty);
        
        // Builder - Create books with flexible attributes
        Book book1 = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd")
                .genre("Software Engineering")
                .build();
        
        Book book2 = new Book.BookBuilder("Data Structures")
                .author("Cormen")
                .build();
        
        Book book3 = new Book.BookBuilder("Java Programming")
                .author("Oracle")
                .edition("11th")
                .build();
        
        // Display initial catalog
        catalog.displayCatalog();
        
        // Add books - triggers notifications to subscribed users
        System.out.println("Adding books to catalog...\n");
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);
        
        // Display updated catalog
        catalog.displayCatalog();
        
        // Demonstrate Singleton - same instance
        LibraryCatalog anotherCatalogRef = LibraryCatalog.getInstance();
        System.out.println("Singleton verification: " + (catalog == anotherCatalogRef));
        
        // Unsubscribe a user
        System.out.println("\nUnsubscribing Alice from notifications...");
        catalog.removeObserver(student);
        
        // Add another book
        Book book4 = new Book.BookBuilder("Machine Learning")
                .author("Andrew Ng")
                .genre("AI")
                .build();
        
        System.out.println("\nAdding another book...");
        catalog.addBook(book4);
        
        catalog.displayCatalog();
        
        System.out.println("=== System Demo Complete ===");
    }
}