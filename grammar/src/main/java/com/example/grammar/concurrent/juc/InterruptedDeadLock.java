package com.example.grammar.concurrent.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述：死锁 中断
 *
 * @author fengna
 * @since 2021/2/3 13:48
 */
public class InterruptedDeadLock implements Runnable {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int num;

    InterruptedDeadLock(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行。。。");
        if (num == 1) {
            try {
                lock1.lock();
                System.out.println(Thread.currentThread().getName() + "线程获取了lock1的锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + "线程开始获取lock2的锁");
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "线程成功获取lock2的锁");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "线程被中断");
            } finally {
                if (lock2.isHeldByCurrentThread()) {
                    System.out.println(Thread.currentThread().getName() + "线程释放lock2锁");
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "线程释放lock1锁");
                lock1.unlock();
            }
        } else {
            try {
                lock2.lock();
                System.out.println(Thread.currentThread().getName() + "线程获取了lock2的锁。");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + "线程开始获取lock1锁");
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "线程成功获取lock1锁");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "线程被中断");
            }finally {
                if(lock1.isHeldByCurrentThread()){
                    System.out.println(Thread.currentThread().getName() + "线程释放lock1锁");
                    lock1.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "线程释放lock2锁");
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new InterruptedDeadLock(1),"t1");
        Thread thread2 = new Thread(new InterruptedDeadLock(2),"t2");

        thread1.start();
        thread2.start();

        Thread.sleep(2000);
        System.out.println("中断线程：" + thread2.getName());
        thread2.interrupt();
    }
}
