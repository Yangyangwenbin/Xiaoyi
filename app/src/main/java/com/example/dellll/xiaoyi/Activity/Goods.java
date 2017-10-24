package com.example.dellll.xiaoyi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

import com.example.dellll.xiaoyi.Net.Api;
import com.example.dellll.xiaoyi.Net.OkHttpUtils;
import com.example.dellll.xiaoyi.R;
import com.example.dellll.xiaoyi.adapter.GoodsAdapter;
import com.example.dellll.xiaoyi.bean.GoodListBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Goods extends BeanActivity {

    private RecyclerView mItemRv;
    private GoodsAdapter adapter;
    private Gson gson;
    private SwipeRefreshLayout mSrl;
    private List<GoodListBean.DatasBean.GoodsListBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        initView();
        Intent intent = getIntent();
        String[] gcId = intent.getStringArrayExtra("gcId");
        getinfo(true);

    }

    private void initView() {
        //获取控件
        gson = new Gson();
        mItemRv = (RecyclerView) findViewById(R.id.item_rv);
        //recycle显示布局个格式
        mItemRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GoodsAdapter(Goods.this, list);
        mItemRv.setAdapter(adapter);
        adapter.setOnItemListenr(new GoodsAdapter.OnItemListenr() {
            @Override
            public void onItemClick(GoodListBean.DatasBean.GoodsListBean goodListBean) {
                //跳转到闲情页面
                Intent intent = new Intent(Goods.this,GoodsDeta.class);
                intent.putExtra("goods_id",goodListBean.getGoods_id());
                startActivity(intent);

            }
        });
        mSrl = (SwipeRefreshLayout) findViewById(R.id.srl);
        mSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getinfo(true);
            }
        });
        mItemRv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) mItemRv.getLayoutManager();
               //总条数
                int childCount = layoutManager.getChildCount();
                //当前可见的最后一条
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                //判断是否滑动到底部
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    if(lastVisibleItemPosition == childCount-1){
                        getinfo(false);

                    }

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void getinfo(final boolean isRefres) {
        //接口请求数据             地址                   返回数据接口
        httpUtil.syncJsonStringByUrl(Api.GOODS_LIST, new OkHttpUtils.FuncJsonString() {
            @Override
            public void onResponse(String result) {
                //解析bean包数据
                GoodListBean goodListBean = gson.fromJson(result, GoodListBean.class);
                //进行并联适配器

                if (isRefres) {
                    adapter.refreshData(goodListBean.getDatas().getGoods_list());
                    mSrl.setRefreshing(false);
                }else {
                    adapter.loadMore(goodListBean.getDatas().getGoods_list());
                }
            }
        });
    }

    /*
    * 刷新数据
    * */
    public void refreshData(List<GoodListBean.DatasBean.GoodsListBean> list) {
        this.list.clear();
        this.list.addAll(list);
        //舒新适配器
        adapter.notifyDataSetChanged();
    }
}
