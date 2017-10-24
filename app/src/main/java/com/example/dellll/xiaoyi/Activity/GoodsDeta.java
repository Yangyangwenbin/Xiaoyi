package com.example.dellll.xiaoyi.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dellll.xiaoyi.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class GoodsDeta extends AppCompatActivity {

    private SimpleDraweeView mSdv;
    private TextView mTvGoodsMsg;
    private LinearLayout mLlToCard;
    private LinearLayout mLlAddCard;
    private RelativeLayout mRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_deta);
        initView();

    }
    private  void getInfo(){


    }

    private void initView() {
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
        mTvGoodsMsg = (TextView) findViewById(R.id.tv_goodsMsg);
        mLlToCard = (LinearLayout) findViewById(R.id.ll_toCard);
        mLlAddCard = (LinearLayout) findViewById(R.id.ll_addCard);
        mRl = (RelativeLayout) findViewById(R.id.rl);
    }
}
