package Annotations;

import java.lang.annotation.*;

// Custom deprecation annotation with additional info
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DeprecatedAPI {
    String since();
    String replacement() default "";
    String reason() default "No longer supported";
}