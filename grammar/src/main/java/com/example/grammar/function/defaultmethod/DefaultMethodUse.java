package com.example.grammar.function.defaultmethod;

/**
 * DefaultMethodUse
 * note : java默认继承类的优先级高于实现的接口
 *
 * @author fengna
 * @date 2019/3/26
 */
public class DefaultMethodUse extends DefaultMethodOneImpl implements DefaultMethodTwo {

    public static void main(String[] args) {
        DefaultMethodUse test = new DefaultMethodUse();
        int result = test.defaultMethod(2, 3);
        System.out.println(result);
    }
}
