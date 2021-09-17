package com.example.grammar.concurrent.juc;

import java.util.concurrent.Semaphore;

/**
 * 类描述：使用信号量（Semaphore）结束时，务必调用release()方法，释放信号量，如果发生了信号量泄露（申请了但没有释放），
 * 那么能进入临界区的线程会越来越少，直到没有线程能访问。
 *
 * @author fengna
 * @since 2021/2/3 17:42
 */
public class SemaphoreDemo implements Runnable {

    private static Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "线程正在执行。。。");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "线程结束执行");
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new SemaphoreDemo()).start();
        }
    }
}
