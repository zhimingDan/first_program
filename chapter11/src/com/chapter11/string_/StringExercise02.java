package com.chapter11.string_;

/*  编程题：
    1.编写java程序，输入形式为：Han shun ping 的人名，要求以Ping,Han.S的形式打印出来，其中.s是中间字母的大写

 */
public class StringExercise02 {
    public static void main(String[] args) {
        String name = "willian jefferson clinton";
        String[] spilt = name.split(" ");
        char[][] ch = new char[3][];
        ch[0] = spilt[2].toCharArray();
        ch[1] = spilt[0].toCharArray();
        ch[2] = spilt[1].toCharArray();

        String str = "";
        for (int i = 0; i < ch.length; i++) {
            ch[i][0] = Character.toUpperCase(ch[i][0]); //把每个段的首字母编程大写
            for (int j = 0; j < ch[i].length; j++) {
                str += ch[i][j] + "";  //把其拼成一个字符串
                if(i == ch.length -1)
                    break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.insert((ch[0].length + ch[1].length),"."); //从后面开始插起
        stringBuilder.insert(ch[0].length,",");
        System.out.println(stringBuilder);
    }
}
