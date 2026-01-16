package Annotations;

import java.lang.annotation.*;

// Custom annotation to track author information
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Author {
    String name();
    String date() default "Unknown";
    String version() default "1.0";
}