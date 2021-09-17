package com.example.grammar.concurrent.seel_example;

/**
 * 类描述：多个窗口同时卖票
 *
 * @author fengna
 * @since 2021/1/28 16:52
 */
public class Station extends Thread {

    Station(String name) {
        //给线程名字赋值
        super(name);
    }

    /**
     * 为了保持票数一致，票数要静态
     */
    private static int tick = 20;

    /**
     * 创建一个静态钥匙，是任意的
     */
    private static Object ob = "aa";

    /**
     * 重写run，实现买票逻辑
     */
    @Override
    public void run() {
        while (tick > 0){
            synchronized (ob){
                if(tick > 0){
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                }
                else {
                    System.out.println("票卖完了。");
                }
            }
            try{
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
