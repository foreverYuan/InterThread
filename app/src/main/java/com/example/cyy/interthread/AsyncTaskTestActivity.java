package com.example.cyy.interthread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.cyy.interthread.base.BaseActivity;

/**
 * Created by user on 2017/8/17.
 */

public class AsyncTaskTestActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.test_list_item);
        //刚开始从主线程（UI线程）开始
        getProcessInfo(false);
        //执行异步任务
        new MyAsyncTask().execute();
    }

    class MyAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            //子线程（工作线程），处理耗时操作
            getProcessInfo(false);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //回到主线程（UI线程），处理UI
            getProcessInfo(true);
        }
    }
}
