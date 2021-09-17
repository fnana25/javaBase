package com.example.grammar.function.methodreference;

import com.example.grammar.function.methodreference.model.Student;
import com.example.grammar.function.methodreference.model.StudentCompare;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * MethodReferenceUse
 * note : 方法引用的四种方式：
 * 1,类::静态方法
 * 2,对象::实例方法
 * 3,类::实例方法 (这种方式调用时当前对象作为第一个方法参数)
 * 4,类::new
 *
 * @author fengna
 * @date 2019/3/26
 */
public class MethodReferenceUse {
    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                Student.builder().id(1).name("na1").score(89).build(),
                Student.builder().id(2).name("na2").score(90).build(),
                Student.builder().id(3).name("na3").score(91).build(),
                Student.builder().id(4).name("na4").score(92).build(),
                Student.builder().id(5).name("na5").score(93).build()
        );

        //类::静态方法
        list.sort(Student::staticCompareByName);
        System.out.println("Student::staticCompareByName : " + list);

        list.sort(Student::staticCompareByScore);
        System.out.println("Student::staticCompareByScore : " + list);

        //类::实例方法
        list.sort(Student::compareByName);
        System.out.println("Student::CompareByName : " + list);

        list.sort(Student::compareByScore);
        System.out.println("Student::CompareByScore : " + list);

        //实例::实例方法
        StudentCompare studentCompare = new StudentCompare();
        list.sort(studentCompare::compareByName);
        System.out.println("studentCompare::compareByName + " + list);

        list.sort(studentCompare::compareByScore);
        System.out.println("studentCompare::compareByScore : " + list);

        //类::new
        Supplier<Object> supplier = Object::new;
        System.out.println(supplier.get());
    }
}
