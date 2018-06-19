package com.xunlei.downloadprovider.web.base.core;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.android.volley.Request;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseJsInterface {
    private static final String EXTRA_CALLBACK = "Callback";
    private static final String EXTRA_METHOD_NAME = "MethodName";
    private static final String EXTRA_PARAMS = "Params";
    public static final String JS_PREFIX = "javascript:";
    public static final String NAME = "XLJSWebViewBridge";
    protected static final String TAG = "BaseJsInterface";
    private static final int WHAT_SEND_MESSAGE = 1;
    static w sJsHttpClient = new w();
    private Context mContext;
    private Handler mHandler = new a(this, Looper.getMainLooper());
    private CustomWebView mWebView;

    private class a extends Handler {
        final /* synthetic */ BaseJsInterface a;

        public a(BaseJsInterface baseJsInterface, Looper looper) {
            this.a = baseJsInterface;
            super(looper);
        }

        public final void handleMessage(android.os.Message r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = r6.what;
            r1 = 1;
            if (r0 == r1) goto L_0x0007;
        L_0x0005:
            goto L_0x0085;
        L_0x0007:
            r6 = r6.peekData();
            if (r6 == 0) goto L_0x0085;
        L_0x000d:
            r0 = r5.a;
            r0 = r0.isDestroyed();
            if (r0 == 0) goto L_0x0016;
        L_0x0015:
            return;
        L_0x0016:
            r0 = "MethodName";
            r0 = r6.getString(r0);
            r2 = "Params";
            r2 = r6.getString(r2);
            r3 = "Callback";
            r6 = r6.getString(r3);
            r3 = com.xunlei.downloadprovider.web.base.core.MethodName.getMethod(r0);
            if (r3 != 0) goto L_0x005e;
        L_0x002e:
            r2 = com.xunlei.downloadprovider.web.base.core.BaseJsInterface.TAG;
            r2 = new java.lang.StringBuilder;
            r3 = "methodName : ";
            r2.<init>(r3);
            r2.append(r0);
            r3 = " should declared in enum MethodName";
            r2.append(r3);
            r2 = android.text.TextUtils.isEmpty(r6);
            if (r2 != 0) goto L_0x005d;
        L_0x0045:
            r2 = r5.a;
            r3 = new java.lang.StringBuilder;
            r4 = "method ";
            r3.<init>(r4);
            r3.append(r0);
            r0 = " is not declared";
            r3.append(r0);
            r0 = r3.toString();
            r2.callbackError(r6, r1, r0);
        L_0x005d:
            return;
        L_0x005e:
            r0 = com.xunlei.downloadprovider.web.base.core.ak.a(r2);	 Catch:{ JSONException -> 0x0076 }
            if (r0 == 0) goto L_0x006b;	 Catch:{ JSONException -> 0x0076 }
        L_0x0064:
            r0 = r5.a;	 Catch:{ JSONException -> 0x0076 }
            r2 = 0;	 Catch:{ JSONException -> 0x0076 }
            r0.handleMessage(r3, r2, r6);	 Catch:{ JSONException -> 0x0076 }
            return;	 Catch:{ JSONException -> 0x0076 }
        L_0x006b:
            r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0076 }
            r0.<init>(r2);	 Catch:{ JSONException -> 0x0076 }
            r2 = r5.a;	 Catch:{ JSONException -> 0x0076 }
            r2.handleMessage(r3, r0, r6);	 Catch:{ JSONException -> 0x0076 }
            return;
        L_0x0076:
            r0 = com.xunlei.downloadprovider.web.base.core.BaseJsInterface.TAG;
            r0 = com.xunlei.downloadprovider.web.base.core.ak.a(r6);
            if (r0 != 0) goto L_0x0085;
        L_0x007e:
            r0 = r5.a;
            r2 = "Params is Error";
            r0.callbackError(r6, r1, r2);
        L_0x0085:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.base.core.BaseJsInterface.a.handleMessage(android.os.Message):void");
        }
    }

    protected abstract boolean handleMessage(MethodName methodName, JSONObject jSONObject, String str) throws JSONException;

    public BaseJsInterface(Context context, CustomWebView customWebView) {
        setupParams(context, customWebView);
    }

    public void setupParams(Context context, CustomWebView customWebView) {
        this.mWebView = customWebView;
        this.mContext = context;
    }

    @JavascriptInterface
    public void sendMessage(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder("sendMessage--methodNameStr=");
            stringBuilder.append(str);
            stringBuilder.append("|params=");
            stringBuilder.append(str2);
            stringBuilder.append("|callback=");
            stringBuilder.append(str3);
            Message obtain = Message.obtain();
            obtain.what = 1;
            Bundle bundle = new Bundle(3);
            bundle.putString(EXTRA_METHOD_NAME, str);
            bundle.putString(EXTRA_CALLBACK, str3);
            bundle.putString(EXTRA_PARAMS, str2);
            obtain.setData(bundle);
            this.mHandler.sendMessage(obtain);
        }
    }

    protected Context getContext() {
        return this.mContext;
    }

    protected CustomWebView getWebView() {
        return this.mWebView;
    }

    protected void callbackWithOneParam(String str, String str2, Object obj) {
        Map map;
        if (TextUtils.isEmpty(str2)) {
            map = null;
        } else {
            map = new HashMap();
            map.put(str2, obj);
        }
        callback(str, map);
    }

    protected void callbackError(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errorCode", Integer.valueOf(i));
        hashMap.put("errorMsg", str2);
        i = new HashMap();
        i.put("internalError", hashMap);
        callback(str, i);
    }

    protected void callback(String str, Map<String, Object> map) {
        runOnUiThread(new a(this, str, map));
    }

    protected void callbackDirect(String str, Map<String, Object> map) {
        if (!ak.a(str)) {
            if (!isDestroyed()) {
                str = generateCallbackJson(str, map);
                if (TextUtils.isEmpty(str) == null) {
                    this.mWebView.a(str);
                }
            }
        }
    }

    protected void add(Request request) {
        w.a(request);
    }

    private String generateCallbackJson(String str, Map<String, Object> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                map = new JSONObject(map).toString();
                return mergeJsCallbackUrl(str, map);
            }
        }
        return mergeJsCallbackUrl(str, new String[0]);
    }

    private static String mergeJsCallbackUrl(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(str);
        stringBuilder.append('(');
        if (strArr != null && strArr.length > null) {
            for (str = null; str < strArr.length; str++) {
                stringBuilder.append("'");
                if (strArr[str] != null) {
                    stringBuilder.append(strArr[str].replace("\\", "\\\\").replace("'", "\\'"));
                }
                stringBuilder.append("'");
                stringBuilder.append(',');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    protected void runOnUiThread(Runnable runnable) {
        if (this.mWebView != null) {
            this.mWebView.post(runnable);
        }
    }

    protected void removeViewCallbacks(Runnable runnable) {
        if (this.mWebView != null) {
            this.mWebView.removeCallbacks(runnable);
        }
    }

    void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mWebView = null;
        this.mContext = null;
    }

    boolean isDestroyed() {
        return this.mWebView == null;
    }
}
