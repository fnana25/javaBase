package com.example.grammar.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 转数组和集合
 *
 * @author fengna
 * @date 2019/3/27
 */
public class Stream4 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("a","b","c","d","e","f");

        String[] array = stream.toArray(String[]::new);

        Arrays.asList(array).forEach(System.out::println);

        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(ArrayList::new,(lastList,item) -> lastList.add(item),(theList1,theList2) -> theList1.addAll(theList2));
        List<String> list3 = stream.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
        List<String> list4 = stream.collect(Collectors.toCollection(LinkedList::new));
        List<String> list5 = stream.collect(Collectors.toCollection(ArrayList::new));

        list5.forEach(System.out::println);
        System.out.println(stream.collect(Collectors.joining(" ")));
    }
}
