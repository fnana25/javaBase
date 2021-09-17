package com.example.grammar.other;

import com.google.common.base.Splitter;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/8/8
 */
public class GuavaTest {
    public static void main(String[] args) {
        splitterTest();
    }

    /**
     * 字符串操作
     */
    private static void splitterTest() {
          /*
         on():指定分隔符来分割字符串
         limit():当分割的子字符串达到了limit个时则停止分割
         fixedLength():根据长度来拆分字符串
         trimResults():去掉子串中的空格
         omitEmptyStrings():去掉空的子串
         withKeyValueSeparator():要分割的字符串中key和value间的分隔符,分割后的子串中key和value间的分隔符默认是=
        */
        //[ a, b, c,d] （limit(3):当分割到4个子串时，停止对子串去掉空字符）
        System.out.println(Splitter.on(",").limit(3).trimResults().split(" a,  b,  c,  d"));
        //[1 2,  3]按固定长度分割
        System.out.println(Splitter.fixedLength(2).split("1a dd   2 3"));
        //[1, 2, 3]
        System.out.println(Splitter.on(" ").omitEmptyStrings().splitToList("1  2 3"));
        //[1, 2, 3]
        System.out.println(Splitter.on(",").omitEmptyStrings().split("1,,,,2,,,3"));
        //[1, 2, 3],默认的连接符是,
        System.out.println(Splitter.on(" ").trimResults().split("1 2 3"));
        //{a=1, b=2, c=3}
        System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3"));
    }

    /**
     * 创建不可变集合方法：
     * copyOf方法，如ImmutableSet.copyOf(set);
     * of方法，如ImmutableSet.of(“a”, “b”, “c”)或 ImmutableMap.of(“a”, 1, “b”, 2);
     * Builder工具
     */
    private static void immutableTest() {
        ImmutableSet<String> set = ImmutableSet.of("a", "b", "c", "d");
        ImmutableSet<String> set1 = ImmutableSet.copyOf(set);
        ImmutableSet<String> set2 = ImmutableSet.<String>builder().addAll(set).add("e").build();
        System.out.println(set);
        ImmutableList<String> list = set.asList();
    }

    /**
     * 新型集合类
     */
    private static void multiCollectionTest() {
        //////////////////////////set///////////////////////////////
        Multiset<String> set = LinkedHashMultiset.create();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        //添加或删除指定元素使其在集合中的数量是count
        set.setCount("a", 5);
        //给定元素在Multiset中的计数
        System.out.println(set.count("a"));
        System.out.println(set);
        //所有元素计数的总和,包括重复元素
        System.out.println(set.size());
        //所有元素计数的总和,不包括重复元素
        System.out.println(set.elementSet().size());
        //清空集合
        set.clear();
        System.out.println(set);
        ///////////////////////////map///////////////////////////////
        //Multimap是把键映射到任意多个值的一般方式
        Multimap<String, Integer> map = HashMultimap.create();
        //key相同时不会覆盖原value
        map.put("a", 1);
        map.put("a", 2);
        map.put("a", 3);
        //{a=[1, 2, 3]}
        System.out.println(map);
        //返回的是集合
        System.out.println(map.get("a"));
        //返回所有”键-单个值映射”的个数,而非不同键的个数
        System.out.println(map.size());
        //返回不同key的个数
        System.out.println(map.keySet().size());
        Map<String, Collection<Integer>> mapView = map.asMap();

        ////////////////////BiMap///////////////////////////////
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("sina", "sina.com");
        biMap.put("qq", "qq.com");
        //会覆盖原来的value
        biMap.put("sina", "sina.cn");
       /*
         在BiMap中,如果你想把键映射到已经存在的值，会抛出IllegalArgumentException异常
         如果对特定值,你想要强制替换它的键，请使用 BiMap.forcePut(key, value)
        */
        //抛出异常
        biMap.put("tecent", "qq.com");
        //强制替换key
        biMap.forcePut("tecent", "qq.com");
        System.out.println(biMap);
        //通过value找key
        System.out.println(biMap.inverse().get("sina.com"));
        //true
        System.out.println(biMap.inverse().inverse() == biMap);
    }

    /**
     * 集合操作
     */
    private static void collections2(){
        Set<Integer> set1= Sets.newHashSet(1,2,3,4,5);
        Set<Integer> set2=Sets.newHashSet(3,4,5,6);
        //交集
        Sets.SetView<Integer> inter=Sets.intersection(set1,set2);
        System.out.println(inter);
        //差集,在A中不在B中
        Sets.SetView<Integer> diff=Sets.difference(set1,set2);
        System.out.println(diff);
        //并集
        Sets.SetView<Integer> union=Sets.union(set1,set2);
        System.out.println(union);
    }
}
