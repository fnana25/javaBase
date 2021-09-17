package com.example.grammar.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * JodaUTC
 *
 * @author fengna
 * @date 2019/4/4
 */
public class JodaUTC {

    public static void main(String[] args) {
        System.out.println(JodaUTC.convertUtcToDateTime("2014-11-04T09:22:54.876Z"));
        System.out.println(JodaUTC.convertDateToUtc(new Date()));
        System.out.println(JodaUTC.convertDateToLocalByFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    private static DateTime convertUtcToDateTime(String utc){

        return DateTime.parse(utc, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
    }

    private static String convertDateToUtc(Date date){

        DateTime dateTime = new DateTime(date, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertDateToLocalByFormat(Date date, String format) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }


}
