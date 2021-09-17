package com.example.grammar.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream flatMap
 *
 * @author fengna
 * @date 2019/3/29
 */
public class Stream11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a b","a c","b c");
        list.stream().map(item -> item.split(" "))
                .flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
