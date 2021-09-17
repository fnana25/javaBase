package com.example.grammar.concurrent.volatile_example.model;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/2/2 14:11
 */
public class Counter {

    private volatile int count = 0;

    public void inc(){
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    @Override
    public String toString() {
        return "[count=" + count + "]";
    }
}
