package com.example.grammar.classloader;

/**
 * Child.str1 没有导致对子类的主动使用,访问父类静态成员变量导致对父类主动使用
 * Child.str2 加载子类时首先加载父类
 * @author fengna
 * @date 2019/4/15
 */
public class Loader1 {

    public static void main(String[] args) {
        System.out.println(Child.str1);
    }
}

class Parent{

    public static String str1 = "parent";

    static {
        System.out.println("parent .3...");
    }

}

class Child extends Parent{

    public static String str2 = "child";

    static {
        System.out.println("child ....");
    }
}
