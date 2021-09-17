package com.example.grammar.classloader;

/**
 * 根类加载器的getClassLoader返回null
 *
 * @author fengna
 * @date 2019/4/18
 */
public class Loader8 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazzC = Class.forName("com.example.grammar.classloader.C");
        System.out.println(clazzC.getClassLoader());
    }
}

class C{

}
