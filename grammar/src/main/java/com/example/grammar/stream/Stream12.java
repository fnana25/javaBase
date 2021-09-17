package com.example.grammar.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream 组合
 *
 * @author fengna
 * @date 2019/3/29
 */
public class Stream12 {
    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a","b","c");
        List<String> list2 = Arrays.asList("A","B","C");

        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
    }
}
