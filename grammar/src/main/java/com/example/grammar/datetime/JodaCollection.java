package com.example.grammar.datetime;

import org.joda.primitives.list.IntList;
import org.joda.primitives.list.impl.ArrayIntList;

/**
 * Joda 原生类型集合
 *
 * @author fengna
 * @date 2019/4/3
 */
public class JodaCollection {

    public static void main(String[] args) {
        IntList list = new ArrayIntList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(System.out::println);
    }
}
