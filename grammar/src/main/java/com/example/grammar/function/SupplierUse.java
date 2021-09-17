package com.example.grammar.function;

import com.example.grammar.function.model.Student;

import java.util.function.Supplier;

/**
 * Supplier use
 *
 * @author fengna
 * @date 2019/3/26
 */
public class SupplierUse {

    public static void main(String[] args) {

        Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get().getAge());
        int[] numbers = {100, 200, 300, 400, 500, -600, -700, -800, -900, -1000};
        int numberMax = arrayMax(
                () -> {
                    int max = numbers[0];
                    for (int number : numbers) {
                        if (max < number) {
                            max = number;
                        }
                    }
                    return max;
                }
        );
        System.out.println("数组中的最大值为：" + numberMax);
    }

    /**
     * 获取一个泛型参数指定类型的对象数据
     * @param integerSupplier 方法的参数为Supplier，泛型使用Integer
     * @return 指定类型的对象数据
     */
    private static Integer arrayMax(Supplier<Integer> integerSupplier) {
        return integerSupplier.get();
    }

}
