package Reflections;
import java.lang.reflect.*;

// Interface
interface Greeting {
    void sayHello(String name);
    String getMessage();
}

// Implementation
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    @Override
    public String getMessage() {
        return "Welcome to Reflection!";
    }
}

// Invocation handler for logging
class LoggingHandler implements InvocationHandler {
    private Object target;
    
    public LoggingHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log before method execution
        System.out.println("[LOG] Calling method: " + method.getName());
        
        // Execute actual method
        Object result = method.invoke(target, args);
        
        // Log after method execution
        System.out.println("[LOG] Method " + method.getName() + " completed");
        
        return result;
    }
}

public class DynamicProxyLogging {
    
    public static void main(String[] args) {
        // Create actual object
        Greeting greeting = new GreetingImpl();
        
        // Create proxy with logging
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingHandler(greeting)
        );
        
        // Call methods through proxy
        proxy.sayHello("Alice");
        System.out.println();
        String msg = proxy.getMessage();
        System.out.println("Returned: " + msg);
    }
}