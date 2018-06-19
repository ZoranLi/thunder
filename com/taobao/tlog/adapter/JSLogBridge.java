package com.taobao.tlog.adapter;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;

public class JSLogBridge extends WVApiPlugin {
    private static final String GETLOGLEVEL = "getLogLevel";
    private static final String LOGD = "logd";
    private static final String LOGE = "loge";
    private static final String LOGI = "logi";
    private static final String LOGV = "logv";
    private static final String LOGW = "logw";
    private static final String tlogBridgeName = "tlogBridge";

    class LogBody {
        String data;
        String module;
        String tag;

        LogBody() {
        }
    }

    public static void init() {
        WVPluginManager.registerPlugin(tlogBridgeName, JSLogBridge.class, true);
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (TextUtils.isEmpty(str) || wVCallBackContext == null) {
            return false;
        }
        if (GETLOGLEVEL.equals(str)) {
            wVCallBackContext.success(AdapterForTLog.getLogLevel());
        } else if (LOGV.equals(str)) {
            logv(str2, wVCallBackContext);
        } else if (LOGD.equals(str)) {
            logd(str2, wVCallBackContext);
        } else if (LOGI.equals(str)) {
            logi(str2, wVCallBackContext);
        } else if (LOGW.equals(str)) {
            logw(str2, wVCallBackContext);
        } else if (LOGE.equals(str) == null) {
            return false;
        } else {
            loge(str2, wVCallBackContext);
        }
        return true;
    }

    public void logv(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logv(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void logd(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logd(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void logi(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logi(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void logw(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logw(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void loge(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.loge(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    private com.taobao.tlog.adapter.JSLogBridge.LogBody getLog(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new com.taobao.tlog.adapter.JSLogBridge$LogBody;	 Catch:{ JSONException -> 0x001f }
        r0.<init>();	 Catch:{ JSONException -> 0x001f }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001f }
        r1.<init>(r4);	 Catch:{ JSONException -> 0x001f }
        r4 = "tag";	 Catch:{ JSONException -> 0x001f }
        r2 = "jsTag";	 Catch:{ JSONException -> 0x001f }
        r4 = r1.optString(r4, r2);	 Catch:{ JSONException -> 0x001f }
        r0.tag = r4;	 Catch:{ JSONException -> 0x001f }
        r4 = "content";	 Catch:{ JSONException -> 0x001f }
        r2 = "";	 Catch:{ JSONException -> 0x001f }
        r4 = r1.optString(r4, r2);	 Catch:{ JSONException -> 0x001f }
        r0.data = r4;	 Catch:{ JSONException -> 0x001f }
        return r0;
    L_0x001f:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tlog.adapter.JSLogBridge.getLog(java.lang.String):com.taobao.tlog.adapter.JSLogBridge$LogBody");
    }
}
