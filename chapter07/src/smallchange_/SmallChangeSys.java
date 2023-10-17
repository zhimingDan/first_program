//使用字符串的方式去完成项目
package smallchange_;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        double money = 0;
        double balance = 0; //用于显示余额
        String add = ""; //用于接收消费的地点
        String str = "===================收益入账=====================";
        Scanner scanner = new Scanner(System.in);
        String choice = "";//用来判断是否退出零钱通
        Date date = null; //java中用date引用来接收时间，当创建好对象的时候，就会自动创建对象的时间，因此此时
        //该引用指向null,但是得到的时间的格式是国外的格式，因此需要进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于将得到的时间格式化

        do{
            System.out.println("====================零钱通菜单================");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 消费");
            System.out.println("\t\t\t\t4 退出");
            System.out.print("请输入选择1-4：");
            String key = scanner.next();

            //分析上述方法可知，使用switch方法最方便，因为本身就是选项的形式，比if-else方式更加简洁
            switch(key){
                case "1" :
                    System.out.println("零钱通明细：");
                    System.out.println(str);
                    break;
                case "2" :
                    money = scanner.nextDouble(); //定义一个变量来接收输入的金额
                    //判断收益的金额是否符合要求,过关斩将的思维方式
                    if(money <= 0){
                        System.out.println("你输入的金额有误");
                        break;
                    }
                    balance += money;
                    date = new Date(); //创建一个Date对象，此时创建对象的时间就是date引用的时间
                    str += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额" +balance;
                    break;
                case "3" :
                    System.out.println("请输入消费的地点");
                    add = scanner.next();
                    System.out.println("请输入消费的金额");
                    money = scanner.nextDouble();
                    //消费金额返回的校验，因为你的消费不能超过你的余额
                    if(money <= 0 || money >balance){
                        System.out.println("消费金额应该在 0-" + balance);
                    }
                    date = new Date(); //创建一个Date对象
                    balance -= money;//计算余额
                    str += "\n"+ add +"\t-" + money + "\t" + sdf.format(date) + "\t余额" +balance;
                    break;
                case "4" :
                    //此时可以发现，如果想要退出do - while 循环是不方便的，因为while()中始终都是true
                    //如果在这里写一个break语句的话，默认是退出switch语句，因此，可以使用变量来进行退出控制

                    //建议一段代码完成一个功能
                    while(true){
                        System.out.println("是否要退出零钱通 y/n");
                        choice = scanner.next();
                        if("y".equals(choice) || "n".equals(choice)){ //判断输入的是否是y/n，
                            // 如果不是就不进行判断，并循环询问是否要退出零钱通
                            break;
                        }
                    }
                    if("y".equals(choice)){
                        loop = false;
                    }//如果是n，则不做任何处理
                    break;
                default:
                    System.out.println("您输入的选择有误，请重新输入1-4");
            }
        }while(loop); // 此时可以巧妙的解决选择退出零钱通的问题
        System.out.println("您已退出零钱通");
    }
}
