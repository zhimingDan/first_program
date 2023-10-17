package com.file_.exercise_;

import java.io.*;
import java.util.Properties;

/*  要求如下：
    1.要编写一个dog.properties
    name=tom
    age=5
    color=red
    2.编写Dog类(name,age,color),创建一个Dog类对象,用properties中的内容完成初始化，并输出
    3.将创建的Dog对象，序列化dog.dat文件中
 */
public class Exercise04 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        Properties properties = new Properties();
        properties.setProperty("name","tom");

        //由此可见，也是可以使用put方法进行添加的
        properties.put("age","5");
        properties.setProperty("color","red");
        properties.store(new FileWriter("dog.properties"),null);

        Dog dog = new Dog(properties.getProperty("name"),
                Integer.parseInt(properties.getProperty("age")),
                properties.getProperty("color"));
        System.out.println(dog);

        oos.writeObject(dog);
        oos.close();
    }
}

class Dog implements Serializable{
    private String name;
    private int age;
    private String red;

    public Dog(String name, int age, String red) {
        this.name = name;
        this.age = age;
        this.red = red;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", red='" + red + '\'' +
                '}';
    }
}
