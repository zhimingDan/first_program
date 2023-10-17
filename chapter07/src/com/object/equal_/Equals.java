package com.object.equal_;

public class Equals {
    public static void main(String[] args) {
        //Object类中的equals方法的应用
        //Object中equals方法的原码如下
        /*
        public boolean equals(Object anObject) {
            if (this == anObject) {  //如果是同一个对象，this本来就表示该对象
                return true;
            }
            if (anObject instanceof String) { //判断输入的对象的运行类型和String是否相同或者是String类型的子类
                String anotherString = (String)anObject; //向下转型
                int n = value.length;
                if (n == anotherString.value.length) {
                    char v1[] = value;
                    char v2[] = anotherString.value;
                    int i = 0;
                    while (n-- != 0) {
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    return true;
                }
            }
            return false;
    }
         */
        //"hello".equals("abc");
        /*
        public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
    }
         */
        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);
        System.out.println(integer1 == integer2); //结果为false，因为引用类型的话==是判断地址相等
        System.out.println(integer1.equals(integer2)); //结果为true ,因为equals是判断值是否相等

    }
}
