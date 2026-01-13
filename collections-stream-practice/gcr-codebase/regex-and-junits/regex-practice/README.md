# Java Regular Expressions (Regex) Practice Problems

This folder contains comprehensive implementations of Java regex patterns for validation, extraction, and text manipulation.

## Programs Overview

### Basic Validation Problems

#### 1. UsernameValidator.java
- **Pattern**: `^[a-zA-Z][a-zA-Z0-9_]{4,14}$`
- **Rules**: Starts with letter, 5-15 chars, letters/numbers/underscore only
- **Usage**: Enter username to validate

#### 2. LicensePlateValidator.java
- **Pattern**: `^[A-Z]{2}\\d{4}$`
- **Rules**: 2 uppercase letters + 4 digits
- **Usage**: Enter license plate number

#### 3. HexColorValidator.java
- **Pattern**: `^#[0-9A-Fa-f]{6}$`
- **Rules**: # followed by 6 hex characters
- **Usage**: Enter hex color code

### Extraction Problems

#### 4. EmailExtractor.java
- **Pattern**: `\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b`
- **Purpose**: Extract all email addresses from text
- **Usage**: Enter text containing emails

#### 5. CapitalizedWordsExtractor.java
- **Pattern**: `\\b[A-Z][a-z]*\\b`
- **Purpose**: Extract words starting with capital letters
- **Usage**: Enter sentence to analyze

#### 6. DateExtractor.java
- **Pattern**: `\\b\\d{2}/\\d{2}/\\d{4}\\b`
- **Purpose**: Extract dates in dd/mm/yyyy format
- **Usage**: Enter text containing dates

#### 7. LinkExtractor.java
- **Pattern**: `https?://[\\w\\.-]+\\.[a-zA-Z]{2,}[/\\w\\.-]*`
- **Purpose**: Extract HTTP/HTTPS URLs
- **Usage**: Enter text containing links

### Text Modification Problems

#### 8. SpaceReplacer.java
- **Pattern**: `\\s+`
- **Purpose**: Replace multiple spaces with single space
- **Usage**: Enter text with multiple spaces

#### 9. BadWordsCensor.java
- **Pattern**: `(?i)\\b{badword}\\b`
- **Purpose**: Censor inappropriate words with ****
- **Usage**: Enter sentence to censor

### Advanced Validation Problems

#### 10. IPAddressValidator.java
- **Pattern**: `^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$`
- **Purpose**: Validate IPv4 addresses (0-255 range)
- **Usage**: Enter IP address to validate

#### 11. CreditCardValidator.java
- **Patterns**: 
  - Visa: `^4\\d{15}$`
  - MasterCard: `^5\\d{15}$`
- **Purpose**: Validate Visa and MasterCard numbers
- **Usage**: Enter credit card number

#### 12. ProgrammingLanguageExtractor.java
- **Pattern**: `\\b{language}\\b` (case insensitive)
- **Purpose**: Extract programming language names
- **Usage**: Enter text mentioning programming languages

#### 13. CurrencyExtractor.java
- **Pattern**: `\\$?\\d+\\.\\d{2}|\\$\\d+`
- **Purpose**: Extract currency values with/without $ symbol
- **Usage**: Enter text containing prices

#### 14. RepeatingWordsFinder.java
- **Pattern**: `\\b(\\w+)\\s+\\1\\b`
- **Purpose**: Find consecutive repeating words
- **Usage**: Enter sentence with repeated words

#### 15. SSNValidator.java
- **Pattern**: `\\b\\d{3}-\\d{2}-\\d{4}\\b`
- **Purpose**: Validate Social Security Number format
- **Usage**: Enter text containing SSN

## Regex Pattern Explanations

### Common Regex Symbols
- `^` - Start of string
- `$` - End of string
- `\\b` - Word boundary
- `\\d` - Digit (0-9)
- `\\w` - Word character (a-z, A-Z, 0-9, _)
- `\\s` - Whitespace character
- `+` - One or more occurrences
- `*` - Zero or more occurrences
- `?` - Zero or one occurrence
- `{n,m}` - Between n and m occurrences
- `[...]` - Character class
- `(...)` - Capturing group
- `(?i)` - Case insensitive flag

### Advanced Patterns
- **Lookahead**: `(?=...)` - Positive lookahead
- **Lookbehind**: `(?<=...)` - Positive lookbehind
- **Non-capturing**: `(?:...)` - Non-capturing group
- **Backreference**: `\\1` - Reference to first captured group

## Key Features

- **User Input**: All programs accept user input for testing
- **Pattern Matching**: Uses Pattern.matches() for validation
- **Pattern Compilation**: Uses Pattern.compile() for extraction
- **Matcher Groups**: Demonstrates capturing groups and backreferences
- **Case Sensitivity**: Shows case-insensitive matching where needed
- **Boundary Matching**: Proper word boundary usage

## How to Run

1. Compile: `javac ProgramName.java`
2. Run: `java ProgramName`
3. Enter test input when prompted
4. Observe regex matching results

## Test Cases

### Valid Examples
- Username: `user_123`, `john_doe`
- License Plate: `AB1234`, `XY9876`
- Hex Color: `#FF5500`, `#abc123`
- Email: `test@example.com`, `user.name@domain.org`
- IP Address: `192.168.1.1`, `10.0.0.1`

### Invalid Examples
- Username: `123user` (starts with number), `us` (too short)
- License Plate: `A12345` (wrong format), `abc123` (lowercase)
- Hex Color: `#123` (too short), `FF5500` (missing #)
- IP Address: `256.1.1.1` (out of range), `192.168.1` (incomplete)

## Learning Objectives

- Understanding regex syntax and metacharacters
- Pattern compilation and matching in Java
- Capturing groups and backreferences
- Case-sensitive vs case-insensitive matching
- Word boundaries and anchors
- Quantifiers and character classes
- Real-world regex applications for validation and extraction