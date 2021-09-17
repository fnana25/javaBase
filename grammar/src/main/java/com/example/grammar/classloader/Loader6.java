package com.example.grammar.classloader;

/**
 * 初始化从上到下依次完成
 * @author fengna
 * @date 2019/4/16
 */
public class Loader6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println("count_1 : " + Singleton.count_1);
        System.out.println("count_2 : " + Singleton.count_2);
    }
}

class Singleton{

    public static int count_1;
//    public static int count_2 = 0;

    public static Singleton singleton = new Singleton();

    private Singleton(){
        count_1++;
        count_2++;
    }

    public static int count_2 = 0;

    public static Singleton getSingleton(){
        return singleton;
    }

}
