package com.example.grammar.concurrent.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/2/1 16:53
 */
public class TestSingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService service = newSingleThreadExecutor();
        System.out.println(service);
        for (int i = 0; i < 5; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - test executor");
            });
        }
    }

}
