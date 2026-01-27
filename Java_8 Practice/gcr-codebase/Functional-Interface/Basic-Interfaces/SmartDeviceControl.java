// Smart Device Control Interface
interface SmartDevice {
    void turnOn();
    void turnOff();
}

// Light implementation
class SmartLight implements SmartDevice {
    private String location;
    
    public SmartLight(String location) {
        this.location = location;
    }
    
    @Override
    public void turnOn() {
        System.out.println(location + " light turned ON");
    }
    
    @Override
    public void turnOff() {
        System.out.println(location + " light turned OFF");
    }
}

// AC implementation
class SmartAC implements SmartDevice {
    private int temperature;
    
    public SmartAC(int temperature) {
        this.temperature = temperature;
    }
    
    @Override
    public void turnOn() {
        System.out.println("AC turned ON at " + temperature + "°C");
    }
    
    @Override
    public void turnOff() {
        System.out.println("AC turned OFF");
    }
}

// TV implementation
class SmartTV implements SmartDevice {
    private String channel;
    
    public SmartTV(String channel) {
        this.channel = channel;
    }
    
    @Override
    public void turnOn() {
        System.out.println("TV turned ON - Channel: " + channel);
    }
    
    @Override
    public void turnOff() {
        System.out.println("TV turned OFF");
    }
}

public class SmartDeviceControl {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartLight("Living Room"),
            new SmartAC(24),
            new SmartTV("Netflix")
        };
        
        // Turn on all devices
        for (SmartDevice device : devices) {
            device.turnOn();
        }
        
        System.out.println();
        
        // Turn off all devices
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }
}