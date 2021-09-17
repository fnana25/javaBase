package com.example.grammar.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {

    String value();

    String hello() default "hello";

    String[] world();
}
