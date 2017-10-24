package com.example.dellll.xiaoyi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dellll.xiaoyi.R;

/**
 * Created by dellll on 2017.10.09.
 */

public class FramentIndex extends Fragment{
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentindex, container, false);

        return view;
    }
}
