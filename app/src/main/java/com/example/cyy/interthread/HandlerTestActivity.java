package com.example.cyy.interthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.example.cyy.interthread.base.BaseActivity;

/**
 * Created by user on 2017/8/17.
 */

public class HandlerTestActivity extends BaseActivity{
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //回到主线程（UI线程），处理UI
            getProcessInfo(true);
            switch (msg.what) {
                case 0:
                    Toast.makeText(HandlerTestActivity.this, "收到子线程发送的消息:" + msg.obj, Toast.LENGTH_LONG).show();
            }
        }
    };
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
                Message msg = new Message();
                msg.what = 0;
                msg.obj = "我的id是" + Thread.currentThread().getId();
                handler.sendMessage(msg);
                getProcessInfo(false);
            }
        }).start();
    }
}
