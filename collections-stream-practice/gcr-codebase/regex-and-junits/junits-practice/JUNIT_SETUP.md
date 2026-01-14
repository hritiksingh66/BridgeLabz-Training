# JUnit Setup Note

## Current Implementation
All test files have been implemented WITHOUT JUnit dependencies to avoid compilation errors.
They use Java assertions and simple test runner methods instead.

## Running Tests
Simply compile and run each test file:
```
javac DatabaseConnectionTest.java DatabaseConnection.java
java -ea DatabaseConnectionTest
```

Note: Use `-ea` flag to enable assertions.

## To Use JUnit 5 (Optional)

### Option 1: Download JUnit JAR
1. Download junit-platform-console-standalone JAR from Maven Central
2. Compile: `javac -cp junit-platform-console-standalone.jar *.java`
3. Run: `java -jar junit-platform-console-standalone.jar --class-path . --scan-class-path`

### Option 2: Use Maven
Add to pom.xml:
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
</dependency>
```

### Option 3: Use Gradle
Add to build.gradle:
```gradle
testImplementation 'org.junit.jupiter:junit-jupiter:5.9.0'
```

## Test Files Modified
All test files now use:
- Java `assert` statements instead of JUnit assertions
- `main()` method to run tests
- Manual setup/teardown calls
- Try-finally blocks for cleanup

This approach demonstrates testing concepts without external dependencies.