import java.util.Scanner;
//在IDEA中，当我们run一个文件的手，会先编译成.class字节码文件，然后再运行

public class Mytools {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner myScanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myScanner.nextInt();
        }
        //实现对数组进行逆序排序(使用冒泡排序法)
        for(int i = 0 ; i < arr.length -1 ; i++){
            for(int j = 0 ; j < arr.length - i - 1 ; j++){
                int temp; //定义一个中间变量用来交换两个数据
                if(arr[j] < arr[j+1]){//如果后面的数据大于前面的数据，就进行交换
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //循环输出排序后的数组
        System.out.println("排序后的数组为：");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] +" ");
        }
    }
}

