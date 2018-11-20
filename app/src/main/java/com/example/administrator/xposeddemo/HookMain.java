package com.example.administrator.xposeddemo;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * author : fanenqian
 * time   : 2018/11/01
 * desc   :
 */
public class HookMain implements IXposedHookLoadPackage {
    HashMap<String, String> map = new HashMap<>();

    @SuppressLint("PrivateApi")
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        Log.e("hookMain", "----执行1hookMain：" + SystemUtil.getSystemLanguage());
        //这里测试Hook静态变量,修改手机机型和厂商
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", "醉猫");//厂商
        XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", "醉猫");//机型
//        XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "RELEASE", "9.2.0");//机型
        if (!lpparam.packageName.equals("com.snail.device")) {
            return;
        }
        try {
            XposedHelpers.findAndHookMethod("android.os.SystemProperties",
                    lpparam.classLoader, "native_get", String.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            Log.e("hookMain", "----------------" + param.args[0]);
                            if (param.args[0].equals("ro.serialno")) {
                                param.setResult("native_get_huawei-huawei");
                            }
                        }
                    });
        } catch (Exception e) {
        }
        try {

            XposedHelpers.findAndHookMethod("android.os.SystemProperties",
                    lpparam.classLoader, "get", String.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            Log.e("hookMain", "----------------2" + param.args[0]);
                            if (param.args[0].equals("ro.serialno")) {
                                param.setResult("get-gethuawei-huawei");
                            }
                        }
                    });
        } catch (Exception e) {
        }

