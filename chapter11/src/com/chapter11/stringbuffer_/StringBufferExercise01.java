package com.chapter11.stringbuffer_;

import java.util.Scanner;

/*   StringBuffer的课堂练习题：
     输入商品的名称以及价格，要求输出的格式如下
     商品名    价格
     手机      123,456.88
     要求，小数点的前面每三位都用逗号隔开
 */
public class StringBufferExercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品的名称");
        String name = scanner.next();
        System.out.println("请输入" + name + "的价格：");
        double price = scanner.nextDouble();
        int num1 = (int)price;
        int length1 = 0;
        while(true){
            if(num1 == 0){
                break;
            }
            num1 /= 10;
            length1++;
        }
        String priceString = price+"";
        StringBuffer stringBuffer = new StringBuffer(priceString);
        while(true){
            length1 -= 3;
            if(length1 <= 0){
                break;
            }
            stringBuffer.insert(length1,",");
        }
        System.out.println(stringBuffer);
    }
}


//StringBuffer中提供了indexOf()查找的方法，以及insert()方法
class StringBufferExercise02{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String price = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(price);
        //找到小数点的位置，然后通过以小数点的位置为基准向前添加","
        for (int i = stringBuffer.lastIndexOf(".") - 3; i > 0 ; i -= 3) {
            stringBuffer.insert(i,",");
        }
        System.out.println(stringBuffer);
    }
}


class StringBufferExercise_{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名：");
        String str = scanner.next();
        System.out.println("请输入金额：");
        StringBuilder stringBuilder = new StringBuilder(scanner.next()); //将输入的字符串转化为StringBuilder类型
        int index = stringBuilder.indexOf(".");
        for (int i = index - 3 ; i > 0 ; i -= 3) {
            stringBuilder = stringBuilder.insert(i,",");
        }
        System.out.println("商品名\t价格\n" + str + "\t" + stringBuilder);
    }
}

