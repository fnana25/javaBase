package com.example.grammar.concurrent.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * 类描述：
 *
 * 线程池
 * 固定容量线程池
 * FixedThreadPool - 固定容量线程池。创建线程池的时候，容量固定。构造的时候，提供线程池最大容量
 * Executors.newFixedThreadPool(int) ->  ExecutorService - 线程池服务类型。所有的线程池类型都实现这个接口。
 * 实现这个接口，代表可以提供线程池能力。
 * shutdown - 优雅关闭。 不是强行关闭线程池，回收线程池中的资源。而是不再处理新的任务，将已接收的任务处理完毕后再关闭。
 * Executors - Executor的工具类。类似Collection和Collections的关系，可以更简单的创建若干种线程池。
 * @author fengna
 * @since 2021/2/1 16:08
 */
public class TestFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService service = newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            service.execute(()-> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" - test executor");
            });
        }

        System.out.println(service);
        service.shutdown();
        // 是否已经结束， 相当于回收了资源。
        System.out.println(service.isTerminated());
        // 是否已经关闭， 是否调用过shutdown方法
        System.out.println(service.isShutdown());
        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}
