package com.example.grammar.function.defaultmethod;

/**
 * DefaultMethodUse
 * note : 子类实现的多个接口有相同默认方法时，编译器无法判断，子类需要重写
 *
 * @author fengna
 * @date 2019/3/26
 */
public class DefaultMethodUse2 implements DefaultMethodOne, DefaultMethodTwo {

    public static void main(String[] args) {
        DefaultMethodUse2 test = new DefaultMethodUse2();
        int result = test.defaultMethod(2, 3);
        System.out.println(result);
    }

    @Override
    public int defaultMethod(int a, int b) {
        return a + b + 20;
    }
}
