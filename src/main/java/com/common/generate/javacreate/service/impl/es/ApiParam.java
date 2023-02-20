package com.common.generate.javacreate.service.impl.es;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xialei
 * @date 2021/12/2 13:38
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiParam {
    String description();

    String defaultValue() default "";

    boolean required() default false;

    boolean hidden() default false;

    String example() default "";
}
