package com.example.grammar.classloader;

/**
 * 静态代码块只在类初始化的时候执行一次；实例代码块每次实例化都会执行
 *
 * @author fengna
 * @date 2019/4/18
 */
public class Loader7 {

    public static void main(String[] args) {
//        System.out.println(Child7.a);
        new Child7();
        new Child7();
    }
}

interface Parent7{

    public static final Thread thread = new Thread(){
        {
            System.out.println("Parent7 thread init ...");
        }
    };
}

class Child7 implements Parent7{

    public static int a = 5;

    static {
        System.out.println("静态代码块...");
    }

    {
        System.out.println("实例代码块...");
    }
    public Child7(){
        System.out.println("Child7 ...");
    }
}
