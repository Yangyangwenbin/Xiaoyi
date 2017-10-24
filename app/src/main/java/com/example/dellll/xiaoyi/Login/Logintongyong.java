package com.example.dellll.xiaoyi.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dellll.xiaoyi.Activity.BeanActivity;
import com.example.dellll.xiaoyi.Net.Api;
import com.example.dellll.xiaoyi.Net.OkHttpUtils;
import com.example.dellll.xiaoyi.R;
import com.example.dellll.xiaoyi.bean.RegBean;

import java.util.HashMap;
import java.util.Map;

public class Logintongyong extends BeanActivity implements View.OnClickListener {

    private ImageView mDenglufanhui;
    /**
     * 登录
     */
    private Button mLogBut;
    /**
     * 注册
     */
    private TextView mZhuce;
    /**
     * 找回密码
     */
    private TextView mZhaohui;
    private EditText mUser;
    private EditText mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logintongyong);
        initView();

    }

    private void initView() {
        mDenglufanhui = (ImageView) findViewById(R.id.denglufanhui);
        mDenglufanhui.setOnClickListener(this);
        mLogBut = (Button) findViewById(R.id.log_but);
        mLogBut.setOnClickListener(this);
        mZhuce = (TextView) findViewById(R.id.zhuce);
        mZhuce.setOnClickListener(this);
        mZhaohui = (TextView) findViewById(R.id.zhaohui);
        mZhaohui.setOnClickListener(this);
        mUser = (EditText) findViewById(R.id.user);
        mPass = (EditText) findViewById(R.id.pass);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.denglufanhui:
                finish();
                break;
            case R.id.log_but:
                String name = mUser.getText().toString().trim();
                String pass = mPass.getText().toString().trim();
                if(checkInfo(name,pass)){
                    showPd();
                    Map<String,String> map= new HashMap<String,String>();
                    map.put("username",name);
                    map.put("password",pass);
                    map.put("client","android");
                    httpUtil.sendDataForClicent(Api.LOGIN, map, new OkHttpUtils.FuncJsonString() {
                        @Override
                        public void onResponse(String result) {
                            dismissPd();
                            RegBean bean=gson.fromJson(result,RegBean.class);
                            int code=bean.getCode();
                            if(code==200){
                                String user = bean.getDatas().getUsername();
                                Intent intent= new Intent();
                                intent.putExtra("u",user);
                                setResult(2,intent);
                                finish();
                            }else {
                                toast("登录失败");
                            }
                        }
                    });

                }

                break;
            case R.id.zhuce:
                Intent intent = new Intent(Logintongyong.this, Register.class);
                startActivity(intent);
                break;
            case R.id.zhaohui:

                break;
        }
    }
    private boolean checkInfo(String name,String pass){
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pass)){
            toast("请输入内容");
            return false;
        }
        return true;
    }
}
