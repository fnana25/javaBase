package com.example.grammar.function;

import com.example.grammar.function.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * BiFunction use
 *
 * @author fengna
 * @date 2019/3/26
 */
public class BiFunctionUse {

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(
                Person.builder().userName("na1").age(11).build(),
                Person.builder().userName("na2").age(12).build(),
                Person.builder().userName("na3").age(13).build(),
                Person.builder().userName("na4").age(14).build(),
                Person.builder().userName("na5").age(15).build());

        BiFunctionUse test = new BiFunctionUse();

        List<Person> resultByAge = test.filterByAge(12, list);
        System.out.println("filterByAge : ======================");
        resultByAge.forEach(System.out::println);

        List<Person> resultByUserName = test.filterByUserName("na2", list);
        System.out.println("filterByUserName : ==================");
        resultByUserName.forEach(System.out::println);

        List<Person> resultByBiFunction = test.filterByAgeByBiFunction(13, list, (age, array) ->
                array.stream().filter(o -> o.getAge() > age).collect(Collectors.toList())
        );

        System.out.println("filterByAgeByBiFunction : ================");
        resultByBiFunction.forEach(System.out::println);
    }

    private List<Person> filterByUserName(String userName, List<Person> list) {
        return list.stream()
                .filter(o -> userName.equals(o.getUserName()))
                .collect(Collectors.toList());
    }

    private List<Person> filterByAge(int age, List<Person> list) {
        return list.stream()
                .filter(o -> o.getAge() > age)
                .collect(Collectors.toList());
    }

    private List<Person> filterByAgeByBiFunction(int age, List<Person> list, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, list);
    }
}
