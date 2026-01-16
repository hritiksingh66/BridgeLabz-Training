# Custom Annotations in Java

This folder contains custom annotation definitions and their usage examples.

## Custom Annotations

### 1. Author.java
- **Purpose**: Track author information for classes and methods
- **Attributes**: name, date, version
- **Target**: TYPE, METHOD
- **Retention**: RUNTIME

### 2. ValidateInput.java
- **Purpose**: Validate method input parameters
- **Attributes**: min, max, message
- **Target**: METHOD
- **Retention**: RUNTIME
- **Use Case**: Input validation before method execution

### 3. Inject.java
- **Purpose**: Mark fields for dependency injection
- **Target**: FIELD
- **Retention**: RUNTIME
- **Use Case**: Automatic dependency resolution

### 4. Loggable.java
- **Purpose**: Mark methods for automatic logging
- **Attributes**: value (log level), logParams, logResult
- **Target**: METHOD
- **Retention**: RUNTIME
- **Use Case**: AOP-style logging

### 5. DeprecatedAPI.java
- **Purpose**: Mark deprecated APIs with additional information
- **Attributes**: since, replacement, reason
- **Target**: METHOD, TYPE
- **Retention**: RUNTIME
- **Use Case**: API versioning and migration

### 6. Transactional.java
- **Purpose**: Mark methods for transaction management
- **Attributes**: value, readOnly, timeout
- **Target**: METHOD
- **Retention**: RUNTIME
- **Use Case**: Database transaction handling

## Demo Programs

### AnnotationDemo.java
- Demonstrates usage of all custom annotations
- Shows how to retrieve annotation values at runtime
- Displays class-level and method-level annotations

### AnnotationProcessor.java
- Implements validation logic using @ValidateInput
- Processes annotations before method execution
- Demonstrates annotation-driven behavior

## Key Concepts

### Annotation Elements
- **@Retention**: Specifies how long annotations are retained
  - SOURCE: Discarded by compiler
  - CLASS: Stored in .class file but not available at runtime
  - RUNTIME: Available at runtime via reflection

- **@Target**: Specifies where annotation can be applied
  - TYPE: Class, interface, enum
  - FIELD: Field declaration
  - METHOD: Method declaration
  - PARAMETER: Method parameter
  - CONSTRUCTOR: Constructor

### Annotation Attributes
- Can have default values
- Must be compile-time constants
- Supported types: primitives, String, Class, enum, annotations, arrays

## Usage Examples

### Applying Annotations
```java
@Author(name = "John", date = "2024-01-15")
public class MyClass {
    
    @ValidateInput(min = 0, max = 100)
    public void setScore(int score) {
        // method body
    }
}
```

### Reading Annotations
```java
if (method.isAnnotationPresent(ValidateInput.class)) {
    ValidateInput validate = method.getAnnotation(ValidateInput.class);
    int min = validate.min();
    int max = validate.max();
}
```

## Real-World Applications

1. **Spring Framework**: @Autowired, @Component, @Service
2. **JPA/Hibernate**: @Entity, @Table, @Column
3. **JUnit**: @Test, @BeforeEach, @AfterEach
4. **JAX-RS**: @Path, @GET, @POST
5. **Validation**: @NotNull, @Size, @Email

## Best Practices

1. Use meaningful annotation names
2. Provide default values for optional attributes
3. Document annotation purpose and usage
4. Keep annotations simple and focused
5. Use appropriate retention policy
6. Specify correct target elements

## Running the Programs

```bash
# Compile
javac Annotations/*.java

# Run demo
java Annotations.AnnotationDemo

# Run processor
java Annotations.AnnotationProcessor
```