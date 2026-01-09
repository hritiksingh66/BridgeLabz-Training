# Java Exception Handling Programs

This folder contains comprehensive implementations of Java exception handling concepts with user input and practical examples.

## Programs Overview

### 1. CheckedException.java
- **Purpose**: Handle checked IOException when reading files
- **Features**:
  - FileReader with BufferedReader
  - IOException handling for file not found
  - Try-with-resources for automatic cleanup
- **Usage**: Enter file name or use default "data.txt"

### 2. UncheckedException.java
- **Purpose**: Handle unchecked runtime exceptions
- **Features**:
  - ArithmeticException for division by zero
  - InputMismatchException for invalid input
  - Multiple exception handling
- **Usage**: Enter two numbers for division operation

### 3. CustomException.java
- **Purpose**: Create and use custom exceptions
- **Features**:
  - InvalidAgeException custom class
  - Age validation method
  - Custom exception throwing and handling
- **Usage**: Enter age to validate (must be 18+)

### 4. MultipleCatchBlocks.java
- **Purpose**: Demonstrate multiple catch blocks
- **Features**:
  - ArrayIndexOutOfBoundsException handling
  - NullPointerException handling
  - Array operations with user input
- **Usage**: Create array and access elements by index

### 5. TryWithResources.java
- **Purpose**: Automatic resource management
- **Features**:
  - Try-with-resources syntax
  - Automatic BufferedReader closing
  - File reading with resource cleanup
- **Usage**: Enter file name or use default "info.txt"

### 6. ThrowVsThrows.java
- **Purpose**: Demonstrate throw vs throws keywords
- **Features**:
  - Method-level exception declaration (throws)
  - Manual exception throwing (throw)
  - Interest calculation with validation
- **Usage**: Enter amount, rate, and years for interest calculation

### 7. FinallyBlock.java
- **Purpose**: Show finally block execution
- **Features**:
  - Finally block always executes
  - Division operation with exception handling
  - Resource cleanup in finally
- **Usage**: Enter two numbers for division

### 8. ExceptionPropagation.java
- **Purpose**: Exception propagation through method calls
- **Features**:
  - Method chain: main() → method2() → method1()
  - Exception bubbling up the call stack
  - Centralized exception handling
- **Usage**: Run to see automatic exception propagation

### 9. NestedTryCatch.java
- **Purpose**: Nested try-catch blocks
- **Features**:
  - Multiple levels of exception handling
  - Array access and division operations
  - Specific exception handling at each level
- **Usage**: Create array, access element, and perform division

### 10. BankTransactionSystem.java
- **Purpose**: Real-world banking system with exceptions
- **Features**:
  - Custom InsufficientBalanceException
  - IllegalArgumentException for validation
  - Bank account withdrawal operations
- **Usage**: Create account and attempt withdrawals

## Exception Types Covered

### Checked Exceptions
- **IOException** - File operations
- **Custom Exceptions** - User-defined business logic

### Unchecked Exceptions
- **ArithmeticException** - Division by zero
- **InputMismatchException** - Invalid input types
- **ArrayIndexOutOfBoundsException** - Array bounds
- **NullPointerException** - Null references
- **IllegalArgumentException** - Invalid parameters

## Key Concepts Demonstrated

- **Exception Hierarchy**: Checked vs Unchecked exceptions
- **Exception Propagation**: How exceptions bubble up
- **Resource Management**: Try-with-resources and finally blocks
- **Custom Exceptions**: Creating domain-specific exceptions
- **Multiple Catch Blocks**: Handling different exception types
- **Nested Try-Catch**: Multiple levels of exception handling

## Best Practices Shown

- Always close resources (try-with-resources preferred)
- Handle specific exceptions before general ones
- Use custom exceptions for business logic validation
- Provide meaningful error messages to users
- Clean up resources in finally blocks when needed

## How to Run

1. Compile: `javac ProgramName.java`
2. Run: `java ProgramName`
3. Follow prompts for user input
4. Observe different exception scenarios

## Test Scenarios

### For File Operations:
- Create test files: `data.txt`, `info.txt`
- Try with non-existent files
- Test with empty files

### For Numeric Operations:
- Enter valid numbers
- Try division by zero
- Enter non-numeric input
- Test negative values

### For Array Operations:
- Create arrays of different sizes
- Access valid and invalid indices
- Test with null arrays

## Learning Objectives

- Understanding exception hierarchy and types
- Proper exception handling techniques
- Resource management best practices
- Creating and using custom exceptions
- Exception propagation mechanisms
- Real-world application of exception handling