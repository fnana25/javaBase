package com.example.grammar.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * parallelStream
 *
 * @author fengna
 * @date 2019/3/28
 */
public class Stream9 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(500000);

        for (int i = 0; i < 500000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("排序开始 ==================");

        long startTime = System.nanoTime();

        list.parallelStream().sorted().forEach(System.out::println);

        long endTime = System.nanoTime();

        long sortTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println("排序耗时 ： " + sortTime);
    }

}
