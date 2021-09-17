package com.example.grammar.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * function接口默认方法的使用
 *
 * @author fengna
 * @date 2019/3/26
 */
public class FunctionUse {

    public static void main(String[] args) {

        FunctionUse test = new FunctionUse();
        System.out.println("Function compose : " + test.computeCompose(10, a -> a * 2, a -> a + 3));
        System.out.println("Function andThen : " + test.computeAndThen(10, a -> a * 2, a -> a + 3));
        System.out.println("BiFunction : " + test.computeBiFunction(10, 5, (a, b) -> a * b));
        System.out.println("BiFunction andThen : " + test.computeBiFunctionAndThen(10, 5, (a, b) -> a * b, a -> a + 8));
    }

    private int computeCompose(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    private int computeAndThen(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    private int computeBiFunction(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    private int computeBiFunctionAndThen(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
