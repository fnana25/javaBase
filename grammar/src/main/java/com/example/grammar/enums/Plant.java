package com.example.grammar.enums;

/**
 * 类描述：在接口中组织 enum
 *
 * Java接口在编译时会自动为enum类型加上public static修饰符；Java类在编译时会自动为 enum 类型加上static修饰符。
 * 在类中组织 enum，如果你不给它修饰为 public，那么只能在本包中进行访问。
 *
 * @author fengna
 * @since 2021/1/27 10:58
 */
public interface Plant {
    enum Vegetable implements INumberEnum {
        POTATO(0, "土豆"),
        TOMATO(0, "西红柿");

        Vegetable(int number, String description) {
            this.code = number;
            this.description = description;
        }

        private int code;
        private String description;

        @Override
        public int getCode() {
            return 0;
        }

        @Override
        public String getDescription() {
            return null;
        }
    }

    enum Fruit implements INumberEnum {
        APPLE(0, "苹果"),
        ORANGE(0, "桔子"),
        BANANA(0, "香蕉");

        Fruit(int number, String description) {
            this.code = number;
            this.description = description;
        }

        private int code;
        private String description;

        @Override
        public int getCode() {
            return 0;
        }

        @Override
        public String getDescription() {
            return null;
        }
    }
}
