package com.example.dellll.xiaoyi;


import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dellll.xiaoyi.fragment.FragmentMine;
import com.example.dellll.xiaoyi.fragment.FragmentShop;
import com.example.dellll.xiaoyi.fragment.FragmentType;
import com.example.dellll.xiaoyi.fragment.FramentIndex;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg;
    private FragmentManager manager;
    private RadioButton rbout1,rbout2,rbout3,rbout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取Fragment管理者
         manager=getSupportFragmentManager();
        //默认加载第一个页面
        manager.beginTransaction().replace(R.id.fram, new FramentIndex()).commit();
        initView();
    }
    private  void initView(){
        rg= (RadioGroup) findViewById(R.id.rg);
        rbout1= (RadioButton) findViewById(R.id.rbout1);
        rbout2= (RadioButton) findViewById(R.id.rbout2);
        rbout3= (RadioButton) findViewById(R.id.rbout3);
        rbout4= (RadioButton) findViewById(R.id.rbout4);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rbout1:
                        getFragment(new FramentIndex());
                        break;
                    case R.id.rbout2:
                        getFragment(new FragmentType());
                        break;
                    case R.id.rbout3:
                        getFragment(new FragmentShop());
                        break;
                    case R.id.rbout4:
                        getFragment(new FragmentMine());
                        break;
                }
            }
        });
    }
    //接受回调值
    protected  void onActivityResul(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        FragmentMine fu=null;
        //使用bundle传递给fragment
        if(data!=null){
            String user=data.getStringExtra("u");
            Bundle bundle=new Bundle();
            bundle.putString("user",user);
            fu=new FragmentMine();
            fu.setArguments(bundle);
            if (requestCode==1&&requestCode==2){
                //fu=new FragmentUser();
                getFragment(new FragmentMine());
                manager.beginTransaction().replace(R.id.fram,fu).commit();
            }
        }else {
            if(requestCode==1&&resultCode==2){
                fu=new FragmentMine();
                //getFragment(new FragmentUser());
                manager.beginTransaction().replace(R.id.fram,fu).commit();
            }
        }

    }
    /**
     * 加载Fragment
     */
    private void getFragment(Fragment fragment){
        manager.beginTransaction().replace(R.id.fram,fragment).commit();
    }
}
