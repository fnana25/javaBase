package com.example.grammar.stream2;

import com.example.grammar.stream2.model.Student;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * collects 方法使用
 *
 * @author fengna
 * @date 19/4/1 20:32
 */
public class Stream1 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                Student.builder().name("na1").score(96).build(),
                Student.builder().name("na1").score(3).build(),
                Student.builder().name("na3").score(99).build(),
                Student.builder().name("na4").score(88).build(),
                Student.builder().name("na4").score(6).build()
        );
//
//        List<Student> students1 = students.stream().collect(toList());
//        students1.forEach(System.out::println);
//        System.out.println("--------------------");
//
//        System.out.println("count : " + students.stream().collect(counting()));
//        System.out.println("count : " + students.stream().count());
//        System.out.println("---------------------");
//
//        students.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
//        students.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
//        System.out.println(students.stream().collect(averagingInt(Student::getScore)));
//        System.out.println(students.stream().collect(summarizingInt(Student::getScore)));
//        IntSummaryStatistics intSummaryStatistics = students.stream().collect(summarizingInt(Student::getScore));
//
//        System.out.println(intSummaryStatistics);
//        System.out.println("---------------------");
//
//        System.out.println(students.stream().map(Student::getName).collect(joining()));
//        System.out.println(students.stream().map(Student::getName).collect(joining(",")));
//        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(",","start===","===end")));
//
//        System.out.println("---------------------");
//
//        Map<Integer,Map<String,List<Student>>> map1 = students.stream().collect(groupingBy(Student::getScore,groupingBy(Student::getName)));
//        Map<Boolean,Map<Boolean,List<Student>>> map2 = students.stream().collect(partitioningBy(s -> s.getScore() > 90,partitioningBy(s -> s.getScore() > 98)));
//        Map<Boolean,Long> map3 = students.stream().collect(partitioningBy(s -> s.getScore() > 90,counting()));
//
//        Map<String,Student> map4 = students.stream().collect(groupingBy(Student::getName,collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)),Optional::get)));
//
//        System.out.println("map1 : " + map1);
//        System.out.println("map2 : " + map2);
//        System.out.println("map3 : " + map3);
//        System.out.println("map4 : " + map4);

        Map<String, Integer> map = students.stream().collect(groupingBy(Student::getName,Collectors.summingInt(Student::getScore)));
        System.out.println(map);
    }


}
