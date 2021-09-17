package com.example.grammar.concurrent.thread_pool;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 类描述：支合并线程池(mapduce 类似的设计思想)。适合用于处理复杂任务。 初始化线程容量与 CPU 核心数相关。
 *
 * 线程池中运行的内容必须是 ForkJoinTask 的子类型(RecursiveTask,RecursiveAction)。 ForkJoinPool - 分支合并线程池。
 * 可以递归完成复杂任务。要求可分支合并的任务必须是 ForkJoinTask 类型的子类型。其中提供了分支和合并的能力。
 * ForkJoinTask 类型提供了两个抽象子类型，RecursiveTask 有返回结果的分支合并任务，RecursiveAction无返回结果的分支合并任务。(Callable/Runnable)compute 方法:就是任务的执行逻辑。
 * ForkJoinPool 没有所谓的容量。默认都是 1 个线程。根据任务自动的分支新的子线程。 当子线程任务结束后，自动合并。所谓自动是根据 fork 和 join 两个方法实现的。
 * 应用: 主要是做科学计算或天文计算的。数据分析的。
 * @author fengna
 * @since 2021/2/1 17:27
 */
public class TestForkJoinPool {

    private final static int[] NUMBERS = new int[1000000];
    private final static int MAX_SIZE = 50000;

    static {
        for (int i = 0; i < 1000000; i++){
            NUMBERS[i] = new Random().nextInt(1000);
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long curr = System.currentTimeMillis();
        long res = 0;
        for (int i = 0; i < 1000000; i++) {
            res += NUMBERS[i];
        }
        System.out.println(res);
        System.out.println("耗时1："+(System.currentTimeMillis() - curr));

        curr = System.currentTimeMillis();

        AddTask addTask = new AddTask(0,NUMBERS.length);
        ForkJoinPool pool = new ForkJoinPool();
        Future<Long> future = pool.submit(addTask);
        System.out.println(future.get());
        System.out.println("耗时2："+(System.currentTimeMillis() - curr));

    }

    static class AddTask extends RecursiveTask<Long>{

        private int start;
        private int end;
        AddTask(int start,int end){
            this.start = start;
            this.end = end;
        }
        @Override
        protected Long compute() {
            long sum = 0;
            if(end - start < MAX_SIZE){
                for (int i = start; i < end; i++) {
                    sum += NUMBERS[i];
                }
                return sum;
            }else {
                int middle = start + (end - start)/2;
                AddTask addTask1 = new AddTask(start,middle);
                AddTask addTask2 = new AddTask(middle,end);
                addTask1.fork();// fork - 就是用于开启新的任务的。 就是分支工作的。 就是开启一个新的线程任务。
                addTask2.fork();
                // join - 合并。将任务的结果获取。 这是一个阻塞方法。一定会得到结果数据。
                return addTask1.join() + addTask2.join();
            }
        }
    }
}
