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
        Log.e("hookMain", "----执行hookMain：" + SystemUtil.getSystemLanguage());
        //这里测试Hook静态变量,修改手机机型和厂商
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", "醉猫");//厂商
//        XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", "bestmk.cn");//机型
//        XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "RELEASE", "9.2.0");//机型
        Class clazz = null;
        try {
            clazz = Class.forName("android.os.SystemProperties");
            HookMethod(clazz, "get", "假数据");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        readData();
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