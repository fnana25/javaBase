package com.example.grammar.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Lambda1
 *
 * @author fengna
 * @date 19/4/1 21:35
 */
public class Lambda1 {


    public static void main(String[] args) {

        Lambda1 lambda1 = new Lambda1();
        Consumer<Integer> integerConsumer = i -> System.out.println(i + "integerConsumer");
        IntConsumer intConsumer = i -> System.out.println(i + "intConsumer");

        System.out.println(integerConsumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        lambda1.test(integerConsumer);
        lambda1.test(intConsumer::accept);
        lambda1.test(integerConsumer::accept);

        //lambda1.test(intConsumer);error:类型不匹配，只能通过函数式调用
    }

    private void test(Consumer<Integer> consumer){
        consumer.accept(100);
    }
}

