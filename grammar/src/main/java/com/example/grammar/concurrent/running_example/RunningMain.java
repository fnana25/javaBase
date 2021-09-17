package com.example.grammar.concurrent.running_example;

/**
 * 类描述：龟兔赛跑2000米
 *
 *  要求：
 *  (1)兔子每 0.1 秒 5 米的速度，每跑20米休息1秒;
 *  (2)乌龟每 0.1 秒跑 2 米，不休息；
 *  (3)其中一个跑到终点后另一个不跑了！
 *
 * @author fengna
 * @since 2021/1/29 15:07
 */
public class RunningMain {

    public static void main(String[] args) {
        Rabbit animal1 = new Rabbit();
        Tortoise animal2 = new Tortoise();

        CallToBackImpl callToBack1 = new CallToBackImpl(animal1);
        animal2.callToBack = callToBack1;
        CallToBackImpl callToBack2 = new CallToBackImpl(animal2);
        animal1.callToBack = callToBack2;
        System.out.println(2222);
        animal1.start();
        animal2.start();
    }
}
