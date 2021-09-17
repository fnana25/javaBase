package com.example.grammar.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/24
 */
public class BeanCopyTest {

    public static void main(String[] args) throws Exception {
        Student source = new Student();
        source.setAge(12);
        source.setName("nana");
        source.setSex("女");
        Student student = (Student) copyBean(source,new Student());
        System.out.println(student);
    }

    private static Object copyBean(Object source, Object target) throws Exception {
        Class<?> clazz = source.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            String getName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            String setName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method getMethed = clazz.getDeclaredMethod(getName);
            Method setMethed = clazz.getDeclaredMethod(setName, new Class[]{field.getType()});
            Object value = getMethed.invoke(source);
            setMethed.invoke(target, new Object[]{value});
        }
        return target;
    }
}

class Student {
    private String name;
    private String sex;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getSex() {
        return this.sex;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name + "," + this.sex + "," + this.age;
    }
}
