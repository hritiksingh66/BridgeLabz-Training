package Annotations;

import java.lang.annotation.*;

// Custom annotation to mark methods for logging
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {
    String value() default "INFO";
    boolean logParams() default true;
    boolean logResult() default true;
}