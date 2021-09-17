package com.example.grammar.concurrent.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类描述：线程池底层实现。除 ForkJoinPool 外，其他常用线程池底层都是使用 ThreadPoolExecutor实现的。
 *
 * 模拟固定容量线程池
 * @author fengna
 * @since 2021/2/2 10:16
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args) {

        ExecutorService service = new ThreadPoolExecutor(5,5,0, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());

        for (int i = 0; i < 16; i++) {
            service.execute(()-> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "- test executor");
            });
        }
        System.out.println(service);

        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}
