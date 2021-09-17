package com.example.grammar.stream;

import java.util.Arrays;
import java.util.List;

/**
 * reduce 方法的使用
 *
 * @author fengna
 * @date 2019/3/27
 */
public class Stream3 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list.stream().map(i -> i * 2).reduce(0,Integer::sum));
    }
}
