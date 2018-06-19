package com.alibaba.sdk.android.feedback.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.alibaba.sdk.android.feedback.util.ErrorCode;
import com.alibaba.sdk.android.feedback.util.FeedbackErrorCallback;
import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.util.n;
import com.alibaba.sdk.android.feedback.windvane.e;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class FeedbackAPI {
    public static final int APP_MONITOR = 1;
    public static String LOCAL_FEEDBACK_URL = "https://bcfeedback.taobao.com";
    public static String ONLINE_FEEDBACK_URL = "https://bcfeedback.taobao.com";
    private static final String PREFS_KEY_CONF = "device_conf";
    private static final int SUCCESS_REQ_CODE = 0;
    private static final String TAG = "FeedbackAPI";
    public static final int UT_ANALYTICS = 2;
    public static Activity activity = null;
    public static e customWebviewFragment = null;
    private static String deviceID = null;
    public static String feedbackUrl = null;
    private static boolean isUTInit = false;
    public static Callable leaveCallback = null;
    private static Object lock = new Object();
    private static String mAppkey = null;
    public static Context mContext = null;
    public static a mErrorManager = new a();
    public static JSONObject mExtInfo = new JSONObject();
    public static Map mFeedbackCustomInfoMap = new HashMap();
    public static Map mUICustomInfo = new HashMap();
    public static int type = 1;
    public static String webviewUrl;

    public static void addErrorCallback(FeedbackErrorCallback feedbackErrorCallback) {
        mErrorManager.a(feedbackErrorCallback);
    }

    public static void addLeaveCallback(Callable callable) {
        leaveCallback = callable;
    }

    public static void cleanActivity() {
        if (activity != null) {
            activity = null;
        }
    }

    public static void cleanFeedbackFragment() {
        if (customWebviewFragment != null) {
            customWebviewFragment = null;
        }
    }

    private static String getConfFromSharedPreferences() {
        return mContext == null ? "" : mContext.getSharedPreferences("ywPrefsTools", 0).getString(PREFS_KEY_CONF, "");
    }

    protected static void getFeedbackConf(Callable callable, Callable callable2) {
        Map hashMap = new HashMap();
        hashMap.put("appkey", mAppkey);
        hashMap.put("status", "0");
        hashMap.put("deviceId", deviceID);
        new Thread(new d(hashMap, new c(callable, callable2))).start();
    }

    public static Fragment getFeedbackFragment() {
        customWebviewFragment = new e();
        Bundle bundle = new Bundle();
        bundle.putString("URL", feedbackUrl);
        customWebviewFragment.setArguments(bundle);
        return customWebviewFragment;
    }

    public static void getFeedbackUnreadCount(IUnreadCountCallback iUnreadCountCallback) {
        if (isUTInit) {
            IWxCallback fVar = new f(iUnreadCountCallback);
            Map hashMap = new HashMap();
            hashMap.put("appkey", mAppkey);
            hashMap.put("deviceId", deviceID);
            new Thread(new g(hashMap, fVar)).start();
            return;
        }
        mErrorManager.a(mContext, "反馈组件初始化失败, 空指针", ErrorCode.NULL_ERROR);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(android.app.Application r4, java.lang.String r5) {
        /*
        r0 = lock;
        monitor-enter(r0);
        if (r4 == 0) goto L_0x008a;
    L_0x0005:
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0088 }
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        goto L_0x008a;
    L_0x000d:
        r1 = 0;
        r2 = type;	 Catch:{ all -> 0x0088 }
        utAndSecurityInit(r5, r1, r4, r2);	 Catch:{ all -> 0x0088 }
        r1 = ONLINE_FEEDBACK_URL;	 Catch:{ all -> 0x0088 }
        feedbackUrl = r1;	 Catch:{ all -> 0x0088 }
        r1 = LOCAL_FEEDBACK_URL;	 Catch:{ all -> 0x0088 }
        webviewUrl = r1;	 Catch:{ all -> 0x0088 }
        r1 = com.alibaba.sdk.android.feedback.util.i.b(r4);	 Catch:{ all -> 0x0088 }
        deviceID = r1;	 Catch:{ all -> 0x0088 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0088 }
        if (r1 == 0) goto L_0x0029;
    L_0x0027:
        monitor-exit(r0);	 Catch:{ all -> 0x0088 }
        return;
    L_0x0029:
        r1 = r4.getApplicationContext();	 Catch:{ all -> 0x0088 }
        mContext = r1;	 Catch:{ all -> 0x0088 }
        mAppkey = r5;	 Catch:{ all -> 0x0088 }
        r1 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x0088 }
        r2 = "appkey";
        r1.put(r2, r5);	 Catch:{ all -> 0x0088 }
        r5 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x0088 }
        r1 = "deviceId";
        r2 = deviceID;	 Catch:{ all -> 0x0088 }
        r5.put(r1, r2);	 Catch:{ all -> 0x0088 }
        r5 = "ywPrefsTools";
        r1 = 0;
        r5 = r4.getSharedPreferences(r5, r1);	 Catch:{ all -> 0x0088 }
        r1 = "annoy_uid";
        r2 = "";
        r1 = r5.getString(r1, r2);	 Catch:{ all -> 0x0088 }
        r2 = "annoy_password";
        r3 = "";
        r5 = r5.getString(r2, r3);	 Catch:{ all -> 0x0088 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0088 }
        r3 = "uid:";
        r2.<init>(r3);	 Catch:{ all -> 0x0088 }
        r2.append(r1);	 Catch:{ all -> 0x0088 }
        r3 = " password:";
        r2.append(r3);	 Catch:{ all -> 0x0088 }
        r2.append(r5);	 Catch:{ all -> 0x0088 }
        r2 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x0088 }
        r3 = "openIMId";
        r2.put(r3, r1);	 Catch:{ all -> 0x0088 }
        r1 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x0088 }
        r2 = "credential";
        r1.put(r2, r5);	 Catch:{ all -> 0x0088 }
        com.alibaba.sdk.android.feedback.util.n.a();	 Catch:{ all -> 0x0088 }
        r5 = 1;
        isUTInit = r5;	 Catch:{ all -> 0x0088 }
        com.alibaba.sdk.android.a.a.a(r5);	 Catch:{ all -> 0x0088 }
        r5 = com.alibaba.sdk.android.a.d.AMS_FEEDBACK;	 Catch:{ all -> 0x0088 }
        com.alibaba.sdk.android.a.a.a(r4, r5);	 Catch:{ all -> 0x0088 }
        monitor-exit(r0);	 Catch:{ all -> 0x0088 }
        return;
    L_0x0088:
        r4 = move-exception;
        goto L_0x008c;
    L_0x008a:
        monitor-exit(r0);	 Catch:{ all -> 0x0088 }
        return;
    L_0x008c:
        monitor-exit(r0);	 Catch:{ all -> 0x0088 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.impl.FeedbackAPI.init(android.app.Application, java.lang.String):void");
    }

    public static void init(Application application, String str, int i) {
        type = i;
        init(application, str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(android.app.Application r3, java.lang.String r4, java.lang.String r5) {
        /*
        r0 = lock;
        monitor-enter(r0);
        if (r3 == 0) goto L_0x0090;
    L_0x0005:
        r1 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        goto L_0x0090;
    L_0x000d:
        r1 = type;	 Catch:{ all -> 0x008e }
        utAndSecurityInit(r4, r5, r3, r1);	 Catch:{ all -> 0x008e }
        r1 = ONLINE_FEEDBACK_URL;	 Catch:{ all -> 0x008e }
        feedbackUrl = r1;	 Catch:{ all -> 0x008e }
        r1 = LOCAL_FEEDBACK_URL;	 Catch:{ all -> 0x008e }
        webviewUrl = r1;	 Catch:{ all -> 0x008e }
        r1 = com.alibaba.sdk.android.feedback.util.i.b(r3);	 Catch:{ all -> 0x008e }
        deviceID = r1;	 Catch:{ all -> 0x008e }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x008e }
        return;
    L_0x0028:
        r1 = r3.getApplicationContext();	 Catch:{ all -> 0x008e }
        mContext = r1;	 Catch:{ all -> 0x008e }
        mAppkey = r4;	 Catch:{ all -> 0x008e }
        r1 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x008e }
        r2 = "appkey";
        r1.put(r2, r4);	 Catch:{ all -> 0x008e }
        r4 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x008e }
        r1 = "deviceId";
        r2 = deviceID;	 Catch:{ all -> 0x008e }
        r4.put(r1, r2);	 Catch:{ all -> 0x008e }
        r4 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x008e }
        r1 = "appSecret";
        r4.put(r1, r5);	 Catch:{ all -> 0x008e }
        r4 = "ywPrefsTools";
        r5 = 0;
        r4 = r3.getSharedPreferences(r4, r5);	 Catch:{ all -> 0x008e }
        r5 = "annoy_uid";
        r1 = "";
        r5 = r4.getString(r5, r1);	 Catch:{ all -> 0x008e }
        r1 = "annoy_password";
        r2 = "";
        r4 = r4.getString(r1, r2);	 Catch:{ all -> 0x008e }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r2 = "uid:";
        r1.<init>(r2);	 Catch:{ all -> 0x008e }
        r1.append(r5);	 Catch:{ all -> 0x008e }
        r2 = " password:";
        r1.append(r2);	 Catch:{ all -> 0x008e }
        r1.append(r4);	 Catch:{ all -> 0x008e }
        r1 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x008e }
        r2 = "openIMId";
        r1.put(r2, r5);	 Catch:{ all -> 0x008e }
        r5 = mFeedbackCustomInfoMap;	 Catch:{ all -> 0x008e }
        r1 = "credential";
        r5.put(r1, r4);	 Catch:{ all -> 0x008e }
        com.alibaba.sdk.android.feedback.util.n.a();	 Catch:{ all -> 0x008e }
        r4 = 1;
        isUTInit = r4;	 Catch:{ all -> 0x008e }
        com.alibaba.sdk.android.a.a.a(r4);	 Catch:{ all -> 0x008e }
        r4 = com.alibaba.sdk.android.a.d.AMS_FEEDBACK;	 Catch:{ all -> 0x008e }
        com.alibaba.sdk.android.a.a.a(r3, r4);	 Catch:{ all -> 0x008e }
        monitor-exit(r0);	 Catch:{ all -> 0x008e }
        return;
    L_0x008e:
        r3 = move-exception;
        goto L_0x0092;
    L_0x0090:
        monitor-exit(r0);	 Catch:{ all -> 0x008e }
        return;
    L_0x0092:
        monitor-exit(r0);	 Catch:{ all -> 0x008e }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.impl.FeedbackAPI.init(android.app.Application, java.lang.String, java.lang.String):void");
    }

    public static void init(Application application, String str, String str2, int i) {
        type = i;
        init(application, str, str2);
    }

    private static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED;
    }

    public static void openFeedbackActivity() {
        if (isUTInit) {
            cleanFeedbackFragment();
            getFeedbackConf(new e(), null);
            return;
        }
        mErrorManager.a(mContext, "反馈组件初始化失败, 空指针异常", ErrorCode.NULL_ERROR);
        n.a("openFeedbackFaild", "appkey or context is null");
    }

    private static void processConfData(org.json.JSONObject r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "global";	 Catch:{ Exception -> 0x002c }
        r3 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x002c }
        r0 = "navbar";	 Catch:{ Exception -> 0x002c }
        r3 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x002c }
        r0 = "style";	 Catch:{ Exception -> 0x002c }
        r3 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x002c }
        r0 = mUICustomInfo;	 Catch:{ Exception -> 0x002c }
        r1 = "themeColor";	 Catch:{ Exception -> 0x002c }
        r2 = "backgroundColor";	 Catch:{ Exception -> 0x002c }
        r2 = r3.getString(r2);	 Catch:{ Exception -> 0x002c }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x002c }
        r0 = mUICustomInfo;	 Catch:{ Exception -> 0x002c }
        r1 = "textColor";	 Catch:{ Exception -> 0x002c }
        r2 = "color";	 Catch:{ Exception -> 0x002c }
        r3 = r3.getString(r2);	 Catch:{ Exception -> 0x002c }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x002c }
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.impl.FeedbackAPI.processConfData(org.json.JSONObject):void");
    }

    public static void setAppExtInfo(JSONObject jSONObject) {
        mExtInfo = jSONObject;
    }

    private static void setConfToSharedPreferences(String str) {
        if (mContext != null) {
            Editor edit = mContext.getSharedPreferences("ywPrefsTools", 0).edit();
            edit.putString(PREFS_KEY_CONF, str);
            edit.apply();
        }
    }

    public static void setFeedbackFragment(Callable callable, Callable callable2) {
        getFeedbackConf(callable, callable2);
    }

    private static void utAndSecurityInit(String str, String str2, Application application, int i) {
        if (!isUTInit) {
            isUTInit = true;
            if (str2 == null) {
                SecurityGuardManager.getInitializer().initializeAsync(application);
            }
            n.a(str, str2, application, i);
        }
    }
}
