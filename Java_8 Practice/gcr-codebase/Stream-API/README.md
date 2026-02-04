# Java Stream API Examples

This project demonstrates various Stream API operations with practical real-world scenarios.

## Project Structure

```
Stream-API/
├── Basic-Operations/
│   ├── Top5TrendingMovies.java           # filter(), sorted(), limit()
│   ├── HospitalDoctorAvailability.java   # filter(), sorted(), groupingBy()
│   ├── InsuranceClaimAnalysis.java       # groupingBy(), averagingDouble()
│   ├── FilteringExpiringMemberships.java # filter() with date operations
│   └── TransformingNamesForDisplay.java  # map(), sorted()
└── ForEach-Method/
    ├── StockPriceLogger.java             # forEach() for live data display
    ├── EventAttendeeWelcomeMessage.java  # forEach() with lambda expressions
    ├── IoTSensorReadings.java            # forEach() with filtering
    ├── EmailNotifications.java           # forEach() for batch processing
    └── LoggingTransactions.java          # forEach() with timestamps
```

## 1. Basic Stream Operations

### Top5TrendingMovies.java
- **Operations**: `filter()`, `sorted()`, `limit()`
- **Use Case**: Movie recommendation system
- **Features**: 
  - Filter recent movies (2019+)
  - Sort by rating (descending) then by year
  - Limit to top 5 results

### HospitalDoctorAvailability.java
- **Operations**: `filter()`, `sorted()`, `groupingBy()`
- **Use Case**: Hospital staff management
- **Features**:
  - Filter doctors available on weekends
  - Sort by specialty and name
  - Group doctors by specialty

### InsuranceClaimAnalysis.java
- **Operations**: `groupingBy()`, `averagingDouble()`, `summingDouble()`, `counting()`
- **Use Case**: Insurance claim analytics
- **Features**:
  - Average claim amount by type
  - Average claim amount by status
  - Count and total by claim type
  - Comprehensive claim analysis

### FilteringExpiringMemberships.java
- **Operations**: `filter()`, `sorted()`, date calculations
- **Use Case**: Gym membership management
- **Features**:
  - Filter memberships expiring within 30 days
  - Categorize by urgency (critical ≤7 days, warning 8-30 days)
  - Group by membership type
  - Calculate days until expiry

### TransformingNamesForDisplay.java
- **Operations**: `map()`, `sorted()`, string transformations
- **Use Case**: Customer name formatting
- **Features**:
  - Transform to uppercase
  - Title case formatting
  - Last name first format
  - Initials format
  - Name statistics (length analysis)

## 2. forEach() Method Examples

### StockPriceLogger.java
- **Operations**: `forEach()` for display, filtering for alerts
- **Use Case**: Stock market monitoring
- **Features**:
  - Display all stock prices with timestamps
  - Filter significant changes (>₹5)
  - Separate gainers and losers
  - High volatility alerts
  - Market summary statistics

### EventAttendeeWelcomeMessage.java
- **Operations**: `forEach()` with lambda expressions
- **Use Case**: Event management system
- **Features**:
  - Send personalized welcome messages
  - Special VIP messages
  - Group messages by ticket type
  - SMS reminders
  - Event statistics

### IoTSensorReadings.java
- **Operations**: `forEach()` with filtering and grouping
- **Use Case**: IoT sensor monitoring
- **Features**:
  - Display all sensor readings
  - Threshold-based alerts
  - Critical alerts (>150% threshold)
  - Group readings by sensor type
  - Calculate averages per sensor type

### EmailNotifications.java
- **Operations**: `forEach()` for batch processing
- **Use Case**: Email marketing system
- **Features**:
  - Send notifications to all users
  - Different message types (welcome, security, promotion)
  - Success/failure tracking
  - Batch processing statistics
  - Retry queue for failed emails

### LoggingTransactions.java
- **Operations**: `forEach()` with timestamps
- **Use Case**: Transaction logging system
- **Features**:
  - Basic transaction logging with timestamps
  - Enhanced logging with log levels
  - Categorized transaction logging
  - Error simulation and handling
  - Audit trail generation

## Key Stream API Concepts Demonstrated

### Intermediate Operations
- `filter()` - Filter elements based on conditions
- `map()` - Transform elements
- `sorted()` - Sort elements with custom comparators
- `distinct()` - Remove duplicates

### Terminal Operations
- `forEach()` - Perform action on each element
- `collect()` - Collect results into collections
- `count()` - Count elements
- `reduce()` - Reduce to single value

### Collectors
- `Collectors.toList()` - Collect to List
- `Collectors.groupingBy()` - Group elements
- `Collectors.averagingDouble()` - Calculate averages
- `Collectors.summingDouble()` - Calculate sums
- `Collectors.counting()` - Count elements

## How to Run

1. Navigate to any subfolder:
```bash
cd Basic-Operations
# or
cd ForEach-Method
```

2. Compile and run:
```bash
javac *.java
java [ClassName]
```

Example:
```bash
cd Basic-Operations
javac Top5TrendingMovies.java
java Top5TrendingMovies
```

## Best Practices Demonstrated

1. **Method Chaining**: Fluent API usage with multiple operations
2. **Lambda Expressions**: Concise functional programming
3. **Method References**: Using `::` operator for cleaner code
4. **Stream Pipeline**: Proper intermediate and terminal operations
5. **Performance**: Efficient filtering before expensive operations
6. **Readability**: Clear and maintainable stream operations

## Real-World Applications

- **Data Analytics**: Filtering, grouping, and aggregating data
- **Reporting**: Generating summaries and statistics
- **Monitoring**: Real-time data processing and alerts
- **Batch Processing**: Processing large datasets efficiently
- **User Interface**: Transforming data for display
- **Business Logic**: Complex filtering and sorting requirements

## Performance Tips

1. Filter early in the pipeline to reduce data volume
2. Use parallel streams for CPU-intensive operations on large datasets
3. Avoid creating unnecessary intermediate collections
4. Use appropriate collectors for the desired output format
5. Consider memory usage when processing large streams