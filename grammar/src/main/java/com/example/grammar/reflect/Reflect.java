package com.example.grammar.reflect;

import com.example.grammar.reflect.model.StudentRef;

/**
 * 类描述：获取class对象的方法
 *
 * 注意：在运行期间，一个类，只有一个Class对象产生。
 * 三种方式常用第三种，第一种对象都有了还要反射干什么。第二种需要导入类的包，依赖太强，不导包就抛编译错误。
 * 一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法。
 *
 * @author fengna
 * @since 2021/1/26 15:28
 */
public class Reflect {

    public static void main(String[] args) {

        //第一种方式获取Class对象
        StudentRef stu1 = new StudentRef();
        Class stuClass = stu1.getClass();
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        Class stuClass2 = StudentRef.class;
        //判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
        System.out.println(stuClass == stuClass2);

        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("com.example.grammar.reflect.model.StudentRef");
            //判断三种方式是否获取的是同一个Class对象
            System.out.println(stuClass3 == stuClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
