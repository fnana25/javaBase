package com.example.grammar.concurrent.running_example;

import java.util.Objects;

/**
 * 类描述：
 * <p>
 * 龟兔赛跑：2000米
 * 要求：
 * (1)兔子每 0.1 秒 5 米的速度，每跑20米休息1秒;
 * (2)乌龟每 0.1 秒跑 2 米，不休息；
 * (3)其中一个跑到终点后另一个不跑了！
 *
 * @author fengna
 * @since 2021/1/29 14:59
 */
public class Tortoise extends AbstractAnimal {

    Tortoise() {
        setName("乌龟");
    }

    @Override
    public void running() {

        int dis = 2;
        length -= dis;
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + length + "米。");
        if (length <= 0) {
            System.out.println("乌龟赢得了比赛");
            if (!Objects.isNull(callToBack)) {
                callToBack.win();
            }
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
