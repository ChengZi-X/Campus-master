package com.xue.zz.campus;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView();
        return view;
    }

    /**
     * 初始化界面：让子类重写
     */
    public abstract View initView();

    /**
     * 初始化数据：让子类重写
     */
    public abstract void initData();
}
