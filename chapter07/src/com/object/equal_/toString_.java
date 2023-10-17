package com.object.equal_;

public class toString_ {
    public static void main(String[] args) {
        //toString 方法的源码

        //getClass().getName()  返回全类名(包名+类名)
        //Integer.toHexString(hashCode())  将对象的哈希码值转换为十六进制
        /*
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
         */
        Monster monster = new Monster("XYG", "巡山");
        System.out.println(monster); //直接输出对象，则默认是调用toString方法
        //等价于
        System.out.println(monster.toString());

    }
}

class Monster{
    private String name;
    private String word;

    public Monster(String name, String word) {
        this.name = name;
        this.word = word;
    }

    @Override
    public String toString() {  //重写toString方法，默认是返回对象的属性信息
        return "Monster{" +
                "name='" + name + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
