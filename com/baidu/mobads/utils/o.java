package com.baidu.mobads.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

public class o implements IXAdSystemUtils {
    private static String b;
    public JSONArray a = new JSONArray();
    private String c = "";
    private String d = "";
    private String e;
    private String f;
    private String g;
    private String h;
    private int i = -1;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;

    @TargetApi(4)
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? true : null;
    }

    public String getSnFrom(Context context) {
        context = new StringBuilder();
        context.append(this.c);
        context.append(this.d);
        return context.toString();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (str.charAt(length) == '0');
        return null;
    }

    public String getIMEI(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
            this.d = "1";
            String deviceId = getDeviceId(context);
            if (a(deviceId)) {
                String string = System.getString(context.getContentResolver(), "bd_setting_i");
                if (a(string)) {
                    this.c = "2";
                    return "";
                }
                this.c = "1";
                return string;
            }
            this.c = "0";
            return deviceId;
        }
        this.c = "1";
        String string2 = System.getString(context.getContentResolver(), "bd_setting_i");
        if (a(string2)) {
            this.c = "2";
            string2 = "";
        }
        try {
            context = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            for (String contains : context) {
                if (contains.contains(MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                    this.d = "2";
                    break;
                }
                this.d = "0";
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return string2;
    }

    public java.lang.String getSn(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.e;	 Catch:{ Exception -> 0x0027 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0027 }
        if (r0 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x0027 }
    L_0x0008:
        r0 = r2.getIMEI(r3);	 Catch:{ Exception -> 0x0027 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0027 }
        if (r1 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x0027 }
    L_0x0012:
        r0 = r2.getMacAddress(r3);	 Catch:{ Exception -> 0x0027 }
    L_0x0016:
        r3 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0027 }
        r3 = r3.getCommonUtils();	 Catch:{ Exception -> 0x0027 }
        r3 = r3.b(r0);	 Catch:{ Exception -> 0x0027 }
        r2.e = r3;	 Catch:{ Exception -> 0x0027 }
    L_0x0024:
        r3 = r2.e;	 Catch:{ Exception -> 0x0027 }
        return r3;
    L_0x0027:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getSn(android.content.Context):java.lang.String");
    }

    public java.lang.String getCUID(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = b;	 Catch:{ Exception -> 0x0060 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0060 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x0060 }
    L_0x0008:
        r0 = r3.getContentResolver();	 Catch:{ Exception -> 0x0060 }
        r1 = "com.baidu.deviceid";	 Catch:{ Exception -> 0x0060 }
        r0 = android.provider.Settings.System.getString(r0, r1);	 Catch:{ Exception -> 0x0060 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x0060 }
    L_0x0014:
        r1 = "";	 Catch:{ Exception -> 0x0060 }
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0060 }
        if (r1 != 0) goto L_0x0051;	 Catch:{ Exception -> 0x0060 }
    L_0x001c:
        r3 = r3.getContentResolver();	 Catch:{ Exception -> 0x0060 }
        r1 = "bd_setting_i";	 Catch:{ Exception -> 0x0060 }
        r3 = android.provider.Settings.System.getString(r3, r1);	 Catch:{ Exception -> 0x0060 }
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0060 }
        if (r1 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x0060 }
    L_0x002c:
        r3 = "0";	 Catch:{ Exception -> 0x0060 }
    L_0x002e:
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0060 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0060 }
        r3 = r1.reverse();	 Catch:{ Exception -> 0x0060 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0060 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0060 }
        r1.<init>();	 Catch:{ Exception -> 0x0060 }
        r1.append(r0);	 Catch:{ Exception -> 0x0060 }
        r0 = "|";	 Catch:{ Exception -> 0x0060 }
        r1.append(r0);	 Catch:{ Exception -> 0x0060 }
        r1.append(r3);	 Catch:{ Exception -> 0x0060 }
        r3 = r1.toString();	 Catch:{ Exception -> 0x0060 }
        b = r3;	 Catch:{ Exception -> 0x0060 }
    L_0x0051:
        r3 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0060 }
        r3 = r3.getCommonUtils();	 Catch:{ Exception -> 0x0060 }
        r0 = b;	 Catch:{ Exception -> 0x0060 }
        r3 = r3.b(r0);	 Catch:{ Exception -> 0x0060 }
        return r3;
    L_0x0060:
        r3 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r3 = r3.getCommonUtils();
        r0 = b;
        r3 = r3.b(r0);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getCUID(android.content.Context):java.lang.String");
    }

    public double[] getGPS(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0013 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0013 }
        r1 = "SYSGPS";	 Catch:{ Exception -> 0x0013 }
        r0 = r0.a(r1);	 Catch:{ Exception -> 0x0013 }
        if (r0 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x0013 }
    L_0x0010:
        r0 = (double[]) r0;	 Catch:{ Exception -> 0x0013 }
        return r0;
    L_0x0013:
        r0 = move-exception;
        r1 = com.baidu.mobads.utils.l.a();
        r1.e(r0);
    L_0x001b:
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0 = r0.getCommonUtils();
        r1 = 0;
        r2 = "android.permission.ACCESS_FINE_LOCATION";
        r0 = r0.hasPermission(r5, r2);
        if (r0 == 0) goto L_0x0056;
    L_0x002c:
        r0 = "location";	 Catch:{ Exception -> 0x0056 }
        r5 = r5.getSystemService(r0);	 Catch:{ Exception -> 0x0056 }
        r5 = (android.location.LocationManager) r5;	 Catch:{ Exception -> 0x0056 }
        r0 = "gps";	 Catch:{ Exception -> 0x0056 }
        r5 = r5.getLastKnownLocation(r0);	 Catch:{ Exception -> 0x0056 }
        if (r5 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x0056 }
    L_0x003c:
        r0 = 3;	 Catch:{ Exception -> 0x0056 }
        r0 = new double[r0];	 Catch:{ Exception -> 0x0056 }
        r1 = 0;
        r2 = r5.getTime();	 Catch:{ Exception -> 0x0055 }
        r2 = (double) r2;	 Catch:{ Exception -> 0x0055 }
        r0[r1] = r2;	 Catch:{ Exception -> 0x0055 }
        r1 = 1;	 Catch:{ Exception -> 0x0055 }
        r2 = r5.getLongitude();	 Catch:{ Exception -> 0x0055 }
        r0[r1] = r2;	 Catch:{ Exception -> 0x0055 }
        r1 = 2;	 Catch:{ Exception -> 0x0055 }
        r2 = r5.getLatitude();	 Catch:{ Exception -> 0x0055 }
        r0[r1] = r2;	 Catch:{ Exception -> 0x0055 }
    L_0x0055:
        r1 = r0;
    L_0x0056:
        r5 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r5 = r5.getCommonUtils();
        r0 = "SYSGPS";
        r5.a(r0, r1);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getGPS(android.content.Context):double[]");
    }

    public java.lang.String getGUID(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = r5.f;	 Catch:{ Exception -> 0x007d }
        if (r0 != 0) goto L_0x007a;	 Catch:{ Exception -> 0x007d }
    L_0x0004:
        if (r6 == 0) goto L_0x007a;	 Catch:{ Exception -> 0x007d }
    L_0x0006:
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x007d }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x007d }
        r1 = "__x_adsdk_agent_header__";	 Catch:{ Exception -> 0x007d }
        r2 = 0;	 Catch:{ Exception -> 0x007d }
        r1 = r6.getSharedPreferences(r1, r2);	 Catch:{ Exception -> 0x007d }
        r3 = "guid";	 Catch:{ Exception -> 0x007d }
        r4 = "";	 Catch:{ Exception -> 0x007d }
        r1 = r1.getString(r3, r4);	 Catch:{ Exception -> 0x007d }
        r5.f = r1;	 Catch:{ Exception -> 0x007d }
        r1 = r5.f;	 Catch:{ Exception -> 0x007d }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Exception -> 0x007d }
    L_0x0023:
        r1 = r5.f;	 Catch:{ Exception -> 0x007d }
        r1 = r1.length();	 Catch:{ Exception -> 0x007d }
        if (r1 > 0) goto L_0x0074;	 Catch:{ Exception -> 0x007d }
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007d }
        r1.<init>();	 Catch:{ Exception -> 0x007d }
        r3 = r5.getMacAddress(r6);	 Catch:{ Exception -> 0x007d }
        r1.append(r3);	 Catch:{ Exception -> 0x007d }
        r3 = "&";	 Catch:{ Exception -> 0x007d }
        r1.append(r3);	 Catch:{ Exception -> 0x007d }
        r3 = r5.getIMEI(r6);	 Catch:{ Exception -> 0x007d }
        r1.append(r3);	 Catch:{ Exception -> 0x007d }
        r3 = "&&";	 Catch:{ Exception -> 0x007d }
        r1.append(r3);	 Catch:{ Exception -> 0x007d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x007d }
        r0 = r0.md5(r1);	 Catch:{ Exception -> 0x007d }
        r5.f = r0;	 Catch:{ Exception -> 0x007d }
        r0 = r5.f;	 Catch:{ Exception -> 0x007d }
        if (r0 == 0) goto L_0x0077;	 Catch:{ Exception -> 0x007d }
    L_0x0056:
        r0 = r5.f;	 Catch:{ Exception -> 0x007d }
        r0 = r0.length();	 Catch:{ Exception -> 0x007d }
        if (r0 > 0) goto L_0x005f;	 Catch:{ Exception -> 0x007d }
    L_0x005e:
        goto L_0x0077;	 Catch:{ Exception -> 0x007d }
    L_0x005f:
        r0 = "__x_adsdk_agent_header__";	 Catch:{ Exception -> 0x007d }
        r6 = r6.getSharedPreferences(r0, r2);	 Catch:{ Exception -> 0x007d }
        r6 = r6.edit();	 Catch:{ Exception -> 0x007d }
        r0 = "guid";	 Catch:{ Exception -> 0x007d }
        r1 = r5.f;	 Catch:{ Exception -> 0x007d }
        r6 = r6.putString(r0, r1);	 Catch:{ Exception -> 0x007d }
        r6.commit();	 Catch:{ Exception -> 0x007d }
    L_0x0074:
        r6 = r5.f;	 Catch:{ Exception -> 0x007d }
        return r6;	 Catch:{ Exception -> 0x007d }
    L_0x0077:
        r6 = "";	 Catch:{ Exception -> 0x007d }
        return r6;	 Catch:{ Exception -> 0x007d }
    L_0x007a:
        r6 = r5.f;	 Catch:{ Exception -> 0x007d }
        return r6;
    L_0x007d:
        r6 = "";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getGUID(android.content.Context):java.lang.String");
    }

    public java.lang.String getAndroidId(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.g;	 Catch:{ Exception -> 0x0023 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0023 }
        if (r0 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x0023 }
    L_0x0008:
        r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x0023 }
        r0 = "android_id";	 Catch:{ Exception -> 0x0023 }
        r2 = android.provider.Settings.Secure.getString(r2, r0);	 Catch:{ Exception -> 0x0023 }
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0023 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0023 }
        r2 = r0.b(r2);	 Catch:{ Exception -> 0x0023 }
        r1.g = r2;	 Catch:{ Exception -> 0x0023 }
    L_0x0020:
        r2 = r1.g;	 Catch:{ Exception -> 0x0023 }
        return r2;
    L_0x0023:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getAndroidId(android.content.Context):java.lang.String");
    }

    public java.lang.String getAppSDC() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0013 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0013 }
        r1 = "sysSdc";	 Catch:{ Exception -> 0x0013 }
        r0 = r0.a(r1);	 Catch:{ Exception -> 0x0013 }
        if (r0 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x0013 }
    L_0x0010:
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0013 }
        return r0;
    L_0x0013:
        r0 = move-exception;
        r1 = com.baidu.mobads.utils.l.a();
        r1.e(r0);
    L_0x001b:
        r0 = android.os.Environment.getExternalStorageState();
        r1 = "mounted";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0055;
    L_0x0027:
        r0 = "";
        r1 = r6.getAvailableExternalMemorySize();	 Catch:{ Exception -> 0x0054 }
        r3 = r6.getAllExternalMemorySize();	 Catch:{ Exception -> 0x0054 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
        r5.<init>();	 Catch:{ Exception -> 0x0054 }
        r5.append(r1);	 Catch:{ Exception -> 0x0054 }
        r1 = ",";	 Catch:{ Exception -> 0x0054 }
        r5.append(r1);	 Catch:{ Exception -> 0x0054 }
        r5.append(r3);	 Catch:{ Exception -> 0x0054 }
        r1 = r5.toString();	 Catch:{ Exception -> 0x0054 }
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0053 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0053 }
        r2 = "sysSdc";	 Catch:{ Exception -> 0x0053 }
        r0.a(r2, r1);	 Catch:{ Exception -> 0x0053 }
        return r1;
    L_0x0053:
        r0 = r1;
    L_0x0054:
        return r0;
    L_0x0055:
        r0 = "0,0";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getAppSDC():java.lang.String");
    }

    public java.lang.String getMem() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0013 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0013 }
        r1 = "sysMem";	 Catch:{ Exception -> 0x0013 }
        r0 = r0.a(r1);	 Catch:{ Exception -> 0x0013 }
        if (r0 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x0013 }
    L_0x0010:
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0013 }
        return r0;
    L_0x0013:
        r0 = move-exception;
        r1 = com.baidu.mobads.utils.l.a();
        r1.e(r0);
    L_0x001b:
        r0 = "";
        r1 = r6.getAvailableInternalMemorySize();	 Catch:{ Exception -> 0x0048 }
        r3 = r6.getAllInternalMemorySize();	 Catch:{ Exception -> 0x0048 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0048 }
        r5.<init>();	 Catch:{ Exception -> 0x0048 }
        r5.append(r1);	 Catch:{ Exception -> 0x0048 }
        r1 = ",";	 Catch:{ Exception -> 0x0048 }
        r5.append(r1);	 Catch:{ Exception -> 0x0048 }
        r5.append(r3);	 Catch:{ Exception -> 0x0048 }
        r1 = r5.toString();	 Catch:{ Exception -> 0x0048 }
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0047 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0047 }
        r2 = "sysMem";	 Catch:{ Exception -> 0x0047 }
        r0.a(r2, r1);	 Catch:{ Exception -> 0x0047 }
        return r1;
    L_0x0047:
        r0 = r1;
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getMem():java.lang.String");
    }

    public long getAllExternalMemorySize() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = -1;
        r2 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x0018 }
        r3 = "mounted";	 Catch:{ Exception -> 0x0018 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x0018 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0018 }
    L_0x000e:
        r2 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0018 }
        r2 = r4.a(r2);	 Catch:{ Exception -> 0x0018 }
        return r2;
    L_0x0017:
        return r0;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getAllExternalMemorySize():long");
    }

    public long getAllInternalMemorySize() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = android.os.Environment.getDataDirectory();	 Catch:{ Exception -> 0x0009 }
        r0 = r2.a(r0);	 Catch:{ Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getAllInternalMemorySize():long");
    }

    public long getAvailableExternalMemorySize() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = -1;
        r2 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x0018 }
        r3 = "mounted";	 Catch:{ Exception -> 0x0018 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x0018 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0018 }
    L_0x000e:
        r2 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0018 }
        r2 = r4.b(r2);	 Catch:{ Exception -> 0x0018 }
        return r2;
    L_0x0017:
        return r0;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getAvailableExternalMemorySize():long");
    }

    public long getAvailableInternalMemorySize() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = android.os.Environment.getDataDirectory();	 Catch:{ Exception -> 0x0009 }
        r0 = r2.b(r0);	 Catch:{ Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getAvailableInternalMemorySize():long");
    }

    @android.annotation.TargetApi(18)
    private long a(java.io.File r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = new android.os.StatFs;	 Catch:{ Exception -> 0x0018 }
        r3 = r3.getPath();	 Catch:{ Exception -> 0x0018 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0018 }
        r3 = r0.getBlockCount();	 Catch:{ Exception -> 0x0018 }
        r0 = r0.getBlockSize();	 Catch:{ Exception -> 0x0018 }
        r3 = r3 * r0;	 Catch:{ Exception -> 0x0018 }
        r3 = r3 / 1024;	 Catch:{ Exception -> 0x0018 }
        r3 = r3 / 1024;	 Catch:{ Exception -> 0x0018 }
        r0 = (long) r3;
        return r0;
    L_0x0018:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.a(java.io.File):long");
    }

    @android.annotation.TargetApi(18)
    private long b(java.io.File r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = new android.os.StatFs;	 Catch:{ Exception -> 0x0018 }
        r3 = r3.getPath();	 Catch:{ Exception -> 0x0018 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0018 }
        r3 = r0.getAvailableBlocks();	 Catch:{ Exception -> 0x0018 }
        r0 = r0.getBlockSize();	 Catch:{ Exception -> 0x0018 }
        r3 = r3 * r0;	 Catch:{ Exception -> 0x0018 }
        r3 = r3 / 1024;	 Catch:{ Exception -> 0x0018 }
        r3 = r3 / 1024;	 Catch:{ Exception -> 0x0018 }
        r0 = (long) r3;
        return r0;
    L_0x0018:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.b(java.io.File):long");
    }

    public String getMacAddress(Context context) {
        if (TextUtils.isEmpty(this.h)) {
            IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE) != null) {
                    this.h = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(wifiManager.getConnectionInfo().getMacAddress());
                } else {
                    adLogger.e("", "Could not get mac address. no android.permission.ACCESS_WIFI_STATE");
                }
            } catch (Context context2) {
                Object[] objArr = new Object[2];
                objArr[0] = "";
                StringBuilder stringBuilder = new StringBuilder("Could not get mac address.");
                stringBuilder.append(context2.toString());
                objArr[1] = stringBuilder.toString();
                adLogger.e(objArr);
            }
        }
        return this.h;
    }

    @android.annotation.TargetApi(3)
    public java.lang.String getIp(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = "";
        r1 = "connectivity";
        r1 = r5.getSystemService(r1);
        r1 = (android.net.ConnectivityManager) r1;
        r1 = r1.getActiveNetworkInfo();
        if (r1 != 0) goto L_0x0013;
    L_0x0010:
        r5 = "";
        return r5;
    L_0x0013:
        r1 = "wifi";	 Catch:{ SocketException -> 0x0074, SocketException -> 0x0074 }
        r5 = r5.getSystemService(r1);	 Catch:{ SocketException -> 0x0074, SocketException -> 0x0074 }
        r5 = (android.net.wifi.WifiManager) r5;	 Catch:{ SocketException -> 0x0074, SocketException -> 0x0074 }
        r5 = r5.getConnectionInfo();	 Catch:{ SocketException -> 0x0074, SocketException -> 0x0074 }
        r5 = r5.getIpAddress();	 Catch:{ SocketException -> 0x0074, SocketException -> 0x0074 }
        r5 = android.text.format.Formatter.formatIpAddress(r5);	 Catch:{ SocketException -> 0x0074, SocketException -> 0x0074 }
        r0 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r0 != 0) goto L_0x0039;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x002d:
        r0 = "0.0.0.0";	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        r0 = r0.equals(r5);	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r0 == 0) goto L_0x0038;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x0035:
        r0 = "";	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        return r0;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x0038:
        return r5;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x0039:
        r0 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x003d:
        r1 = r0.hasMoreElements();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r1 == 0) goto L_0x0075;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x0043:
        r1 = r0.nextElement();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        r1 = (java.net.NetworkInterface) r1;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        r1 = r1.getInetAddresses();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x004d:
        r2 = r1.hasMoreElements();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r2 == 0) goto L_0x003d;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x0053:
        r2 = r1.nextElement();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        r2 = (java.net.InetAddress) r2;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        r3 = r2.isLoopbackAddress();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r3 != 0) goto L_0x004d;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x005f:
        r3 = r2.isLinkLocalAddress();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r3 != 0) goto L_0x004d;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x0065:
        r3 = r2.isSiteLocalAddress();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r3 == 0) goto L_0x004d;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x006b:
        r3 = r2 instanceof java.net.Inet4Address;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        if (r3 == 0) goto L_0x004d;	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
    L_0x006f:
        r0 = r2.getHostAddress();	 Catch:{ SocketException -> 0x0075, SocketException -> 0x0075 }
        return r0;
    L_0x0074:
        r5 = r0;
    L_0x0075:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getIp(android.content.Context):java.lang.String");
    }

    public String getMaxCpuFreq() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        StringBuilder stringBuilder;
        if (this.i < 0) {
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (Throwable e) {
                    th = e;
                    bufferedReader = null;
                    th2 = th;
                    try {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d(th2);
                        fileReader.close();
                        bufferedReader.close();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(this.i);
                        return stringBuilder.toString();
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            fileReader.close();
                            bufferedReader.close();
                        } catch (Throwable e2) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
                        }
                        throw th2;
                    }
                } catch (Throwable e3) {
                    th = e3;
                    bufferedReader = null;
                    th2 = th;
                    fileReader.close();
                    bufferedReader.close();
                    throw th2;
                }
                try {
                    this.i = Integer.parseInt(bufferedReader.readLine().trim()) / 1000;
                } catch (Exception e4) {
                    th2 = e4;
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d(th2);
                    fileReader.close();
                    bufferedReader.close();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(this.i);
                    return stringBuilder.toString();
                }
                try {
                    fileReader.close();
                    bufferedReader.close();
                } catch (Throwable th22) {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d(th22);
                }
            } catch (Throwable e22) {
                bufferedReader = null;
                th22 = e22;
                fileReader = bufferedReader;
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(th22);
                fileReader.close();
                bufferedReader.close();
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.i);
                return stringBuilder.toString();
            } catch (Throwable e222) {
                bufferedReader = null;
                th22 = e222;
                fileReader = bufferedReader;
                fileReader.close();
                bufferedReader.close();
                throw th22;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.i);
        return stringBuilder.toString();
    }

    public java.lang.String getNetworkOperatorName(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = r5.j;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0076;
    L_0x0008:
        r0 = 1;
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x005f }
        r1 = r1.getCommonUtils();	 Catch:{ Exception -> 0x005f }
        r2 = "phone";	 Catch:{ Exception -> 0x005f }
        r6 = r6.getSystemService(r2);	 Catch:{ Exception -> 0x005f }
        r6 = (android.telephony.TelephonyManager) r6;	 Catch:{ Exception -> 0x005f }
        r2 = r6.getSimOperatorName();	 Catch:{ Exception -> 0x005f }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005f }
        r3.<init>();	 Catch:{ Exception -> 0x005f }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x005f }
        if (r4 != 0) goto L_0x002c;	 Catch:{ Exception -> 0x005f }
    L_0x0028:
        r3.append(r2);	 Catch:{ Exception -> 0x005f }
        goto L_0x0039;	 Catch:{ Exception -> 0x005f }
    L_0x002c:
        r2 = r6.getNetworkOperatorName();	 Catch:{ Exception -> 0x005f }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x005f }
        if (r4 != 0) goto L_0x005c;	 Catch:{ Exception -> 0x005f }
    L_0x0036:
        r3.append(r2);	 Catch:{ Exception -> 0x005f }
    L_0x0039:
        r2 = "_";	 Catch:{ Exception -> 0x005f }
        r3.append(r2);	 Catch:{ Exception -> 0x005f }
        r6 = r6.getSimOperator();	 Catch:{ Exception -> 0x005f }
        r2 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x005f }
        if (r2 != 0) goto L_0x004b;	 Catch:{ Exception -> 0x005f }
    L_0x0048:
        r3.append(r6);	 Catch:{ Exception -> 0x005f }
    L_0x004b:
        r6 = r3.length();	 Catch:{ Exception -> 0x005f }
        if (r6 <= r0) goto L_0x0076;	 Catch:{ Exception -> 0x005f }
    L_0x0051:
        r6 = r3.toString();	 Catch:{ Exception -> 0x005f }
        r6 = r1.getTextEncoder(r6);	 Catch:{ Exception -> 0x005f }
        r5.j = r6;	 Catch:{ Exception -> 0x005f }
        goto L_0x0076;	 Catch:{ Exception -> 0x005f }
    L_0x005c:
        r6 = "";	 Catch:{ Exception -> 0x005f }
        return r6;
    L_0x005f:
        r6 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r6 = r6.getAdLogger();
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "Get operator failed";
        r1[r2] = r3;
        r2 = "";
        r1[r0] = r2;
        r6.e(r1);
    L_0x0076:
        r6 = r5.j;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getNetworkOperatorName(android.content.Context):java.lang.String");
    }

    public java.lang.String getNetworkOperator(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.k;	 Catch:{ Exception -> 0x0025 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x0025 }
    L_0x0008:
        r0 = "phone";	 Catch:{ Exception -> 0x0025 }
        r2 = r2.getSystemService(r0);	 Catch:{ Exception -> 0x0025 }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x0025 }
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0025 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0025 }
        r2 = r2.getNetworkOperator();	 Catch:{ Exception -> 0x0025 }
        r2 = r0.b(r2);	 Catch:{ Exception -> 0x0025 }
        r1.k = r2;	 Catch:{ Exception -> 0x0025 }
    L_0x0022:
        r2 = r1.k;	 Catch:{ Exception -> 0x0025 }
        return r2;
    L_0x0025:
        r2 = r1.k;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getNetworkOperator(android.content.Context):java.lang.String");
    }

    public String getPhoneOSBuildVersionSdk() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(VERSION.SDK);
    }

    @SuppressLint({"DefaultLocale"})
    @TargetApi(3)
    public String getNetworkType(Context context) {
        String str = "none";
        try {
            context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context != null && context.isConnectedOrConnecting()) {
                if (context.getType() == 1) {
                    return "wifi";
                }
                String str2 = "unknown";
                try {
                    if (context.getSubtypeName() == null) {
                        return str2;
                    }
                    str = context.getSubtypeName().toLowerCase();
                } catch (Exception e) {
                    context = e;
                    str = str2;
                    XAdSDKFoundationFacade.getInstance().getAdLogger().i(context);
                    return str;
                }
            }
        } catch (Exception e2) {
            context = e2;
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(context);
            return str;
        }
        return str;
    }

    public String getNetType(Context context) {
        Throwable e;
        String str = "";
        String stringBuilder;
        try {
            StringBuilder stringBuilder2 = new StringBuilder("_");
            stringBuilder2.append(((TelephonyManager) context.getSystemService("phone")).getNetworkType());
            stringBuilder = stringBuilder2.toString();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                context = connectivityManager.getNetworkInfo(1);
                if (networkInfo == null || !networkInfo.isAvailable()) {
                    if (!(context == null || context.isAvailable() == null)) {
                        context = new StringBuilder("wifi");
                        context.append(stringBuilder);
                        return context.toString();
                    }
                    return stringBuilder;
                }
                context = new StringBuilder();
                context.append(networkInfo.getExtraInfo());
                context.append(stringBuilder);
                return context.toString();
            } catch (Exception e2) {
                e = e2;
                l.a().e(e);
                return stringBuilder;
            }
        } catch (Exception e3) {
            e = e3;
            stringBuilder = str;
            l.a().e(e);
            return stringBuilder;
        }
    }

    public int getNetworkCatagory(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = "connectivity";	 Catch:{ Exception -> 0x0054 }
        r5 = r5.getSystemService(r1);	 Catch:{ Exception -> 0x0054 }
        r5 = (android.net.ConnectivityManager) r5;	 Catch:{ Exception -> 0x0054 }
        r5 = r5.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0054 }
        r1 = 3;	 Catch:{ Exception -> 0x0054 }
        r2 = 1;	 Catch:{ Exception -> 0x0054 }
        if (r5 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x0011:
        r3 = r5.isConnected();	 Catch:{ Exception -> 0x0054 }
        if (r3 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x0017:
        r3 = r5.getType();	 Catch:{ Exception -> 0x0054 }
        if (r3 != r2) goto L_0x0020;	 Catch:{ Exception -> 0x0054 }
    L_0x001d:
        r0 = 100;	 Catch:{ Exception -> 0x0054 }
        goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x0020:
        r3 = r5.getType();	 Catch:{ Exception -> 0x0054 }
        if (r3 != 0) goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x0026:
        r3 = r5.getSubtypeName();	 Catch:{ Exception -> 0x0054 }
        r5 = r5.getSubtype();	 Catch:{ Exception -> 0x0054 }
        switch(r5) {
            case 0: goto L_0x003a;
            case 1: goto L_0x0038;
            case 2: goto L_0x0038;
            case 3: goto L_0x0036;
            case 4: goto L_0x0038;
            case 5: goto L_0x0036;
            case 6: goto L_0x0036;
            case 7: goto L_0x0038;
            case 8: goto L_0x0036;
            case 9: goto L_0x0036;
            case 10: goto L_0x0036;
            case 11: goto L_0x0038;
            default: goto L_0x0031;
        };	 Catch:{ Exception -> 0x0054 }
    L_0x0031:
        if (r3 == 0) goto L_0x003a;	 Catch:{ Exception -> 0x0054 }
    L_0x0033:
        r5 = "TD-SCDMA";	 Catch:{ Exception -> 0x0054 }
        goto L_0x003c;	 Catch:{ Exception -> 0x0054 }
    L_0x0036:
        r0 = r1;	 Catch:{ Exception -> 0x0054 }
        goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x0038:
        r0 = 2;	 Catch:{ Exception -> 0x0054 }
        goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x003a:
        r0 = r2;	 Catch:{ Exception -> 0x0054 }
        goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x003c:
        r5 = r3.equalsIgnoreCase(r5);	 Catch:{ Exception -> 0x0054 }
        if (r5 != 0) goto L_0x0036;	 Catch:{ Exception -> 0x0054 }
    L_0x0042:
        r5 = "WCDMA";	 Catch:{ Exception -> 0x0054 }
        r5 = r3.equalsIgnoreCase(r5);	 Catch:{ Exception -> 0x0054 }
        if (r5 != 0) goto L_0x0036;	 Catch:{ Exception -> 0x0054 }
    L_0x004a:
        r5 = "CDMA2000";	 Catch:{ Exception -> 0x0054 }
        r5 = r3.equalsIgnoreCase(r5);	 Catch:{ Exception -> 0x0054 }
        if (r5 == 0) goto L_0x003a;
    L_0x0052:
        goto L_0x0036;
    L_0x0053:
        return r0;
    L_0x0054:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getNetworkCatagory(android.content.Context):int");
    }

    public Boolean isWifiConnected(Context context) {
        return a(context, 1);
    }

    public Boolean is3GConnected(Context context) {
        return a(context, 0);
    }

    private java.lang.Boolean a(android.content.Context r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Exception -> 0x0046 }
        r1 = r4.checkCallingOrSelfPermission(r1);	 Catch:{ Exception -> 0x0046 }
        r2 = 1;	 Catch:{ Exception -> 0x0046 }
        if (r1 == 0) goto L_0x0025;	 Catch:{ Exception -> 0x0046 }
    L_0x000a:
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0046 }
        r4 = r4.getAdLogger();	 Catch:{ Exception -> 0x0046 }
        r5 = 2;	 Catch:{ Exception -> 0x0046 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0046 }
        r1 = "Utils";	 Catch:{ Exception -> 0x0046 }
        r5[r0] = r1;	 Catch:{ Exception -> 0x0046 }
        r1 = "no permission android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Exception -> 0x0046 }
        r5[r2] = r1;	 Catch:{ Exception -> 0x0046 }
        r4.e(r5);	 Catch:{ Exception -> 0x0046 }
        r4 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x0046 }
        return r4;	 Catch:{ Exception -> 0x0046 }
    L_0x0025:
        r1 = "connectivity";	 Catch:{ Exception -> 0x0046 }
        r4 = r4.getSystemService(r1);	 Catch:{ Exception -> 0x0046 }
        r4 = (android.net.ConnectivityManager) r4;	 Catch:{ Exception -> 0x0046 }
        r4 = r4.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0046 }
        if (r4 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0046 }
    L_0x0033:
        r1 = r4.getType();	 Catch:{ Exception -> 0x0046 }
        if (r1 != r5) goto L_0x0040;	 Catch:{ Exception -> 0x0046 }
    L_0x0039:
        r4 = r4.isConnected();	 Catch:{ Exception -> 0x0046 }
        if (r4 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0046 }
    L_0x003f:
        goto L_0x0041;	 Catch:{ Exception -> 0x0046 }
    L_0x0040:
        r2 = r0;	 Catch:{ Exception -> 0x0046 }
    L_0x0041:
        r4 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0046 }
        return r4;
    L_0x0046:
        r4 = java.lang.Boolean.valueOf(r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.a(android.content.Context, int):java.lang.Boolean");
    }

    public String getDeviceId(Context context) {
        if (TextUtils.isEmpty(this.l) && context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("__x_adsdk_agent_header__", 0);
            Object string = sharedPreferences.getString(XAdSDKFoundationFacade.getInstance().getBase64().decodeStr("pyd-pifb"), "");
            if (TextUtils.isEmpty(string)) {
                try {
                    String str = (String) XAdSDKFoundationFacade.getInstance().getCommonUtils().a((TelephonyManager) context.getApplicationContext().getSystemService("phone"), XAdSDKFoundationFacade.getInstance().getBase64().decodeStr("uvNYwANvpyP-iyfb"), new Object[0]);
                    if (!TextUtils.isEmpty(str)) {
                        new Thread(new p(this, sharedPreferences, str)).start();
                        this.l = str;
                    }
                } catch (Throwable e) {
                    l.a().d(e);
                }
            } else {
                this.l = string;
            }
        }
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(this.l);
    }

    public java.lang.String getEncodedSN(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.m;	 Catch:{ Exception -> 0x001d }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x001d }
        if (r0 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x001d }
    L_0x0008:
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x001d }
        r0 = r0.getBase64();	 Catch:{ Exception -> 0x001d }
        r2 = r1.getSn(r2);	 Catch:{ Exception -> 0x001d }
        r2 = r0.encode(r2);	 Catch:{ Exception -> 0x001d }
        r1.m = r2;	 Catch:{ Exception -> 0x001d }
    L_0x001a:
        r2 = r1.m;	 Catch:{ Exception -> 0x001d }
        return r2;
    L_0x001d:
        r2 = r1.m;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getEncodedSN(android.content.Context):java.lang.String");
    }

    public String getPhoneOSBrand() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.BRAND);
    }

    public java.util.List<java.lang.String[]> getCell(android.content.Context r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0013 }
        r0 = r0.getCommonUtils();	 Catch:{ Exception -> 0x0013 }
        r1 = "cell";	 Catch:{ Exception -> 0x0013 }
        r0 = r0.a(r1);	 Catch:{ Exception -> 0x0013 }
        if (r0 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x0013 }
    L_0x0010:
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x0013 }
        return r0;
    L_0x0013:
        r0 = move-exception;
        r1 = com.baidu.mobads.utils.l.a();
        r1.e(r0);
    L_0x001b:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "phone";	 Catch:{ Exception -> 0x009a }
        r9 = r9.getSystemService(r1);	 Catch:{ Exception -> 0x009a }
        r9 = (android.telephony.TelephonyManager) r9;	 Catch:{ Exception -> 0x009a }
        r9 = r9.getCellLocation();	 Catch:{ Exception -> 0x009a }
        if (r9 == 0) goto L_0x008d;	 Catch:{ Exception -> 0x009a }
    L_0x002e:
        r1 = 3;	 Catch:{ Exception -> 0x009a }
        r2 = new java.lang.String[r1];	 Catch:{ Exception -> 0x009a }
        r3 = r9 instanceof android.telephony.gsm.GsmCellLocation;	 Catch:{ Exception -> 0x009a }
        r4 = 2;	 Catch:{ Exception -> 0x009a }
        r5 = 1;	 Catch:{ Exception -> 0x009a }
        r6 = 0;	 Catch:{ Exception -> 0x009a }
        if (r3 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x009a }
    L_0x0038:
        r9 = (android.telephony.gsm.GsmCellLocation) r9;	 Catch:{ Exception -> 0x009a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009a }
        r1.<init>();	 Catch:{ Exception -> 0x009a }
        r3 = r9.getCid();	 Catch:{ Exception -> 0x009a }
        r1.append(r3);	 Catch:{ Exception -> 0x009a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x009a }
        r2[r6] = r1;	 Catch:{ Exception -> 0x009a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009a }
        r1.<init>();	 Catch:{ Exception -> 0x009a }
        r9 = r9.getLac();	 Catch:{ Exception -> 0x009a }
        r1.append(r9);	 Catch:{ Exception -> 0x009a }
        r9 = r1.toString();	 Catch:{ Exception -> 0x009a }
        r2[r5] = r9;	 Catch:{ Exception -> 0x009a }
        r9 = "0";	 Catch:{ Exception -> 0x009a }
        r2[r4] = r9;	 Catch:{ Exception -> 0x009a }
        goto L_0x008a;	 Catch:{ Exception -> 0x009a }
    L_0x0063:
        r9 = r9.toString();	 Catch:{ Exception -> 0x009a }
        r3 = "[";	 Catch:{ Exception -> 0x009a }
        r7 = "";	 Catch:{ Exception -> 0x009a }
        r9 = r9.replace(r3, r7);	 Catch:{ Exception -> 0x009a }
        r3 = "]";	 Catch:{ Exception -> 0x009a }
        r7 = "";	 Catch:{ Exception -> 0x009a }
        r9 = r9.replace(r3, r7);	 Catch:{ Exception -> 0x009a }
        r3 = ",";	 Catch:{ Exception -> 0x009a }
        r9 = r9.split(r3);	 Catch:{ Exception -> 0x009a }
        r3 = r9[r6];	 Catch:{ Exception -> 0x009a }
        r2[r6] = r3;	 Catch:{ Exception -> 0x009a }
        r1 = r9[r1];	 Catch:{ Exception -> 0x009a }
        r2[r5] = r1;	 Catch:{ Exception -> 0x009a }
        r1 = 4;	 Catch:{ Exception -> 0x009a }
        r9 = r9[r1];	 Catch:{ Exception -> 0x009a }
        r2[r4] = r9;	 Catch:{ Exception -> 0x009a }
    L_0x008a:
        r0.add(r2);	 Catch:{ Exception -> 0x009a }
    L_0x008d:
        r9 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x009a }
        r9 = r9.getCommonUtils();	 Catch:{ Exception -> 0x009a }
        r1 = "cell";	 Catch:{ Exception -> 0x009a }
        r9.a(r1, r0);	 Catch:{ Exception -> 0x009a }
    L_0x009a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getCell(android.content.Context):java.util.List<java.lang.String[]>");
    }

    public List<String[]> getWIFI(Context context) {
        Object a;
        IXAdCommonUtils commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        try {
            a = ((d) commonUtils).a("wifi");
            if (a != null) {
                return (List) a;
            }
        } catch (Throwable e) {
            l.a().e(e);
        }
        a = new ArrayList();
        try {
            if (commonUtils.hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    context = wifiManager.getScanResults();
                    Collections.sort(context, new q(this));
                    int i = 0;
                    while (i < context.size() && i < 5) {
                        ScanResult scanResult = (ScanResult) context.get(i);
                        Object obj = new String[2];
                        obj[0] = scanResult.BSSID.replace(Constants.COLON_SEPARATOR, "").toLowerCase(Locale.getDefault());
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(Math.abs(scanResult.level));
                        obj[1] = stringBuilder.toString();
                        a.add(obj);
                        i++;
                    }
                }
            }
        } catch (Throwable e2) {
            l.a().e(e2);
        }
        ((d) commonUtils).a("wifi", a);
        return a;
    }

    public boolean canSupportSdcardStroage(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x001b }
        r1 = r1.getCommonUtils();	 Catch:{ Exception -> 0x001b }
        r2 = "android.permission.WRITE_EXTERNAL_STORAGE";	 Catch:{ Exception -> 0x001b }
        r4 = r1.hasPermission(r4, r2);	 Catch:{ Exception -> 0x001b }
        if (r4 != 0) goto L_0x0019;	 Catch:{ Exception -> 0x001b }
    L_0x0011:
        r4 = r3.isUseOldStoragePath();	 Catch:{ Exception -> 0x001b }
        if (r4 != 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0019;
    L_0x0018:
        return r0;
    L_0x0019:
        r4 = 1;
        return r4;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.canSupportSdcardStroage(android.content.Context):boolean");
    }

    public boolean isUseOldStoragePath() {
        return VERSION.SDK_INT < 23;
    }

    public String getWifiConnected(Context context) {
        String str = "";
        try {
            if (!XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                return str;
            }
            context = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            String ssid = context.getSSID();
            if (ssid == null) {
                ssid = "";
            } else if (ssid.length() > 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) {
                ssid = ssid.substring(1, ssid.length() - 1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getBSSID());
            stringBuilder.append("|");
            stringBuilder.append(XAdSDKFoundationFacade.getInstance().getBase64().encode(ssid));
            return stringBuilder.toString();
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return str;
        }
    }

    public JSONArray getWifiScans(Context context) {
        Object a;
        try {
            a = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("wifiScans");
            if (a != null) {
                return (JSONArray) a;
            }
        } catch (Throwable e) {
            l.a().e(e);
        }
        a = new JSONArray();
        try {
            if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    context = wifiManager.getScanResults();
                    Collections.sort(context, new r(this));
                    int i = 0;
                    while (i < context.size() && i < 50) {
                        ScanResult scanResult = (ScanResult) context.get(i);
                        String str = scanResult.BSSID;
                        String str2 = scanResult.SSID;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("|");
                        stringBuilder.append(XAdSDKFoundationFacade.getInstance().getBase64().encode(str2));
                        a.put(stringBuilder.toString());
                        i++;
                    }
                }
            }
        } catch (Throwable e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a("wifiScans", a);
        return a;
    }

    public JSONArray getBackgroundBrowsers(Context context) {
        IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
        String[] supportedBrowsers = XAdSDKFoundationFacade.getInstance().getAdConstants().getSupportedBrowsers();
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            context = context.getApplicationContext().getPackageManager();
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (!(context.getLaunchIntentForPackage(runningAppProcessInfo.processName) == null || context.getApplicationInfo(runningAppProcessInfo.processName, 128) == null)) {
                    for (Object equals : supportedBrowsers) {
                        if (runningAppProcessInfo.processName.equals(equals)) {
                            this.a.put(runningAppProcessInfo.processName);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            adLogger.d(e);
        }
        context = new StringBuilder("bgBrowsers:");
        context.append(this.a);
        adLogger.d(context.toString());
        return this.a;
    }

    public java.net.HttpURLConnection getHttpConnection(android.content.Context r1, java.lang.String r2, int r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = this;
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x0012 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0012 }
        r1 = r1.openConnection();	 Catch:{ Exception -> 0x0012 }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ Exception -> 0x0012 }
        r1.setConnectTimeout(r3);	 Catch:{ Exception -> 0x0013 }
        r1.setReadTimeout(r4);	 Catch:{ Exception -> 0x0013 }
        return r1;
    L_0x0012:
        r1 = 0;
    L_0x0013:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getHttpConnection(android.content.Context, java.lang.String, int, int):java.net.HttpURLConnection");
    }

    public boolean isCurrentNetworkAvailable(Context context) {
        try {
            context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context == null || context.isAvailable() == null) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("isCurrentNetworkAvailable", e);
            return false;
        }
    }

    public java.lang.String getCurrentProcessName(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r3.n;	 Catch:{ Exception -> 0x0034 }
        if (r0 != 0) goto L_0x0031;	 Catch:{ Exception -> 0x0034 }
    L_0x0004:
        r0 = android.os.Process.myPid();	 Catch:{ Exception -> 0x0034 }
        r1 = "activity";	 Catch:{ Exception -> 0x0034 }
        r4 = r4.getSystemService(r1);	 Catch:{ Exception -> 0x0034 }
        r4 = (android.app.ActivityManager) r4;	 Catch:{ Exception -> 0x0034 }
        if (r4 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0034 }
    L_0x0012:
        r4 = r4.getRunningAppProcesses();	 Catch:{ Exception -> 0x0034 }
        if (r4 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0034 }
    L_0x0018:
        r4 = r4.iterator();	 Catch:{ Exception -> 0x0034 }
    L_0x001c:
        r1 = r4.hasNext();	 Catch:{ Exception -> 0x0034 }
        if (r1 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0034 }
    L_0x0022:
        r1 = r4.next();	 Catch:{ Exception -> 0x0034 }
        r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1;	 Catch:{ Exception -> 0x0034 }
        r2 = r1.pid;	 Catch:{ Exception -> 0x0034 }
        if (r2 != r0) goto L_0x001c;	 Catch:{ Exception -> 0x0034 }
    L_0x002c:
        r1 = r1.processName;	 Catch:{ Exception -> 0x0034 }
        r3.n = r1;	 Catch:{ Exception -> 0x0034 }
        goto L_0x001c;	 Catch:{ Exception -> 0x0034 }
    L_0x0031:
        r4 = r3.n;	 Catch:{ Exception -> 0x0034 }
        return r4;
    L_0x0034:
        r4 = r3.n;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getCurrentProcessName(android.content.Context):java.lang.String");
    }

    public int getCurrentProcessId(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = this;
        r1 = android.os.Process.myPid();	 Catch:{ Exception -> 0x0005 }
        return r1;
    L_0x0005:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.o.getCurrentProcessId(android.content.Context):int");
    }
}
