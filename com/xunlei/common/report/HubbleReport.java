package com.xunlei.common.report;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.analytics.HubbleAgent;
import com.xunlei.analytics.config.AnalyticsReportConfigurationBuilder;
import com.xunlei.common.androidutil.AndroidConfig;
import java.util.HashMap;

class HubbleReport {
    private static String appId = "17";
    private static volatile boolean sInited = false;
    private static String secretKey = "ed35b80ab6de3944a96466be405de2fc";

    HubbleReport() {
    }

    public static void init(Context context) {
        HubbleAgent.init(context, appId, secretKey, AndroidConfig.getPartnerId(context));
        HubbleAgent.setReportConfiguration(new AnalyticsReportConfigurationBuilder().reportCheckInterval(180000).batchUploadCount(10).reportRetryCount(3).deleteExpirationDayTime(604800000).uploadInWifiOnly(true).build());
        HubbleAgent.setReportEventServerMode(3);
        sInited = true;
    }

    public static void reportEvent(StatEvent statEvent) {
        if (statEvent != null) {
            if (!TextUtils.isEmpty(statEvent.mEventId)) {
                checkInit();
                if (statEvent.hasExtraData()) {
                    HubbleAgent.onEvent(statEvent.mEventId, statEvent.getExtraData());
                } else {
                    HubbleAgent.onEvent(statEvent.mEventId);
                }
            }
        }
    }

    public static void onResume(Context context) {
        checkInit();
        HubbleAgent.onResume(context);
    }

    public static void onPause(Context context) {
        checkInit();
        HubbleAgent.onPause(context);
    }

    public static void setSpecialCommonParams(HashMap<String, String> hashMap) {
        HubbleAgent.setSpecialCommonParams(hashMap);
    }

    private static void checkInit() {
        if (!sInited) {
            Throwable illegalStateException = new IllegalStateException("Hubble is not init yet. Did you call init()？");
            illegalStateException.printStackTrace();
            ThunderReport.postCatchedException(illegalStateException);
        }
    }
}
