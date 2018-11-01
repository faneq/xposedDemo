package com.example.administrator.xposeddemo;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * author : fanenqian
 * time   : 2018/11/01
 * desc   :
 */
public class HookMain implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        Log.e("hookMain", "----执行hookMain：" + SystemUtil.getSystemLanguage());
        //这里测试Hook静态变量,修改手机机型和厂商
        XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", "醉猫");//厂商
        XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", "bestmk.cn");//机型
        XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "RELEASE", "9.2.0");//机型
    }
}