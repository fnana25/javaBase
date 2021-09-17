package com.example.grammar.classloader;

/**
 *  常量在编译阶段会存入到调用这个方法所在的类的常量池中，
 *  本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 *
 *  注意：这里指的是将常量存放到了Loader2的常量池中，之后Loader2与Parent2已经没有任何关系了，甚至可以将Parent2的class文件删除
 * @author fengna
 * @date 2019/4/15
 */
public class Loader2 {

    public static void main(String[] args) {
        System.out.println(Parent2.str);
    }
}

class Parent2 {

    public static final String str = "Parent2";
    public static final short s = 127;
    public static final int i = 200;
    public static final int ii = 5;

    static {
        System.out.println("Parent2 ...");
    }
}
