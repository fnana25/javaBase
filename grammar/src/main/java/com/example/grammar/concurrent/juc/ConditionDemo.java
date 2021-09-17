package com.example.grammar.concurrent.juc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述：锁的条件对象
 * Condition对象与Lock对象是绑定的，Condition对象只能在当前Lock对象上操作。
 * 和Object类中的 wait 、notify和notifyAll 方法一样，当调用await()方法时，会释放掉当前的锁，被 signal()方法唤醒时会去竞争锁资源。
 * signal()方法必须在await()方法之后被调用，不然线程不会被唤醒。
 *
 * @author fengna
 * @since 2021/2/3 15:57
 */
public class ConditionDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "线程开始执行。。。");
        System.out.println(Thread.currentThread().getName() + "线程进入等待");
        try {
            lock.lock();
            condition.await();
            System.out.println(Thread.currentThread().getName() + "线程被唤醒，执行任务结束。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new ConditionDemo());
//        thread.start();
//        Thread.sleep(2000);
//        lock.lock();
//        condition.signalAll();
//        lock.unlock();

//        System.out.println(LocalDate.now());
//        LocalDate startDate = LocalDate.of(2021, 6, 25);
//        System.out.println(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//       Integer aa = null;
//       test(aa);
//        T t = new T();
//        t.setName("na");
//        t.setAge(23);
//        if(t.getName().equals("na2")){
//            System.out.println(1232);
//        }else if(t.getAge()==232){
//            System.out.println(333);
//        }else {
//            System.out.println("2222222222222222");
//        }
//        System.out.println(t);

        LocalDate from = Optional.ofNullable("2021-06-01").map(LocalDate::parse).orElse(LocalDate.now().minusDays(1));
        LocalDate to = Optional.ofNullable("2021-09-09").map(LocalDate::parse).orElse(LocalDate.now().minusDays(1));

        long fromSeconds = LocalDateTime.of(from, LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();

        long toSeconds = LocalDateTime.of(to, LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        System.out.println(fromSeconds);
        System.out.println(toSeconds);

    }

    public static void test(int a){
        Integer b = 3;
        if(Objects.equals(b, a)){
        }

    }
}
