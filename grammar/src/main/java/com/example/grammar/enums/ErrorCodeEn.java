package com.example.grammar.enums;

/**
 * 类描述：枚举可以实现接口，，不能继承类（因为 enum 实际上都继承自 java.lang.Enum 类，而 Java 不支持多重继承，所以 enum 不能再继承其他类，当然也不能继承另一个 enum）
 *
 * @author fengna
 * @since 2021/1/27 10:55
 */
public enum ErrorCodeEn implements INumberEnum {
    OK(0, "成功"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    ErrorCodeEn(int number, String description) {
        this.code = number;
        this.description = description;
    }

    private int code;
    private String description;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
