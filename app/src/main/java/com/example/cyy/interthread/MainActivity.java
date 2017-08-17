package com.example.cyy.interthread;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.cyy.interthread.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.btn_thread_inter_a:
                Intent intent_a = new Intent(this, RunOnUiTestActivity.class);
                startActivity(intent_a);
                break;
            case R.id.btn_thread_inter_b:
                Intent intent_b = new Intent(this, PostTestActivity.class);
                startActivity(intent_b);
                break;
            case R.id.btn_thread_inter_c:
                Intent intent_c = new Intent(this, PostDelayTestActivity.class);
                startActivity(intent_c);
                break;
            case R.id.btn_thread_inter_d:
                Intent intent_d = new Intent(this, HandlerTestActivity.class);
                startActivity(intent_d);
                break;
            case R.id.btn_thread_inter_e:
                Intent intent_e = new Intent(this, AsyncTaskTestActivity.class);
                startActivity(intent_e);
                break;
        }
    }
}
