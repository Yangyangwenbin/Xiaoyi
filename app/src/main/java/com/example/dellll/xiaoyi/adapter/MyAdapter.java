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
import com.example.dellll.xiaoyi.bean.ClassBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by admin on 2017/10/19/019.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ClassBean.DatasBean.ClassListBean> list;
    private OnItemListener onItemListener;

    public MyAdapter(Context context, List<ClassBean.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    public interface OnItemListener {
         void onItemClick(ClassBean.DatasBean.ClassListBean classListBean);
    }
    public void setOnItemListener(OnItemListener onItemListener){
        this.onItemListener=onItemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.class_left_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        String imageUrl=list.get(position).getImage();
        ImageLoader.getInstance().displayImage(imageUrl,myViewHolder.iv);
        myViewHolder.tv.setText(list.get(position).getGc_name());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemListener!=null){
                    onItemListener.onItemClick(list.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        /*if(list!=null){

            return list.size();
        }
        return 0;*/
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;
        private LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.class_left_iv);
            tv= (TextView) itemView.findViewById(R.id.class_left_tv);
            ll= (LinearLayout) itemView.findViewById(R.id.class_left_ll);
        }
    }
}
