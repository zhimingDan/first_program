package com.chapter11.string_;

/*  编程题：
    将指定位置的字符串中的内容进行翻转，可以指定长度
 */
public class StringExercise {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverse(str,1,6));
    }

    public static String reverse(String str, int start, int end){
        String strNow = str.substring(start, end); //截取指定范围的字符串
        int m = end - start;
        String str1 = "";
        char[] ch = new char[m];
        for (int i = 0; i < m; i++) {
            ch[i] = strNow.charAt(i);
        }
        char temp;
        for (int i = 0; i < m/2; i++) { //交换字符中位置
            temp = ch[i];
            ch[i] = ch[m - i -1];
            ch[m - i -1] = temp;
        }
        for (int i = 0; i <ch.length ; i++) {
            str1 += ch[i] + "";
        }
        StringBuilder stringBuilder = new StringBuilder(str); //创建一个StringBuilder对象
        stringBuilder.replace(start,end,str1);
        return stringBuilder.toString();
    }
}


//老师的代码如下：仔细学习老师的代码

class StringExercisePro{
    public static void main(StringExercise01[] args) {
        String str = "abcdefg";
        //在调用该方法中接收并处理该异常
        System.out.println("交换前的字符串为：");
        System.out.println(str);
        try {
            str = reverse(str,1,40);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        //但是这里如果输入的字符是null等等，会出现异常，因此可以进行异常机制的处理
        System.out.println("交换过后的字符串为：");
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end){//返回值是可以返回该类的对象的

        //极其重要的编程思想！！！！
        //对于需要列出的情况的步骤：
        //1.写出所有正确的情况
        //2.然后取反就可以得到所有错误的情况

        //进行异常处理
        if(!(str != null && start >= 0 && end > start && end < str.length())){
            //如果不满足以上情况，那么就可以抛出一个异常
            throw new RuntimeException("输入的参数不正确");
        }

        //因为String类型中存储的数据是一个常量，因此无法直接改变该类型中的值，可以通过一个char数组来进行接收
        char[] ch = str.toCharArray();
        char temp = ' '; //定义一个用于交换的临时变量
        //这里得到了数组，对于数组的交换，可以采用双指针的形式，进行交换
        for (int i = start,j = end; i < j ; i++,j--) {
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
        return new String(ch); //重新构建一个String类型
    }
}
