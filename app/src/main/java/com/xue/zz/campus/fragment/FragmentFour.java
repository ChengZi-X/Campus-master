package com.xue.zz.campus.fragment;

import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.xue.zz.campus.BaseFragment;
import com.xue.zz.campus.R;

public class FragmentFour extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.four, null);
        // 注册控件
        ViewUtils.inject(this, view);
        initData();
        return view;
    }

    @Override
    public void initData() {

    }
}
