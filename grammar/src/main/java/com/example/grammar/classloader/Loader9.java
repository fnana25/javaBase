package com.example.grammar.classloader;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/4/18
 */
public class Loader9 {
    public static void main(String[] args) {
        System.out.println(Child9.a);
        Child9.doSomething();
    }
}

class Parent9 {
    public static int a = 3;

    public static void doSomething(){
        System.out.println("doSomething ...");
    }
}

class Child9 extends Parent9{
    static {
        System.out.println("Child9 ...");
    }
}
