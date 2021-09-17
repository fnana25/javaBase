package com.example.grammar.function.defaultmethod;

/**
 * DefaultMethodTwo
 *
 * @author fengna
 * @date 2019/3/26
 */
public interface DefaultMethodTwo {

    default int defaultMethod(int a,int b){
        return a * b;
    }
}
