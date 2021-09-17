package com.example.grammar.stream2;

import com.example.grammar.stream2.model.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 布尔值排序
 *
 * @author fengna
 * @date 2019/7/18
 */
public class ComparingBoolean {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                Student.builder().flag(true).score(12).name("a").build(),
                Student.builder().flag(false).score(16).name("b").build(),
                Student.builder().flag(true).score(14).name("c").build(),
                Student.builder().flag(true).score(12).name("d").build(),
                Student.builder().flag(false).score(16).name("e").build(),
                Student.builder().flag(true).score(14).name("f").build(),
                Student.builder().flag(true).score(12).name("g").build(),
                Student.builder().flag(false).score(16).name("h").build(),
                Student.builder().flag(true).score(14).name("i").build(),
                Student.builder().flag(false).score(11).name("j").build()
        );
        Collections.sort(list,Comparator.comparing(Student::getFlag).reversed().thenComparingInt(Student::getScore));
        System.out.println(list);

    }

}
