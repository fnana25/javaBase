package com.example.grammar.enums;

import com.example.grammar.enums.enums.FontConstant;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * Java 中提供了两个方便操作enum的工具类——EnumSet 和 EnumMap。
 *
 * EnumSet 是枚举类型的高性能 Set 实现。它要求放入它的枚举常量必须属于同一枚举类型。
 * EnumMap 是专门为枚举类型量身定做的 Map 实现。虽然使用其它的 Map 实现（如HashMap）也能完成枚举类型实例到值得映射，
 * 但是使用 EnumMap 会更加高效：它只能接收同一枚举类型的实例作为键值，并且由于枚举类型实例的数量相对固定并且有限，
 * 所以 EnumMap 使用数组来存放与枚举类型对应的值。这使得 EnumMap 的效率非常高。
 *
 * @author fengna
 * @date 2019/7/22
 */
public class EnumSetDemo {

    public static void main(String[] args) {
        EnumSet<FontConstant> enumSet = EnumSet.of(FontConstant.Blod,FontConstant.Italilc);
        showEnumSet(enumSet);
        System.out.println("---------------");

        showEnumSet(EnumSet.complementOf(enumSet));
        System.out.println("---------------");

        EnumSet<FontConstant> enumSet1 = EnumSet.noneOf(FontConstant.class);
        enumSet1.add(FontConstant.Blod);
        enumSet1.add(FontConstant.Italilc);
        showEnumSet(enumSet1);
        System.out.println("---------------");

        List<FontConstant> enumList = new ArrayList<>(3);
        enumList.add(FontConstant.Blod);
        enumList.add(FontConstant.Italilc);
        enumList.add(FontConstant.Plain);
        showEnumSet(EnumSet.copyOf(enumList));
        System.out.println("---------------");


    }

    private static void showEnumSet(EnumSet<FontConstant> enumSet) {

        for (Iterator<FontConstant> iterator = enumSet.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
