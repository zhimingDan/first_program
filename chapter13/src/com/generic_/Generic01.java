package com.generic_;

//泛型的介绍：
//泛型的作用是可以在类声明的时候，通过一个标志符表示类中某个属性的类型，或者某个方法的返回值类型，或者是参数类型
public class Generic01 {
    public static void main(String[] args) {
        Person<String> person1 = new Person<>("jack");
        //这样创建一个对象的时候，就好像：把下面这个类中所有的E地方全部替换成了String，而E可以指定任意的类型
        //因此创建的对象也会相应的发生变化
        /*
        class Person{  //这个字母是任意的，一般使用E,T等
            public String name;  //这个时候,name的类型由我创建class对象的时候来进行指定

            public Person(String name) { //E也可以在参数这个地方体现
                this.name = name;
            }

            public String f(){  //E也可以在返回值这个地方体现
                return name;
            }
        }

         */
    }
}

class Person<E>{  //这个字母是任意的，一般使用E,T等，E的数据类型在编译期就已经确定了
    //如果按照传统方式，我声明成员变量的时候必须需要指定数据类型
    //public String name;  //而且我一旦指定，name的数据类型就不能再进行修改
    //但是我想自己动态的进行类型指定，这个时候就可以使用泛型

    public E name;  //这个时候,name的类型由我创建class对象的时候来进行指定

    public Person(E name) { //E也可以在参数这个地方体现
        this.name = name;
    }

    public E f(){  //E也可以在返回值这个地方体现
        return name;
    }
}
