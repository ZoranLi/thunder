package com.baidu.mobads.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alipay.sdk.cons.c;
import com.baidu.mobads.command.a;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.tencent.smtt.sdk.WebView;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class d implements IXAdCommonUtils {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private final String e = "_cpr";
    private final AtomicLong f = new AtomicLong(1);
    private Method g = null;
    private String h = null;
    private HashMap<String, Object> i = new HashMap();

    public String b() {
        return "android_8.7036_4.0.0";
    }

    public String b(String str) {
        return str == null ? "" : str;
    }

    public boolean bitMaskContainsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public void sendDownloadAdLog(Context context, String str, int i, String str2) {
    }

    public int getApkDownloadStatus(Context context, String str, String str2) {
        XAdSDKFoundationFacade.getInstance().getIoUtils();
        str2 = -1;
        if (!(str == null || "".equals(str))) {
            SharedPreferences sharedPreferences;
            JSONObject jSONObject;
            int optInt;
            try {
                JSONObject optJSONObject = new JSONObject(context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_ACTIVATION, 0).getString(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY, "{}")).optJSONObject(str);
                if (optJSONObject != null && optJSONObject.optBoolean("a", false)) {
                    return 100;
                }
            } catch (Exception e) {
                e.getMessage();
            }
            int i = 5;
            try {
                sharedPreferences = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("#$#");
                stringBuilder.append(a.b());
                jSONObject = new JSONObject(sharedPreferences.getString(stringBuilder.toString(), "{}"));
                optInt = jSONObject.optInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, -1);
            } catch (Exception e2) {
                context = e2;
                context.getMessage();
                return str2;
            }
            try {
                str2 = jSONObject.optString(c.e, null);
                if (str2 != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(k.a(context));
                    stringBuilder2.append(str2);
                    str2 = new File(stringBuilder2.toString());
                    if (optInt == 3) {
                        boolean z = true;
                        if (str2.exists() != null) {
                            if (str2.length() != 0) {
                                long optLong = jSONObject.optLong("contentLength", -1);
                                if (optLong == -1 || Math.abs(optLong - str2.length()) < 2) {
                                    z = false;
                                }
                            }
                        }
                        if (z) {
                            try {
                                jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, 5);
                                context = sharedPreferences.edit();
                                context.putString(str, jSONObject.toString());
                                if (VERSION.SDK_INT >= 9) {
                                    context.apply();
                                } else {
                                    context.commit();
                                }
                                return i;
                            } catch (Exception e3) {
                                context = e3;
                                str2 = 5;
                                context.getMessage();
                                return str2;
                            }
                        }
                    }
                }
                i = optInt;
                return i;
            } catch (Exception e4) {
                context = e4;
                str2 = optInt;
                context.getMessage();
                return str2;
            }
        }
        return str2;
    }

    public java.lang.String getStatusStr(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
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
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0 = r0.getPackageUtils();
        r1 = "NONE";
        r5 = r2.getApkDownloadStatus(r3, r4, r5);	 Catch:{ Exception -> 0x0044 }
        r3 = r0.isInstalled(r3, r4);	 Catch:{ Exception -> 0x0044 }
        r4 = 100;	 Catch:{ Exception -> 0x0044 }
        if (r5 == r4) goto L_0x0041;	 Catch:{ Exception -> 0x0044 }
    L_0x0016:
        switch(r5) {
            case 0: goto L_0x0039;
            case 1: goto L_0x0039;
            case 2: goto L_0x0031;
            case 3: goto L_0x0029;
            case 4: goto L_0x0031;
            case 5: goto L_0x0021;
            default: goto L_0x0019;
        };	 Catch:{ Exception -> 0x0044 }
    L_0x0019:
        if (r3 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x0044 }
    L_0x001b:
        r3 = "INSTALLED_BY_OTHER";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x001e:
        r3 = "NONE";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x0021:
        if (r3 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x0044 }
    L_0x0023:
        r3 = "DONE";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x0026:
        r3 = "NONE";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x0029:
        if (r3 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x0044 }
    L_0x002b:
        r3 = "INSTALLED";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x002e:
        r3 = "DOWNLOADED";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x0031:
        if (r3 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x0044 }
    L_0x0033:
        r3 = "INSTALLED_BY_OTHER";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x0036:
        r3 = "DOWNLOAD_FAILED";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x0039:
        if (r3 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0044 }
    L_0x003b:
        r3 = "INSTALLED_BY_OTHER";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x003e:
        r3 = "DOWNLOADING";	 Catch:{ Exception -> 0x0044 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0044 }
    L_0x0041:
        r3 = "DONE";	 Catch:{ Exception -> 0x0044 }
    L_0x0043:
        return r3;
    L_0x0044:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getStatusStr(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getMD5(String str) {
        str = str.getBytes();
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str);
            str = instance.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            int i2 = i;
            while (i < 16) {
                byte b = str[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (String str2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("AdUtil.getMD5", "", str2);
            return null;
        }
    }

    private String c(String str) {
        return getMD5(str);
    }

    private java.lang.String a(android.content.Context r5) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r5 = r5.getFilesDir();	 Catch:{ Exception -> 0x0023 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0023 }
        r1 = r5.toString();	 Catch:{ Exception -> 0x0023 }
        r2 = 0;	 Catch:{ Exception -> 0x0023 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0023 }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0023 }
        r5 = r5.lastIndexOf(r3);	 Catch:{ Exception -> 0x0023 }
        r5 = r1.substring(r2, r5);	 Catch:{ Exception -> 0x0023 }
        r0.append(r5);	 Catch:{ Exception -> 0x0023 }
    L_0x0023:
        r5 = java.io.File.separator;
        r0.append(r5);
        r5 = "bddownload";
        r0.append(r5);
        r5 = r0.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.a(android.content.Context):java.lang.String");
    }

    public java.lang.String getFileLocalFullPath(android.content.Context r2, java.lang.String r3) {
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
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x001d }
        r0.<init>();	 Catch:{ Exception -> 0x001d }
        r2 = r1.a(r2);	 Catch:{ Exception -> 0x001d }
        r0.append(r2);	 Catch:{ Exception -> 0x001d }
        r2 = java.io.File.separator;	 Catch:{ Exception -> 0x001d }
        r0.append(r2);	 Catch:{ Exception -> 0x001d }
        r2 = r1.c(r3);	 Catch:{ Exception -> 0x001d }
        r0.append(r2);	 Catch:{ Exception -> 0x001d }
        r2 = r0.toString();	 Catch:{ Exception -> 0x001d }
        return r2;
    L_0x001d:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getFileLocalFullPath(android.content.Context, java.lang.String):java.lang.String");
    }

    public boolean isStringAvailable(String str) {
        return (str == null || str.length() <= null) ? null : true;
    }

    public void makeCall(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                StringBuilder stringBuilder = new StringBuilder(WebView.SCHEME_TEL);
                stringBuilder.append(str);
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse(stringBuilder.toString().toString()));
                intent.addFlags(268435456);
                a(context, intent);
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void sendSMS(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str);
            intent.putExtra("sms_body", str2);
            intent.setType("vnd.android-dir/mms-sms");
            intent.addFlags(268435456);
            a(context, intent);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    @TargetApi(4)
    private void a(Context context, Intent intent) {
        try {
            if (VERSION.SDK_INT < 19) {
                context.startActivity(intent);
            } else {
                new Handler(context.getMainLooper()).post(new e(this, context, intent));
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public java.lang.String getDebugToken(android.content.Context r2) {
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
        r0 = b;	 Catch:{ Exception -> 0x000f }
        if (r0 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x000f }
    L_0x0004:
        r0 = "BaiduMobAd_DEBUG_TOKEN";	 Catch:{ Exception -> 0x000f }
        r2 = r1.d(r2, r0);	 Catch:{ Exception -> 0x000f }
        b = r2;	 Catch:{ Exception -> 0x000f }
    L_0x000c:
        r2 = b;	 Catch:{ Exception -> 0x000f }
        return r2;
    L_0x000f:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getDebugToken(android.content.Context):java.lang.String");
    }

    public java.lang.String getAppId(android.content.Context r2) {
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
        r0 = a;	 Catch:{ Exception -> 0x000f }
        if (r0 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x000f }
    L_0x0004:
        r0 = "BaiduMobAd_APP_ID";	 Catch:{ Exception -> 0x000f }
        r2 = r1.d(r2, r0);	 Catch:{ Exception -> 0x000f }
        a = r2;	 Catch:{ Exception -> 0x000f }
    L_0x000c:
        r2 = a;	 Catch:{ Exception -> 0x000f }
        return r2;
    L_0x000f:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getAppId(android.content.Context):java.lang.String");
    }

    public String getAppSec(Context context) {
        if (c == null || c.length() == 0 || c.startsWith("null")) {
            setAppSec(getAppId(context));
        }
        return c;
    }

    public void setAppSec(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_cpr");
        c = stringBuilder.toString();
    }

    private java.lang.String d(android.content.Context r4, java.lang.String r5) {
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
        r0 = "error";
        r1 = r4.getPackageManager();	 Catch:{ Exception -> 0x002c }
        r4 = r4.getPackageName();	 Catch:{ Exception -> 0x002c }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x002c }
        r4 = r1.getApplicationInfo(r4, r2);	 Catch:{ Exception -> 0x002c }
        r4 = r4.metaData;	 Catch:{ Exception -> 0x002c }
        r4 = r4.get(r5);	 Catch:{ Exception -> 0x002c }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x002c }
        r0 = r4.trim();	 Catch:{ Exception -> 0x002d }
        r1 = "";	 Catch:{ Exception -> 0x002d }
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x002d }
        if (r0 == 0) goto L_0x0038;	 Catch:{ Exception -> 0x002d }
    L_0x0026:
        r0 = new java.lang.Exception;	 Catch:{ Exception -> 0x002d }
        r0.<init>();	 Catch:{ Exception -> 0x002d }
        throw r0;	 Catch:{ Exception -> 0x002d }
    L_0x002c:
        r4 = r0;
    L_0x002d:
        r0 = "Could not read %s meta-data from AndroidManifest.xml";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r5;
        java.lang.String.format(r0, r1);
    L_0x0038:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.d(android.content.Context, java.lang.String):java.lang.String");
    }

    public java.lang.String md5(java.lang.String r6) {
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
        r0 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r6 = r6.getBytes();	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r0.update(r6);	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r6 = r0.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r0 = new java.lang.StringBuffer;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r0.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r1 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
    L_0x0017:
        r2 = r6.length;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        if (r1 >= r2) goto L_0x003f;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
    L_0x001a:
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r3 = r6[r1];	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r2 = r2 & r3;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r2 = java.lang.Integer.toHexString(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
    L_0x0023:
        r3 = r2.length();	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r4 = 2;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        if (r3 >= r4) goto L_0x0039;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
    L_0x002a:
        r3 = new java.lang.StringBuilder;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r4 = "0";	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r3.<init>(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r3.append(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r2 = r3.toString();	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        goto L_0x0023;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
    L_0x0039:
        r0.append(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        r1 = r1 + 1;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        goto L_0x0017;	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
    L_0x003f:
        r6 = r0.toString();	 Catch:{ NoSuchAlgorithmException -> 0x0044 }
        return r6;
    L_0x0044:
        r6 = "";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.md5(java.lang.String):java.lang.String");
    }

    public long generateUniqueId() {
        long j;
        long j2;
        do {
            j = this.f.get();
            j2 = 1;
            long j3 = j + 1;
            if (j3 <= 9223372036854775806L) {
                j2 = j3;
            }
        } while (!this.f.compareAndSet(j, j2));
        return j;
    }

    @android.annotation.TargetApi(17)
    public android.graphics.Rect getScreenRect(android.content.Context r4) {
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
        r4 = r3.getDisplayMetrics(r4);
        r0 = r4.widthPixels;	 Catch:{ Exception -> 0x001f }
        r1 = r4.heightPixels;	 Catch:{ Exception -> 0x001f }
        r2 = 0;	 Catch:{ Exception -> 0x001f }
        if (r0 <= r1) goto L_0x0015;	 Catch:{ Exception -> 0x001f }
    L_0x000b:
        r0 = new android.graphics.Rect;	 Catch:{ Exception -> 0x001f }
        r1 = r4.heightPixels;	 Catch:{ Exception -> 0x001f }
        r4 = r4.widthPixels;	 Catch:{ Exception -> 0x001f }
        r0.<init>(r2, r2, r1, r4);	 Catch:{ Exception -> 0x001f }
        goto L_0x001e;	 Catch:{ Exception -> 0x001f }
    L_0x0015:
        r0 = new android.graphics.Rect;	 Catch:{ Exception -> 0x001f }
        r1 = r4.widthPixels;	 Catch:{ Exception -> 0x001f }
        r4 = r4.heightPixels;	 Catch:{ Exception -> 0x001f }
        r0.<init>(r2, r2, r1, r4);	 Catch:{ Exception -> 0x001f }
    L_0x001e:
        return r0;
    L_0x001f:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getScreenRect(android.content.Context):android.graphics.Rect");
    }

    public Rect getWindowRect(Context context) {
        context = getDisplayMetrics(context);
        return new Rect(0, 0, context.widthPixels, context.heightPixels);
    }

    @TargetApi(4)
    public float getScreenDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    @TargetApi(17)
    public DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public int getLogicalPixel(android.content.Context r2, int r3) {
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
        r0 = (float) r3;
        r2 = r1.getScreenDensity(r2);	 Catch:{ Exception -> 0x0008 }
        r0 = r0 / r2;
        r2 = (int) r0;
        return r2;
    L_0x0008:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getLogicalPixel(android.content.Context, int):int");
    }

    public int getPixel(android.content.Context r2, int r3) {
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
        r0 = (float) r3;
        r2 = r1.getScreenDensity(r2);	 Catch:{ Exception -> 0x0008 }
        r0 = r0 * r2;
        r2 = (int) r0;
        return r2;
    L_0x0008:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getPixel(android.content.Context, int):int");
    }

    public java.lang.String getTextEncoder(java.lang.String r2) {
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
        if (r2 == 0) goto L_0x0013;
    L_0x0002:
        r0 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        goto L_0x0013;
    L_0x000b:
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0012, UnsupportedEncodingException -> 0x0012 }
        r0 = java.net.URLEncoder.encode(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x0012, UnsupportedEncodingException -> 0x0012 }
        r2 = r0;
    L_0x0012:
        return r2;
    L_0x0013:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getTextEncoder(java.lang.String):java.lang.String");
    }

    public java.lang.String getSubscriberId(android.content.Context r2) {
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
        r0 = r1.h;
        if (r0 != 0) goto L_0x001a;
    L_0x0004:
        r0 = "android.permission.READ_PHONE_STATE";	 Catch:{ Exception -> 0x001a }
        r0 = r1.hasPermission(r2, r0);	 Catch:{ Exception -> 0x001a }
        if (r0 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x001a }
    L_0x000c:
        r0 = "phone";	 Catch:{ Exception -> 0x001a }
        r2 = r2.getSystemService(r0);	 Catch:{ Exception -> 0x001a }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x001a }
        r2 = r2.getSubscriberId();	 Catch:{ Exception -> 0x001a }
        r1.h = r2;	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        r2 = r1.h;
        r2 = r1.b(r2);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.getSubscriberId(android.content.Context):java.lang.String");
    }

    public String getAppPackage(Context context) {
        return context.getPackageName();
    }

    public static boolean a(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == null;
        } catch (Throwable e) {
            l.a().e(e);
            return false;
        }
    }

    public boolean hasPermission(Context context, String str) {
        return a(context, str);
    }

    public java.lang.String encodeURIComponent(java.lang.String r4) {
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
        r0 = "UTF-8";	 Catch:{ Exception -> 0x0037 }
        r0 = java.net.URLEncoder.encode(r4, r0);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\+";	 Catch:{ Exception -> 0x0037 }
        r2 = "%20";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%21";	 Catch:{ Exception -> 0x0037 }
        r2 = "!";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%27";	 Catch:{ Exception -> 0x0037 }
        r2 = "'";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%28";	 Catch:{ Exception -> 0x0037 }
        r2 = "(";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%29";	 Catch:{ Exception -> 0x0037 }
        r2 = ")";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%7E";	 Catch:{ Exception -> 0x0037 }
        r2 = "~";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r4 = r0;
    L_0x0037:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.encodeURIComponent(java.lang.String):java.lang.String");
    }

    public java.lang.String decodeURIComponent(java.lang.String r2) {
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
        if (r2 != 0) goto L_0x0004;
    L_0x0002:
        r2 = 0;
        return r2;
    L_0x0004:
        r0 = "UTF-8";	 Catch:{ Exception -> 0x000b }
        r0 = java.net.URLDecoder.decode(r2, r0);	 Catch:{ Exception -> 0x000b }
        r2 = r0;
    L_0x000b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.decodeURIComponent(java.lang.String):java.lang.String");
    }

    public java.lang.String vdUrl(java.lang.String r8, int r9) {
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
        r7 = this;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0.getURIUitls();
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "?";
        r1 = r8.indexOf(r1);
        r2 = 1;
        r1 = r1 + r2;
        r8 = r8.substring(r1);
        r1 = "&";
        r8 = r8.split(r1);
        r1 = 0;
        r3 = r1;
    L_0x0020:
        r4 = r8.length;
        if (r3 >= r4) goto L_0x0042;
    L_0x0023:
        r4 = r8[r3];	 Catch:{ Exception -> 0x003f }
        r5 = "=";	 Catch:{ Exception -> 0x003f }
        r4 = r4.split(r5);	 Catch:{ Exception -> 0x003f }
        r5 = r4.length;	 Catch:{ Exception -> 0x003f }
        if (r5 <= r2) goto L_0x003f;	 Catch:{ Exception -> 0x003f }
    L_0x002e:
        r5 = r4[r1];	 Catch:{ Exception -> 0x003f }
        r6 = "type";	 Catch:{ Exception -> 0x003f }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x003f }
        if (r5 != 0) goto L_0x003f;	 Catch:{ Exception -> 0x003f }
    L_0x0038:
        r5 = r4[r1];	 Catch:{ Exception -> 0x003f }
        r4 = r4[r2];	 Catch:{ Exception -> 0x003f }
        r0.putOpt(r5, r4);	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        r3 = r3 + 1;
        goto L_0x0020;
    L_0x0042:
        r8 = new java.lang.StringBuilder;
        r1 = new java.lang.StringBuilder;
        r2 = "type=";
        r1.<init>(r2);
        r1.append(r9);
        r9 = "&";
        r1.append(r9);
        r9 = r1.toString();
        r8.<init>(r9);
        r9 = new java.util.TreeMap;
        r9.<init>();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r0.keys();	 Catch:{ Exception -> 0x0087 }
    L_0x0068:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x0087 }
        if (r3 == 0) goto L_0x0087;
    L_0x006e:
        r3 = r2.next();	 Catch:{ Exception -> 0x0068 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0068 }
        if (r3 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x0068 }
    L_0x0076:
        r4 = "";	 Catch:{ Exception -> 0x0068 }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x0068 }
        if (r4 == 0) goto L_0x007f;	 Catch:{ Exception -> 0x0068 }
    L_0x007e:
        goto L_0x0068;	 Catch:{ Exception -> 0x0068 }
    L_0x007f:
        r4 = r0.optString(r3);	 Catch:{ Exception -> 0x0068 }
        r9.put(r3, r4);	 Catch:{ Exception -> 0x0068 }
        goto L_0x0068;
    L_0x0087:
        r0 = "ts";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = java.lang.System.currentTimeMillis();
        r2.append(r3);
        r2 = r2.toString();
        r9.put(r0, r2);
        r0 = r9.keySet();
        r0 = r0.iterator();
    L_0x00a4:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x00fb;
    L_0x00aa:
        r2 = r0.next();
        r2 = (java.lang.String) r2;
        r3 = r9.get(r2);
        r3 = (java.lang.String) r3;
        if (r2 == 0) goto L_0x00a4;
    L_0x00b8:
        if (r3 == 0) goto L_0x00a4;
    L_0x00ba:
        r4 = "targetscheme";
        r4 = r2.equals(r4);
        if (r4 != 0) goto L_0x00ca;
    L_0x00c2:
        r2 = r7.encodeURIComponent(r2);
        r3 = r7.encodeURIComponent(r3);
    L_0x00ca:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r2);
        r2 = "=";
        r4.append(r2);
        r4.append(r3);
        r2 = "&";
        r4.append(r2);
        r2 = r4.toString();
        r8.append(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r3);
        r3 = ",";
        r2.append(r3);
        r2 = r2.toString();
        r1.append(r2);
        goto L_0x00a4;
    L_0x00fb:
        r9 = "mobads,";
        r1.append(r9);
        r9 = r1.toString();
        r9 = r7.getMD5(r9);
        r0 = new java.lang.StringBuilder;
        r1 = "vd=";
        r0.<init>(r1);
        r0.append(r9);
        r9 = "&";
        r0.append(r9);
        r9 = r0.toString();
        r8.append(r9);
        r9 = new java.lang.StringBuilder;
        r0 = "https://mobads-logs.baidu.com/dz.zb?";
        r9.<init>(r0);
        r8 = r8.toString();
        r9.append(r8);
        r8 = r9.toString();
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.vdUrl(java.lang.String, int):java.lang.String");
    }

    public String getChannelId() {
        return d;
    }

    public void setChannelId(String str) {
        d = str;
    }

    public String getBaiduMapsInfo(Context context) {
        Object a = a("mapinfo");
        if (a != null) {
            return String.valueOf(a);
        }
        Object a2;
        String str = "";
        try {
            a2 = new com.baidu.mobads.h.a(context).a();
        } catch (Throwable e) {
            l.a().e(e);
            a2 = str;
        }
        a("mapinfo", a2);
        return a2;
    }

    public void a(String str, Object obj) {
        if (!a()) {
            HashMap hashMap = this.i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_E");
            hashMap.put(stringBuilder.toString(), Long.valueOf(System.currentTimeMillis() + 5000));
            hashMap = this.i;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_V");
            hashMap.put(stringBuilder.toString(), obj);
        }
    }

    public Object a(String str) {
        if (a()) {
            return null;
        }
        try {
            HashMap hashMap = this.i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_E");
            Object obj = hashMap.get(stringBuilder.toString());
            if (obj != null) {
                if (System.currentTimeMillis() < ((Long) obj).longValue()) {
                    hashMap = this.i;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("_V");
                    return hashMap.get(stringBuilder.toString());
                }
            }
        } catch (Throwable e) {
            l.a().e(e);
        }
        return null;
    }

    public boolean a() {
        return VERSION.SDK_INT >= 24;
    }

    public void setAppId(String str) {
        a = str;
    }

    @android.annotation.TargetApi(3)
    private static java.lang.String b(android.content.Context r9) {
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
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0 = r0.getAdConstants();
        r0 = r0.getSupportedBrowsers();
        r1 = r9.getPackageManager();	 Catch:{ Exception -> 0x00fd }
        r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00fd }
        r2.<init>();	 Catch:{ Exception -> 0x00fd }
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00fd }
        r3.<init>();	 Catch:{ Exception -> 0x00fd }
        r4 = 0;	 Catch:{ Exception -> 0x00fd }
        r1.getPreferredActivities(r2, r3, r4);	 Catch:{ Exception -> 0x00fd }
        r2 = r3.iterator();	 Catch:{ Exception -> 0x00fd }
    L_0x0022:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x00fd }
        r4 = 0;	 Catch:{ Exception -> 0x00fd }
        if (r3 == 0) goto L_0x004f;	 Catch:{ Exception -> 0x00fd }
    L_0x0029:
        r3 = r2.next();	 Catch:{ Exception -> 0x00fd }
        r3 = (android.content.ComponentName) r3;	 Catch:{ Exception -> 0x00fd }
    L_0x002f:
        r5 = r0.length;	 Catch:{ Exception -> 0x00fd }
        if (r4 >= r5) goto L_0x0022;	 Catch:{ Exception -> 0x00fd }
    L_0x0032:
        r5 = r0[r4];	 Catch:{ Exception -> 0x00fd }
        r6 = r3.getPackageName();	 Catch:{ Exception -> 0x00fd }
        r6 = r5.equals(r6);	 Catch:{ Exception -> 0x00fd }
        if (r6 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x00fd }
    L_0x003e:
        r9 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x00fd }
        r9 = r9.getAdLogger();	 Catch:{ Exception -> 0x00fd }
        r0 = "规则1 hit!";	 Catch:{ Exception -> 0x00fd }
        r9.d(r5, r0);	 Catch:{ Exception -> 0x00fd }
        return r5;
    L_0x004c:
        r4 = r4 + 1;
        goto L_0x002f;
    L_0x004f:
        r2 = -1;
        r3 = "activity";	 Catch:{ Exception -> 0x009b }
        r9 = r9.getSystemService(r3);	 Catch:{ Exception -> 0x009b }
        r9 = (android.app.ActivityManager) r9;	 Catch:{ Exception -> 0x009b }
        r9 = r9.getRunningAppProcesses();	 Catch:{ Exception -> 0x009b }
        r9 = r9.iterator();	 Catch:{ Exception -> 0x009b }
        r3 = r2;
    L_0x0061:
        r5 = r9.hasNext();	 Catch:{ Exception -> 0x009c }
        if (r5 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x009c }
    L_0x0067:
        r5 = r9.next();	 Catch:{ Exception -> 0x009c }
        r5 = (android.app.ActivityManager.RunningAppProcessInfo) r5;	 Catch:{ Exception -> 0x009c }
        r6 = r5.processName;	 Catch:{ Exception -> 0x009c }
        r6 = r1.getLaunchIntentForPackage(r6);	 Catch:{ Exception -> 0x009c }
        if (r6 == 0) goto L_0x0061;	 Catch:{ Exception -> 0x009c }
    L_0x0075:
        r6 = r5.processName;	 Catch:{ Exception -> 0x009c }
        r7 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x009c }
        r6 = r1.getApplicationInfo(r6, r7);	 Catch:{ Exception -> 0x009c }
        if (r6 == 0) goto L_0x0061;
    L_0x007f:
        r6 = r3;
        r3 = r4;
    L_0x0081:
        r7 = r0.length;	 Catch:{ Exception -> 0x0099 }
        if (r3 >= r7) goto L_0x0097;	 Catch:{ Exception -> 0x0099 }
    L_0x0084:
        r7 = r5.processName;	 Catch:{ Exception -> 0x0099 }
        r8 = r0[r3];	 Catch:{ Exception -> 0x0099 }
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0099 }
        if (r7 == 0) goto L_0x0094;
    L_0x008e:
        if (r6 != r2) goto L_0x0091;
    L_0x0090:
        goto L_0x0093;
    L_0x0091:
        if (r3 >= r6) goto L_0x0094;
    L_0x0093:
        r6 = r3;
    L_0x0094:
        r3 = r3 + 1;
        goto L_0x0081;
    L_0x0097:
        r3 = r6;
        goto L_0x0061;
    L_0x0099:
        r3 = r6;
        goto L_0x009c;
    L_0x009b:
        r3 = r2;
    L_0x009c:
        if (r3 == r2) goto L_0x00a1;
    L_0x009e:
        r9 = r0[r3];	 Catch:{ Exception -> 0x00fd }
        return r9;	 Catch:{ Exception -> 0x00fd }
    L_0x00a1:
        r9 = new android.content.Intent;	 Catch:{ Exception -> 0x00fd }
        r2 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x00fd }
        r9.<init>(r2);	 Catch:{ Exception -> 0x00fd }
        r2 = "http://m.baidu.com";	 Catch:{ Exception -> 0x00fd }
        r2 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x00fd }
        r9.setData(r2);	 Catch:{ Exception -> 0x00fd }
        r2 = 64;	 Catch:{ Exception -> 0x00fd }
        r9 = r1.queryIntentActivities(r9, r2);	 Catch:{ Exception -> 0x00fd }
        if (r9 == 0) goto L_0x00ea;	 Catch:{ Exception -> 0x00fd }
    L_0x00b9:
        r1 = r4;	 Catch:{ Exception -> 0x00fd }
    L_0x00ba:
        r2 = r0.length;	 Catch:{ Exception -> 0x00fd }
        if (r1 >= r2) goto L_0x00ea;	 Catch:{ Exception -> 0x00fd }
    L_0x00bd:
        r2 = r4;	 Catch:{ Exception -> 0x00fd }
    L_0x00be:
        r3 = r9.size();	 Catch:{ Exception -> 0x00fd }
        if (r2 >= r3) goto L_0x00e7;	 Catch:{ Exception -> 0x00fd }
    L_0x00c4:
        r3 = r9.get(r2);	 Catch:{ Exception -> 0x00fd }
        r3 = (android.content.pm.ResolveInfo) r3;	 Catch:{ Exception -> 0x00fd }
        r3 = r3.activityInfo;	 Catch:{ Exception -> 0x00fd }
        r3 = r3.packageName;	 Catch:{ Exception -> 0x00fd }
        r5 = r0[r1];	 Catch:{ Exception -> 0x00fd }
        r3 = r5.equals(r3);	 Catch:{ Exception -> 0x00fd }
        if (r3 == 0) goto L_0x00e4;	 Catch:{ Exception -> 0x00fd }
    L_0x00d6:
        r9 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x00fd }
        r9 = r9.getAdLogger();	 Catch:{ Exception -> 0x00fd }
        r0 = "规则2 hit!";	 Catch:{ Exception -> 0x00fd }
        r9.d(r5, r0);	 Catch:{ Exception -> 0x00fd }
        return r5;	 Catch:{ Exception -> 0x00fd }
    L_0x00e4:
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00fd }
        goto L_0x00be;	 Catch:{ Exception -> 0x00fd }
    L_0x00e7:
        r1 = r1 + 1;	 Catch:{ Exception -> 0x00fd }
        goto L_0x00ba;	 Catch:{ Exception -> 0x00fd }
    L_0x00ea:
        if (r9 == 0) goto L_0x0117;	 Catch:{ Exception -> 0x00fd }
    L_0x00ec:
        r0 = r9.size();	 Catch:{ Exception -> 0x00fd }
        if (r0 <= 0) goto L_0x0117;	 Catch:{ Exception -> 0x00fd }
    L_0x00f2:
        r9 = r9.get(r4);	 Catch:{ Exception -> 0x00fd }
        r9 = (android.content.pm.ResolveInfo) r9;	 Catch:{ Exception -> 0x00fd }
        r9 = r9.activityInfo;	 Catch:{ Exception -> 0x00fd }
        r9 = r9.packageName;	 Catch:{ Exception -> 0x00fd }
        return r9;
    L_0x00fd:
        r9 = move-exception;
        r0 = com.baidu.mobads.c.a.a();
        r1 = new java.lang.StringBuilder;
        r2 = "open browser outside failed: ";
        r1.<init>(r2);
        r9 = r9.toString();
        r1.append(r9);
        r9 = r1.toString();
        r0.a(r9);
    L_0x0117:
        r9 = "";
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.b(android.content.Context):java.lang.String");
    }

    @TargetApi(3)
    public void browserOutside(Context context, String str) {
        if (str.startsWith("wtai://wp/mc;")) {
            StringBuilder stringBuilder = new StringBuilder(WebView.SCHEME_TEL);
            stringBuilder.append(str.substring(13));
            str = stringBuilder.toString();
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            String b;
            if (XAdSDKFoundationFacade.getInstance().getURIUitls().isHttpProtocol(str).booleanValue()) {
                b = b(context);
                StringBuilder stringBuilder2 = new StringBuilder("AdUtil.browserOutside pkgOfBrowser=");
                stringBuilder2.append(b);
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("Utils", stringBuilder2.toString());
                if (!b.equals("")) {
                    intent = context.getPackageManager().getLaunchIntentForPackage(b);
                    intent.setData(Uri.parse(str));
                    intent.setAction("android.intent.action.VIEW");
                }
            } else if (((s) XAdSDKFoundationFacade.getInstance().getURIUitls()).a(str).booleanValue()) {
                intent.setType("vnd.android-dir/mms-sms");
                b = str.substring(4, str.indexOf(63) > 0 ? str.indexOf(63) : str.length());
                intent.putExtra("address", b);
                int indexOf = str.indexOf("body=") + 5;
                String str2 = "";
                if (indexOf > 5) {
                    int indexOf2 = str.indexOf(38, indexOf);
                    if (indexOf2 <= 0) {
                        indexOf2 = str.length();
                    }
                    str2 = str.substring(indexOf, indexOf2);
                    intent.putExtra("sms_body", Uri.decode(str2));
                }
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(b, str2);
            }
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                context.startActivity(intent);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdCommonUtils.browserOutside 1", str, e);
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            } catch (Context context2) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdCommonUtils.browserOutside 2", str, context2);
            }
        }
    }

    public boolean hasSupportedApps(android.content.Context r4, int r5) {
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
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x009e }
        r1 = r1.getSystemUtils();	 Catch:{ Exception -> 0x009e }
        r2 = 1;	 Catch:{ Exception -> 0x009e }
        switch(r5) {
            case 0: goto L_0x0063;
            case 1: goto L_0x0052;
            case 2: goto L_0x0030;
            case 3: goto L_0x001b;
            case 4: goto L_0x000e;
            default: goto L_0x000d;
        };	 Catch:{ Exception -> 0x009e }
    L_0x000d:
        return r0;	 Catch:{ Exception -> 0x009e }
    L_0x000e:
        r5 = new android.content.Intent;	 Catch:{ Exception -> 0x009e }
        r1 = "android.intent.action.EDIT";	 Catch:{ Exception -> 0x009e }
        r5.<init>(r1);	 Catch:{ Exception -> 0x009e }
        r1 = "vnd.android.cursor.item/event";	 Catch:{ Exception -> 0x009e }
        r5.setType(r1);	 Catch:{ Exception -> 0x009e }
        goto L_0x0073;	 Catch:{ Exception -> 0x009e }
    L_0x001b:
        r5 = r1.canSupportSdcardStroage(r4);	 Catch:{ Exception -> 0x009e }
        if (r5 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x009e }
    L_0x0021:
        r5 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x009e }
        r5.getPackageUtils();	 Catch:{ Exception -> 0x009e }
        r4 = com.baidu.mobads.utils.m.b(r4);	 Catch:{ Exception -> 0x009e }
        if (r4 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x009e }
    L_0x002e:
        return r2;	 Catch:{ Exception -> 0x009e }
    L_0x002f:
        return r0;	 Catch:{ Exception -> 0x009e }
    L_0x0030:
        r5 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x009e }
        r5 = r5.getCommonUtils();	 Catch:{ Exception -> 0x009e }
        r1 = "android.permission.ACCESS_WIFI_STATE";	 Catch:{ Exception -> 0x009e }
        r5 = r5.hasPermission(r4, r1);	 Catch:{ Exception -> 0x009e }
        if (r5 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x009e }
    L_0x0040:
        r5 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x009e }
        r5 = r5.getCommonUtils();	 Catch:{ Exception -> 0x009e }
        r1 = "android.permission.CHANGE_WIFI_STATE";	 Catch:{ Exception -> 0x009e }
        r4 = r5.hasPermission(r4, r1);	 Catch:{ Exception -> 0x009e }
        if (r4 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x009e }
    L_0x0050:
        return r2;	 Catch:{ Exception -> 0x009e }
    L_0x0051:
        return r0;	 Catch:{ Exception -> 0x009e }
    L_0x0052:
        r5 = new android.content.Intent;	 Catch:{ Exception -> 0x009e }
        r1 = "android.intent.action.SENDTO";	 Catch:{ Exception -> 0x009e }
        r5.<init>(r1);	 Catch:{ Exception -> 0x009e }
        r1 = "sms:12345678";	 Catch:{ Exception -> 0x009e }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x009e }
        r5.setData(r1);	 Catch:{ Exception -> 0x009e }
        goto L_0x0073;	 Catch:{ Exception -> 0x009e }
    L_0x0063:
        r5 = new android.content.Intent;	 Catch:{ Exception -> 0x009e }
        r1 = "android.intent.action.SENDTO";	 Catch:{ Exception -> 0x009e }
        r5.<init>(r1);	 Catch:{ Exception -> 0x009e }
        r1 = "mailto:baidumobadstest@baidu.com";	 Catch:{ Exception -> 0x009e }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x009e }
        r5.setData(r1);	 Catch:{ Exception -> 0x009e }
    L_0x0073:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x009e }
        r1.<init>();	 Catch:{ Exception -> 0x009e }
        r4 = r4.getPackageManager();	 Catch:{ Exception -> 0x009e }
        r1 = 64;	 Catch:{ Exception -> 0x009e }
        r4 = r4.queryIntentActivities(r5, r1);	 Catch:{ Exception -> 0x009e }
        if (r4 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x009e }
    L_0x0084:
        r5 = r4.size();	 Catch:{ Exception -> 0x009e }
        if (r5 <= 0) goto L_0x009d;	 Catch:{ Exception -> 0x009e }
    L_0x008a:
        r4 = r4.get(r0);	 Catch:{ Exception -> 0x009e }
        r4 = (android.content.pm.ResolveInfo) r4;	 Catch:{ Exception -> 0x009e }
        r4 = r4.activityInfo;	 Catch:{ Exception -> 0x009e }
        r4 = r4.packageName;	 Catch:{ Exception -> 0x009e }
        r5 = "com.android.fallback";	 Catch:{ Exception -> 0x009e }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x009e }
        if (r4 != 0) goto L_0x009d;
    L_0x009c:
        return r2;
    L_0x009d:
        return r0;
    L_0x009e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.d.hasSupportedApps(android.content.Context, int):boolean");
    }

    public JSONArray list2Json(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < list.size()) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (Object put : (String[]) list.get(i)) {
                    jSONArray2.put(put);
                }
                jSONArray.put(jSONArray2);
                i++;
            } catch (Throwable e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
        return jSONArray;
    }

    public String base64Encode(String str) {
        return XAdSDKFoundationFacade.getInstance().getBase64().encode(str);
    }

    public JSONArray array2Json(double[] dArr) {
        JSONArray jSONArray;
        Throwable e;
        if (dArr == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray();
            int i = 0;
            while (i < dArr.length) {
                try {
                    jSONArray.put(dArr[i]);
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return jSONArray;
        } catch (Exception e3) {
            e = e3;
            jSONArray = null;
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return jSONArray;
        }
    }

    public String getLocationInfo(Context context) {
        return getBaiduMapsInfo(context);
    }

    public String getApkFileLocalPath(Context context, String str) {
        try {
            context = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("#$#");
            stringBuilder.append(a.b());
            context = context.getString(stringBuilder.toString(), "");
            if (TextUtils.isEmpty(context) == null) {
                str = new JSONObject(context);
                context = str.optString("folder");
                str = str.optString("filename");
                if (!(TextUtils.isEmpty(context) || TextUtils.isEmpty(str))) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(context);
                    stringBuilder.append(str);
                    return stringBuilder.toString();
                }
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
        return "";
    }

    public void sendDownloadAdLog(Context context, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        Throwable e;
        Context context2 = context;
        try {
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
            IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder("msg=");
            stringBuilder2.append(str);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&prod=");
            stringBuilder2.append(str2);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&pk=");
            stringBuilder2.append(str3);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&appid=");
            stringBuilder2.append(str4);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&apid=");
            stringBuilder2.append(str5);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&brand=");
            stringBuilder2.append(str6);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&tp=");
            stringBuilder2.append(str7);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&osv=");
            stringBuilder2.append(str8);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&bdr=");
            stringBuilder2.append(i2);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&sn=");
            stringBuilder2.append(systemUtils.getEncodedSN(context2));
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("&mac=");
            stringBuilder2.append(base64.encode(systemUtils.getMacAddress(context2)));
            stringBuilder.append(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder("&cuid=");
            stringBuilder3.append(systemUtils.getCUID(context2));
            stringBuilder.append(stringBuilder3.toString());
            StringBuilder stringBuilder4 = new StringBuilder("&pack=");
            stringBuilder4.append(context2.getPackageName());
            stringBuilder.append(stringBuilder4.toString());
            StringBuilder stringBuilder5 = new StringBuilder("&v=");
            stringBuilder4 = new StringBuilder("android_");
            stringBuilder4.append(com.baidu.mobads.a.a.c);
            stringBuilder4.append("_4.1.30");
            stringBuilder5.append(stringBuilder4.toString());
            stringBuilder.append(stringBuilder5.toString());
            try {
                com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(uRIUitls.addParameters(vdUrl(stringBuilder.toString(), i), null), "");
                cVar.e = 1;
                new com.baidu.mobads.openad.d.a().a(cVar);
            } catch (Exception e2) {
                e = e2;
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        } catch (Exception e3) {
            e = e3;
            d dVar = this;
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void installApp(Context context, String str, File file, boolean z) {
        try {
            XAdSDKFoundationFacade.getInstance().getPackageUtils().b(context, file);
            if (z && str != null && str != null && str.equals("") == null) {
                file = new a(str, "");
                file.l = true;
                str = new com.baidu.mobads.b.a(file);
                file = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                file.addDataScheme("package");
                context.registerReceiver(str, file);
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public boolean isOldPermissionModel() {
        return VERSION.SDK_INT < 23;
    }

    public static boolean b(Context context, String str) {
        if (VERSION.SDK_INT >= 23) {
            return c(context, str);
        }
        return a(context, str);
    }

    public static boolean c(Context context, String str) {
        try {
            return ((Integer) Context.class.getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() == null;
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return true;
        }
    }

    public boolean checkSelfPermission(Context context, String str) {
        return c(context, str);
    }

    public String createRequestId(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(XAdSDKFoundationFacade.getInstance().getSystemUtils().getIMEI(context));
        stringBuilder.append(getAppId(context));
        stringBuilder.append(str);
        stringBuilder.append(System.currentTimeMillis());
        return getMD5(stringBuilder.toString());
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                } else {
                    new Handler(Looper.getMainLooper()).post(new f(this, runnable));
                }
            } catch (Throwable e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
    }

    public static Class<?> a(Object obj) {
        try {
            return Class.forName(obj.getClass().getName());
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        try {
            obj = a(obj).getDeclaredMethod(str, clsArr);
            obj.setAccessible(true);
            return obj;
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }

    public Object a(Object obj, String str, Object... objArr) {
        try {
            Class[] clsArr = new Class[objArr.length];
            for (int i = 0; i < clsArr.length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return a(obj, str, clsArr).invoke(obj, objArr);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a((Class) cls, str, (Class[]) clsArr)) {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            }
            return null;
        } catch (Class<?> cls2) {
            cls2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr) != null;
        } catch (Class<?> cls2) {
            cls2.printStackTrace();
            return false;
        }
    }

    public void a(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
    }

    public String a(List<String> list) {
        if (list != null) {
            if (list.size() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size() - 1; i++) {
                    stringBuilder.append((String) list.get(i));
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuilder.append((String) list.get(list.size() - 1));
                return stringBuilder.toString();
            }
        }
        return "";
    }
}
