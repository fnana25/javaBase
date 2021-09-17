package com.example.grammar.concurrent.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 类描述：循环栅栏
 * 与倒计数器（CountDownLatch）非常相似，但CyclicBarrier的功能更复杂更强大。CountDownLatch在倒计数结束之后就唤醒线程，
 * 它只能使用一次。而CyclicBarrier的这个计数器可以循环多次使用，还可以接受一个Runnable类型的参数，就是完成一次计数后，系统会执行的动作
 *
 * @author fengna
 * @since 2021/2/3 17:55
 */
public class CyclicBarrierDemo {

    public static void main(String[] args){
        CyclicBarrier barrier = new CyclicBarrier(5, ()->System.err.println("5个线程执行完成，循环完一遍"));
        Random random = new Random();
        for(int i=0; i<20; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "线程开始执行。。。。");
                try {
                    Thread.sleep(random.nextInt(40) * 500);
                    System.err.println(Thread.currentThread().getName() + "线程开始等待");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程继续执行。。。");
            }).start();
        }
    }
}
