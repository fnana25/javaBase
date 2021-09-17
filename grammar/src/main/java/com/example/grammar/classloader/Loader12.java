package com.example.grammar.classloader;

/**
 *  在运行期，一个java类是由类的完全限定名（binary name 二进制名）和用于加载该类的定义加载器所共同决定的，
 *  如果同样名字（即相同限定名）的类是由两个不同的加载器加载，那么这些类是不同的，即便.class文件的字节码都一样，
 *  并且从相同的位置加载亦如此
 *
 * @author fengna
 * @date 2019/4/23
 */
public class Loader12 {

    public static void main(String[] args) {
        //启动类加载器加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        //扩展类加载器加载路径
        System.out.println(System.getProperty("java.ext.dirs"));
        //应用类加载器加载路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
