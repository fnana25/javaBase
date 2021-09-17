package com.example.grammar.reflect.dynamic;

import java.lang.reflect.Proxy;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/24
 */
public class Test {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        DynamicSubject handler = new DynamicSubject(realSubject);
        /**
         * 大概流程
         *
         * 1、为接口创建代理类的字节码文件
         * 2、使用ClassLoader将字节码文件加载到JVM
         * 3、创建代理类实例对象，执行对象的目标方法
         */
        ISubject subject = (ISubject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler);
        subject.request();
        subject.request2();
    }
}
