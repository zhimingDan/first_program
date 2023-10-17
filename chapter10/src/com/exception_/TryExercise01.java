package com.exception_;

//异常的练习题：
public class TryExercise01 {
    public static int method(){
        String[] str = new String[3]; //这里创建了一个字符串数组，但是没有赋值，因此里面数组的值默认为null
        try {
            if(str[1].equals("tom")){ //因此这里会发生空指针异常的情况！！！！
                System.out.println(str[1]);
            }else{
                str[3] = "jack";  //前面就发生了异常，因此程序是不会执行到这里的
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
                return 2;
        }catch(NullPointerException e){
            //由于发生了空指针异常，本来应该执行返回3，但是由于finally必须执行，且return这个语句返回时
            // 只能返回一个值，因此最后的返回结果应该是finally的值
            return 3; //这句话不是不会执行，而是执行以后不会立马返回值
        }finally{
            return 4;
        }
    }

    public static void main(String[] args) {
        System.out.println(method()); //返回结果为4
    }
}

//练习2：
class TryExercise02{
    public static int method(){
        int i = 1;
        i++;
        String[] str = new String[3]; //这里创建了一个字符串数组，但是没有赋值，因此里面数组的值默认为null
        try {
            if(str[i].equals("tom")){ //因此这里会发生空指针异常的情况！！！！
                System.out.println(str[1]);
            }else{
                str[i+2] = "jack";  //前面就发生了异常，因此程序是不会执行到这里的
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        }catch(NullPointerException e){
            //由于发生了空指针异常，本来应该执行返回3，但是由于finally必须执行，因此最后的返回结果应该是finally的值
            return i++; //这句话不是不会执行，而是执行以后不会立马返回值
        }finally{
            return ++i;
        }
    }

    public static void main(String[] args) {
        System.out.println("类2的结果为：" + method()); //返回结果为4
    }
}

//练习2：
class TryExercise03{
    public static int method(){
        int n = 1;
        n++;
        String[] str2 = new String[3]; //这里创建了一个字符串数组，但是没有赋值，因此里面数组的值默认为null
        try {
            if(str2[n].equals("tom")){ //因此这里会发生空指针异常的情况！！！！
                System.out.println(str2[1]);
            }else{
                str2[n+2] = "jack";  //前面就发生了异常，因此程序是不会执行到这里的
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        }catch(NullPointerException e){
            //由于发生了空指针异常，本来应该执行返回3，但是由于finally必须执行，因此最后的返回结果应该是finally的值
            //这句话不是不会执行，而是执行以后不会立马返回值,因为下面的finally语句没有返回值，因此会生成一个
            //临时变量temp = 3，然后执行下面的finally语句，最后再返回temp变量中的值
            //catch中返回值的时候都会生成一个临时变量temp,该return语句一定是返回该temp值
            return n++;
        }finally{
            n++;
            System.out.println("n = " + n);
        }
    }

    public static void main(String[] args) {
        System.out.println("类3的结果为：" + method()); //返回结果为n = 4 ,3
    }
}
