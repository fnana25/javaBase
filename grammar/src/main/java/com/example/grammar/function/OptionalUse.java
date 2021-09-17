package com.example.grammar.function;

import com.example.grammar.function.model.Company;
import com.example.grammar.function.model.Employee;
import com.example.grammar.function.model.Person;

import java.util.*;

/**
 * Optional use https://www.cnblogs.com/zhangboyu/p/7580262.html
 *
 * @author fengna
 * @date 2019/3/26
 */
public class OptionalUse {

    public static void main(String[] args) {

        //1.创建 Optional实例
        Optional<Person> p1 = Optional.empty();
        //报异常 NoSuchElementException
        System.out.println(p1.get());
        //of() 和 ofNullable() 方法不同之处在于如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException
        //如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法
        Person person = new Person(23, "1234","");
        //会抛出 NullPointerException
        Optional<Person> p2 = Optional.of(person);
        //不会抛异常
        Optional<Person> p3 = Optional.ofNullable(person);

        System.out.println("/////////////////////////////");

        //2.访问 Optional 对象的值
        //从 Optional 实例中取回实际值对象的方法之一是使用 get() 方法,这个方法会在值为 null 的时候抛出异常
        p3.get();

        //3.检查是否有值 isPresent()和ifPresent() 方法
        // ifPresent() 方法接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式
        p3.isPresent();
        p3.ifPresent(System.out::println);

        //4.返回默认值  在对象为空的时候返回默认值
        //orElse()，如果有值则返回该值，否则返回传递给它的参数值
        //orElseGet() 这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果
        //orElse()与orElseGet()不同之处：两个 Optional  对象都包含非空值，两个方法都会返回对应的非空值。不过，orElse() 方法仍然调用了createNewUser方法。与之相反，orElseGet() 方法则不创建 User 对象。
        Person user = new Person(23, "1234","");
        Person result = Optional.ofNullable(user).orElse(createNewUser());
        System.out.println("orElse............." + result);
        Person result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
        System.out.println("orElseGet.............." + result2);

        //返回异常 orElseThrow() 接受一个Supplier参数
        p3.orElseThrow(IllegalArgumentException::new);

        //转换值 map() 和 flatMap() 方法
        p3.map(Person::getUserName).orElse("zhangsan");
        String position = p3
                .flatMap(u -> u.getPosition()).orElse("default");
        //Optional 类的链式方法
//        String result = Optional.ofNullable(user)
//                .flatMap(u -> u.getAddress())
//                .flatMap(a -> a.getCountry())
//                .map(c -> c.getIsocode())
//                .orElse("default");

        //过滤值 filter() 接受一个 Predicate 参数，为 true 时返回结果。为 false时，会返回一个空的 Optional。
        p3.filter(e->e.getAge()>23);

        List<Employee> employeeList = Arrays.asList(
                Employee.builder().name("na1").build(),
                Employee.builder().name("na2").build(),
                Employee.builder().name("na3").build()
        );
        Company company = Company.builder().name("com.na").employees(employeeList).build();

        Optional<Company> optionalCompany = Optional.ofNullable(company);
        System.out.println(optionalCompany.map(Company::getEmployees).orElse(Collections.emptyList()));

    }

    private static Person createNewUser() {
        System.out.println("createNewUser.................");
        return new Person(22, "12345","");
    }
}
