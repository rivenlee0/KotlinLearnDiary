package com.example.rivenlee.kotlin_learn_diary.day10;


import java.util.logging.Logger;

/**
 * author: rivenlee
 * date: 2019/8/29
 * email: rivenlee0@gmail.com
 */
public class InnerClass {

    private int a;
    public class Inner{

    }

    public static void main(String... args){
        InnerClass innerClass = new InnerClass();
        Inner inner = innerClass.new Inner();
    }
}
