package com.example.grammar.concurrent.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述：interrupted
 *
 * lock()与lockInterruptibly()的区别：
 * lock 优先考虑获取锁，待获取锁成功后，才响应中断。
 * lockInterruptibly 优先考虑响应中断，而不是响应锁的普通获取或重入获取。
 *
 * ReentrantLock.lockInterruptibly允许在等待时由其它线程调用等待线程的Thread.interrupt方法来中断等待线程的等待而直接返回，这时不用获取锁，
 * 而会抛出一个InterruptedException。 ReentrantLock.lock方法不允许Thread.interrupt中断,即使检测到Thread.isInterrupted,一样会继续尝试获取锁，
 * 失败则继续休眠。只是在最后获取锁成功后再把当前线程置为interrupted状态,然后再中断线程。
 * @author fengna
 * @since 2021/2/3 13:54
 */
public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread thread = new Thread(()-> {
                lock.lock();
//                try {
//                    lock.lockInterruptibly();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + "interrupted");
        });
        thread.start();
        Thread.sleep(1000);
        //即使执行了interrupt()方法也没有反应。
        //将注释代码取消掉，会发现，程序要求捕捉该异常
        thread.interrupt();
        Thread.sleep(1000000);
    }
}
