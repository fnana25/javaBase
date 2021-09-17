package com.example.grammar.concurrent;

import java.util.concurrent.*;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/2/1 14:26
 */
public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(
            ()->"first future task"
        );
        new Thread(task).start();
        System.out.println(task.get());

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaa");
            return Thread.currentThread().getName() + " - test executor";
        });

        System.out.println(future);
        // 查看线程是否结束， 任务是否完成。 call方法是否执行结束
        System.out.println(future.isDone());

        // 获取call方法的返回值。
        System.out.println(future.get());
        System.out.println(future.isDone());
    }
}
