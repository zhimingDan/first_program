package com.chapter11.string_;

public class StringExercise04 {
    String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};

    public void change(String str,char[] ch){
        str = "java";
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        StringExercise04 ex = new StringExercise04();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + "and");
        for (int i = 0; i < ex.ch.length; i++) {
            System.out.print(ex.ch[i]);
        }
    }
}
