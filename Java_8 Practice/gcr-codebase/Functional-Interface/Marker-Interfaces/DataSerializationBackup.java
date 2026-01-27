import java.io.*;

// Marker interface for backup serialization
interface BackupSerializable {
    // Marker interface - no methods
}

// User data class marked for backup
class UserData implements BackupSerializable, Serializable {
    private String username;
    private String email;
    private transient String password; // Not serialized for security
    
    public UserData(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "UserData{username='" + username + "', email='" + email + "'}";
    }
}

// Configuration class marked for backup
class SystemConfig implements BackupSerializable, Serializable {
    private String configName;
    private String value;
    
    public SystemConfig(String configName, String value) {
        this.configName = configName;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "SystemConfig{configName='" + configName + "', value='" + value + "'}";
    }
}

// Regular class not marked for backup
class TemporaryData {
    private String tempValue;
    
    public TemporaryData(String tempValue) {
        this.tempValue = tempValue;
    }
    
    @Override
    public String toString() {
        return "TemporaryData{tempValue='" + tempValue + "'}";
    }
}

// Backup processor utility
class BackupProcessor {
    
    public static void processForBackup(Object obj) {
        if (obj instanceof BackupSerializable) {
            System.out.println("✅ Processing for backup: " + obj.getClass().getSimpleName());
            serializeObject(obj);
        } else {
            System.out.println("❌ Skipping backup (not marked): " + obj.getClass().getSimpleName());
        }
    }
    
    private static void serializeObject(Object obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            
            System.out.println("   Serialized successfully - Size: " + baos.size() + " bytes");
            System.out.println("   Data: " + obj);
        } catch (IOException e) {
            System.out.println("   Serialization failed: " + e.getMessage());
        }
        System.out.println();
    }
}

public class DataSerializationBackup {
    
    public static void main(String[] args) {
        System.out.println("=== Data Backup Processing ===\n");
        
        Object[] objects = {
            new UserData("john_doe", "john@example.com", "secret123"),
            new SystemConfig("max_connections", "100"),
            new TemporaryData("temp_session_data"),
            new UserData("jane_smith", "jane@example.com", "password456")
        };
        
        for (Object obj : objects) {
            BackupProcessor.processForBackup(obj);
        }
    }
}