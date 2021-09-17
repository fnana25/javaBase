package com.example.grammar.reflect;

import java.lang.reflect.Method;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/22
 */
public class DumpMethods {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods){
            System.out.println(m);
        }
    }
}
