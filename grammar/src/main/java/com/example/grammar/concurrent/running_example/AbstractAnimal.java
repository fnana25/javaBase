package com.example.grammar.concurrent.running_example;

/**
 *
 * @author fengna
 * @since 2021/1/29 14:53
 */
public abstract class AbstractAnimal extends Thread {

    int length = 2000;

    public abstract void running() throws InterruptedException;

    @Override
    public void run() {
        while (length > 0){
            try {
                running();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public interface CallToBack{
        void win();
    }

    CallToBack callToBack;
}
