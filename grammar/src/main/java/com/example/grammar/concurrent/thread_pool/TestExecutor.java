package com.example.grammar.concurrent.thread_pool;

import java.util.concurrent.Executor;

/**
 * 类描述：线程池
 * Executor - 线程池底层处理机制。
 * 在使用线程池的时候，底层如何调用线程中的逻辑。
 *
 * @author fengna
 * @since 2021/2/1 14:16
 */
public class TestExecutor implements Executor {

    public static void main(String[] args) {
        new TestExecutor().execute(() ->
            System.out.println(Thread.currentThread().getName() + " - test executor")
         );
    }

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
