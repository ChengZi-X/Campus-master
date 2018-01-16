package com.xue.zz.campus.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.Request;
import com.xue.zz.campus.BaseFragment;
import com.xue.zz.campus.R;
import com.xue.zz.campus.XListView.XListView;
import com.xue.zz.campus.activity.Upload_quanzi_Activity;
import com.xue.zz.campus.adapter.ThreeAdapter;
import com.xue.zz.campus.config.Global;
import com.xue.zz.campus.modelinfo.ThreeInfo;
import com.xue.zz.campus.modeljson.ThreeJson;
import com.xue.zz.campus.utlis.OkHttpClientManager;
import com.xue.zz.campus.utlis.ToastUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentThree extends BaseFragment {
    private View view;
    private XListView xListView;
    private ThreeAdapter ThreeAdapter;
    private List<ThreeInfo> ThreeList;
    private ProgressDialog MyDialog = null;
    private int page = 1;
    private int totalCount;
    private ImageView mCamare;

    @Override
    public View initView() {
        view = View.inflate(getActivity(), R.layout.three, null);
        // 注册控件
        xListView = (XListView) view.findViewById(R.id.xlistview_layout);
        mCamare = (ImageView) view.findViewById(R.id.camare);
        mCamare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Upload_quanzi_Activity.class);
                startActivity(intent);
            }
        });
        ThreeList = new ArrayList<>();
        xListView.setXListViewListener(xListViewListener);
        initData();
        ThreeAdapter = new ThreeAdapter(ThreeList, getActivity());
        xListView.setAdapter(ThreeAdapter);
        return view;
    }

    @Override
    public void initData() {
        MyDialog = new ProgressDialog(getActivity());
        MyDialog.setTitle("温馨提示");
        MyDialog.setMessage("正在加载，请稍等...");
        MyDialog.setCancelable(false);
        MyDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        MyDialog.setIndeterminate(true);
        MyDialog.show();
        String url = Global.BASE_URL_YUN + "/api/getDieCircle.api.php";// 获取圈子列表的url
        Map<String, String> params = new HashMap<>();
        params.put("page", page + "");
        OkHttpClientManager.postAsyn(url, params,new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onResponse(String response) {
                MyDialog.dismiss();
                ThreeJson three = JSONObject.parseObject(response, ThreeJson.class);
                totalCount = three.getTotal();
                if (page >= totalCount) {
                    xListView.setPullLoadEnable(false);
                } else {
                    xListView.setPullLoadEnable(true);
                }
                switch (three.getRes()) {
                    case "true":
                        MyDialog.dismiss();
                        for (int i = 0; i < three.getData().size(); i++) {
                            ThreeInfo threeinfo = new ThreeInfo();
                            ThreeJson.ThreeList info = three.getData().get(i);
                            threeinfo.setGroup_text(info.getGroup_text());
                            threeinfo.setGroup_time(info.getGroup_time());
                            threeinfo.setGroup_title(info.getGroup_title());
                            threeinfo.setHeadimg(info.getHeadimg());
                            ThreeList.add(threeinfo);
                        }
                        ThreeAdapter.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onError(Request request, Exception e) {
                MyDialog.dismiss();
                ToastUtils.showToast(getActivity(), "网络连接失败，请查询网络");
            }
        });
//        String ResetConfirmUrl = Global.BASE_URL_YUN + "/api/getDieCircle.api.php";// 获取圈子列表的url
//        HttpUtils http = new HttpUtils();
//        http.configCurrentHttpCacheExpiry(1000);
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("page", page + "");
//        http.send(HttpRequest.HttpMethod.POST, ResetConfirmUrl, params, new RequestCallBack<String>() {
//                    @Override
//                    public void onSuccess(ResponseInfo<String> responseInfo) {
//                        String s = responseInfo.result;
//                        Log.e("ssssssssss0000>>>", s);
//                        ThreeJson three = JSONObject.parseObject(s, ThreeJson.class);
//                        totalCount = three.getTotal();
//                        if (page >= totalCount) {
//                            xListView.setPullLoadEnable(false);
//                        } else {
//                            xListView.setPullLoadEnable(true);
//                        }
//                        switch (three.getRes()) {
//                            case "true":
//                                MyDialog.dismiss();
//                                for (int i = 0; i < three.getData().size(); i++) {
//                                    ThreeInfo threeinfo = new ThreeInfo();
//                                    ThreeJson.ThreeList info = three.getData().get(i);
//                                    threeinfo.setGroup_text(info.getGroup_text());
//                                    threeinfo.setGroup_time(info.getGroup_time());
//                                    threeinfo.setGroup_title(info.getGroup_title());
//                                    threeinfo.setHeadimg(info.getHeadimg());
//                                    ThreeList.add(threeinfo);
//                                }
//                                ThreeAdapter.notifyDataSetChanged();
//                                break;
//                            case "false":
//                                MyDialog.dismiss();
////                                String mes = three.getMes();
////                                ToastUtils.showToast(getActivity(), mes);
//                                break;
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(HttpException e, String s) {
//                        MyDialog.dismiss();
//                        ToastUtils.showToast(getActivity(), "网络连接失败，请查询网络");
//                    }
//                }
//        );
    }

    /**
     * 监听上拉刷新下拉加载
     */
    private XListView.IXListViewListener xListViewListener = new XListView.IXListViewListener() {
        @Override
        public void onRefresh() {
            page = 1;
            // 下拉刷新操作
            new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    ThreeList.clear();
                    ThreeAdapter.notifyDataSetChanged();
                    initData();
                    onLoad();
                }
            }.sendEmptyMessageDelayed(0, 1000);
        }

        @Override
        public void onLoadMore() {
            page++;
            // 加载更多
            new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    initData();
                    ThreeAdapter.notifyDataSetChanged();
                    xListView.setSelection(ThreeAdapter.getCount());
                    onLoad();
                }
            }.sendEmptyMessageDelayed(0, 1000);
        }
    };

    /**
     * 加载数据后停止刷新
     */
    private void onLoad() {
        xListView.stopRefresh();
        xListView.stopLoadMore();
        xListView.setRefreshTime(new Date().toLocaleString());

    }
}
