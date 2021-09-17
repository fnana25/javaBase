package com.example.grammar.function.defaultmethod;

/**
 * DefaultMethodOneImpl
 *
 * @author fengna
 * @date 2019/3/26
 */
public class DefaultMethodOneImpl implements DefaultMethodOne {

    @Override
    public int defaultMethod(int a, int b) {
        return a + b + 10;
    }
}
