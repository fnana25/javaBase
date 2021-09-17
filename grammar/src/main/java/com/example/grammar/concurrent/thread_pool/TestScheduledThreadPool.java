package com.example.grammar.concurrent.thread_pool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * 类描述：
 * 计划任务线程池。
 *
 * @author fengna
 * @since 2021/2/1 16:45
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = newScheduledThreadPool(3);
        System.out.println(service);
        service.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "");
        }, 0, 300, TimeUnit.MILLISECONDS);
    }
}
