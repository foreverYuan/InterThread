package com.example.cyy.interthread.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import java.util.List;

/**
 * Created by user on 2017/8/17.
 */

public class BaseActivity extends AppCompatActivity {
    public ActivityManager manager;
    private StringBuilder builder;
    public static final String THREAD_TAG = "thread_tag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        if(manager == null) {
            manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        }
    }

    public void getProcessInfo(boolean isShow){
        List<ActivityManager.RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
        if(builder == null) {
            builder = new StringBuilder();
        }
        for (ActivityManager.RunningAppProcessInfo processInfo : processes) {
            builder.append("当前进程id:")
                    .append(processInfo.pid)
                    .append("\n当前线程id:")
                    .append(Thread.currentThread().getId())
                    .append("\n当前线程状态:")
                    .append(Thread.currentThread().getState())
                    .append("\n");
        }
        if(isShow){
            ((TextView) findViewById(android.R.id.text1)).setText(builder.toString());
            Log.e(THREAD_TAG, builder.toString());
        }
    }
}
