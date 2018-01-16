package com.xue.zz.campus.fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.xue.zz.campus.BaseFragment;
import com.xue.zz.campus.R;
import com.xue.zz.campus.adapter.OneAdapter;
import com.xue.zz.campus.config.Global;
import com.xue.zz.campus.listener.EndlessRecyclerOnScrollListener;
import com.xue.zz.campus.modelinfo.ThreeInfo;
import com.xue.zz.campus.modeljson.ThreeJson;
import com.xue.zz.campus.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends BaseFragment {
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private LoadMoreWrapper loadMoreWrapper;
    private List<ThreeInfo> ThreeList = new ArrayList<>();
    private int pageNum = 1;
    private int total;

    @Override
    public View initView() {
        view = View.inflate(getActivity(), R.layout.one, null);
        initData();
        init();
        return view;
    }
    private void init() {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#4DB6AC"));
        OneAdapter loadMoreWrapperAdapter = new OneAdapter(ThreeList, getActivity());
        loadMoreWrapper = new LoadMoreWrapper(loadMoreWrapperAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(loadMoreWrapper);
        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                pageNum = 1;
                ThreeList.clear();
                initData();
                loadMoreWrapper.notifyDataSetChanged();
            }
        });
        // 设置加载更多监听
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                loadMoreWrapper.setLoadState(loadMoreWrapper.LOADING);
                if (ThreeList.size() < total) {
                    initData();
                } else {
                    // 显示加载到底的提示
                    loadMoreWrapper.setLoadState(loadMoreWrapper.LOADING_END);
                }
            }
        });
    }
    @Override
    public void initData() {
        String url = Global.BASE_URL_YUN + "/api/getDieCircle.api.php";// 获取圈子列表的url
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000);
        RequestParams params = new RequestParams();
        Log.e("pageNum>>>>", pageNum + "");
        params.addBodyParameter("page", pageNum + "");
        http.send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String s = responseInfo.result;
                Log.e("ssssssssss0000>>>", s);
                ThreeJson three = JSONObject.parseObject(s, ThreeJson.class);
                total = three.getTotal();
                switch (three.getRes()) {
                    case "true":
                        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                        for (int i = 0; i < three.getData().size(); i++) {
                            ThreeInfo threeinfo = new ThreeInfo();
                            ThreeJson.ThreeList info = three.getData().get(i);
                            threeinfo.setGroup_text(info.getGroup_text());
                            threeinfo.setGroup_time(info.getGroup_time());
                            threeinfo.setGroup_title(info.getGroup_title());
                            threeinfo.setHeadimg(info.getHeadimg());
                            ThreeList.add(threeinfo);
                        }
                        loadMoreWrapper.notifyDataSetChanged();
                        break;
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(), "网络连接失败，请查询网络", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
