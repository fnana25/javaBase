package com.example.grammar.classloader;

import java.io.*;

/**
 * 自定义类加载器
 *
 * @author fengna
 * @date 2019/4/18
 */
public class Loader11 extends ClassLoader{

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public Loader11(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public Loader11(ClassLoader parent,String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString(){
        return "classLoaderName = " + classLoaderName;
    }

    public void setPath(String path){
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        System.out.println("findClass invoked : " + name);
        System.out.println("class loader name : " + this.classLoaderName);
        byte[] data = loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name){

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            this.classLoaderName = this.classLoaderName.replace(".","\\");
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())){
                byteArrayOutputStream.write(ch);
            }
            data = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("com.example.grammar.classloader.Loader1");
        Object object = clazz.newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Loader11 loader1 = new Loader11("loader1");
//        test(loader1);

        Loader11 loader1 = new Loader11("loader1");
        loader1.setPath("D:\\");
        Class<?> clazz1 = loader1.loadClass("com.example.grammar.classloader.Loader1");
        Object object1 = clazz1.newInstance();
        System.out.println(object1);

        Loader11 loader2 = new Loader11("loader2");
        loader1.setPath("D:\\");
        Class<?> clazz2 = loader1.loadClass("com.example.grammar.classloader.Loader1");
        Object object2 = clazz1.newInstance();
        System.out.println(object2);
    }
}
