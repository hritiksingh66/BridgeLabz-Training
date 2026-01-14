# JUnit Practice Problems

This folder contains comprehensive JUnit test implementations covering basic to advanced testing concepts.

## Basic JUnit Tests

### 1. Calculator & CalculatorTest
- **Purpose**: Basic arithmetic operations testing
- **Features**: Tests add, subtract, multiply, divide methods
- **Exception Testing**: Division by zero handling
- **Annotations**: `@Test`

### 2. StringUtils & StringUtilsTest
- **Purpose**: String manipulation methods testing
- **Features**: reverse(), isPalindrome(), toUpperCase()
- **Edge Cases**: null values, empty strings
- **Annotations**: `@Test`

### 3. ListManager & ListManagerTest
- **Purpose**: List operations testing
- **Features**: Add, remove, size operations
- **Setup**: `@BeforeEach` for test initialization
- **Annotations**: `@Test`, `@BeforeEach`

### 4. MathOperations & MathOperationsTest
- **Purpose**: Exception handling testing
- **Features**: ArithmeticException for division by zero
- **Annotations**: `@Test`, `assertThrows()`

### 5. DatabaseConnection & DatabaseConnectionTest
- **Purpose**: Setup and teardown testing
- **Features**: Connection lifecycle management
- **Annotations**: `@BeforeEach`, `@AfterEach`

### 6. NumberUtils & NumberUtilsTest
- **Purpose**: Parameterized testing
- **Features**: Even number validation with multiple inputs
- **Annotations**: `@ParameterizedTest`, `@ValueSource`

### 7. TaskProcessor & TaskProcessorTest
- **Purpose**: Performance/timeout testing
- **Features**: Long-running task simulation
- **Annotations**: `@Test`, `@Timeout`

### 8. FileProcessor & FileProcessorTest
- **Purpose**: File I/O operations testing
- **Features**: Write, read, file existence checks
- **Exception Testing**: IOException handling
- **Cleanup**: `@AfterEach` for file cleanup

## Advanced JUnit Tests

### 9. BankAccount & BankAccountTest
- **Purpose**: Banking operations testing
- **Features**: Deposit, withdraw, balance validation
- **Business Logic**: Insufficient funds handling
- **Edge Cases**: Negative amounts, boundary conditions

### 10. PasswordValidator & PasswordValidatorTest
- **Purpose**: Password strength validation
- **Features**: Length, uppercase, digit requirements
- **Parameterized**: Valid/invalid password sets
- **Annotations**: `@ParameterizedTest`, `@ValueSource`

### 11. TemperatureConverter & TemperatureConverterTest
- **Purpose**: Temperature conversion testing
- **Features**: Celsius ↔ Fahrenheit conversion
- **Precision**: Delta comparison for floating-point
- **Test Cases**: Freezing, boiling, body temperature

### 12. DateFormatter & DateFormatterTest
- **Purpose**: Date format conversion testing
- **Features**: yyyy-MM-dd → dd-MM-yyyy conversion
- **Exception Testing**: Invalid date format handling
- **Java 8**: LocalDate and DateTimeFormatter usage

### 13. UserRegistration & UserRegistrationTest
- **Purpose**: User validation testing
- **Features**: Username, email, password validation
- **Multiple Validations**: Comprehensive input checking
- **Exception Testing**: IllegalArgumentException scenarios

## JUnit Concepts Covered

### Core Annotations
- `@Test` - Basic test method
- `@BeforeEach` - Setup before each test
- `@AfterEach` - Cleanup after each test
- `@ParameterizedTest` - Multiple input testing
- `@ValueSource` - Parameter source for tests
- `@Timeout` - Performance testing

### Assertion Methods
- `assertEquals()` - Value equality
- `assertTrue()/assertFalse()` - Boolean conditions
- `assertNull()/assertNotNull()` - Null checking
- `assertThrows()` - Exception testing
- `assertTimeoutPreemptively()` - Timeout testing

### Advanced Features
- **Parameterized Tests**: Testing with multiple inputs
- **Exception Testing**: Verifying proper exception handling
- **Setup/Teardown**: Resource management
- **Timeout Testing**: Performance validation
- **File Operations**: I/O testing with cleanup
- **Floating-Point Comparison**: Delta-based assertions

## Test Organization

### Test Structure
```java
public class ClassNameTest {
    private ClassName objectUnderTest;
    
    @BeforeEach
    void setUp() {
        // Initialize test objects
    }
    
    @Test
    void testMethodName() {
        // Arrange, Act, Assert
    }
    
    @AfterEach
    void tearDown() {
        // Cleanup resources
    }
}
```

### Best Practices Demonstrated
- **AAA Pattern**: Arrange, Act, Assert
- **Descriptive Names**: Clear test method names
- **Edge Cases**: Boundary and error conditions
- **Resource Cleanup**: Proper teardown
- **Isolation**: Independent test methods
- **Parameterization**: Efficient multiple input testing

## How to Run Tests

### Prerequisites
- JUnit 5 (Jupiter) dependency
- Java 8 or higher

### Maven Dependency
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>
```

### Running Tests
1. Compile: `javac -cp junit-platform-console-standalone.jar *.java`
2. Run: `java -cp junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --class-path . --scan-class-path`

## Learning Objectives

- Understanding JUnit 5 annotations and assertions
- Writing effective unit tests for different scenarios
- Exception testing and validation
- Parameterized testing for multiple inputs
- Setup and teardown lifecycle management
- Performance testing with timeouts
- File I/O testing with proper cleanup
- Business logic validation in real-world scenarios

## Test Categories

### Functional Testing
- Method behavior validation
- Input/output verification
- Business rule enforcement

### Exception Testing
- Error condition handling
- Invalid input scenarios
- Resource failure simulation

### Performance Testing
- Timeout validation
- Resource usage monitoring
- Efficiency verification

### Integration Testing
- File system operations
- External resource interaction
- Component collaboration