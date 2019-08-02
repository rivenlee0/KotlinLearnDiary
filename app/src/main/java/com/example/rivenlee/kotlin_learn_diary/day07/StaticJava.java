package com.example.rivenlee.kotlin_learn_diary.day07;


/**
 * author: rivenlee
 * date: 2019/8/2
 * email: rivenlee0@gmail.com
 */
public class StaticJava {

    public void method(){
        Latitude latitude = Latitude.Companion.ofDouble(3.0);
        //kotlin使用 @JVMStatic注解声明静态方法
        Latitude latitude1 = Latitude.ofLatitude(latitude);

        //kotlin使用 @JVMField注解声明静态属性
        String tag = Latitude.TAG;
        String tag1 = Latitude.Companion.getTAG1();
    }
}
