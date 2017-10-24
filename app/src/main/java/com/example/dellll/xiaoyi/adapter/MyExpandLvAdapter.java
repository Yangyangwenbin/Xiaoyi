package com.example.dellll.xiaoyi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.example.dellll.xiaoyi.Activity.Goods;
import com.example.dellll.xiaoyi.R;
import com.example.dellll.xiaoyi.bean.RightChildBean;

import java.util.List;

/**
 * Created by admin on 2017/10/20/020.
 */

public class MyExpandLvAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> group;
    private List<List<RightChildBean.DatasBean.ClassListBean>> child;

    public MyExpandLvAdapter(Context context, List<String> group, List<List<RightChildBean.DatasBean.ClassListBean>> child){
        this.context=context;
        this.group=group;
        this.child=child;
    }
    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return group.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View v= LayoutInflater.from(context).inflate(R.layout.right_title_item,null);
        TextView tv=v.findViewById(R.id.riht_title_item_tv);
        tv.setText(group.get(i));
        return v;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v=LayoutInflater.from(context).inflate(R.layout.right_child_item,null);
        RecyclerView rv=v.findViewById(R.id.right_child_rv);
        rv.setLayoutManager(new GridLayoutManager(context,3));
        RightRvAdapter adapter=new RightRvAdapter(context,child.get(i));
        rv.setAdapter(adapter);
        adapter.setOnChildListtener(new RightRvAdapter.OnChildListtener() {
            @Override
            public void onChilditemClick(RightChildBean.DatasBean.ClassListBean classListBean) {
                String gc_id=classListBean.getGc_id();
                Intent intent=new Intent(context, Goods.class);
                intent.putExtra("gcid",gc_id);
                context.startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
