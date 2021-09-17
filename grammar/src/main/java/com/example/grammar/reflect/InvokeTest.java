package com.example.grammar.reflect;

import java.lang.reflect.Method;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/22
 */
public class InvokeTest {

    public int add(int a, int b) {
        return a + b;
    }

    public String echo(String message) {
        return "hello" + message;
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = InvokeTest.class;
        Object invokeTest = clazz.newInstance();
        Method method = clazz.getMethod("add",int.class,int.class);
        Object result = method.invoke(invokeTest,1,2);
        System.out.println(result);

        Method method1 = clazz.getMethod("echo",String.class);
        Object result1 = method1.invoke(invokeTest,"test");
        System.out.println(result1);
    }
}
