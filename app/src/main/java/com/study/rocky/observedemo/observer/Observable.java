package com.study.rocky.observedemo.observer;

import java.util.ArrayList;
import java.util.List;

//被观察者
public class Observable<T> {
    //提供三个方法 并且维护观察者
    private List<IObserver<T>> observers = new ArrayList<>();

    //注册
    public void register(IObserver<T> observer) {
        observers.add(observer);
    }

    //反注册
    public void unregister(IObserver<T> observer) {
        if (observer == null) {

        } else {
            if (observers.contains(observer)) {
                observers.remove(observer);
            }
        }
    }
    //通知观察者 数据更新
    public void notifyDataChanged(T data){
        for (IObserver<T> observer : observers) {
            observer.update(this,data);
        }
    }
}
