package com.example.grammar.reflect.dynamic;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/24
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("realSubject......");
    }

    @Override
    public void request2() {
        System.out.println("request2......");
    }
}
