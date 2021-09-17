package com.example.grammar.generic;

/**
 * 类描述：泛型类
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 * 注：泛型的类型参数只能是类类型，不能是简单类型。
 *
 * 泛型参考：https://www.cnblogs.com/coprince/p/8603492.html
 *
 * @author fengna
 * @since 2021/1/21 17:07
 */
public class GenericClass<T> {
    private T key;

    public GenericClass(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }

    public static void main(String[] args) {
        //传入的实参类型需与泛型的类型参数类型相同.
        GenericClass<Integer> genericInteger = new GenericClass<Integer>(123456);
        GenericClass<String> genericString = new GenericClass<String>("key_vlaue");
        System.out.println("泛型测试key is " + genericInteger.getKey());
        System.out.println("泛型测试key is " + genericString.getKey());

        //在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用。
        // 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        GenericClass generic = new GenericClass("111111");
        GenericClass generic1 = new GenericClass(4444);
        GenericClass generic2 = new GenericClass(55.55);
        GenericClass generic3 = new GenericClass(false);

        System.out.println("泛型测试key is " + generic.getKey());
        System.out.println("泛型测试key is " + generic1.getKey());
        System.out.println("泛型测试key is " + generic2.getKey());
        System.out.println("泛型测试key is " + generic3.getKey());
    }
}
