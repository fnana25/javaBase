package com.example.grammar.annotation;

/**
 * test
 *
 * @author may
 * @date 19/1/8 21:15
 */
@MyAnnotation(value = "a",hello = "h",world = {"d","f"})
public class Test {

    @Deprecated
    @MyAnnotation(value = "o",hello = "a",world = "q")
    public void output(String message){
        System.out.println(message);
    }
}
