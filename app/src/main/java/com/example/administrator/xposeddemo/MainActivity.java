package com.example.administrator.xposeddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSystemParameter();
    }

    private void showSystemParameter() {
        String TAG = "----系统参数：";
        Log.e(TAG, "----手机厂商：" + SystemUtil.getDeviceBrand());
        Log.e(TAG, "----手机型号：" + SystemUtil.getSystemModel());
        Log.e(TAG, "----手机当前系统语言：" + SystemUtil.getSystemLanguage());
        Log.e(TAG, "----Android系统版本号：" + SystemUtil.getSystemVersion());
        Log.e(TAG, "----手机IMEI：" + SystemUtil.getIMEI(getApplicationContext()));
    }
}
