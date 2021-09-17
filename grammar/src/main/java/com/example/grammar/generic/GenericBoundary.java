package com.example.grammar.generic;

/**
 * 类描述：泛型边界
 *
 * 在使用泛型的时候，我们还可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类。
 * 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
 *
 * @author fengna
 * @since 2021/1/21 18:05
 */
public class GenericBoundary {

    //方法设置边界
    public void showKeyValue1(GenericClass<? extends Number> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    //泛型类设置边界
    class Generic1<T extends Number>{
        private T key;

        public Generic1(T key) {
            this.key = key;
        }

        public T getKey(){
            return key;
        }
    }

    //泛型方法添加边界
    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(GenericClass<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args) {
        GenericClass<String> generic1 = new GenericClass<String>("11111");
        GenericClass<Integer> generic2 = new GenericClass<Integer>(2222);
        GenericClass<Float> generic3 = new GenericClass<Float>(2.4f);
        GenericClass<Double> generic4 = new GenericClass<Double>(2.56);


        GenericBoundary genericBoundary = new GenericBoundary();
        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        //genericBoundary.showKeyValue1(generic1);
        genericBoundary.showKeyValue1(generic2);
        genericBoundary.showKeyValue1(generic3);
        genericBoundary.showKeyValue1(generic4);

        //这一行代码也会报错，因为String不是Number的子类
//        Generic1<String> generic5 = new Generic1<String>("11111");
    }
}
