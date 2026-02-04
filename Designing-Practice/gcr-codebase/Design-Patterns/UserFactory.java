// Factory Pattern - User interface and implementations
interface User extends Observer {
    void showRole();
}

class Student implements User {
    private String name;
    
    public Student(String name) {
        this.name = name;
    }
    
    @Override
    public void showRole() {
        System.out.println(name + " is a Student.");
    }
    
    @Override
    public void update(String message) {
        System.out.println(name + " notified: " + message);
    }
}

class Faculty implements User {
    private String name;
    
    public Faculty(String name) {
        this.name = name;
    }
    
    @Override
    public void showRole() {
        System.out.println(name + " is a Faculty.");
    }
    
    @Override
    public void update(String message) {
        System.out.println(name + " notified: " + message);
    }
}

class Librarian implements User {
    private String name;
    
    public Librarian(String name) {
        this.name = name;
    }
    
    @Override
    public void showRole() {
        System.out.println(name + " is a Librarian.");
    }
    
    @Override
    public void update(String message) {
        System.out.println(name + " notified: " + message);
    }
}

class UserFactory {
    public static User createUser(String type, String name) {
        return switch (type.toLowerCase()) {
            case "student" -> new Student(name);
            case "faculty" -> new Faculty(name);
            case "librarian" -> new Librarian(name);
            default -> throw new IllegalArgumentException("Unknown user type");
        };
    }
}