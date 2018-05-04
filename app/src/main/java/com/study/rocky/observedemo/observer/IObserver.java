package com.study.rocky.observedemo.observer;

//抽象观察者
public interface IObserver<T> {
    //提供数据的更新方法
    public void update(Observable<T> observable,T t);
}
