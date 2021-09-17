package com.example.grammar.reflect.reflectUse;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 类描述：读取配置文件
 *
 * 利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 *
 * @author fengna
 * @since 2021/1/26 15:44
 */
public class ReadProperties {
    public static void main(String[] args) throws Exception {
        //通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));
        //2获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));
        //3.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());

    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("demo.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
