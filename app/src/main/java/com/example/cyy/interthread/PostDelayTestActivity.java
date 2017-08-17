package com.example.cyy.interthread;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.example.cyy.interthread.base.BaseActivity;

/**
 * Created by user on 2017/8/17.
 */

public class PostDelayTestActivity extends BaseActivity{
    private TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.test_list_item);
        //刚开始从主线程（UI线程）开始
        getProcessInfo(false);
        text = (TextView) findViewById(android.R.id.text1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程（工作线程），处理耗时操作
                getProcessInfo(false);
                text.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //回到主线程（UI线程），处理UI
                        getProcessInfo(true);
                    }
                }, 5000);
            }
        }).start();
    }
}
