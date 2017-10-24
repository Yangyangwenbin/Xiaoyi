package com.example.dellll.xiaoyi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.dellll.xiaoyi.R;
import com.example.dellll.xiaoyi.bean.RightChildBean;

import java.util.List;

/**
 * Created by admin on 2017/10/20/020.
 */

public class RightRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<RightChildBean.DatasBean.ClassListBean> list;
    private OnChildListtener onChildListtener;

    public interface OnChildListtener{
        void onChilditemClick(RightChildBean.DatasBean.ClassListBean classListBean);
    }
    public void setOnChildListtener(OnChildListtener onChildListtener){
        this.onChildListtener=onChildListtener;
    }
    public RightRvAdapter(Context context, List<RightChildBean.DatasBean.ClassListBean> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.right_rv_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.tv.setText(list.get(position).getGc_name());
        myViewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onChildListtener!=null){
                    onChildListtener.onChilditemClick(list.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.right_child_rv_tv);
        }
    }
}
