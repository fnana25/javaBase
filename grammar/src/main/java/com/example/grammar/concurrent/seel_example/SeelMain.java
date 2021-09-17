package com.example.grammar.concurrent.seel_example;

/**
 * 类描述：多个窗口同时卖票
 *
 * @author fengna
 * @since 2021/1/28 17:03
 */
public class SeelMain {

    public static void main(String[] args) {
        Station s1 = new Station("窗口1");
        Station s2 = new Station("窗口2");
        Station s3 = new Station("窗口3");

        s1.start();
        s2.start();
        s3.start();

    }
}
