package com.example.grammar.generic;

/**
 * 类描述：泛型通配符
 *
 * @author fengna
 * @since 2021/1/21 17:22
 */
public class GeneratorImpl3 {

    public static void main(String[] args) {
        GenericClass<Integer> gInteger = new GenericClass<Integer>(123);
        GenericClass<Number> gNumber = new GenericClass<Number>(456);

        showKeyValue(gNumber);
        // showKeyValue(gInteger)：Generic<java.lang.Integer>
        // cannot be applied to Generic<java.lang.Number>
        // showKeyValue(gInteger);

        //使用通配符
        //  showKeyValue1(gInteger);
        //  showKeyValue1(gNumber);

    }

    /**
     * Ingeter是Number的一个子类，同时在特性章节中我们也验证过Generic<Ingeter>与Generic<Number>实际上是相同的一种基本类型。
     * 但是在使用Generic<Number>作为形参的方法中，不能使用Generic<Ingeter>的实例传入，Generic<Number>和Generic<Ingeter>不可以看成具有父子关系的泛型类型
     *
     * 当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
     */
    private static void showKeyValue(GenericClass<Number> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    private static void showKeyValue1(GenericClass<?> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }
}
