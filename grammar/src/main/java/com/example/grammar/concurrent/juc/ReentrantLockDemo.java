package com.example.grammar.concurrent.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/2/3 11:04
 */
public class ReentrantLockDemo implements Runnable{

    private static int count = 0;

    private static ReentrantLock lock = new ReentrantLock();
    //公平锁
//    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        //获取锁，如果锁已被占用，则等待
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程抢到了锁");
            count++;
        }finally {
            System.out.println(Thread.currentThread().getName() + "线程释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        Thread thread1 = new Thread((demo));
        Thread thread2 = new Thread((demo));
        Thread thread3 = new Thread((demo));

        thread1.start();
        thread2.start();
        thread3.start();


        thread3.join();
        thread1.join();
        thread2.join();
        System.out.println("count = " + count);
    }
}
