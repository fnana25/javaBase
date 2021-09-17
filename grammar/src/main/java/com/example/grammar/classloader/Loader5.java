package com.example.grammar.classloader;

import java.util.Random;

/**
 *  当一个接口初始化的时候并不要求其父接口都完成了初始化，
 *  只有当真正使用到了父接口（如引用父接口中的常量时）才会初始化
 * @author fengna
 * @date 2019/4/15
 */
public class Loader5 {

    public static void main(String[] args) {
        System.out.println(Child5.b);
    }
}

interface Parent5 {
     public static final int a = new Random().nextInt(5);
}

interface Child5 extends Parent5{
    public static final int b = new Random().nextInt(6);
}
