package Annotations;

import java.lang.annotation.*;

// Custom annotation for transaction management
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {
    String value() default "default";
    boolean readOnly() default false;
    int timeout() default 30;
}