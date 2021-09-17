package com.example.grammar.concurrent.juc;

import java.util.concurrent.Semaphore;

/**
 * 类描述：
 * 三个线程 a、b、c 并发运行，b,c 需要 a 线程的数据怎么实现
 * 分析过程如下：
 * 根据问题的描述，我将问题用以下代码演示，ThreadA、ThreadB、ThreadC，ThreadA 用于初始化数据 num，只有当num初始化完成之后再让ThreadB和ThreadC获取到初始化后的变量num。
 * 考虑到多线程的不确定性，因此我们不能确保ThreadA就一定先于ThreadB和ThreadC前执行，就算ThreadA先执行了，我们也无法保证ThreadA什么时候才能将变量num给初始化完成。
 * 因此我们必须让ThreadB和ThreadC去等待ThreadA完成任务后发出消息。
 *
 *
 * 定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程，
 * 线程的阻塞和释放是通过 permit 概念来实现的
 * 线程通过 semaphore.acquire()方法获取 permit，如果当前 semaphore 有 permit 则分配给该线程，
 * 如果没有则阻塞该线程直到 semaphore
 * 用 release（）方法释放 permit。
 * @author fengna
 * @since 2021/2/2 15:19
 */
public class SemaphoreDemo2 {

    private static int num;

    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(()-> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num++;
                semaphore.release(2);
        });

        Thread threadB = new Thread(()-> {
                try {
                    //获取 permit，如果 semaphore 没有可用的 permit 则等待，如果有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"获取到 num 的值为："+num);
        });

        Thread threadC = new Thread(()-> {
                try {
                    //获取 permit，如果 semaphore 没有可用的 permit 则等待，如果有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"获取到 num 的值为："+num);
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
