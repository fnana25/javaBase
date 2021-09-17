package com.example.grammar.other;

import org.checkerframework.checker.units.qual.A;

import java.util.Date;
import java.util.Locale;

/**
 * 字符串格式化
 * %s    字符串
 * %c    字符
 * %b    布尔
 * %d    整数类型
 * %f     浮点
 * %g    通用浮点类型
 * %h    散列码
 * %%   百分比
 * %n    换行符
 * %tx   日期与时间
 *
 * @author fengna
 * @date 2019/8/8
 */
public class StringFormatTest {
    public static void main(String[] args) {
        dateTimeTest1();
        System.out.println();
        System.out.println("///////////////////////");
        dateTimeTest2();
        System.out.println();
        System.out.println("///////////////////////");
        ///////////////////输出为//////////////////////////////
//        Hi,王力
//        Hi,王南:王力.王张
//        字母a的大写是：A
//        3>7的结果是：false
//        100的一半是：50
//        50元的书打8.5折扣是：42.500000 元
//        上面价格的指数表示：4.250000e+01
//        上面价格的指数和浮点数结果的长度较短的是：42.5000
//        上面的折扣是85%
//        字母A的散列码是：41
        String str;
        str = String.format("Hi,%s", "王力");
        System.out.println(str);
        str = String.format("Hi,%s:%s.%s", "王南", "王力", "王张");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c%n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3 > 7);
        System.out.printf("100的一半是：%d %n", 100 / 2);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
    }

    /**
     * 常见日期和时间组合的格式
      */
    private static void dateTimeTest1(){
        //////////////////////////输出为/////////////////////////////////////
//        全部日期和时间信息：星期一 九月 10 10:43:36 CST 2012
//        年-月-日格式：2012-09-10
//        月/日/年格式：09/10/12
//        HH:MM:SS PM格式（12时制）：10:43:36 上午
//        HH:MM:SS格式（24时制）：10:43:36
//        HH:MM格式（24时制）：10:43

        Date date=new Date();
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);
    }

    /**
     *
     */
    private static void dateTimeTest2(){
//        英文月份简称：Sep
//        本地月份简称：九月
//        英文月份全称：September
//        本地月份全称：九月
//        英文星期的简称：Mon
//        本地星期的简称：星期一
//        年的前两位数字（不足两位前面补0）：20
//        年的后两位数字（不足两位前面补0）：12
//        一年中的天数（即年的第几天）：254
//        两位数字的月份（不足两位前面补0）：09
//        两位数字的日（不足两位前面补0）：10
//        月份的日（前面不补0）：10
        Date date=new Date();
        //b的使用，月份简称
        String str=String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te",date);
    }
}
