package com.example.grammar.concurrent.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类描述：读写锁性能对比
 *
 * @author fengna
 * @since 2021/2/3 16:47
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();
        Lock lock = new ReentrantLock();

        Thread[] threads = new Thread[20];

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(()->{
//                ReadWriteLockDemo.lockTest(readLock);
                ReadWriteLockDemo.lockTest(writeLock);
//                ReadWriteLockDemo.lockTest(lock);
            });
        }

        long currTime = System.currentTimeMillis();
        for (Thread t : threads){
            t.start();
        }
        for (Thread t : threads){
            t.join();
        }
        System.out.println("共耗时：" + (System.currentTimeMillis() - currTime));
    }

    public static void lockTest(Lock lock){

        lock.lock();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
