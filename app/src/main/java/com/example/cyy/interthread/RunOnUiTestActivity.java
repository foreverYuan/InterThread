package com.example.cyy.interthread;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.cyy.interthread.base.BaseActivity;

/**
 * Created by user on 2017/8/17.
 */

public class RunOnUiTestActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.test_list_item);
        //刚开始从主线程（UI线程）开始
        getProcessInfo(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程（工作线程），处理耗时操作
                getProcessInfo(false);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //回到主线程（UI线程），处理UI
                        getProcessInfo(true);
                    }
                });
            }
        }).start();
    }
}
