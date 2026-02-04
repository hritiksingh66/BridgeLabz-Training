# Java Collectors Examples

This project demonstrates various Collectors operations with practical real-world scenarios for data aggregation and analysis.

## Project Structure

```
Collectors/
├── StudentResultGrouping.java          # Collectors.groupingBy() with mapping
├── WordFrequencyCounter.java           # Collectors.toMap() for frequency analysis
├── OrderRevenueSummary.java            # Collectors.summingDouble() for revenue
├── EmployeeSalaryCategorization.java   # Collectors.averagingDouble() by department
└── LibraryBookStatistics.java         # Collectors.summarizingInt() for statistics
```

## Examples Overview

### 1. StudentResultGrouping.java
- **Primary Collector**: `Collectors.groupingBy()` with `Collectors.mapping()`
- **Use Case**: Educational system - group students by grade level
- **Features**:
  - Group students by grade and collect names
  - Count students per grade
  - Calculate average scores by grade
  - Detailed student information by grade

**Key Code:**
```java
Map<String, List<String>> studentsByGrade = students.stream()
    .collect(Collectors.groupingBy(
        Student::getGradeLevel,
        Collectors.mapping(Student::getName, Collectors.toList())
    ));
```

### 2. WordFrequencyCounter.java
- **Primary Collector**: `Collectors.toMap()` and `Collectors.groupingBy()`
- **Use Case**: Text analysis - analyze word frequency in paragraphs
- **Features**:
  - Count word occurrences using `toMap()` with merge function
  - Alternative approach using `groupingBy()` with `counting()`
  - Find most frequent words
  - Group words by length
  - Identify unique words

**Key Code:**
```java
Map<String, Integer> wordCount = Arrays.stream(text.split("\\W+"))
    .collect(Collectors.toMap(
        Function.identity(),
        word -> 1,
        Integer::sum
    ));
```

### 3. OrderRevenueSummary.java
- **Primary Collector**: `Collectors.summingDouble()`
- **Use Case**: E-commerce analytics - calculate revenue summaries
- **Features**:
  - Sum order totals per customer
  - Revenue analysis by order status
  - Customer order statistics (count, average)
  - Filter completed orders for accurate revenue

**Key Code:**
```java
Map<String, Double> revenueByCustomer = orders.stream()
    .collect(Collectors.groupingBy(
        Order::getCustomerName,
        Collectors.summingDouble(Order::getTotal)
    ));
```

### 4. EmployeeSalaryCategorization.java
- **Primary Collector**: `Collectors.averagingDouble()`
- **Use Case**: HR analytics - employee salary analysis by department
- **Features**:
  - Calculate average salary by department (as specified)
  - Department-wise employee details
  - Salary distribution analysis
  - Highest paid employee per department
  - Salary range categorization

**Key Code (as specified):**
```java
Map<String, Double> avgSalaryByDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
             Collectors.averagingDouble(Employee::getSalary)));
```

### 5. LibraryBookStatistics.java
- **Primary Collector**: `Collectors.summarizingInt()`
- **Use Case**: Library management - comprehensive book statistics
- **Features**:
  - Complete page statistics per genre (total, average, max, min, count)
  - Longest and shortest books by genre
  - Overall library statistics
  - Books categorized by page ranges
  - Publication year analysis

**Key Code (as specified):**
```java
Map<String, IntSummaryStatistics> pageStatsByGenre = books.stream()
    .collect(Collectors.groupingBy(
        Book::getGenre,
        Collectors.summarizingInt(Book::getPages)
    ));
```

## Key Collectors Demonstrated

### Grouping Collectors
- `Collectors.groupingBy()` - Group elements by classifier
- `Collectors.groupingBy(classifier, downstream)` - Group with downstream collector

### Mapping Collectors
- `Collectors.mapping()` - Transform elements before collecting
- `Collectors.toMap()` - Collect to Map with key/value mappers

### Numeric Collectors
- `Collectors.summingDouble()` - Sum numeric values
- `Collectors.averagingDouble()` - Calculate averages
- `Collectors.summarizingInt()` - Complete statistics (count, sum, min, max, average)
- `Collectors.counting()` - Count elements

### Reduction Collectors
- `Collectors.maxBy()` - Find maximum element
- `Collectors.minBy()` - Find minimum element

## How to Run

1. Navigate to the Collectors folder:
```bash
cd Collectors
```

2. Compile and run any example:
```bash
javac StudentResultGrouping.java
java StudentResultGrouping
```

## Real-World Applications

### Business Analytics
- **Revenue Analysis**: Sum sales by customer, product, or time period
- **Performance Metrics**: Average scores, ratings, or KPIs by category
- **Statistical Reports**: Complete statistics for business intelligence

### Data Processing
- **Text Analysis**: Word frequency, sentiment analysis
- **Log Analysis**: Error counts, performance metrics by service
- **User Behavior**: Activity patterns, usage statistics

### Educational Systems
- **Grade Analysis**: Student performance by class, subject, or semester
- **Resource Management**: Book statistics, library analytics
- **Progress Tracking**: Learning outcomes and assessments

### HR Management
- **Salary Analysis**: Compensation analysis by department, role, or experience
- **Employee Statistics**: Headcount, demographics, performance metrics
- **Budget Planning**: Cost analysis and resource allocation

## Best Practices Demonstrated

1. **Efficient Grouping**: Use appropriate downstream collectors for specific needs
2. **Multiple Aggregations**: Combine different collectors for comprehensive analysis
3. **Data Transformation**: Use mapping collectors to transform data during collection
4. **Statistical Analysis**: Leverage summarizing collectors for complete statistics
5. **Performance**: Choose the right collector for the specific use case

## Advanced Patterns

### Nested Grouping
```java
// Group by department, then by salary range
Map<String, Map<String, Long>> nestedGrouping = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.groupingBy(emp -> getSalaryRange(emp.getSalary()),
                             Collectors.counting())
    ));
```

### Custom Collectors
```java
// Combine multiple statistics in one pass
Map<String, String> customStats = books.stream()
    .collect(Collectors.groupingBy(
        Book::getGenre,
        Collectors.collectingAndThen(
            Collectors.summarizingInt(Book::getPages),
            stats -> String.format("Avg: %.1f, Max: %d", 
                                  stats.getAverage(), stats.getMax())
        )
    ));
```

## Performance Considerations

1. **Stream vs Loop**: Collectors are optimized for parallel processing
2. **Memory Usage**: Be aware of memory consumption with large datasets
3. **Parallel Streams**: Use `.parallelStream()` for CPU-intensive aggregations
4. **Collector Choice**: Choose the most specific collector for better performance