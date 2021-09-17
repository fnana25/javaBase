package com.example.grammar.function.defaultmethod;

/**
 * DefaultMethodOne
 *
 * @author fengna
 * @date 2019/3/26
 */
public interface DefaultMethodOne {

    default int defaultMethod(int a,int b){
        return a + b;
    }
}
