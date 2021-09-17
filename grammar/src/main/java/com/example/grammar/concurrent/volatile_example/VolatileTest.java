package com.example.grammar.concurrent.volatile_example;

import com.example.grammar.concurrent.volatile_example.model.Counter;

/**
 * 类描述：线程并发问题
 * <p>
 * 在 java 的内存模型中每一个线程运行时都有一个线程栈，线程栈保存了线程运行时候变量值信息。当线程访问某一个对象值的时候，
 * 首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存变量的具体值load到线程本地内存中，建立一个变量副本，
 * 之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本变量的值，在修改完之后的某一个时刻（线程退出之前），
 * 自动把线程变量副本的值回写到对象在堆中变量。这样在堆中的对象的值就产生变化了。
 * 下面主函数中开启了 1000 个子线程，每个线程都有一个变量副本，每个线程修改变量只是临时修改了自己的副本，当线程结束时再将修改的值写入在主内存中，
 * 这样就出现了线程安全问题。因此结果就不可能等于1000了，一般都会小于1000。
 *
 * @author fengna
 * @since 2021/2/2 14:11
 */
public class VolatileTest {

    public static void main(String[] args) {

        final Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> counter.inc()).start();
            System.out.println(counter);
        }
        System.out.println("counter: "+counter);
    }
}
