package com.chapter11.bignum_;

import java.math.BigInteger;

//对大数进行操作
public class BigInteger_ {
    public static void main(String[] args) {
        //对于一个很大的数，此时不能用long类型来进行处理，这个时候采用BigInteger,无论多大的数据都可以搞定
        //long l = 1222222222222222222222222222222222222222l;

        //因为BigInteger是一个类，因此需要创建一个对象

        //不能直接把整数存进去，需要使用字符串来进行存储，但是得到的bigInteger仍是一个整数
        BigInteger bigInteger = new BigInteger("1222222222222222222222222222222222222222");

        System.out.println(bigInteger);

        //BigInteger不能直接进行加，减，乘，除的操作，
        // 需要使用BigInteger中的特定的方法加(add)，减(subtract)，乘(multiply)，除(divide)

        BigInteger bigInteger1 = new BigInteger("1");
        //相加以后返回的类型，仍然是一个BigInteger类型
        bigInteger = bigInteger.add(bigInteger1);
        System.out.println(bigInteger);
    }
}
