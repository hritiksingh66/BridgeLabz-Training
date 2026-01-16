package Annotations;

import java.lang.annotation.*;

// Custom annotation for method validation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidateInput {
    int min() default 0;
    int max() default 100;
    String message() default "Invalid input";
}