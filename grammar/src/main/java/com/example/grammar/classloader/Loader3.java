package com.example.grammar.classloader;

import java.util.UUID;

/**
 * str的值在编译期不能确定，所以会触发Parent3初始化
 * @author fengna
 * @date 2019/4/15
 */
public class Loader3 {
    public static void main(String[] args) {
        System.out.println(Parent3.str);
    }
}

class Parent3 {

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("Parent3 ...");
    }
}
