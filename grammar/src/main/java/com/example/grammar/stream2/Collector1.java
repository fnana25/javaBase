package com.example.grammar.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Collector1
 *
 * @author fengna
 * @date 2019/4/3
 */
public class Collector1<T> implements Collector<T,Set<T>,Set<T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("Supplier invoke");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke");
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoke");
        return (s1,s2) -> {
            s1.addAll(s2);
            return s1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
//        System.out.println("finisher invoke");
//        return Function.identity();
          throw new UnsupportedOperationException();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb","cc","aa");
        Set<String> set = list.stream().collect(new Collector1<>());
        System.out.println(set);
    }
}
