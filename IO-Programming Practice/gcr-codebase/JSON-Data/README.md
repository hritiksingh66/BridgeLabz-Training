# JSON Data Handling - Practice Problems & IPL Censor Analyzer

## 📌 Practice Problems Implemented

### Basic JSON Operations
1. **Create Student JSON** - Generate JSON object with name, age, and subjects array
2. **Convert Car Object to JSON** - Transform Java object to JSON format
3. **Extract Specific Fields** - Read JSON and extract only name and email fields
4. **Merge JSON Objects** - Combine two JSON objects into one
5. **Filter JSON Records** - Extract records where age > 25
6. **Convert List to JSON Array** - Transform Java list to JSON array format

### Advanced Operations
7. **JSON Validation** - Validate JSON structure
8. **JSON to XML Conversion** - Convert JSON format to XML
9. **CSV to JSON Conversion** - Transform CSV data to JSON format
10. **Database to JSON Report** - Generate JSON reports from database records

## 🏏 IPL Censor Analyzer

### Problem Statement
Develop a Java application that reads IPL match data from JSON and CSV files, applies censorship rules, and writes sanitized data back to new files.

### Features
- **Input Support**: JSON and CSV formats
- **Censorship Rules**:
  - Mask team names: "Mumbai Indians" → "Mumbai ***"
  - Redact player names: Replace with "REDACTED"
- **Output**: Generate censored JSON and CSV files

### Files Structure
```
JSON-Data/
├── data/
│   ├── ipl_matches.json          # Original IPL data (JSON)
│   ├── ipl_matches.csv           # Original IPL data (CSV)
│   ├── ipl_matches_censored.json # Censored output (JSON)
│   └── ipl_matches_censored.csv  # Censored output (CSV)
├── IPLMatch.java                 # Data model class
├── IPLCensorAnalyzer.java        # Main analyzer (with Jackson)
├── SimpleIPLCensorAnalyzer.java  # Simple version (no dependencies)
└── JSONPracticeProblems.java     # Practice problems solutions
```

## 🚀 How to Run

### IPL Censor Analyzer
```bash
# Compile
javac SimpleIPLCensorAnalyzer.java

# Run
java SimpleIPLCensorAnalyzer
```

### JSON Practice Problems
```bash
# Compile
javac JSONPracticeProblems.java

# Run
java JSONPracticeProblems
```

## 📊 Sample Data

### Original IPL Data (JSON)
```json
[
  {
    "match_id": 101,
    "team1": "Mumbai Indians",
    "team2": "Chennai Super Kings",
    "score": {
      "Mumbai Indians": 178,
      "Chennai Super Kings": 182
    },
    "winner": "Chennai Super Kings",
    "player_of_match": "MS Dhoni"
  }
]
```

### Censored Output
```json
[
  {
    "match_id": 101,
    "team1": "Mumbai ***",
    "team2": "Chennai ***",
    "score": {
      "Mumbai ***": 178,
      "Chennai ***": 182
    },
    "winner": "Chennai ***",
    "player_of_match": "REDACTED"
  }
]
```

## 🛠️ Dependencies

### For Full Featured Version (IPLCensorAnalyzer.java)
- Jackson Core
- Jackson Databind

### For Simple Version (SimpleIPLCensorAnalyzer.java)
- No external dependencies (uses built-in Java libraries only)

## 📝 Practice Exercises

1. **Basic JSON Creation**: Create JSON objects for different entities
2. **Data Transformation**: Convert between JSON, CSV, and XML formats
3. **Data Filtering**: Apply various filtering criteria to JSON data
4. **Data Validation**: Implement JSON schema validation
5. **Data Merging**: Combine multiple JSON sources
6. **Censorship Rules**: Apply custom data masking rules
7. **Report Generation**: Create formatted reports from JSON data

## 🎯 Learning Objectives

- Understand JSON structure and syntax
- Learn JSON parsing and generation in Java
- Practice data transformation between formats
- Implement data filtering and validation
- Apply censorship and data masking techniques
- Handle file I/O operations with JSON data
- Work with nested JSON objects and arrays