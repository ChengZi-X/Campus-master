package com.xue.zz.campus.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
 * Created by Administrator on 2017/7/18.
 */
public class Reset_Password_Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText pwd, pwd1;
    private RelativeLayout confirm;
    private String phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_reset_password);
        phone = getIntent().getStringExtra("phone");
        TextView toolbartitle = (TextView) findViewById(R.id.title_tool);
        toolbartitle.setText("找回密码");
        ImageView titleback = (ImageView) findViewById(R.id.title_back);
        pwd = (EditText) findViewById(R.id.pwd);
        pwd1 = (EditText) findViewById(R.id.pwd1);
        confirm = (RelativeLayout) findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        titleback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.confirm:
                password = pwd.getText().toString().trim();
                String password1 = pwd1.getText().toString().trim();
                if (password.length() < 6) {
                    ToastUtils.showToast(Reset_Password_Activity.this, "密码不能少于六位");
                    return;
                }
                // 判断内容是否相同
                if (!password1.equals(password)) {
                    ToastUtils.showToast(Reset_Password_Activity.this, "两次输入的密码不一致");
                    return;
                }
                Confirm();
                break;
        }
    }

    private void Confirm() {
        String ResetConfirmUrl = Global.BASE_URL_YUN + "/api/reSetPwd.api.php"; //重置密码的url
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000);
        RequestParams params = new RequestParams();
        params.addBodyParameter("phnum", phone);
        params.addBodyParameter("pwd", password);
        http.send(HttpRequest.HttpMethod.POST, ResetConfirmUrl, params, new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String s = responseInfo.result;
                        Log.e("ssssssssss0000>>>", s);
                        LoginJson login = JSONObject.parseObject(s, LoginJson.class);
                        String mes = login.getMes();
                        switch (login.getRes()) {
                            case "true":
                                ToastUtils.showToast(Reset_Password_Activity.this, mes);
                                Intent intent = new Intent(getApplicationContext(),Passwd_Modification_Succeed_Activity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case "false":
                                ToastUtils.showToast(Reset_Password_Activity.this, mes);
                                break;
                        }
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        ToastUtils.showToast(Reset_Password_Activity.this, "网络连接失败，请查询网络");
                    }
                }

        );

    }
}
