package com.example.grammar.classloader;

/**
 * 助记符：
 * newarray 表示创建一个引用类型（如类，接口，数组）的数组，并将其引用值压入栈顶
 * newarray 表示创建一个原始类型的数组，并将其引用值压入栈顶
 * @author fengna
 * @date 2019/4/15
 */
public class Loader4 {

    public static void main(String[] args) {
        //new对象是对类的主动使用，会触发Parent4初始化
        //Parent4 parent4 = new Parent4();

        //[Lcom.test.jvm.classloader.Parent4 是由jvm运行期动态出来的类型，其父类就是Object,
        //对于数组来说，javadoc经常将构成数组的元素称为component，即数组降低一个维度后的类型
        Parent4[] array1 = new Parent4[3];
        System.out.println(array1.getClass());

        Parent4[][] array2 = new Parent4[3][4];
        System.out.println(array2.getClass());

        System.out.println("==============");

        int[] intArray = new int[5];
        System.out.println(intArray.getClass());
        System.out.println(intArray.getClass().getSuperclass());

        char[] charArray = new char[5];
        boolean[] booleanArray = new boolean[5];
    }
}

class Parent4 {

    static {
        System.out.println("Parent4 ...");
    }
}
