package com.example.grammar.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream 的创建方式
 *
 * @author fengna
 * @date 2019/3/27
 */
public class Stream1 {

    public static void main(String[] args) {
        Stream stream1 = Stream.of("a","b","c");

        String[] array = new String[]{"a","b","c"};
        Stream stream2 = Stream.of(array);

        Stream stream3 = Arrays.stream(array);

        List<String> list = Arrays.asList(array);
        Stream stream4 = list.stream();
    }

}
