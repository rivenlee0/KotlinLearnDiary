package com.example.rivenlee.kotlin_learn_diary.day15;

import android.util.SparseIntArray;

import java.util.HashMap;

/**
 * author: rivenlee
 * date: 2019/9/10
 * email: rivenlee0@gmail.com
 */
public class MainClass {

    private int[] ints = {
            1,2,3,4,5,6,7,8,9,9,0,2
    };

    public void forEach(){
        SparseIntArray sparseIntArray = new SparseIntArray();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int anInt : ints) {
            Integer count = hashMap.get(anInt);
            if (count == null) {
                sparseIntArray.put(anInt, 1);
                hashMap.put(anInt, 1);
            } else {
                sparseIntArray.put(anInt, count + 1);
                hashMap.put(anInt, count + 1);
            }
        }
        System.out.println(sparseIntArray);
    }
}
