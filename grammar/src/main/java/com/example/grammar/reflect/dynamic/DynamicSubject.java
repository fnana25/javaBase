package com.example.grammar.reflect.dynamic;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/24
 */
public class DynamicSubject implements InvocationHandler {

    private Object realObject;

    public DynamicSubject(){

    }
    public DynamicSubject(Object target){
        this.realObject = target;
    }

    public void setRealObject(Object object){
        this.realObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("aaaaaaaaaa");
        method.invoke(realObject,args);
        System.out.println("bbbbbbbbbb");
        return null;
    }
}
