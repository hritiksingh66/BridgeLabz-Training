# Java Reflection and Annotations Practice

This folder contains comprehensive implementations of Java Reflection API and custom annotations with practical examples.

## Basic Level Programs

### 1. ClassInspector.java
- **Purpose**: Inspect class information at runtime
- **Features**: Display constructors, fields, and methods
- **Usage**: Enter any class name (e.g., java.lang.String)
- **Key Concepts**: Class.forName(), getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods()

### 2. AccessPrivateField.java
- **Purpose**: Access and modify private fields
- **Features**: Read and write private field values
- **Key Concepts**: getDeclaredField(), setAccessible(true), get(), set()

### 3. InvokePrivateMethod.java
- **Purpose**: Invoke private methods dynamically
- **Features**: Call private methods with parameters
- **Key Concepts**: getDeclaredMethod(), setAccessible(true), invoke()

### 4. DynamicObjectCreation.java
- **Purpose**: Create objects without using 'new' keyword
- **Features**: Instantiate objects using reflection
- **Key Concepts**: Class.forName(), getDeclaredConstructor(), newInstance()

## Intermediate Level Programs

### 5. DynamicMethodInvocation.java
- **Purpose**: Call methods dynamically based on user input
- **Features**: Runtime method selection and invocation
- **Key Concepts**: getMethod(), invoke() with parameters
- **Usage**: Enter method name and parameters at runtime

### 6. RetrieveAnnotations.java
- **Purpose**: Create and retrieve custom annotations
- **Features**: @Author annotation with runtime retention
- **Key Concepts**: @Retention, @Target, isAnnotationPresent(), getAnnotation()

### 7. ModifyStaticField.java
- **Purpose**: Access and modify static fields
- **Features**: Change static field values at runtime
- **Key Concepts**: getDeclaredField() on static fields, pass null for static access

## Advanced Level Programs

### 8. CustomObjectMapper.java
- **Purpose**: Map properties to object fields
- **Features**: Convert Map<String, Object> to typed objects
- **Key Concepts**: Field iteration, type conversion, dynamic object population
- **Use Case**: Similar to JSON deserialization

### 9. ObjectToJSON.java
- **Purpose**: Generate JSON representation of objects
- **Features**: Convert any object to JSON-like string
- **Key Concepts**: Field inspection, value extraction, string building
- **Use Case**: Custom serialization

### 10. DynamicProxyLogging.java
- **Purpose**: Intercept method calls with logging
- **Features**: Automatic logging before/after method execution
- **Key Concepts**: Proxy.newProxyInstance(), InvocationHandler, dynamic proxies
- **Use Case**: AOP-style logging, method interception

### 11. SimpleDependencyInjection.java
- **Purpose**: Implement basic DI container
- **Features**: @Inject annotation, automatic dependency resolution
- **Key Concepts**: Custom annotations, field injection, instance management
- **Use Case**: Lightweight dependency injection framework

### 12. MethodExecutionTiming.java
- **Purpose**: Measure method execution time
- **Features**: Dynamic performance profiling
- **Key Concepts**: Method invocation with timing, System.nanoTime()
- **Use Case**: Performance monitoring, profiling

## Key Reflection Concepts

### Core Classes
- **Class<?>** - Represents classes and interfaces
- **Field** - Represents class fields
- **Method** - Represents class methods
- **Constructor** - Represents class constructors

### Important Methods
- **Class.forName(String)** - Load class by name
- **getDeclaredFields()** - Get all fields including private
- **getDeclaredMethods()** - Get all methods including private
- **getDeclaredConstructors()** - Get all constructors
- **setAccessible(true)** - Bypass access control
- **invoke(Object, Object...)** - Call method dynamically
- **newInstance()** - Create new object instance

### Annotation Concepts
- **@Retention** - Specify annotation lifetime (SOURCE, CLASS, RUNTIME)
- **@Target** - Specify where annotation can be applied
- **isAnnotationPresent()** - Check if annotation exists
- **getAnnotation()** - Retrieve annotation instance

## Use Cases

### When to Use Reflection
- **Frameworks** - Spring, Hibernate use reflection extensively
- **Testing** - JUnit uses reflection for test discovery
- **Serialization** - JSON/XML libraries use reflection
- **Dependency Injection** - IoC containers
- **Dynamic Proxies** - AOP implementations
- **Plugin Systems** - Load classes dynamically

### Performance Considerations
- Reflection is slower than direct access
- Use caching for frequently accessed members
- Avoid reflection in performance-critical code
- Consider alternatives like method handles

## Best Practices

1. **Cache Reflection Objects** - Store Method, Field objects for reuse
2. **Handle Exceptions** - Reflection throws many checked exceptions
3. **Security** - Be careful with setAccessible(true)
4. **Type Safety** - Use generics where possible
5. **Documentation** - Document reflection usage clearly

## Common Patterns

### Factory Pattern
```java
Object obj = Class.forName(className).getDeclaredConstructor().newInstance();
```

### Property Access
```java
Field field = clazz.getDeclaredField(fieldName);
field.setAccessible(true);
Object value = field.get(object);
```

### Method Invocation
```java
Method method = clazz.getMethod(methodName, paramTypes);
Object result = method.invoke(object, args);
```

## Running the Programs

1. Compile: `javac ProgramName.java`
2. Run: `java ProgramName`
3. Follow prompts for user input where applicable
4. Use `-ea` flag to enable assertions if needed

## Learning Objectives

- Understanding Java Reflection API
- Creating and using custom annotations
- Dynamic object creation and manipulation
- Method interception and proxies
- Building simple frameworks
- Performance profiling techniques
- Dependency injection concepts