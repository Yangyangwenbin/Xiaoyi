package com.example.dellll.xiaoyi.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dellll.xiaoyi.Net.OkHttpUtils;
import com.google.gson.Gson;

import java.util.LinkedList;

/**
 * Created by dellll on 2017.10.20.
 */

public class BeanActivity  extends AppCompatActivity {
    private LinkedList<Activity> list = new LinkedList<>();
    protected OkHttpUtils httpUtil;
    private ProgressDialog dialog;
    protected Gson gson;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        httpUtil=OkHttpUtils.getInstance(this);
        gson=new Gson();
    }

    protected void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    /**
     * 显示进度条
     */
    protected void showPd() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加載...");
        dialog.show();
    }

    /**
     * 关闭进度条
     */
    protected void dismissPd() {
        if (dialog != null && !this.isFinishing()) {
            dialog.dismiss();
        }
    }

}
