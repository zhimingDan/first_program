package com.chapter11.string_;


//输入一个字符串判断里面有多少个大写的字母，多少个小写的字母，多少个数字
public class StringExercise03 {
    public static void main(String[] args) {
        String str = "123456sdafasfAJDFJASDF";
        char[] ch = str.toCharArray();
        int digitCount = 0;
        int upperLetterCount = 0;
        int lowerLetterCount = 0;

        for (int i = 0; i < ch.length; i++) {
            if(Character.isDigit(ch[i])){
                digitCount ++;
            }else if(Character.isUpperCase(ch[i])){
                upperLetterCount++;
            }else if(Character.isLowerCase(ch[i])){
                lowerLetterCount++;
            }
        }
        System.out.println("数字的个数：" + digitCount + " 大写字母的个数：" + upperLetterCount +
                " 小写字母的个数：" + lowerLetterCount);
    }
}
