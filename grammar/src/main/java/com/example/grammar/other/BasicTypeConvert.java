package com.example.grammar.other;

/**
 * Test 数据类型转换
 *
 * 如果符合以下条件，则 JAVA 将会自动做类型转换：
 * 1.由小数据转换为大数据
 *   显而易见的是，“小”数据类型的数值表示范围小于“大”数据类型的数值表示范围，即精度小于“大”数据类型。
 *   所以，如果“大”数据向“小”数据转换，会丢失数据精度。比如：long 转为 int，则超出 int 表示范围的数据将会丢失，导致结果的不确定性。
 *   反之，“小”数据向“大”数据转换，则不会存在数据丢失情况。由于这个原因，这种类型转换也称为扩大转换。
 *   这些类型由“小”到“大”分别为：(byte，short，char) < int < long < float < double。
 *   这里我们所说的“大”与“小”，并不是指占用字节的多少，而是指表示值的范围的大小。
 * 2.转换前后的数据类型要兼容
 *   由于 boolean 类型只能存放 true 或 false，这与整数或字符是不兼容的，因此不可以做类型转换。
 * 3.整型类型和浮点型进行计算后，结果会转为浮点类型
 *
 * 强制转换:
 * 在不符合自动转换条件时或者根据用户的需要，可以对数据类型做强制的转换。
 *
 * @author may
 * @date 19/1/8 21:15
 */
public class BasicTypeConvert {

    public static void main(String[] args) {
        long a = 2000000;
    float b = (float) a;
        float c = 3000.0f;
        int d = (int) c;
        System.out.println(d);

    }
}
