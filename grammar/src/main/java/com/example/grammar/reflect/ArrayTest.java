package com.example.grammar.reflect;

import java.lang.reflect.Array;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/24
 */
public class ArrayTest {

    public static void main(String[] args) throws Exception {
        Class<?> clazzType = Class.forName("java.lang.String");
        Object array1 = Array.newInstance(clazzType, 10);
        Array.set(array1, 0, "a");
        Array.set(array1, 1, "b");
        Array.set(array1, 2, "c");
        System.out.println(Array.get(array1, 1));

        System.out.println("-----------------------");

        int[] dims = new int[]{5, 10, 15};
        //5、10、15的三维数组
        Object array2 = Array.newInstance(Integer.TYPE, dims);
        Object arrayObj = Array.get(array2, 3);
        arrayObj = Array.get(arrayObj, 5);
        Array.setInt(arrayObj, 10, 37);

        int[][][] arrayCast = (int[][][]) array2;
        System.out.println(arrayCast[3][5][10]);
    }
}
