package com.chapter07.houserentsystem;
import java.util.Scanner;

public class HouseRentSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //创建一个对象来接收键盘输入
        boolean loop = true;
        HouseRentApp[] house = new HouseRentApp[1];
        house[0] = new HouseRentApp("jack","001","beijing",8000,"未出租");
        do{
            System.out.println("--------------房屋出租系统-------------");
            System.out.println("1.新增房源");
            System.out.println("2.查找房源");
            System.out.println("3.删除房源");
            System.out.println("4.修改房源信息");
            System.out.println("5.房源列表");
            System.out.println("6.退出系统");
            System.out.print("请输入你的选择(1-6)：");
            int key = scanner.nextInt();
            switch (key){
                case 1 :
                    HouseRentApp[] houseNew = new HouseRentApp[house.length + 1];
                    for (int i = 0; i < house.length; i++) {
                        houseNew[i] = house[i]; //进行数组拷贝
                    }

                    //十分注意
                    houseNew[house.length] = new HouseRentApp();  //一定要注意开辟空间


                    houseNew[house.length].addHouse(); //对最新的数组进行赋值操作
                    house = houseNew; //将让原来的数组执行新增后的数组
                    System.out.println("---------房源添加完成--------------");
                    break;
                    case 2 :
                        System.out.print("请输入你要查找的房源: ");
                        int index = scanner.nextInt();
                        if(index > house.length){
                            System.out.println("没有找到房源");
                            break;
                        }
                        System.out.println(house[index-1].find(index));  //实现房屋系统的调用
                        break;
                    case 3 :
                        System.out.print("请输入你要删除的房源: ");
                        int index1 = scanner.nextInt();
                        if(house.length == 1){ //如果数组的长度等于1，那么就不能删除了
                            System.out.println("无法删除房源");
                            break;
                        }
                        HouseRentApp[] houseNew1 = new HouseRentApp[house.length-1];
                        for (int i = 0; i < house.length - 1; i++) {
                            if((index1 - 1) == i && (index1 - 1) != (house.length -1)){  //如果到下标对应的房源，就进行删除操作
                                houseNew1[i] = house[i+1];  //如果删除的是中间的数据，那么就把后一个数据赋给新数组
                                i++;
                                continue;
                            }
                            houseNew1[i] = house[i];
                        }
                        house = houseNew1; //把删除后的数组赋给原来的数组
                        System.out.println(" ------------房源已删除--------------");
                        break;
                case 4 :
                    System.out.println("--------------------修改房屋--------------");
                    System.out.println("请选择待修改的房屋编号(-1)退出：");
                    int index2 = scanner.nextInt(); //接收到房屋编号
                    if(index2 == -1){
                        break;
                    }
                    house[index2-1].alter();
                    System.out.println("----------------修改完成------------------");
                    break;
                case 5 :
                    System.out.println("-------------------房屋列表----------------");
                    System.out.println("编号" + "\t房主" + "\t电话" + "\t地址" + "\t月租" + "\t状态");
                    for (int i = 0; i < house.length; i++) {
                        System.out.println((i+1) + "\t" + house[i].getName() +
                                "\t" + house[i].getNumber() + "\t" + house[i].getAddress() +
                                "\t" + house[i].getMouthPrice() + "\t" + house[i].getCondition());
                    }//输出房屋的信息
                    System.out.println("------------------房屋列表完成---------------");
                    break;
                case 6 :
                    System.out.println("是否确定要退出房源系统？y/n");
                    char keyChar = scanner.next().charAt(0);
                    while(true){ //对选择进行判断
                        if(keyChar == 'y' ){
                            loop = false;
                            break;
                        }else if(keyChar == 'n'){
                            break;
                        }else{
                            System.out.println("选择出错，请重新输入");
                            keyChar = scanner.next().charAt(0);
                            continue;
                        }
                    }
                    break;
                default:
                    System.out.println("您输入的选择有误，请重新输入");
            }
        }while(loop);
    }
}
