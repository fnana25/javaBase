package com.example.grammar.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate use
 *
 * @author fengna
 * @date 2019/3/26
 */
public class PredicateUse {

    public static void main(String[] args) {

        PredicateUse test = new PredicateUse();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        test.conditionFilter(list, (i) -> i > 5);
        test.conditionFilter(list, (i) -> i > 5, (i) -> i % 2 == 0);
    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (int i : list) {
            if (predicate.test(i)) {
                System.out.println("predicate : " + i);
            }
        }
    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (int i : list) {
            if (predicate1.and(predicate2).negate().test(i)) {
                System.out.println("predicate and negate : " + i);
            }
        }
    }
}
