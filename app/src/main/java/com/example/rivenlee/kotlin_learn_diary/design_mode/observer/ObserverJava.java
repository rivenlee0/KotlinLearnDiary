package com.example.rivenlee.kotlin_learn_diary.design_mode.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * 观察者
 */
interface Observer {
    void update(Object object);
}

/**
 * 被观察者
 */
abstract class Observable {
    List<Observer> observerList = new ArrayList<>();

    public void register(Observer observer){
        this.observerList.add(observer);
    }

    public void unRegister(Observer observer){
        this.observerList.remove(observer);
    }

    public void notifyAllObservers(Object object){
        for (Observer observer : observerList) {
            observer.update(object);
        }
    }
}