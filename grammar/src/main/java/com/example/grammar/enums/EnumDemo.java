package com.example.grammar.enums;

/**
 * 类描述：枚举 https://www.cnblogs.com/jingmoxukong/p/6098351.html
 *
 * 如果枚举不添加任何方法，枚举值默认为从0开始的有序数值。以 Color 枚举类型举例，它的枚举常量依次为 RED：0，GREEN：1，BLUE：2。
 * 枚举的好处：可以将常量组织起来，统一进行管理。
 * 枚举的典型应用场景：错误码、状态机等。
 * 枚举类型的本质: enum是一种受限制的类，并且具有自己的方法,创建enum时，编译器会生成一个相关的类，这个类继承自 java.lang.Enum。
 *
 * 在enum中，提供了一些基本方法：
 * values()：返回 enum 实例的数组，而且该数组中的元素严格保持在 enum 中声明时的顺序。
 * name()：返回实例名。
 * ordinal()：返回实例声明时的次序，从0开始。
 * getDeclaringClass()：返回实例所属的 enum 类型。
 * equals() ：判断是否为同一个对象。
 * 可以使用 == 来比较enum实例。
 * 此外，java.lang.Enum实现了Comparable和 Serializable 接口，所以也提供 compareTo() 方法。
 *
 * 枚举可以添加普通方法、静态方法、抽象方法、构造方法
 * Java 虽然不能直接为实例赋值，但是它有更优秀的解决方案：为 enum 添加方法来间接实现显示赋值。
 * 创建 enum 时，可以为其添加多种方法，甚至可以为其添加构造方法。
 * 注意一个细节：如果要为enum定义方法，那么必须在enum的最后一个实例尾部添加一个分号。此外，在enum中，必须先定义实例，不能将字段或方法定义在实例前面。否则，编译器会报错。
 *
 * @author fengna
 * @since 2021/1/27 10:46
 */
public class EnumDemo {

    //注：如果枚举中没有定义方法，也可以在最后一个实例后面加逗号、分号或什么都不加。
    //enum的基本方法的使用:
    enum Color {RED, GREEN, BLUE}
    enum Size {BIG, MIDDLE, SMALL}
    public static void main(String args[]) {
        System.out.println("=========== Print all Color ===========");
        for (Color c : Color.values()) {
            System.out.println(c + " ordinal: " + c.ordinal());
        }
        System.out.println("=========== Print all Size ===========");
        for (Size s : Size.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
        }

        Color green = Color.GREEN;
        System.out.println("green name(): " + green.name());
        System.out.println("green getDeclaringClass(): " + green.getDeclaringClass());
        System.out.println("green hashCode(): " + green.hashCode());
        System.out.println("green compareTo Color.GREEN: " + green.compareTo(Color.GREEN));
        System.out.println("green equals Color.GREEN: " + green.equals(Color.GREEN));
        System.out.println("green equals Size.MIDDLE: " + green.equals(Size.MIDDLE));
        System.out.println("green equals 1: " + green.equals(1));
        System.out.format("green == Color.BLUE: %b\n", green == Color.BLUE);
    }
}

/**
 * 在枚举中定义普通方法、静态方法、抽象方法、构造方法
 */
enum ErrorCode {
    OK(0) {
        @Override
        public String getDescription() {
            return "成功";
        }
    },
    ERROR_A(100) {
        @Override
        public String getDescription() {
            return "错误A";
        }
    },
    ERROR_B(200) {
        @Override
        public String getDescription() {
            return "错误B";
        }
    };

    private int code;

    // 构造方法：enum的构造方法只能被声明为private权限或不声明权限
    private ErrorCode(int number) { // 构造方法
        this.code = number;
    }
    public int getCode() { // 普通方法
        return code;
    } // 普通方法
    public abstract String getDescription(); // 抽象方法
    public static void main(String args[]) { // 静态方法
        for (ErrorCode s : ErrorCode.values()) {
            System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
        }
    }
}
