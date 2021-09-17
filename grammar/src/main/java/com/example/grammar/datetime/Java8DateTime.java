package com.example.grammar.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Java8DateTime
 *
 * @author fengna
 * @date 2019/4/4
 */
public class Java8DateTime {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now.getYear() + "," + now.getMonthValue() + "," + now.getDayOfMonth());

        System.out.println("----------------");

        LocalDate localDate = LocalDate.of(2017,3,23);
        System.out.println(localDate);
        System.out.println(localDate.plus(2, ChronoUnit.WEEKS));
        System.out.println(localDate.minus(3,ChronoUnit.DAYS));

        System.out.println("----------------");

        LocalDate localDate2 = LocalDate.of(2018,3,23);
        MonthDay monthDay1 = MonthDay.of(localDate.getMonth(),localDate.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.of(localDate2.getMonth(),localDate2.getDayOfMonth());

        if(monthDay1.equals(monthDay2)){
            System.out.println("monthDay1 equals monthDay2");
        }else {
            System.out.println("monthDay1 not equals monthDay2");
        }

        System.out.println("----------------");

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.plusHours(2).plusMinutes(20).plusSeconds(20));

        System.out.println("----------------");

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        System.out.println("----------------");

        LocalDate localDateOne = LocalDate.now();
        LocalDate localDateTwo = LocalDate.of(2019,4,5);
        System.out.println(localDateOne.isAfter(localDateTwo));
        System.out.println(localDateOne.isBefore(localDateTwo));
        System.out.println(localDateOne.equals(localDateTwo));

        Period period = Period.between(localDateOne,localDateTwo);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        System.out.println(Instant.now());

        System.out.println("----------------");

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        Set<String> treeSet = new HashSet<String>(){
            {
                addAll(zoneIds);
            }
        };
        treeSet.forEach(System.out::println);

        System.out.println("-----------------");

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime nowDate = LocalDateTime.now();
        System.out.println(nowDate);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(nowDate,zoneId);
        System.out.println(zonedDateTime);

        System.out.println("-----------------");

        YearMonth yearMonth = YearMonth.of(2017,6);
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfYear());
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.isLeapYear());

        System.out.println("-----------------");


    }
}
