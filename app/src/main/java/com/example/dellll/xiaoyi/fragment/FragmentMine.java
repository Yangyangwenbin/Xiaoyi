package com.example.dellll.xiaoyi.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dellll.xiaoyi.Login.Logintongyong;
import com.example.dellll.xiaoyi.R;

/**
 * Created by dellll on 2017.10.09.
 */

public class FragmentMine extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentmine, container, false);
         ImageView tou = (ImageView) view.findViewById(R.id.touxiang);
        TextView  deng = (TextView) view.findViewById(R.id.denglu);
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),Logintongyong.class);
                startActivity(intent);
            }
        });
        tou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),Logintongyong.class);
                getActivity().startActivityForResult(intent,1);
               // intent.setClass(FragmentMine.this, Logintongyong.class);


            }
        });
        //接受传值
        Bundle bundle=getArguments();
        if(bundle!=null){
            String user=bundle.getString("user");
            deng.setText(user);
        }

        return view;
    }


}
