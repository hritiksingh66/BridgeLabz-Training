package Annotations;

import java.lang.annotation.*;

// Custom annotation for dependency injection
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Inject {
}