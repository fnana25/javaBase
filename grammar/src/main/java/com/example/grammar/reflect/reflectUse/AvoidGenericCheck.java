package com.example.grammar.reflect.reflectUse;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 类描述：避免泛型检查
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 *
 * @author fengna
 * @since 2021/1/26 15:53
 */
public class AvoidGenericCheck {
    public static void main(String[] args) throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        //    strList.add(100);
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m = listClass.getMethod("add", Object.class);
        //调用add()方法
        m.invoke(strList, 100);

        //遍历集合
        for(Object obj : strList){
            System.out.println(obj);
        }
    }
}
