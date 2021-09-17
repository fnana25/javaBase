package com.example.grammar.concurrent.producer_consumer;

/**
 * 类描述：生产者
 *
 * @author fengna
 * @since 2021/2/2 17:48
 */
public class Producer implements Runnable {

    private Resource resource;

    Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (resource.count < 100) {
            resource.set("商品");
        }
    }
}
