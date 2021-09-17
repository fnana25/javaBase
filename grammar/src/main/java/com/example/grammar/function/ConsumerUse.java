package com.example.grammar.function;

import com.example.grammar.function.model.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Consumer Use
 *
 * @author fengna
 * @date 2019/3/26
 */
public class ConsumerUse {

    public static void main(String[] args) {

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("hello :" + LocalDateTime.now());

        List<Person> lisiList = new ArrayList<>();
        Consumer<Person> consumer2  = x -> {
            if (x.getUserName().equals("lisi")){
                lisiList.add(x);
            }
        };
        //过滤掉小于23岁的数据
//        consumer2 = consumer2.andThen(
//                x -> lisiList.removeIf(y -> y.getAge() < 23)
//        );
        Stream.of(
                new Person(21,"zhangsan",""),
                new Person(22,"lisi",""),
                new Person(23,"wangwu",""),
                new Person(24,"wangwu",""),
                new Person(23,"lisi",""),
                new Person(26,"lisi",""),
                new Person(26,"zhangsan","")
        ).forEach(consumer2);

        System.out.println(lisiList);
    }

}