//       readData();
    }

    private void readData() {
        try {
            String[] ks = new String[]{"getBestProvider", "getProvider", "getAccuracy", "setLatitude", "getLongitude", "density", "densityDpi", "scaledDensity", "getExtraInfo", "getReason", "getSubtype", "getSubtypeName", "getType", "getTypeName", "cc.getBaseStationId", "cc.getBaseStationLatitude", "cc.getBaseStationLongitude", "isboolue", "cc.getNetworkId", "cc.getSystemId", "gcl.getCid", "gcl.getLac", "gcl.getPsc", "getCellLocation", "getDeviceId", "androidId", "getNetworkOperator", "getNetworkOperatorName", "getNetworkType", "getSimSerialNumber", "getSimOperator", "getSimOperatorName", "getSubscriberId", "SERIAL", "getDataActivity", "BOARD", "BRAND", "BOOTLOADER", "DISPLAY", "DEVICE", "FINGERPRINT", "HARDWARE", "MANUFACTURER", "MODEL", "PRODUCT", "RELEASE", "SDK", "SDK_INT", "getRssi", "getCanonicalHostName", "getHostAddress", "getHostName", "getLocalHost", "getMacAddress", "getBSSID", "getIpAddress", "getNetworkId", "getSSID", "ScanResults.level", "ScanResults.frequency", "ScanResults.BSSID", "ScanResults.capabilities", "ScanResults.SSID", "widthPixels", "heightPixels", "getWidth", "getHeight", "getRotation", "version", "getLine1Number", "TAGS", "TIME", "TYPE", "USER", "HOST", "getRadioVersion", "CODENAME", "INCREMENTAL", "Build.ID"};
            for (String k : ks) {
                this.map.put(k, "12");
            }
            if (!this.map.isEmpty()) {
                HookAll();
            }
        } catch (Throwable th) {
            Log.e("hookMain", th.getMessage());
        }
    }

    private void HookAll() {
        Log.e("hookMain", "----执行hookMain：" + "HookAll");
//        try {
////            location();
//        } catch (Exception e) {
//        }
//        if (this.map.get("getExtraInfo") == null || "NULL".equals(this.map.get("getExtraInfo")) || "null".equals(this.map.get("getExtraInfo"))) {
//            HookMethod(NetworkInfo.class, "getExtraInfo", null);
//        } else {
//            HookMethod(NetworkInfo.class, "getExtraInfo", this.map.get("getExtraInfo"));
//        }
//        if (this.map.get("getReason") == null || "NULL".equals(this.map.get("getReason")) || "null".equals(this.map.get("getReason"))) {
//            HookMethod(NetworkInfo.class, "getReason", null);
//        } else {
//            HookMethod(NetworkInfo.class, "getReason", this.map.get("getReason"));
//        }
//        HookMethod(NetworkInfo.class, "getSubtype", Integer.parseInt(this.map.get("getSubtype")));
//        HookMethod(NetworkInfo.class, "getSubtypeName", this.map.get("getSubtypeName"));
//        HookMethod(NetworkInfo.class, "getType", Integer.parseInt(this.map.get("getType")));
//        HookMethod(NetworkInfo.class, "getTypeName", this.map.get("getTypeName"));
//        HookMethod(TelephonyManager.class, "getDeviceId", this.map.get("getDeviceId"));
//        HookMethod(TelephonyManager.class, "getNetworkOperator", this.map.get("getNetworkOperator"));
//        HookMethod(TelephonyManager.class, "getNetworkOperatorName", this.map.get("getNetworkOperatorName"));
//        HookMethod(TelephonyManager.class, "getNetworkType", Integer.parseInt(this.map.get("getNetworkType")));
//        HookMethod(TelephonyManager.class, "getSimOperator", this.map.get("getSimOperator"));
//        HookMethod(TelephonyManager.class, "getSimOperatorName", this.map.get("getSimOperatorName"));
//        HookMethod(TelephonyManager.class, "getSubscriberId", this.map.get("getSubscriberId"));
//        HookMethod(TelephonyManager.class, "getDataActivity", Integer.parseInt(this.map.get("getDataActivity")));
//        HookMethod(TelephonyManager.class, "getDeviceSoftwareVersion", this.map.get("version"));
//        if (this.map.get("getLine1Number") == null || "NULL".equals(this.map.get("getLine1Number")) || "null".equals(this.map.get("getLine1Number"))) {
//            HookMethod(TelephonyManager.class, "getLine1Number", null);
//        } else {
//            HookMethod(TelephonyManager.class, "getLine1Number", this.map.get("getLine1Number"));
//        }
//        HookMethod(TelephonyManager.class, "getSimSerialNumber", this.map.get("getSimSerialNumber"));
//        HookMethod(Build.class, "getRadioVersion", this.map.get("getRadioVersion"));
//        HookMethod(WifiInfo.class, "getMacAddress", this.map.get("getMacAddress"));
//        HookMethod(WifiInfo.class, "getBSSID", this.map.get("getBSSID"));
//        HookMethod(WifiInfo.class, "getIpAddress", Integer.parseInt(this.map.get("getIpAddress")));
//        HookMethod(WifiInfo.class, "getNetworkId", Integer.parseInt(this.map.get("getNetworkId")));
//        HookMethod(WifiInfo.class, "getSSID", this.map.get("getSSID"));
//        HookMethod(WifiInfo.class, "getRssi", Integer.parseInt(this.map.get("getRssi")));
//        try {
//            XposedHelpers.findAndHookMethod(Settings.Secure.class, "getString", ContentResolver.class, String.class, new XC_MethodHook() {
//                protected void afterHookedMethod(MethodHookParam param) {
//                    if (param.args[1] == "android_id") {
//                        param.setResult(HookMain.this.map.get("androidId"));
//                    }
//                }
//            });
//        } catch (Throwable th) {
//        }
//        findField(Build.class, "TAGS", this.map.get("TAGS"));
//        findField(Build.class, "HOST", this.map.get("HOST"));
//        findField(Build.class, "USER", this.map.get("USER"));
//        findField(Build.class, "TIME", Long.parseLong(this.map.get("TIME")));
//        findField(Build.class, "DISPLAY", this.map.get("DISPLAY"));
//        findField(Build.class, "BOOTLOADER", this.map.get("BOOTLOADER"));
//        findField(Build.class, "SERIAL", this.map.get("SERIAL"));
//        findField(Build.class, "BOARD", this.map.get("BOARD"));
//        findField(Build.class, "BRAND", this.map.get("BRAND"));
//        findField(Build.class, "DEVICE", this.map.get("DEVICE"));
////        findField(Build.class, "FINGERPRINT", this.map.get("FINGERPRINT"));
////        findField(Build.class, "HARDWARE", this.map.get("HARDWARE"));
        findField(Build.class, "MANUFACTURER", this.map.get("MANUFACTURER"));
////        findField(Build.class, "TYPE", this.map.get("TYPE"));
        findField(Build.class, "MODEL", this.map.get("MODEL"));
////        findField(Build.class, "PRODUCT", this.map.get("PRODUCT"));
////        findField(Build.class, "ID", this.map.get("Build.ID"));
////        findField(Build.VERSION.class, "RELEASE", this.map.get("RELEASE"));
////        findField(Build.VERSION.class, "INCREMENTAL", this.map.get("INCREMENTAL"));
////        findField(Build.VERSION.class, "CODENAME", this.map.get("CODENAME"));
////        String SDK_INT = this.map.get("SDK_INT");
////        if (!(SDK_INT == null || BuildConfig.FLAVOR.equals(SDK_INT.trim()) || "NULL".equals(SDK_INT) || "null".equals(SDK_INT))) {
////            findField(Build.VERSION.class, "SDK", this.map.get("SDK"));
////            findField1(Build.VERSION.class, "SDK_INT", Integer.parseInt(SDK_INT));
////        }
////        try {
////            String isboolue = this.map.get("isboolue");
////            if (isboolue == null || "true".equals(isboolue)) {
////                XposedHelpers.findAndHookMethod(BluetoothAdapter.class, "getDefaultAdapter", new XC_MethodHook() {
////                    @SuppressLint({"NewApi"})
////                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        super.afterHookedMethod(param);
////                        param.setResult(null);
////                    }
////                });
////            }
////        } catch (Throwable th2) {
////        }
////        try {
////            XposedHelpers.findAndHookMethod(TelephonyManager.class, "getCellLocation", new XC_MethodHook() {
////                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                    super.afterHookedMethod(param);
////                    String str = HookMain.this.map.get("getCellLocation");
////                    if (str == null || "null".equals(str) || "NULL".equals(str)) {
////                        param.setResult(null);
////                    } else if (str == null || BuildConfig.FLAVOR.equals(str.trim())) {
////                        param.setResult(null);
////                    } else {
////                        try {
////                            String[] ss = str.replace("[", BuildConfig.FLAVOR).replace("]", BuildConfig.FLAVOR).split(",");
////                            if (ss.length == 5) {
////                                CdmaCellLocation cc = new CdmaCellLocation();
////                                cc.setCellLocationData(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]), Integer.parseInt(ss[3]), Integer.parseInt(ss[4]));
////                                param.setResult(cc);
////                            } else if (ss.length == 3) {
////                                Bundle b = new Bundle();
////                                b.putInt("lac", Integer.parseInt(ss[0]));
////                                b.putInt("cid", Integer.parseInt(ss[1]));
////                                b.putInt("psc", Integer.parseInt(ss[2]));
////                                param.setResult(new GsmCellLocation(b));
////                            }
////                        } catch (Exception e) {
////                            param.setResult(null);
////                        }
////                    }
////                }
////            });
////        } catch (Throwable th3) {
////        }
////        try {
////            XposedHelpers.findAndHookMethod(WifiManager.class, "getScanResults", new XC_MethodHook() {
////                @SuppressLint({"NewApi"})
////                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                    super.afterHookedMethod(param);
////                    ArrayList<ScanResult> sr = (ArrayList) param.getResult();
////                    sr.get(0).BSSID = HookMain.this.map.get("ScanResults.BSSID");
////                    sr.get(0).capabilities = HookMain.this.map.get("ScanResults.capabilities");
////                    sr.get(0).frequency = Integer.parseInt(HookMain.this.map.get("ScanResults.frequency"));
////                    sr.get(0).level = Integer.parseInt(HookMain.this.map.get("ScanResults.level"));
////                    sr.get(0).SSID = HookMain.this.map.get("ScanResults.SSID");
////                    param.setResult(sr);
////                }
////            });
////        } catch (Throwable th4) {
////        }
////        try {
////            XposedHelpers.findAndHookMethod(InetAddress.class, "getLocalHost", new XC_MethodHook() {
////                @SuppressLint({"NewApi"})
////                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                    super.afterHookedMethod(param);
////                    param.setResult(InetAddress.getByName(HookMain.this.map.get("getHostAddress")));
////                }
////            });
////        } catch (Throwable th5) {
////        }
////        if (this.map.get("density") != null && !"NULL".equals(this.map.get("density")) && !"null".equals(this.map.get("density")) && !"0".equals(this.map.get("density")) && !BuildConfig.FLAVOR.equals(this.map.get("density"))) {
////            try {
////                HookMethod(Display.class, "getWidth", Integer.parseInt(this.map.get("getWidth")));
////                HookMethod(Display.class, "getHeight", Integer.parseInt(this.map.get("getHeight")));
////                HookMethod(Display.class, "getRotation", Integer.parseInt(this.map.get("getRotation")));
////                XposedHelpers.findAndHookMethod(Resources.class, "getDisplayMetrics", new XC_MethodHook() {
////                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        super.afterHookedMethod(param);
////                        DisplayMetrics metrics = new DisplayMetrics();
////                        metrics.widthPixels = Integer.parseInt(HookMain.this.map.get("widthPixels"));
////                        metrics.heightPixels = Integer.parseInt(HookMain.this.map.get("heightPixels"));
////                        metrics.density = Float.parseFloat(HookMain.this.map.get("density"));
////                        metrics.densityDpi = Integer.parseInt(HookMain.this.map.get("densityDpi"));
////                        metrics.scaledDensity = Float.parseFloat(HookMain.this.map.get("scaledDensity"));
////                        param.setResult(metrics);
////                    }
////                });
////            } catch (Throwable th6) {
////            }
////        }

//        ------------------------------------------------------------------------
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getDeviceId", GetCatValue("imei"));
//        HTool.XHookMethod("com.android.internal.telephony.PhoneSubInfo",mLpp.classLoader, "getDeviceId", GetCatValue("imei"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getSubscriberId", GetCatValue("imsi"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getLine1Number", GetCatValue("number"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getSimSerialNumber", GetCatValue("simserial"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getSimCountryIso", GetCatValue("simcountryiso"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getSimOperator", GetCatValue("simoperator"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getSimOperatorName", GetCatValue("simoperatorname"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getNetworkCountryIso", GetCatValue("networkcountryiso"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getNetworkOperator", GetCatValue("networkoperator"));
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getNetworkOperatorName", GetCatValue("networkoperatorname"));
//
////WIFI信息
//        HTool.XHookMethod(android.net.wifi.WifiInfo.class.getName(),mLpp.classLoader, "getMacAddress", GetCatValue("wifimac"));
//        HTool.XHookMethod(android.net.wifi.WifiInfo.class.getName(),mLpp.classLoader, "getBSSID", GetCatValue("bssid"));
//        HTool.XHookMethod(android.net.wifi.WifiInfo.class.getName(),mLpp.classLoader, "getSSID", "\""+GetCatValue("ssid")+"\"");
//        XposedHelpers.findAndHookMethod(java.net.NetworkInterface.class.getName(),mLpp.classLoader, "getHardwareAddress", new Object[] {
//                new XC_MethodHook()
//                {
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable
//                    {
//                        //每个安卓系统中 至少存在5个以上的MAC地址
//                        //但大多数软件只修改了MAC和BSSID
//                        //真正的MAC修改是在此处理函数中监听每次访问.
//                    }
//                }});
//
////蓝牙信息
//        HTool.XHookMethod(BluetoothAdapter.class.getName(),mLpp.classLoader,"getAddress", GetCatValue("bluemac"));
//        HTool.XHookMethod(BluetoothAdapter.class.getName(),mLpp.classLoader, "getName", GetCatValue("bluename"));
//
////设置手机信息 无论手机是否插入了sim卡 都会模拟出SIM卡的信息 APP获得SIM卡消息时返回该手机已有SIM卡
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getPhoneType", TelephonyManager.PHONE_TYPE_GSM);
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getNetworkType", TelephonyManager.NETWORK_TYPE_HSPAP);
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "getSimState", TelephonyManager.SIM_STATE_READY);
//        HTool.XHookMethod(android.telephony.TelephonyManager.class.getName(),mLpp.classLoader, "hasIccCard", true);
//
//
////修改手机系统信息 此处是手机的基本信息 包括厂商 信号 ROM版本 安卓版本 主板 设备名 指纹名称等信息
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", GetCatValue("model"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "MANUFACTURER", GetCatValue("manufacturer"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", GetCatValue("brand"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "HARDWARE", GetCatValue("hardware"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "BOARD", GetCatValue("board"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "SERIAL", GetCatValue("serial"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "DEVICE", GetCatValue("device"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "ID", GetCatValue("id"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "PRODUCT", GetCatValue("product"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "DISPLAY", GetCatValue("display"));
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "FINGERPRINT", GetCatValue("fingerprint"));
//
//        XposedHelpers.findAndHookMethod("android.os.SystemProperties",mLpp.classLoader, "native_get", new Object[] {String.class,String.class,
//                new XC_MethodHook()
//                {
//                    //为了防止某些APP跳过Build类 而直接使用SystemProperties.native_get获得参数
//                }});
////修改系统版本 我看到世面上的软件基本上都是不能修改系统版本的 从而造成了刷量后 很多渠道最终会显示你的APP用户全部使用的某一系统版本
////这样的话数据就太假了.
//        XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "RELEASE", GetCatValue("version"));
//        XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "SDK", GetCatValue("apilevel"));
//
//        HTool.XHookMethod(android.os.Build.class.getName(),mLpp.classLoader, "getRadioVersion", GetCatValue("radioversion"));
//
////修改为指定的运营商mnc mcc信息
//        XposedHelpers.findAndHookMethod(android.content.res.Resources.class.getName(),mLpp.classLoader, "getConfiguration", new Object[] {
//                new XC_MethodHook()
//                {
//            ...........................
//                    //此处的mnc和mcc必须和系统中其他关于运营商的数据对应!
//                }});
//
////修改ANDROID_ID
//        XposedHelpers.findAndHookMethod(android.provider.Settings.Secure.class.getName(),mLpp.classLoader, "getString",
//                new Object[] {ContentResolver.class,String.class,
//                        new XC_MethodHook()
//                        {
//            ...............................
//                            //此处会根据传入的String参数 判断返回值 其中包括比较关键的数据就是android_id
//                        }});
//
////防止APP使用Runtime.exec方式获取一些特定的系统属性
//        XposedHelpers.findAndHookMethod(Runtime.class.getName(),mLpp.classLoader, "exec",new Object[] {String.class,String[].class, File.class,
//                new XC_MethodHook()
//                {
//                    //一些APP从JAVA层获得到了数据 还会从shell(native)层获得一些更底层的数据 来判断用户的合法性
//                    //经常用到的有 cat、getprop、ifconfig等等命令，当exec执行这些命令后 往往会返回一些手机的真实信息
//                    //因为框架和处理方式不同，...部分此处根据自己需求，编写重定向返回值的过程...
//                }});
//
////修改位置信息
//        XposedHelpers.findAndHookMethod(LocationManager.class.getName(),mLpp.classLoader, "getLastKnownLocation",
//                new Object[] {String.class,
//                        new XC_MethodHook()
//                        {
//                ..........................
//                            //返回预先设置好的经纬度信息以伪装地理位置
//                        }});
//
//        HTool.XHookMethod(Location.class.getName(),mLpp.classLoader, "getLatitude", latitude);
//        HTool.XHookMethod(Location.class.getName(),mLpp.classLoader, "getLongitude", longitude);
//
//
////修改GSM制式手机的基站信息
//        HTool.XHookMethod(android.telephony.gsm.GsmCellLocation.class.getName(),mLpp.classLoader, "getLac", GsmLac);
//        HTool.XHookMethod(android.telephony.gsm.GsmCellLocation.class.getName(),mLpp.classLoader, "getCid", GsmCid);
//
//
////修改CDMA制式手机的基站信息
//        HTool.XHookMethod(android.telephony.cdma.CdmaCellLocation.class.getName(),mLpp.classLoader, "getBaseStationLatitude", CdmaLatitude);
//        HTool.XHookMethod(android.telephony.cdma.CdmaCellLocation.class.getName(),mLpp.classLoader, "getBaseStationLongitude", CdmaLongitude);
//        HTool.XHookMethod(android.telephony.cdma.CdmaCellLocation.class.getName(),mLpp.classLoader, "getBaseStationId", CdmaBid);
//        HTool.XHookMethod(android.telephony.cdma.CdmaCellLocation.class.getName(),mLpp.classLoader, "getSystemId", CdmaSid);
//        HTool.XHookMethod(android.telephony.cdma.CdmaCellLocation.class.getName(),mLpp.classLoader, "getNetworkId", CdmaNid);
//
//
////模拟手机的APP列表
//        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",mLpp.classLoader, "getInstalledPackages",new Object[] {int.class,
//                new XC_MethodHook()
//                {
//                    //此处模拟正常用户的APP列表 其中随机的增加和删除一些常用APP 以达到每个手机的APP有很大的随意性和合理性
//                }});
//
//        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",mLpp.classLoader, "getInstalledApplications",new Object[] {int.class,
//                new XC_MethodHook()
//                {
//                    //此处模拟正常用户的APP列表 其中随机的增加和删除一些常用APP 以达到每个手机的APP有很大的随意性和合理性
//                }});
//
////防止APP的VPN SOCK5 HTTP代理检测
//        XposedHelpers.findAndHookMethod(java.net.NetworkInterface.class.getName(),mLpp.classLoader, "getNetworkInterfacesList",new Object[] {
//                new XC_MethodHook()
//                {
//            ........................................
//                    //此处对于一些连接信息 对JAVA做了隐藏处理 但对于系统和Native层依然是可见的 所以APP不会检测到代理 但代理却可以正常的运行...
//                }});
    }

    private void HookMethod(Class cl, String method, final String result) {
        try {
            XposedHelpers.findAndHookMethod(cl, method, new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) {
                    param.args[0] = "ro.product.model";
                    param.setResult(result);
                }
            });
        } catch (Throwable th) {
        }
    }

    private void HookMethod(Class cl, String method, final int result) {
        try {
            XposedHelpers.findAndHookMethod(cl, method, new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) {
                    param.args[0] = "ro.product.model";
                    param.setResult(result);
                }
            });
        } catch (Throwable th) {
        }
    }

    private void HookMethod(Class cl, String method, final long result) {
        try {
            XposedHelpers.findAndHookMethod(cl, method, new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) {
                    param.setResult(result);
                }
            });
        } catch (Throwable th) {
        }
    }

    private void findField(Class cl, String method, String result) {
        try {
            XposedHelpers.findField(cl, method).set(null, result);
        } catch (Exception e) {
        }
    }

    private void findField(Class cl, String method, long result) {
        try {
            XposedHelpers.findField(cl, method).set(null, Long.valueOf(result));
        } catch (Exception e) {
        }
    }

    private void findField1(Class cl, String method, int result) {
        try {
            XposedHelpers.setStaticObjectField(cl, method, Integer.valueOf(result));
        } catch (Exception e) {
        }
    }
}