package com.study.rocky.observedemo.observer;

public class TestObservable extends Observable<Boolean> {
    private static TestObservable observable;
    private TestObservable(){}
    public static TestObservable getInstance() {
        if (observable == null) {
            synchronized (TestObservable.class) {
                if (observable == null) {
                    observable = new TestObservable();
                }
            }
        }
        return observable;
    }
}
