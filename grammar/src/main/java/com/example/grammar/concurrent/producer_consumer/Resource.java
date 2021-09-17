package com.example.grammar.concurrent.producer_consumer;

/**
 * 类描述：资源类
 *
 * @author fengna
 * @since 2021/2/2 17:47
 */
public class Resource {

    private String name;
    int count = 1;
    private boolean flag = false;

    /**
     * 生产资源
     */
    public synchronized void set(String name) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "--" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        flag = true;
        //通知消费者线程
        this.notifyAll();
    }

    /**
     * 消费资源
     */
    public synchronized void out() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        flag = false;
        //唤醒生产者生产资源
        this.notifyAll();
    }
}
