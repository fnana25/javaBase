package com.example.grammar.concurrent.producer_consumer;

/**
 * 类描述：消费者模式实现
 *
 * @author fengna
 * @since 2021/2/2 17:28
 */
public class ProducerConsumerMain {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        Thread threadA = new Thread(producer);
        Thread threadB = new Thread(consumer);
        threadA.start();
        threadB.start();
    }
}
