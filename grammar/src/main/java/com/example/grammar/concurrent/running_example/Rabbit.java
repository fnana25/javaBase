package com.example.grammar.concurrent.running_example;

import java.util.Objects;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/1/29 14:59
 */
public class Rabbit extends AbstractAnimal {

    Rabbit() {
        setName("兔子");
    }

    @Override
    public void running() {
        int dis = 5;
        length -= dis;
        System.out.println("兔子跑了" + dis + "米，距离终点还有" + length + "米。");
        if (length <= 0) {
            System.out.println("兔子赢得了比赛");
            if (!Objects.isNull(callToBack)) {
                callToBack.win();
            }
        }
        try {
            if (length % 20 == 0) {
                sleep(1000);
            } else {
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
