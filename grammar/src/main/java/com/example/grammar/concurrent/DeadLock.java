package com.example.grammar.concurrent;

/**
 * 类描述：死锁例子
 *
 * @author fengna
 * @since 2021/2/2 15:36
 */
public class DeadLock implements Runnable{

    private int flag;

    public DeadLock(int flag){
        this.flag = flag;
    }

    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {

        DeadLock deadLock1 = new DeadLock(1);
        DeadLock deadLock2 = new DeadLock(2);

        //td1,td2 都处于可执行状态，但 JVM 线程调度先执行哪个线程是不确定的。
        // td2 的 run()可能在 td1 的 run()之前运行
        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }

    @Override
    public void run() {
        System.out.println("flag:"+flag);
        if(flag == 1){
            synchronized (obj1){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println(1);
                }
            }
        }
        else if(flag == 2){
            synchronized (obj2){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println(2);
                }
            }
        }
    }

}
