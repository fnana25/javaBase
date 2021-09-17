package com.example.grammar.concurrent.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 类描述：倒计数器
 * 倒计数器（CountDownLatch）通常用来控制线程等待，它可以让一个线程等待直到倒计数结束后再执行。
 * 生活中这样的场景很多，举个例子。工厂里生产一个产品，先是在各个车间里制造产品的组件，所有组件制造好后再组装起来，这个例子可能不是很恰当
 *
 * @author fengna
 * @since 2021/2/3 17:50
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(new Random().nextInt(10)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行结束，计数减一。");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("主线程执行结束。");
    }
}
