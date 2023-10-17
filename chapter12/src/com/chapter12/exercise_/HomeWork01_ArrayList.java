package com.chapter12.exercise_;

import java.util.ArrayList;

/*  按要求实现：
    1.封装一个新闻类，包含标题和内容属性，提供get,set方法，重写toString方法，打印对象时只打印标题
    2.只提供一个带参数的构造器，实例化对象时，只初始化标题，并且实例化两个对象：
    新闻一：新冠确诊病例超千万，数百万印度信徒恒河"圣浴"引民众担忧
    新闻二：男子突然想起2个月前钓的鱼还在网兜，捞起一看赶紧放生
    3.将新闻对象添加到ArrayList集合中，并且进行倒叙遍历
    4.在遍历集合的过程中，对新闻标题进行处理，超过15字只保留15个字，然后在后面添加...
    5.在控制台中输出打印遍历出经过处理的新闻标题
 */
public class HomeWork01_ArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("新冠确诊病例超千万，数百万印度信徒恒河\"圣浴\"引民众担忧!!!"));
        arrayList.add(new News("男子突然想起2个月前钓的鱼还在网兜，捞起一看赶紧放生!!!"));

        for(int i = arrayList.size() - 1 ; i >= 0 ; i--){
             Object obj= arrayList.get(i);   //get方法的返回类型是Object类型
            News news = (News) obj;          //进行向下转型
            if(news.getTitle().length() > 15){ //如果新闻表题超过了15个字
                String str = news.getTitle().substring(0,15);
                System.out.println(str.concat("..."));
            }else{
                System.out.println(news.getTitle());
            }
        }
    }

    //以上代码的耦合性太差，应该专门单独写一个显示新闻标题的方法

    public static void show(){

    }
}

class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "title = " + title;
    }
}
