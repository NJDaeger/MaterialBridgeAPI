package com.njdaeger.mbapi.version;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a material for version 1.13+
 */
@Target( ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME)
public @interface v113 {
}
