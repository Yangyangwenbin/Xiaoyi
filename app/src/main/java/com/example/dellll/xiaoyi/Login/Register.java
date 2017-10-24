package com.example.dellll.xiaoyi.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dellll.xiaoyi.Activity.BeanActivity;
import com.example.dellll.xiaoyi.Net.Api;
import com.example.dellll.xiaoyi.Net.OkHttpUtils;
import com.example.dellll.xiaoyi.R;
import com.example.dellll.xiaoyi.bean.RegBean;

import java.util.HashMap;
import java.util.Map;

public class Register extends BeanActivity  {

    private ImageView mZhucefanhui;
    /**
     * 请输入账号
     */
    private EditText mRegUsername;
    /**
     * 请输入密码
     */
    private EditText mRegPass;
    /**
     * 请再次输入密码
     */
    private EditText mRegPasstrue;
    /**
     * 请输入邮箱地址
     */
    private EditText mRegEmail;
    /**
     * 注册
     */
    private Button mRegReg;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        mZhucefanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,Logintongyong.class);
                startActivity(intent);
                finish();
            }
        });
        mRegReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mRegUsername.getText().toString().trim();
                String pass = mRegPass.getText().toString().trim();
                String passtrue = mRegPasstrue.getText().toString().trim();
                String email = mRegEmail.getText().toString().trim();
                if(checkInfo(name,pass,passtrue,email)){
                    showPd();
                    Map<String,String> map=new HashMap<String, String>();
                    map.put("username",name);
                    map.put("password",pass);
                    map.put("password_confirm",passtrue);
                    map.put("email",email);
                    map.put("client","android");
                    httpUtil.sendDataForClicent(Api.REGISTER,map, new OkHttpUtils.FuncJsonString() {

                        @Override
                        public void onResponse(String result) {
                            dismissPd();
                            RegBean bean=gson.fromJson(result,RegBean.class);
                            int code=bean.getCode();
                            if(code==200){
                                Intent intent=new Intent(Register.this,Logintongyong.class);
                                startActivity(intent);
                                Register.this.finish();
                            }else{
                                toast("注册失败");
                            }
                        }
                    });
                }
            }
        });
    }
    private boolean checkInfo(String name,String pass,String passtrue,String email){
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(passtrue)||TextUtils.isEmpty(email)){
            toast("请输入内容");
            return false;
        }
        return true;
    }

    private void initView() {
        mZhucefanhui = (ImageView) findViewById(R.id.zhucefanhui);
        mRegUsername = (EditText) findViewById(R.id.reg_username);
        mRegPass = (EditText) findViewById(R.id.reg_pass);
        mRegPasstrue = (EditText) findViewById(R.id.reg_passtrue);
        mRegEmail = (EditText) findViewById(R.id.reg_email);
        mRegReg = (Button) findViewById(R.id.reg_reg);

    }


}
