package com.study.rocky.observedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.study.rocky.observedemo.handler.DeptManager;
import com.study.rocky.observedemo.handler.GeneralManager;
import com.study.rocky.observedemo.handler.Handler;
import com.study.rocky.observedemo.handler.ProjectManager;
import com.study.rocky.observedemo.observer.IObserver;
import com.study.rocky.observedemo.observer.Observable;
import com.study.rocky.observedemo.observer.TestObservable;

public class MainActivity extends AppCompatActivity {

    private IObserver<Boolean> iObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        iObserver = new IObserver<Boolean>() {
//            @Override
//            public void update(Observable<Boolean> observable, Boolean aBoolean) {
//                if (aBoolean) {
//                    Log.d("MainActivity", "接收到通知");
//                }
//            }
//        };
//        TestObservable.getInstance().register(iObserver);
//        TestObservable.getInstance().notifyDataChanged(true);






        //先要组装责任链
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试
        String test1 = h3.handleFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = h3.handleFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");

        String test3 = h3.handleFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = h3.handleFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");

        String test5 = h3.handleFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = h3.handleFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        TestObservable.getInstance().unregister(iObserver);
    }
}
