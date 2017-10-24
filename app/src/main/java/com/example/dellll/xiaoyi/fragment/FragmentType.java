package com.example.dellll.xiaoyi.fragment;

import android.graphics.RegionIterator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.dellll.xiaoyi.Net.Api;
import com.example.dellll.xiaoyi.Net.OkHttpUtils;
import com.example.dellll.xiaoyi.R;
import com.example.dellll.xiaoyi.adapter.MyAdapter;
import com.example.dellll.xiaoyi.adapter.MyExpandLvAdapter;
import com.example.dellll.xiaoyi.bean.ClassBean;
import com.example.dellll.xiaoyi.bean.RightBean;
import com.example.dellll.xiaoyi.bean.RightChildBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellll on 2017.10.09.
 */

public class FragmentType extends Fragment {
    private RecyclerView classRv;
    private View view;
    private RecyclerView mClassRv;
    private ExpandableListView mClassElv;
    private OkHttpUtils httpUtils;
    private List<String> group = new ArrayList<>();
    private List<List<RightChildBean.DatasBean.ClassListBean>> child = new ArrayList<>();
    private Gson gson;
    private int titlesize;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        view = inflater.inflate(R.layout.fragmenttype, container, false);

        initView(view);
        getLeft();

        return view;
    }

    //左侧列表
    private void getLeft() {
        //进行请求数据
        httpUtils.syncJsonStringByUrl(Api.CLASS, new OkHttpUtils.FuncJsonString() {
            @Override
            public void onResponse(String result) {
                ClassBean bean = FragmentType.this.gson.fromJson(result, ClassBean.class);
              /*  ClassBean bean = gson1.fromJson(result, ClassBean.class);*/
                List<ClassBean.DatasBean.ClassListBean> class_list = bean.getDatas().getClass_list();
                if (bean.getCode() == 200) {
                    //Toast.makeText(getContext(),class_list.toString(),Toast.LENGTH_LONG).show();
                    MyAdapter adapter = new MyAdapter(getActivity(), bean.getDatas().getClass_list());
                    mClassRv.setAdapter(adapter);
                    getRight(bean.getDatas().getClass_list().get(0).getGc_id());
                    adapter.setOnItemListener(new MyAdapter.OnItemListener() {
                        @Override
                        public void onItemClick(ClassBean.DatasBean.ClassListBean classListBean) {
                            String gc_id = classListBean.getGc_id();
                            getRight(gc_id);
                        }
                    });
                }
            }
        });
    }

    private void getRight(String gcid) {
        String url = String.format(Api.RIGHT, gcid);
        httpUtils.syncJsonStringByUrl(url, new OkHttpUtils.FuncJsonString() {

            @Override
            public void onResponse(String result) {
                RightBean bean = gson.fromJson(result, RightBean.class);
                //防止添加重复的数据
                if (bean.getCode() == 200) {
                    if (group.size() > 0) {
                        group.clear();
                    }
                    //防止重复的数据
                    if (child.size() > 0) {
                        child.clear();
                    }
                    titlesize = bean.getDatas().getClass_list().size();
                    for (int i = 0; i < titlesize; i++) {
                        group.add(bean.getDatas().getClass_list().get(i).getGc_name());
                        String gc_id = bean.getDatas().getClass_list().get(i).getGc_id();
                        getRightItem(gc_id);
                    }
                }
            }
        });
    }

    private void getRightItem(String gc_id) {
        String url = String.format(Api.RIGHT, gc_id);
        httpUtils.syncJsonStringByUrl(url, new OkHttpUtils.FuncJsonString() {
            @Override
            public void onResponse(String result) {
                RightChildBean bean = gson.fromJson(result, RightChildBean.class);
                if (bean.getCode() == 200) {
                    int size = bean.getDatas().getClass_list().size();
                    List<RightChildBean.DatasBean.ClassListBean> l = new ArrayList<RightChildBean.DatasBean.ClassListBean>();
                    for (int i = 0; i < size; i++) {
                        String gc_name = bean.getDatas().getClass_list().get(i).getGc_name();
                        String gc_id = bean.getDatas().getClass_list().get(i).getGc_id();
                        RightChildBean.DatasBean.ClassListBean classListBean = new RightChildBean.DatasBean.ClassListBean();
                        classListBean.setGc_name(gc_name);
                        classListBean.setGc_id(gc_id);
                        l.add(classListBean);
                    }
                    child.add(l);
                    if (child.size() == titlesize) {
                        MyExpandLvAdapter expandLvAdapter = new MyExpandLvAdapter(getActivity(), group, child);
                        mClassElv.setAdapter(expandLvAdapter);
                    }
                }

            }
        });
    }


    private void initView(View view) {
        gson = new Gson();
        mClassRv = (RecyclerView) view.findViewById(R.id.class_rv);
        mClassElv = (ExpandableListView) view.findViewById(R.id.class_elv);
        mClassRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mClassRv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        httpUtils = OkHttpUtils.getInstance(getActivity());
    }
}
