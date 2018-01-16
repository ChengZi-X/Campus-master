package com.xue.zz.campus.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.xue.zz.campus.MainActivity;
import com.xue.zz.campus.R;
import com.xue.zz.campus.config.Global;
import com.xue.zz.campus.modeljson.LoginJson;
import com.xue.zz.campus.utlis.SharedPreferencesUtils;
import com.xue.zz.campus.utlis.ToastUtils;

/**
 * Created by Administrator on 2017/7/13.
 */

public class Ac_Login extends AppCompatActivity implements View.OnClickListener {
    private TextView mRegister, mForgetpassword;
    private EditText mUsername, mPassword;
    private RelativeLayout mLoing;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);
        Init();
    }

    private void Init() {
        mRegister = (TextView) findViewById(R.id.register);
        mForgetpassword = (TextView) findViewById(R.id.forgetpassword);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLoing = (RelativeLayout) findViewById(R.id.login);
        mRegister.setOnClickListener(this);
        mForgetpassword.setOnClickListener(this);
        mLoing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register://注册
                Intent intent = new Intent(Ac_Login.this, Ac_Register.class);
                startActivity(intent);
                break;
            case R.id.forgetpassword://忘记密码
                Intent intent1 = new Intent(Ac_Login.this, Ac_Forget_password.class);
                startActivity(intent1);
                break;
            case R.id.login://登录
//                username = mUsername.getText().toString().trim();
//                password = mPassword.getText().toString().trim();
//                if (username.equals("")) {
//                    ToastUtils.showToast(Ac_Login.this, "请输入手机号/学号");
//                    return;
//                }
//                if (password.equals("")) {
//                    ToastUtils.showToast(Ac_Login.this, "请输入密码");
//                    return;
//                }
//                if (password.length() < 6) {
//                    ToastUtils.showToast(Ac_Login.this, "密码不能少于六位");
//                    return;
//                }
                Intent intent2 = new Intent(Ac_Login.this, MainActivity.class);
                startActivity(intent2);
                //LOGIN();
                break;
        }

    }

    private void LOGIN() {
        String LoginUrl = Global.BASE_URL_YUN + "/api/loginPro.api.php"; // 登陆的url
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000);
        RequestParams params = new RequestParams();
        params.addBodyParameter("userid", username);
        params.addBodyParameter("password", password);
        http.send(HttpRequest.HttpMethod.POST, LoginUrl, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String s = responseInfo.result;
                Log.e("sssssssssssss", s);
                LoginJson login = JSONObject.parseObject(s, LoginJson.class);
                String mes = login.getMes();
                switch (login.getRes()) {
                    case "true":
                        //用户ID
                        final String id = login.getData().get(0).id;
                        //手机号
                        final String tel = login.getData().get(0).tel;
                        //学号
                        String stuid = login.getData().get(0).stuid;
                        //真实姓名
                        String tname = login.getData().get(0).tname;
                        //学校
                        String school = login.getData().get(0).school;
                        //QQ
                        String qq = login.getData().get(0).qq;
                        //微信
                        String wechat = login.getData().get(0).wechat;
                        //邮箱
                        String email = login.getData().get(0).email;
                        //生日
                        String birth = login.getData().get(0).birth;
                        //送餐地址
                        String address = login.getData().get(0).address;
                        //我的地址
                        String address_item = login.getData().get(0).address_item;
                        //性别
                        String sex = login.getData().get(0).sex;
                        //手机
                        String phone = login.getData().get(0).phone;
                        //昵称
                        String nickname = login.getData().get(0).nickname;
                        //喜好标签
                        String like_id = login.getData().get(0).like_id;
                        //厌恶标签
                        String hate = login.getData().get(0).hate;
                        //头像
                        String headimg = login.getData().get(0).headimg;
                        //厌恶菜单的ID
                        String hate_menu = login.getData().get(0).hate_menu;
                        SharedPreferencesUtils.setParam(Ac_Login.this, "uid", id);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "tel", tel);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "stuid", stuid);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "nickname", nickname);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "address", address);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "address_item", address_item);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "sex", sex);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "phone", phone);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "like_id", like_id);//喜好
                        SharedPreferencesUtils.setParam(Ac_Login.this, "hate", hate);//厌恶
                        SharedPreferencesUtils.setParam(Ac_Login.this, "headimg", headimg);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "hate_menu", hate_menu);
                        SharedPreferencesUtils.setParam(Ac_Login.this, "tname", tname);//真实姓名
                        SharedPreferencesUtils.setParam(Ac_Login.this, "school", school);//学校
                        SharedPreferencesUtils.setParam(Ac_Login.this, "qq", qq);//QQ
                        SharedPreferencesUtils.setParam(Ac_Login.this, "wechat", wechat);//微信
                        SharedPreferencesUtils.setParam(Ac_Login.this, "email", email);//邮箱
                        SharedPreferencesUtils.setParam(Ac_Login.this, "birth", birth);//生日
                        ToastUtils.showToast(Ac_Login.this, mes);
                        Intent intent = new Intent(Ac_Login.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case "false":
                        ToastUtils.showToast(Ac_Login.this, mes);
                        break;
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                ToastUtils.showToast(Ac_Login.this, "网络连接失败，请查询网络");
            }
        });
    }
}
