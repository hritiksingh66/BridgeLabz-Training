# Java Streams and File I/O Programs

This folder contains comprehensive implementations of Java I/O streams with user input and error handling.

## Programs Overview

### 1. FileReadWrite.java
- **Purpose**: Read and write text files using FileInputStream/FileOutputStream
- **Features**: 
  - User input for file paths
  - Proper exception handling for file not found
  - Resource cleanup in finally block
- **Usage**: Enter source and destination file paths when prompted

### 2. BufferedFileCopy.java
- **Purpose**: Compare performance of buffered vs unbuffered file copying
- **Features**:
  - 4KB buffer size for efficient copying
  - Performance measurement using System.nanoTime()
  - Side-by-side comparison of execution times
- **Usage**: Provide source file and two destination paths for comparison

### 3. UserInputToFile.java
- **Purpose**: Read user information from console and save to file
- **Features**:
  - BufferedReader for console input
  - FileWriter for file output
  - Collects name, age, and favorite programming language
- **Usage**: Follow prompts to enter personal information

### 4. EmployeeSerialization.java
- **Purpose**: Demonstrate object serialization with Employee objects
- **Features**:
  - Serializable Employee class with id, name, department, salary
  - List serialization and deserialization
  - Proper exception handling for ClassNotFoundException
- **Usage**: Enter number of employees and their details

### 5. ImageToByteArray.java
- **Purpose**: Convert image to byte array and back to verify integrity
- **Features**:
  - ByteArrayInputStream/ByteArrayOutputStream usage
  - File integrity verification
  - Works with any image format
- **Usage**: Provide source image path and destination path

### 6. UppercaseToLowercase.java
- **Purpose**: Convert uppercase text to lowercase using character streams
- **Features**:
  - BufferedReader/BufferedWriter for efficiency
  - Line-by-line processing
  - Character encoding handling
- **Usage**: Enter source and destination file paths

### 7. StudentDataStreams.java
- **Purpose**: Store and retrieve primitive data using DataStreams
- **Features**:
  - DataInputStream/DataOutputStream for binary data
  - Handles int, String (UTF), and double data types
  - Maintains data order for proper reading
- **Usage**: Enter student count and details for each student

### 8. PipedStreamsCommunication.java
- **Purpose**: Inter-thread communication using PipedStreams
- **Features**:
  - Producer-consumer pattern implementation
  - Thread synchronization
  - Proper resource cleanup
- **Usage**: Run program to see automatic thread communication

### 9. LargeFileReader.java
- **Purpose**: Efficiently read large files and find error lines
- **Features**:
  - Line-by-line reading for memory efficiency
  - Case-insensitive error detection
  - Progress indicator for large files
- **Usage**: Enter file path to search for error lines

### 10. WordCounter.java
- **Purpose**: Count words and find top 5 most frequent words
- **Features**:
  - HashMap for word frequency counting
  - Punctuation removal and case normalization
  - Sorted results by frequency
- **Usage**: Enter file path to analyze word frequency

## Key Features

- **User Input**: All programs accept user input for file paths and data
- **Error Handling**: Comprehensive exception handling for I/O operations
- **Resource Management**: Proper closing of streams and resources
- **Performance**: Efficient algorithms for large file processing
- **Comments**: Simple and essential comments explaining key operations

## How to Run

1. Compile: `javac ProgramName.java`
2. Run: `java ProgramName`
3. Follow the prompts for user input
4. Check output files in the same directory

## Sample Test Files

Create these test files for testing:
- `sample.txt` - Text file with mixed case content
- `large.txt` - Large text file for performance testing
- `log.txt` - Log file with error messages for error detection
- `image.jpg` - Any image file for byte array conversion

## Learning Objectives

- Understanding different I/O stream types and their use cases
- Proper exception handling in file operations
- Performance comparison between buffered and unbuffered streams
- Object serialization and deserialization
- Inter-thread communication using streams
- Efficient processing of large files