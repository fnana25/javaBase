package com.example.grammar.stream;

import java.util.stream.IntStream;

/**
 * range 方法使用
 *
 * @author fengna
 * @date 2019/3/27
 */
public class Stream2 {

    public static void main(String[] args) {

        IntStream.of(1,2,3,4,5).forEach(System.out::print);
        System.out.println();
        IntStream.range(1,6).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1,5).forEach(System.out::print);
    }
}
