# Smart University Library Management System

A comprehensive library management system demonstrating four essential design patterns: Singleton, Factory, Observer, and Builder.

## System Requirements Implementation

### 1. Library Catalog (Singleton Pattern)
- **Requirement**: Only one catalog should exist
- **Implementation**: `LibraryCatalog` class with synchronized singleton pattern
- **Benefits**: Ensures data consistency across the entire campus

### 2. User Management (Factory Pattern)
- **Requirement**: Support multiple user types with dynamic creation
- **Implementation**: `UserFactory` creates Student, Faculty, Librarian objects
- **Benefits**: Flexible user creation at runtime based on role

### 3. Notifications (Observer Pattern)
- **Requirement**: Notify subscribed users when new books arrive
- **Implementation**: Users implement `Observer` interface, catalog maintains observer list
- **Benefits**: Automatic notifications to interested users

### 4. Book Creation (Builder Pattern)
- **Requirement**: Flexible book construction with optional attributes
- **Implementation**: `Book.BookBuilder` with fluent interface
- **Benefits**: Clean construction of complex Book objects

## UML Class Diagram

```
┌─────────────────────┐    <<Singleton>>
│   LibraryCatalog    │
├─────────────────────┤
│ - instance          │
│ - books: List<Book> │
│ - observers: List   │
├─────────────────────┤
│ + getInstance()     │
│ + addBook()         │
│ + addObserver()     │
│ + newBookArrived()  │
└─────────────────────┘
           │
           │ manages
           ▼
┌─────────────────────┐    <<Product>>
│        Book         │
├─────────────────────┤
│ - title: String     │
│ - author: String    │
│ - edition: String   │
│ - genre: String     │
├─────────────────────┤
│ + getTitle()        │
│ + toString()        │
└─────────────────────┘
           ▲
           │ creates
┌─────────────────────┐    <<Builder>>
│    BookBuilder      │
├─────────────────────┤
│ + author()          │
│ + edition()         │
│ + genre()           │
│ + build()           │
└─────────────────────┘

┌─────────────────────┐         ┌─────────────────────┐
│    UserFactory      │ ─────→  │    User (intf)      │
├─────────────────────┤         ├─────────────────────┤
│ + createUser()      │         │ + showRole()        │
└─────────────────────┘         └─────────────────────┘
                                           ▲
                        ┌──────────────────┼──────────────────┐
                        │                  │                  │
              ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐
              │    Student      │ │    Faculty      │ │   Librarian     │
              ├─────────────────┤ ├─────────────────┤ ├─────────────────┤
              │ + showRole()    │ │ + showRole()    │ │ + showRole()    │
              │ + update()      │ │ + update()      │ │ + update()      │
              └─────────────────┘ └─────────────────┘ └─────────────────┘

┌─────────────────────┐    <<Observer>>
│   BookCatalog       │ ────────────────→ ┌─────────────────────┐
├─────────────────────┤                   │   Observer (User)   │
│ + addObserver()     │                   ├─────────────────────┤
│ + removeObs()       │                   │ + update(msg)       │
│ + notifyAll()       │                   └─────────────────────┘
└─────────────────────┘
```

## File Structure

```
Design-Patterns/
├── Observer.java                    # Observer interface
├── UserFactory.java                 # Factory pattern + User implementations
├── Book.java                        # Builder pattern for Book creation
├── LibraryCatalog.java              # Singleton pattern with Observer integration
├── LibraryManagementSystem.java     # Main application
└── README.md                        # This documentation
```

## How to Run

1. Compile all Java files:
```bash
javac *.java
```

2. Run the main application:
```bash
java LibraryManagementSystem
```

## Expected Output

```
=== Smart University Library Management System ===

Alice is a Student.
Dr. Bob is a Faculty.
Carol is a Librarian.

=== Library Catalog ===
No books in catalog
========================

Adding books to catalog...

Alice notified: New book available: Design Patterns
Dr. Bob notified: New book available: Design Patterns
Alice notified: New book available: Data Structures
Dr. Bob notified: New book available: Data Structures
Alice notified: New book available: Java Programming
Dr. Bob notified: New book available: Java Programming

=== Library Catalog ===
1. Book: Design Patterns by GoF (2nd) [Software Engineering]
2. Book: Data Structures by Cormen
3. Book: Java Programming by Oracle (11th)
========================

Singleton verification: true

Unsubscribing Alice from notifications...

Adding another book...
Dr. Bob notified: New book available: Machine Learning

=== Library Catalog ===
1. Book: Design Patterns by GoF (2nd) [Software Engineering]
2. Book: Data Structures by Cormen
3. Book: Java Programming by Oracle (11th)
4. Book: Machine Learning by Andrew Ng [AI]
========================

=== System Demo Complete ===
```

## Design Pattern Benefits

### Singleton Pattern
- **Thread Safety**: Synchronized getInstance() method
- **Memory Efficiency**: Single instance throughout application
- **Global Access**: Consistent catalog access from anywhere

### Factory Pattern
- **Flexibility**: Easy to add new user types
- **Encapsulation**: User creation logic centralized
- **Runtime Decision**: User type determined at runtime

### Observer Pattern
- **Loose Coupling**: Catalog doesn't need to know specific user types
- **Dynamic Subscription**: Users can subscribe/unsubscribe anytime
- **Scalability**: Easy to add more observers

### Builder Pattern
- **Flexibility**: Optional attributes handled elegantly
- **Readability**: Fluent interface makes code self-documenting
- **Immutability**: Book objects are immutable after creation

## Extension Suggestions

1. **Strategy Pattern**: Add book reservation strategies (FIFO, Priority, etc.)
2. **Singleton Logger**: Add logging functionality with singleton logger
3. **Additional User Types**: Add Guest users via Factory pattern
4. **Command Pattern**: Implement undo/redo for catalog operations
5. **Decorator Pattern**: Add book features like digital/physical copies

## Learning Outcomes

✅ **Singleton**: Ensures single catalog instance across campus
✅ **Factory**: Dynamic user creation based on role
✅ **Observer**: Automatic notifications for book arrivals
✅ **Builder**: Flexible book construction with optional attributes
✅ **Integration**: Multiple patterns working together seamlessly