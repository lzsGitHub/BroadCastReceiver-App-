package com.example.r.remotenotification;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/**
 * Created by ${Lee} on 2017/12/22.
 */

public class BaseActivity extends Activity{
    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //将启动的Activity添加进来
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        ActivityCollector.removeActivity(this);
        super.onDestroy();
    }

    //注册广播
    @Override
    protected void onResume() {
        IntentFilter fliter=new IntentFilter();
        fliter.addAction("OffLine");
        receiver=new MyReceiver();
        registerReceiver(receiver, fliter);
        super.onResume();
    }

    //注销广播
    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }

    //接收广播
    private class MyReceiver  extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builer=new AlertDialog.Builder(context);
            builer.setTitle("强制下线广播")
                    .setMessage("您的账号在异地登录")
                    .setCancelable(true)//设置取消按钮不能使用,
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCollector.finishAll() ;
                            Intent in=new Intent(context ,MainActivity.class);
                            startActivity(in);
                        }
                    }).show();
        }

    }
}
