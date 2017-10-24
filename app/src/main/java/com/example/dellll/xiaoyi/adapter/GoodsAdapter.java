package com.example.dellll.xiaoyi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dellll.xiaoyi.R;
import com.example.dellll.xiaoyi.bean.GoodListBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by dellll on 2017.10.23.
 */

public class GoodsAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<GoodListBean.DatasBean.GoodsListBean> list;
    private OnItemListenr onItemListenr;

    public GoodsAdapter(Context context, List<GoodListBean.DatasBean.GoodsListBean> list) {
        this.context = context;
        this.list = list;
    }
    public interface OnItemListenr {
        public void onItemClick(GoodListBean.DatasBean.GoodsListBean goodsListBean);
    }

    public void setOnItemListenr(OnItemListenr onItemListenr) {
        this.onItemListenr = onItemListenr;
    }
/*
    public interface OnItemListenr {
        public void onItemClick(GoodListBean.DatasBean.GoodsListBean goodListBean);
    }

    public void setOnItemListenr(OnItemListenr onItemListener) {
        this.onItemListenr = onItemListenr;
    }*/

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //获取item条目布局
        View view = LayoutInflater.from(context).inflate(R.layout.activity_goods_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //绑定数据 并显示
        final GoodListBean.DatasBean.GoodsListBean goodsListBean = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        ImageLoader.getInstance().displayImage(goodsListBean.getGoods_image_url(), myViewHolder.iv_watch);
        // myViewHolder.iv_watch.setImageURI(goodsListBean.getGoods_image_url());
        myViewHolder.tv_goodsName.setText(goodsListBean.getGoods_name());
        myViewHolder.tv_price.setText(goodsListBean.getGoods_price());
        myViewHolder.tv_saleNum.setText(goodsListBean.getGoods_salenum());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemListenr.onItemClick(goodsListBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class MyViewHolder extends RecyclerView.ViewHolder {
        //获取item条目控件
        private TextView tv_goodsName;
        private TextView tv_price;
        private TextView tv_saleNum;
        private ImageView iv_watch;
        private LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            ll = itemView.findViewById(R.id.ll);
            iv_watch = itemView.findViewById(R.id.iv_watch);
            tv_goodsName = itemView.findViewById(R.id.tv_goodsName);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_saleNum = itemView.findViewById(R.id.tv_saleNum);

        }
    }

    /**
     * 刷新数据
     *
     * @param list
     */
    public void refreshData(List<GoodListBean.DatasBean.GoodsListBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    /**
     * 加载更多
     *
     * @param list
     */
    public void loadMore(List<GoodListBean.DatasBean.GoodsListBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
