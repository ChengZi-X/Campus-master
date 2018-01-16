package com.xue.zz.campus.fragment;

import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.xue.zz.campus.BaseFragment;
import com.xue.zz.campus.R;
import com.xue.zz.campus.ZiXunBanner;
import com.xue.zz.campus.config.Global;
import com.xue.zz.campus.modeljson.TwoLunJson;
import com.xue.zz.campus.utlis.ImageCycleView;
import com.xue.zz.campus.utlis.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends BaseFragment {
    private List<TwoLunJson.TwoLun> TwoLunList;
    private ImageCycleView banner;
    private ZiXunBanner kanner;
    private ProgressDialog MyDialog = null;
    private String imageUrl1 = "http://www.hsydining-hall.com/images/news_img/20161031/20161031204340.jpg";
    private String imageUrl2 = "http://www.hsydining-hall.com/images/news_img/20161031/20161031205228.jpg";
    private String imageUrl3 = "http://www.hsydining-hall.com/images/news_img/20171022/20171022192412.jpg";

    @Override
    public View initView() {
        initData();
        View view = View.inflate(getActivity(), R.layout.two, null);
        TwoLunList = new ArrayList<>();
        banner = (ImageCycleView) view.findViewById(R.id.banner);
        kanner = (ZiXunBanner) view.findViewById(R.id.kanner);
        ArrayList<String> mImageUrl = new ArrayList<>();
        mImageUrl.add(imageUrl1);
        mImageUrl.add(imageUrl2);
        mImageUrl.add(imageUrl3);
        banner.setImageResources(mImageUrl, mImageUrl, new ImageCycleView.ImageCycleViewListener() {
            @Override
            public void onImageClick(int position, View imageView) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_LONG).show();
            }
        }, 0);//最后一个参数是切换指示器，0和1
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
        String ResetConfirmUrl = Global.BASE_URL_YUN + "/api/getNewsTop.api.php";// 获取资讯顶部轮播图的url
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000);
        http.send(HttpRequest.HttpMethod.POST, ResetConfirmUrl, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String s = responseInfo.result;
                Log.e("ssssssssss0000>>>", s);
                TwoLunJson twolun = JSONObject.parseObject(s, TwoLunJson.class);
                TwoLunList = twolun.data;
                switch (twolun.getRes()) {
                    case "true":
                        MyDialog.dismiss();
                        // 获得图片url
                        ArrayList<String> mImageUrl = new ArrayList<>();
                        for (int i = 0; i < TwoLunList.size(); i++) {
                            TwoLunJson.TwoLun qwe = TwoLunList.get(i);
                            mImageUrl.add(Global.BASE_URL_YUN + qwe.litpic);
                        }
                        System.out.println("资讯轮播图-2" + mImageUrl);
                        // 添加到数组里面
                        String array[] = new String[mImageUrl.size()];
                        for (int i = 0; i < mImageUrl.size(); i++) {
                            array[i] = mImageUrl.get(i);
                        }
                        System.out.println("资讯轮播图-=-==" + array);
                        kanner.setImagesUrl(array);
//                        banner.setImageResources(mImageUrl, mImageUrl, new ImageCycleView.ImageCycleViewListener() {
//                            @Override
//                            public void onImageClick(int position, View imageView) {
//                                Toast.makeText(getActivity(), position + "", Toast.LENGTH_LONG).show();
//                            }
//                        }, 0);//最后一个参数是切换指示器，0和1
                        break;
                    case "false":
                        ToastUtils.showToast(getActivity(), "失败");
                        break;
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                MyDialog.dismiss();
                ToastUtils.showToast(getActivity(), "网络连接失败，请查询网络");
            }

        });
    }


    @Override
    public void onPause() {
        super.onPause();
        banner.pushImageCycle();
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.startImageCycle();
    }
}