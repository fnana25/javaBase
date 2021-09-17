package com.example.grammar.enums;

import java.util.EnumMap;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/22
 */
public class EnumMapDemo {

    public static void main(String[] args) {

        EnumMap<Action,String> enumMap = new EnumMap<Action, String>(Action.class);
        enumMap.put(Action.TURN_LEFT,"向左转");
        enumMap.put(Action.TURN_RIGHT,"向右转");
        enumMap.put(Action.SHOOT,"射击");

        for (Action c : Action.values()){
            System.out.println(enumMap.get(c));
        }
    }
}

enum Action {
    TURN_LEFT, TURN_RIGHT, SHOOT
}
