package com.example.grammar.function;

import java.util.function.Function;

/**
 * FunctionTest
 *
 * @author fengna
 * @date 19/3/25 21:28
 */
public class FunctionTest {

    public static void main(String[] args) {

        FunctionTest test = new FunctionTest();

        Function<Integer,Integer> computeFunction = a -> a + 10;

        //int result = test.compute(3,computeFunction);
        int result = test.compute(3,test::doMultiply);
        System.out.println("result : " + result);

        String resultStr = test.convert(3,a -> String.valueOf(a) + "na");
        System.out.println("resultStr : " + resultStr);
    }

    private int compute(int a, Function<Integer, Integer> function) {

        return function.apply(a);
    }

    private String convert(int a,Function<Integer,String> function){

        return function.apply(a);
    }

    public int doPlus(int a) {
        return a + 2;
    }

    public int doMinus(int a) {
        return 10 - a;
    }

    public int doMultiply(int a){
        return 2 * a;
    }

    public int doDivide(int a){
        return 6 / a;
    }
}
