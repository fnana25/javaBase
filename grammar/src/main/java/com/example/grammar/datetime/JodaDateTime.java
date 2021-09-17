package com.example.grammar.datetime;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Joda2
 *
 * @author fengna
 * @date 2019/4/3
 */
public class JodaDateTime {

    public static void main(String[] args) {

        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));

        System.out.println("---------------");

        //当前月第一天
        DateTime dayOfMonth = today.withDayOfMonth(1);
        System.out.println(dayOfMonth.toString("yyyy-MM-dd"));

        System.out.println("---------------");

        //当地日期
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);

        System.out.println("----------------");

        //3个月后的最后一天
        localDate = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localDate);

        System.out.println("----------------");

        // 计算2年前第3个月最后1天的日期
        DateTime dateTime = new DateTime().minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMinimumValue();
        System.out.println(dateTime.toString("yyyy-MM-dd"));

    }
}
