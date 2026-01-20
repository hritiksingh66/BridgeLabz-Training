# CSV Data Handling in Java

This folder contains comprehensive implementations for CSV file operations, from basic reading/writing to advanced data processing.

## Basic Level Programs

### 1. ReadCSVFile.java
- **Purpose**: Read CSV file and display structured data
- **Features**: Parse CSV rows, skip header, formatted output
- **Usage**: Enter CSV file path when prompted

### 2. WriteCSVFile.java
- **Purpose**: Create CSV file with employee data
- **Features**: Write header and 5 sample records
- **Usage**: Enter output file name

### 3. CountCSVRows.java
- **Purpose**: Count records in CSV file excluding header
- **Features**: Line counting, header detection
- **Usage**: Enter CSV file path to count

## Intermediate Level Programs

### 4. FilterCSVRecords.java
- **Purpose**: Filter students with marks > 80
- **Features**: Conditional filtering, data parsing
- **Usage**: Enter CSV file with student data

### 5. SearchCSVRecord.java
- **Purpose**: Search employee by name
- **Features**: Case-insensitive search, display details
- **Usage**: Enter file path and employee name

### 6. ModifyCSVFile.java
- **Purpose**: Increase IT department salary by 10%
- **Features**: Data modification, conditional updates
- **Usage**: Enter input and output file paths

### 7. SortCSVRecords.java
- **Purpose**: Sort by salary and show top 5
- **Features**: Custom sorting, data ranking
- **Usage**: Enter CSV file with salary data

## Advanced Level Programs

### 8. ValidateCSVData.java
- **Purpose**: Validate email and phone number formats
- **Features**: Regex validation, error reporting
- **Usage**: Enter CSV file with email/phone columns

### 9. CSVToObjects.java
- **Purpose**: Convert CSV rows to Java Student objects
- **Features**: Object mapping, type conversion
- **Usage**: Enter CSV file with student data

### 10. MergeCSVFiles.java
- **Purpose**: Merge two CSV files based on ID
- **Features**: Join operations, data correlation
- **Usage**: Enter two CSV files and output path

### 11. ReadLargeCSV.java
- **Purpose**: Process large CSV files in chunks
- **Features**: Memory-efficient reading, progress tracking
- **Usage**: Enter large CSV file path

### 12. DetectDuplicatesCSV.java
- **Purpose**: Find duplicate records based on ID
- **Features**: Duplicate detection, detailed reporting
- **Usage**: Enter CSV file to check for duplicates

### 13. GenerateCSVReport.java
- **Purpose**: Generate CSV report from simulated database
- **Features**: Data export, report generation
- **Usage**: Enter output report file name

### 14. JSONCSVConverter.java
- **Purpose**: Convert between JSON and CSV formats
- **Features**: Bidirectional conversion, format transformation
- **Usage**: Choose conversion direction and file paths

### 15. EncryptDecryptCSV.java
- **Purpose**: Encrypt/decrypt sensitive CSV fields
- **Features**: Caesar cipher, data security
- **Usage**: Choose encrypt/decrypt and file paths

## Key CSV Concepts

### File Structure
- **Header Row**: Column names (first row)
- **Data Rows**: Actual records
- **Delimiter**: Comma separator (,)
- **Escaping**: Handle commas in data

### Common Operations
- **Reading**: BufferedReader with split(",")
- **Writing**: PrintWriter with formatted output
- **Parsing**: String.split() and trim()
- **Validation**: Regex patterns for data formats

### Data Processing Patterns
- **Filtering**: Conditional record selection
- **Sorting**: Comparator-based ordering
- **Grouping**: Map-based categorization
- **Aggregation**: Sum, count, average calculations

## File Formats Handled

### CSV Structure
```
ID,Name,Age,Marks
1,John Doe,20,85
2,Jane Smith,21,92
```

### JSON Structure
```json
[
  {"id": "1", "name": "John Doe", "age": "20", "marks": "85"},
  {"id": "2", "name": "Jane Smith", "age": "21", "marks": "92"}
]
```

## Error Handling

### Common Issues
- **File Not Found**: Check file path and permissions
- **Format Errors**: Validate CSV structure
- **Data Type Errors**: Handle parsing exceptions
- **Memory Issues**: Use streaming for large files

### Best Practices
- Always close resources (try-with-resources)
- Validate data before processing
- Handle edge cases (empty files, malformed data)
- Use appropriate data types for parsing

## Performance Considerations

### Large Files
- **Streaming**: Read line by line
- **Chunking**: Process in batches
- **Memory Management**: Avoid loading entire file
- **Progress Tracking**: Show processing status

### Optimization Tips
- Use StringBuilder for string concatenation
- Cache compiled regex patterns
- Use appropriate collection types
- Consider parallel processing for large datasets

## Sample Data Files

Create these test files for practice:

### students.csv
```
ID,Name,Age,Marks
1,John Doe,20,85
2,Jane Smith,21,92
3,Mike Johnson,19,78
```

### employees.csv
```
ID,Name,Department,Salary
1,Alice Brown,IT,75000
2,Bob Wilson,HR,65000
3,Carol Davis,Finance,70000
```

## Running the Programs

1. **Compile**: `javac ProgramName.java`
2. **Run**: `java ProgramName`
3. **Input**: Follow prompts for file paths and parameters
4. **Output**: Check generated files and console output

## Learning Objectives

- Understanding CSV file structure and parsing
- Implementing file I/O operations efficiently
- Data validation and error handling
- Object-oriented data mapping
- Performance optimization for large files
- Data transformation and format conversion
- Security considerations for sensitive data

## Real-World Applications

- **Data Import/Export**: Business applications
- **Report Generation**: Analytics and reporting
- **Data Migration**: System integrations
- **Batch Processing**: ETL operations
- **Configuration Management**: Settings and parameters
- **Log File Analysis**: System monitoring