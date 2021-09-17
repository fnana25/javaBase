package com.example.grammar.concurrent.draw_money_example;

/**
 * 类描述：两个人AB通过一个账户,A在柜台取钱和B在ATM机取钱
 *
 * @author fengna
 * @since 2021/1/28 17:56
 */
public class DrawMoneyMain {

    public static void main(String[] args) {
        Bank bank = new Bank();
        DrawPerson personA = new DrawPerson(bank, "ATM", 100);
        DrawPerson personB = new DrawPerson(bank, "counter", 200);
        personA.start();
        personB.start();
    }
}
