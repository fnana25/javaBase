package com.example.grammar.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 调用了终止操作才会执行中间操作
 *
 * @author fengna
 * @date 2019/3/28
 */
public class Stream7 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("a","b","c");
//
//        stream.map(String::toUpperCase).forEach(System.out::println);

        stream.map(i -> {
            String result = i.toUpperCase();
            System.out.println(result);
            return result;
        }).forEach(System.out::println);

    }
}
