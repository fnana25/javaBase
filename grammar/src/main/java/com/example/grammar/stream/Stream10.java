package com.example.grammar.stream;

import java.util.stream.Stream;

/**
 * stream 短路
 *
 * @author fengna
 * @date 2019/3/29
 */
public class Stream10 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("abc","ab","abc");
        //stream.mapToInt(String::length).filter(i -> i == 3).findFirst().ifPresent(System.out::println);

        stream.mapToInt(i -> {
            int length = i.length();
            System.out.println(i);
            return length;
        }).filter(i -> i == 3).findFirst().ifPresent(System.out::println);

    }
}
