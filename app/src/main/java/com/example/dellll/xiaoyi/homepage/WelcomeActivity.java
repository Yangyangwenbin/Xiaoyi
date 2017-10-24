package com.example.dellll.xiaoyi.homepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dellll.xiaoyi.MainActivity;
import com.example.dellll.xiaoyi.R;

public class WelcomeActivity extends Activity {
    TextView textView;
    int time = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = (TextView) findViewById(R.id.textview);

        handler.postDelayed(runnable, 3000);

    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            handler.postDelayed(this, 1000);
            textView.setText("跳转：" + time + "秒");

            if (time == 0) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        //结束线程
                        handler.removeCallbacks(runnable);
                        finish();
                    }
                });
            }
        }
    };
}




