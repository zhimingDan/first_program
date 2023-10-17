package com.chapter11.bignum_;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        double d1 = 1.32323232322232;
        System.out.println(d1);
        //当我们需要保存一个精度比较多大的数据的时候，此时double就不够用了。这个时候可以采用BigDecimal来实现
        BigDecimal bigDecimal = new BigDecimal("11123321.7777777788888888889999999");
        BigDecimal bigDecimal1 = new BigDecimal("1.1");

        //但是注意一个点：BigDecimal和BigInteger一样，不能直接进行加，减，乘，除
        //需要调用对应的方法(add)，减(subtract)，乘(multiply)，除(divide)

        //这里使用加，减，乘都不在进行演示，这里直接看除法

        //BigDecimal divide = bigDecimal.divide(bigDecimal1);

        //除法可能会抛出一个异常，因为有可能除出来的数据是个无限不循环(循环)的小数
        //解决的方式也十分的简单，就是在divide(bigDecimal1)中加入BigDecimal.ROUND_CEILING 来指定精度即可
        //如果有无限不循环(循环)的小数，BigDecimal.ROUND_CEILING 指定的精度和 分子 的精度是一样的

        BigDecimal divide = bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING);
    }
}
