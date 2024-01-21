package com.dagy.cafeheroapi.core.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Dagnogo Yaya
 * @since 21/20/24
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Interactor {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
