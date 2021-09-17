package com.example.grammar.stream2;

/**
 * Lambda2
 * note : lambda 表达式不是匿名内部类的实现
 *
 * @author fengna
 * @date 19/4/1 21:46
 */
public class Lambda2 {

    Runnable lambda = () -> System.out.println("lambda : " + this);

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("runnable : " + this);
        }
    };

    public static void main(String[] args) {

        Lambda2 lambda2 = new Lambda2();

        new Thread(lambda2.lambda).start();
        new Thread(lambda2.runnable).start();
    }

}
