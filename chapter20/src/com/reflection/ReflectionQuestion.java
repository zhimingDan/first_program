package com.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

//引出反射的需求
//使用反射机制的最大的好处：可以不用通过修改源码，只要修改配置文件，就能达到理想的效果
@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception{
        //传统方法：使用new -> 创建一个对象
//        Cat cat = new Cat();
//        cat.hi();

        //尝试读取properties文件中的数据，来明白反射机制
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\IDEA项目\\first_program\\chapter20\\src\\re.properties"));

        String classfullpath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + method);

        //创建对象 -> 此时并不能根据上面得到的字符串来创建一个对象
        //new classfullpath() //这个是错误的，因此classfullpath只是个String，并不是个类名

        //引出反射，使用反射机制来创建对象
        //(1) 加载类，返回一个Class类型的对象 -> cls  这个对象的类型就是Class类型
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());//可以看到o的运行类型就是com.reflection.Cat类型
        //(3) 通过 cls 得到你加载的类 com.reflection.Cat 的method(这里对应 hi 方法) 方法的对象
        //    即：在反射中，可以把方法视为对象 (万物皆对象)
        Method method1 = cls.getMethod(method);

        //表示方法调用时，取消安全检测，以提高执行效率
        method1.setAccessible(true);

        //(4) 通过 method1 调用方法:即通过方法对象来实现方法的调用
        method1.invoke(o); //传统方式：对象.方法  -> 反射机制中 方法.invoke(对象)

        //前面都是对反射的类以及反射的方法进行操作，下面对反射的字段(成员变量)以及反射的构造方法进行操作
        //java.lang.reflect.Field:代表类的成员变量，Field对象表示某个类的成员变量

        //Field name = cls.getField("name"); //结果是会抛出异常的，因为name是私有的属性

        Field age = cls.getField("age");
        System.out.println(age.get(o));//传统写法:对象.成员变量 -> 反射写法: 成员变量对象.get(对象)

        //java.lang.reflect.Constructor:代表类的构造器，Constructor对象表示某个类的构造器
        Constructor constructor = cls.getConstructor();//如果里面没有任何的参数，表示无参构造器,放置什么参数，表示什么构造器

        Constructor constructor1 = cls.getConstructor(String.class);//这里传入的String.class就是String类的class对象

    }
}
