package com.customgeneric_;

import java.util.*;

/*  编程题：
    定义一个泛型类DAO<T>，在其中定义一个Map成员变量，Map的键为String 类型，值为T类型

    分别创建一下方法：
    1.public void save(String id, T entity);  保存T类型的对象到Map成员变量中
    2.public T get(String id) : 从Map对象中获取id对应的对象
    3.public void update(String id , T entity):替换map中的key为id的内容，改为entity对象
    4.public List<T> list() : 返回map中存放的所有的T对象
    5.public void delete(String id) :删除指定的id对象

    定义一个User类：
    该类包含：private成员变量(int 类型) id,age; (String类型)name
    创建DAO类的对象，分别调用其save,get,update,list,delete方法，来操作User对象
 */
public class HomeWork01 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("123",new User(123, 23, "jack"));
        userDAO.save("456",new User(456, 18, "tom"));
        userDAO.save("789",new User(789, 25, "marry"));
        userDAO.save("101",new User(101, 29, "rose"));
        userDAO.save("102",new User(102, 40, "smith"));
        userDAO.save("103",new User(103, 60, "jerry"));

        System.out.println(userDAO.get("123"));
        System.out.println(userDAO.get("102"));

    }
}

class DAO<T> {
    Map<String, T> map = new HashMap<>();  //定义一个HashMap对象

    public void save(String id, T entity){ //保存T类型的对象到Map成员变量中
        map.put(id,entity);
    }

    public T get(String id){ //从Map对象中获取id对应的对象
        return map.get(id);
    }

    public void update(String id , T entity){//替换map中的key为id的内容，改为entity对象
        map.put(id,entity);
    }

    public List<T> list(){ //返回map中存放的所有的T对象
        ArrayList<T> ts = new ArrayList<>();

        //因为这里面对应的K值都是String类型，因此前面的泛型也指出来是String类型了
        Set<String> strings = map.keySet();
        for (String o : strings) {
            ts.add(map.get(o));

            //也可以调用本类中自己重写的get方法，也是得到V值
            //ts.add(get(o));
        }
        return ts;
    }

    public void delete(String id){ //删除指定的id对象
        map.remove(id);
    }
}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
