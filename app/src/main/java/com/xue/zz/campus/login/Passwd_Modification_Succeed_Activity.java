package com.xue.zz.campus.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.xue.zz.campus.R;

/**
 * Created by Administrator on 2017/7/18.
 */

public class Passwd_Modification_Succeed_Activity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout mGo_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_passwd_modification_succeed);
        mGo_login = (RelativeLayout) findViewById(R.id.go_login);
        mGo_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_login:
                Intent intent = new Intent(Passwd_Modification_Succeed_Activity.this, Ac_Login.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
