package com.xue.zz.campus.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.xue.zz.campus.R;
import com.xue.zz.campus.config.Global;
import com.xue.zz.campus.modeljson.LoginJson;
import com.xue.zz.campus.utlis.ToastUtils;

/**
 * Created by Administrator on 2017/7/14.
 */

public class Ac_Forget_password extends AppCompatActivity implements View.OnClickListener {

    private EditText mEt_phone, mEt_smscode;
    private TextView mTv_verification_code;
    private RelativeLayout next_step;
    private String phone, smscode;
    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_forget_password);
        time = new TimeCount(30000, 1000);// 构造CountDownTimer对象
        TextView toolbartitle = (TextView) findViewById(R.id.title_tool);
        toolbartitle.setText("找回密码");
        ImageView titleback = (ImageView) findViewById(R.id.title_back);
        mEt_phone = (EditText) findViewById(R.id.et_phone);
        mEt_smscode = (EditText) findViewById(R.id.et_smscode);
        mTv_verification_code = (TextView) findViewById(R.id.tv_verification_code);
        next_step = (RelativeLayout) findViewById(R.id.next_step);
        mTv_verification_code.setOnClickListener(this);
        next_step.setOnClickListener(this);
        titleback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();//返回上一页
                break;
            case R.id.tv_verification_code:
                phone = mEt_phone.getText().toString().trim();
                if (!isMobileNO(phone)) {
                    ToastUtils.showToast(Ac_Forget_password.this, "手机号格式不正确请重新输入");
                    return;
                } else {
                    time.start();// 开始计时
                }
                Verification();//获取手机验证码
                break;
            case R.id.next_step:
                smscode = mEt_smscode.getText().toString().trim();
                if (!isMobileNO(phone)) {
                    ToastUtils.showToast(Ac_Forget_password.this, "手机号格式不正确请重新输入");
                    return;
                }
                if (smscode.equals("") || smscode.equals(null)) {
                    ToastUtils.showToast(Ac_Forget_password.this, "验证码不能为空");
                    return;
                }
                Next_step();//验证手机验证码
                break;
        }
    }

    private void Verification() {
        String ForgetUrl = Global.BASE_URL_YUN + "/api/getfindPwdCode.api.php"; //获取手机验证码url
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000);
        RequestParams params = new RequestParams();
        params.addBodyParameter("phnum", phone);
        http.send(HttpRequest.HttpMethod.POST, ForgetUrl, params, new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String s = responseInfo.result;
                        Log.e("ssssssssss111111", s);
                        LoginJson login = JSONObject.parseObject(s, LoginJson.class);
                        String mes = login.getMes();
                        switch (login.getRes()) {
                            case "true":
                                ToastUtils.showToast(Ac_Forget_password.this, mes);
                                break;
                            case "false":
                                ToastUtils.showToast(Ac_Forget_password.this, mes);
                                break;
                        }
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        ToastUtils.showToast(Ac_Forget_password.this, "网络连接失败，请查询网络");
                    }
                }

        );
    }

    private void Next_step() {
        String VerificationUrl = Global.BASE_URL_YUN + "/api/checkFindPwdCode.api.php"; //验证手机验证码url
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000);
        RequestParams params = new RequestParams();
        params.addBodyParameter("phnum", phone);
        params.addBodyParameter("code", smscode);
        http.send(HttpRequest.HttpMethod.POST, VerificationUrl, params, new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String s = responseInfo.result;
                        Log.e("sssssssssss22222", s);
                        LoginJson login = JSONObject.parseObject(s, LoginJson.class);
                        String mes = login.getMes();
                        switch (login.getRes()) {
                            case "true":
                                ToastUtils.showToast(Ac_Forget_password.this, mes);
                                Intent intent = new Intent(Ac_Forget_password.this, Reset_Password_Activity.class);
                                intent.putExtra("phone", phone);
                                startActivity(intent);
                                finish();
                                break;
                            case "false":
                                ToastUtils.showToast(Ac_Forget_password.this, mes);
                                break;
                        }
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        ToastUtils.showToast(Ac_Forget_password.this, "网络连接失败，请查询网络");
                    }
                }

        );

    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3587]\\d{9}";
        if (TextUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }


    /* 定义一个倒计时的内部类 */
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {// 计时完毕时触发
            mTv_verification_code.setText("重新验证");
            mTv_verification_code.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程显示
            mTv_verification_code.setClickable(false);
            mTv_verification_code.setText(millisUntilFinished / 1000 + "秒");
        }
    }
}


