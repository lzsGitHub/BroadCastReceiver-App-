package com.example.r.remotenotification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText mUserName;
    private EditText mUserPwd;
    private Button mLoginBt;
    private String userName;
    private String userPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserName = (EditText) findViewById(R.id.user_name);
        mUserPwd = (EditText) findViewById(R.id.user_pwd);
        mLoginBt = (Button) findViewById(R.id.login_bt);
        mLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=mUserName.getText().toString();
                userPwd=mUserPwd.getText().toString();
                if (userName.equals("lzs123")&&userPwd.equals("123456")){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"输入错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
