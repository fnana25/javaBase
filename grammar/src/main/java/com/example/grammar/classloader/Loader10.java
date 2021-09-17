package com.example.grammar.classloader;

/**
 * 数组的加载器是数组中元素的加载器
 * String[] 的类加载器是根加载器
 * int[] 等原生数据类型没有类加载器
 *
 * @author fengna
 * @date 2019/4/18
 */
public class Loader10 {

    public static void main(String[] args) {
        String[] arr = new String[5];
        System.out.println(arr.getClass().getClassLoader());

        System.out.println("============");

        Loader10[] arr2 = new Loader10[2];
        System.out.println(arr2.getClass().getClassLoader());

        System.out.println("============");
        int[] arr3 = new int[3];
        System.out.println(arr3.getClass().getClassLoader());
    }


}
