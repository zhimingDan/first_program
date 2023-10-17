package com.reflectionclass;

import java.lang.reflect.Field;

//Class类中常用的方法
@SuppressWarnings({"all"})
public class ClassMethod {
    public static void main(String[] args) throws Exception{
        //1.获取到Car类中对应的Class对象,<?>表示泛型可以为任意类型
        Class<?> cls = Class.forName("com.reflectionclass.Car");
        //2.输出
        System.out.println(cls); //显示cls对象是哪个类的Class对象 com.reflectionclass.Car
        System.out.println(cls.getClass()); //输出cls的运行类型 java.lang.Class

        //3.得到包名
        System.out.println(cls.getPackage()); //输出 package com.reflectionclass
        System.out.println(cls.getPackage().getName()); //输出 com.reflectionclass 使用getName可以把前面的前缀去掉

        //4.得到全类名
        System.out.println(cls.getName()); //com.reflectionclass.Car

        //5.通过cls创建对象实例
        Car car = (Car)cls.newInstance();
        System.out.println(car); //调用toString方法

        //6.通过反射获得属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//宝马

        //7.通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car)); //奔驰

        //8.得到所有的属性
        System.out.println("=========所有的属性值==========");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.get(car));
        }

    }
}
