package com.example.grammar.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * flatMap
 *
 * @author fengna
 * @date 2019/3/28
 */
public class Stream5 {

    public static void main(String[] args) {

//        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2),Arrays.asList(1,23,4),Arrays.asList(11,2,34,89));
//        stream.flatMap(list -> list.stream()).map(i -> i * 2).forEach(System.out::println);

        Map<Long,List<Long>> map = new HashMap<>(3);
        map.put(1L,Arrays.asList(1L,2L));
        map.put(2L,Arrays.asList(1L,22L));
        map.put(3L,Arrays.asList(111L,22L));
        List<Long> rest = map.values().stream().flatMap(list -> list.stream()).distinct().collect(Collectors.toList());

        System.out.println(rest);
    }
}
