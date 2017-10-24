package com.example.dellll.xiaoyi.Net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.dellll.xiaoyi.Utils.NetWorkUtil;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by admin on 2017/10/16/016.
 */

public class OkHttpUtils {

    //声明客户端
    private OkHttpClient client;
    //防止多个线程同时访问所造成的安全隐患
    private volatile static OkHttpUtils utils;
    private Context context;
    //子线程
    private Handler handler;
    //构造方法
    private OkHttpUtils(Context context){
        //拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client=new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        handler=new Handler(Looper.getMainLooper());
        this.context=context;
    }
    //单例模式
    public static OkHttpUtils getInstance(Context context){
        if(utils==null){
            //线程同步锁
            synchronized (OkHttpUtils.class){
                if(utils==null){
                    utils=new OkHttpUtils(context);
                    utils=utils;
                }
            }
        }
        return utils;
    }

    //网络请求
    public void syncJsonStringByUrl(String url, final FuncJsonString callback){
        //网络判断
        if (!NetWorkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "没有网络，请查看设置", Toast.LENGTH_SHORT).show();
            return;
        }
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("TAG", "解析失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response!=null&&response.isSuccessful()){
                    OnSuccessJsonString(response.body().string(),callback);
                }
            }
        });
    }

    //post提交表单数据
    public void sendDataForClicent(String url, Map<String,String> params, final FuncJsonString callback){
        //网络判断
        if (!NetWorkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "没有网络，请查看设置", Toast.LENGTH_SHORT).show();
            return;
        }
        //表单对象，包含input开始的操作
        FormBody.Builder from=new FormBody.Builder();
        if(params != null && !params.isEmpty()){
            for (Map.Entry<String,String> entry:params.entrySet()){
                //装载表单值
                from.add(entry.getKey(),entry.getValue());
            }
        }
        RequestBody body=from.build();
        //post提交
        Request request=new Request.Builder().url(url).post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("TAG", "解析失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response!=null&&response.isSuccessful()){
                    OnSuccessJsonString(response.body().string(),callback);
                }
            }
        });
    }

    //返回json字符串的接口
    public interface FuncJsonString{
        void onResponse(String result);
    }
    //请求的返回是json字符串
    private void OnSuccessJsonString(final String jsonValue, final FuncJsonString callback){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(callback!=null){
                    try {
                        callback.onResponse(jsonValue);
                    }catch (Exception e){

                    }
                }
            }
        });
    }
}
