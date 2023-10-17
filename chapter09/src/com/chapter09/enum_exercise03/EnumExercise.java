package com.chapter09.enum_exercise03;

//枚举类型中的toString方法只是输出枚举实例的名字
public class EnumExercise {
    enum Gender{ //定义一个性别类,性别中不止包含了这一个属性，而是包含了很多东西
        BOY("男生","jack"),GIRL("女生","marry");
        private String gender;
        private String name;

        Gender(String gender, String name) {
            this.gender = gender;
            this.name = name;
        }

        @Override
        public String toString() {
            return "名字：" + name + " 性别：" + gender;
        }
    }

    public static void main(String[] args) {
        switch(Gender.BOY){
            case BOY :
                System.out.println(Gender.BOY);
                break;
            case GIRL:
                System.out.println(Gender.GIRL);
        }
    }
}

