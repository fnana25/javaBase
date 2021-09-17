package com.example.grammar.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * generate iterate summaryStatistics
 *
 * @author fengna
 * @date 2019/3/28
 */
public class Stream6 {

    public static void main(String[] args) {

        Stream<String> uuidStream = Stream.generate(UUID.randomUUID()::toString);
        uuidStream.findFirst().ifPresent(System.out::println);

        Stream<Integer> intStream = Stream.iterate(1,i -> i + 2).limit(10);
        System.out.println(intStream.filter(i -> i > 20).mapToInt(i -> i * 2).skip(2).limit(3).sum());
        intStream.filter(i -> i > 20).mapToInt(i -> i * 2).skip(2).limit(3).max().ifPresent(System.out::println);

        IntSummaryStatistics summaryStatistics = intStream.filter(i -> i > 30).mapToInt(i -> i * 2).skip(1).limit(5).summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getSum());

    }
}
