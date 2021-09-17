package com.example.grammar.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 集合迭代时删除元素的正确方法 iterator 或removeIf()
 *
 * @author fengna
 * @date 2019/1/4
 */
public class Main {

    public static void main(String[] args){
        String[] str = new String[] { "you", "wu" };
        List list = Arrays.asList(str);
        str[0]="yangguanbao";
        System.out.println(list.get(0));

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
//        Iterator<String> iterator = list2.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if ("1".equals(item)) {
//                iterator.remove();
//            }
//        }
        list2.removeIf((o)->"1".equals(o));
//        for (String item : list2) {
//            if ("1".equals(item)) {
//                list.remove(item);
//            }
//        }
        System.out.println(list2.size());
    }
}
