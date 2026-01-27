# Java Interface Examples

This project demonstrates various types of interfaces in Java with practical real-world scenarios.

## Project Structure

```
Functional-Interface/
├── Basic-Interfaces/
│   ├── SmartDeviceControl.java      # Smart home device control
│   ├── VehicleRentalSystem.java     # Multi-vehicle rental system
│   └── DigitalPaymentSystem.java    # Payment method implementations
├── Functional-Interfaces/
│   ├── TemperatureAlertSystem.java  # Predicate<Double> for alerts
│   ├── StringLengthChecker.java     # Function<String, Integer>
│   └── BackgroundJobExecution.java  # Runnable for async tasks
├── Static-Methods/
│   ├── PasswordStrengthValidator.java # Security utilities
│   ├── UnitConversionTool.java      # Logistics conversions
│   └── DateFormatUtility.java       # Invoice date formatting
├── Default-Methods/
│   ├── PaymentGatewayIntegration.java # Payment processor with refund
│   ├── DataExportFeature.java       # Report exporter with JSON
│   └── SmartVehicleDashboard.java   # Vehicle dashboard features
└── Marker-Interfaces/
    ├── DataSerializationBackup.java # BackupSerializable marker
    ├── CloningPrototypeObjects.java # Cloneable for prototypes
    └── SensitiveDataTagging.java    # Custom SensitiveData marker
```

## 1. Basic Interfaces

### SmartDeviceControl.java
- **Interface**: `SmartDevice` with `turnOn()` and `turnOff()` methods
- **Implementations**: SmartLight, SmartAC, SmartTV
- **Use Case**: Home automation system

### VehicleRentalSystem.java
- **Interface**: `Rentable` with `rent()` and `returnVehicle()` methods
- **Implementations**: Car, Bike, Bus
- **Use Case**: Vehicle rental management

### DigitalPaymentSystem.java
- **Interface**: `PaymentMethod` with `pay()` method
- **Implementations**: UPIPayment, CreditCardPayment, WalletPayment
- **Use Case**: Payment processing system

## 2. Functional Interfaces

### TemperatureAlertSystem.java
- **Functional Interface**: `Predicate<Double>`
- **Use Case**: Temperature monitoring with threshold alerts
- **Features**: High, low, and critical temperature detection

### StringLengthChecker.java
- **Functional Interface**: `Function<String, Integer>`
- **Use Case**: Message length validation for character limits
- **Features**: Length checking and status reporting

### BackgroundJobExecution.java
- **Functional Interface**: `Runnable`
- **Use Case**: Asynchronous task execution
- **Features**: Data backup, email notifications, report generation

## 3. Static Methods in Interfaces

### PasswordStrengthValidator.java
- **Interface**: `SecurityUtils`
- **Static Methods**: `checkPasswordStrength()`, `displayPasswordRequirements()`
- **Use Case**: Insurance portal password validation
- **Features**: Strength scoring, requirement display

### UnitConversionTool.java
- **Interface**: `UnitConverter`
- **Static Methods**: Distance, weight, and temperature conversions
- **Use Case**: Logistics software unit conversions
- **Features**: km↔miles, kg↔lbs, °C↔°F conversions

### DateFormatUtility.java
- **Interface**: `DateFormatter`
- **Static Methods**: Multiple date format conversions
- **Use Case**: Invoice generator date formatting
- **Features**: ISO, US, European, long, short formats

## 4. Default Methods in Interfaces

### PaymentGatewayIntegration.java
- **Interface**: `PaymentProcessor`
- **Default Method**: `refund()` - added without breaking existing implementations
- **Use Case**: Payment gateway integration with backward compatibility
- **Features**: PayPal (uses default), Stripe (custom implementation)

### DataExportFeature.java
- **Interface**: `DataExporter`
- **Default Method**: `exportToJSON()` - added later for JSON support
- **Use Case**: Reporting module with new export format
- **Features**: CSV, PDF (existing), JSON (new default method)

### SmartVehicleDashboard.java
- **Interface**: `VehicleDashboard`
- **Default Method**: `displayBatteryPercentage()` - for electric vehicles
- **Use Case**: Vehicle dashboard with electric vehicle features
- **Features**: Regular cars, electric cars, hybrid cars

## 5. Marker Interfaces

### DataSerializationBackup.java
- **Marker Interface**: `BackupSerializable`
- **Use Case**: Mark classes for backup processing
- **Features**: Automatic serialization for marked classes only

### CloningPrototypeObjects.java
- **Marker Interface**: `Cloneable`
- **Use Case**: Prototype pattern for object cloning
- **Features**: Product and user profile prototypes with customization

### SensitiveDataTagging.java
- **Custom Marker Interface**: `SensitiveData`
- **Use Case**: Mark sensitive data classes for encryption
- **Features**: Customer, financial, medical data encryption

## How to Run

1. Navigate to any subfolder
2. Compile: `javac *.java`
3. Run: `java [ClassName]`

Example:
```bash
cd Basic-Interfaces
javac SmartDeviceControl.java
java SmartDeviceControl
```

## Key Learning Points

1. **Basic Interfaces**: Contract definition and multiple implementations
2. **Functional Interfaces**: Single abstract method interfaces for lambda expressions
3. **Static Methods**: Utility methods that belong to the interface
4. **Default Methods**: Backward compatibility when adding new features
5. **Marker Interfaces**: Tagging classes for special processing

## Best Practices Demonstrated

- Interface segregation principle
- Backward compatibility with default methods
- Utility methods as static interface methods
- Marker interfaces for metadata
- Functional programming with built-in functional interfaces