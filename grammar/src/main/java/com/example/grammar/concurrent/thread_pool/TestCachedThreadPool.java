package com.example.grammar.concurrent.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * 类描述：
 *
 * 无容量限制的线程池（最大容量默认为Integer.MAX_VALUE）
 * @author fengna
 * @since 2021/2/1 16:41
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService service = newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(()-> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" - test executor");
            });
        }

        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(service);
    }

}
