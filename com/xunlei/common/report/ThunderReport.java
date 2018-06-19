package com.xunlei.common.report;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import com.umeng.message.proguard.k;
import com.xunlei.analytics.HubbleAgent;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThunderReport {
    protected static final String TAG = "ThunderReport";
    private static final HashMap<String, String> sCommonParams;
    private static String sCommonParamsDebugInfo = sCommonParams.toString();
    static CrashReportProxy sCrashReportProxy = null;
    private static boolean sDebugMode = true;
    private static String sLocationInfo = null;
    private static String sShouleiMemberDeviceId = "";
    private static long sShouleiUserId;

    static {
        HashMap hashMap = new HashMap(2);
        sCommonParams = hashMap;
        hashMap.put("shoulei_pub_apilv", String.valueOf(VERSION.SDK_INT));
    }

    public static void setDebugMode(boolean z) {
        sDebugMode = z;
    }

    public static synchronized void init(Context context) {
        synchronized (ThunderReport.class) {
            HubbleReport.init(context.getApplicationContext());
            HubbleReport.setSpecialCommonParams(new HashMap(sCommonParams));
        }
    }

    public static void reportEvent(StatEvent statEvent) {
        HubbleReport.reportEvent(statEvent);
        if (sDebugMode) {
            StringBuilder stringBuilder = new StringBuilder("[HUBBLE_STAT_EVENT]");
            stringBuilder.append(statEvent);
            stringBuilder.append(" CommonParams:");
            stringBuilder.append(sCommonParamsDebugInfo);
        }
    }

    public static void onResumeActivity(Context context) {
        try {
            HubbleReport.onResume(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sDebugMode) {
            new StringBuilder("[HUBBLE_STAT_EVENT][onResume]").append(context);
        }
    }

    public static void onPauseActivity(Context context) {
        try {
            HubbleReport.onPause(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sDebugMode) {
            new StringBuilder("[HUBBLE_STAT_EVENT][onPause]").append(context);
        }
    }

    public static String getHubbleDeviceId(Context context) {
        return HubbleAgent.getHubbleDeviceId(context);
    }

    public static void forceUpdateBaseParams(Context context) {
        String hubbleDeviceId = HubbleAgent.getHubbleDeviceId(context);
        HubbleAgent.forceUpdateBaseParams(context);
        context = HubbleAgent.getHubbleDeviceId(context);
        if (sDebugMode) {
            StringBuilder stringBuilder = new StringBuilder("Hubble forceUpdateBaseParams: ");
            stringBuilder.append(context);
            stringBuilder.append(" (");
            stringBuilder.append(hubbleDeviceId);
            stringBuilder.append(k.t);
        }
    }

    public static long getShouleiUserId() {
        return sShouleiUserId;
    }

    public static void setShouleiUserId(long j) {
        sShouleiUserId = j;
        setCommonParam("shoulei_pub_userid", String.valueOf(j));
    }

    public static String getShouleiMemberDeviceId() {
        return sShouleiMemberDeviceId;
    }

    public static void setShouleiMemberDeviceId(String str) {
        if (str == null) {
            str = "";
        }
        sShouleiMemberDeviceId = str;
        setCommonParam("shoulei_pub_deviceid", sShouleiMemberDeviceId);
        if (sDebugMode != null) {
            new StringBuilder("Hubble setShouleiMemberDeviceId:").append(sShouleiMemberDeviceId);
        }
    }

    public static String getShouleiLocation() {
        return sLocationInfo;
    }

    public static void setShouleiLocation(String str) {
        if (str == null) {
            str = "";
        }
        sLocationInfo = str;
        setCommonParam("shoulei_pub_location", sLocationInfo);
        if (sDebugMode != null) {
            new StringBuilder("Hubble setShouleiLocation:").append(sLocationInfo);
        }
    }

    private static void setCommonParam(@Nullable String str, String str2) {
        HashMap hashMap = sCommonParams;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put(str, str2);
        if (sDebugMode != null) {
            sCommonParamsDebugInfo = sCommonParams.toString();
        }
        HubbleReport.setSpecialCommonParams(new HashMap(sCommonParams));
    }

    public static void setCrashReportProxy(CrashReportProxy crashReportProxy) {
        sCrashReportProxy = crashReportProxy;
    }

    public static void postCatchedException(Throwable th) {
        if (sCrashReportProxy != null) {
            sCrashReportProxy.postCatchedException(th);
        }
    }

    public static String getContentList(List<Map<String, String>> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map map : list) {
            if (map != null) {
                for (String str : map.keySet()) {
                    String str2 = (String) map.get(str);
                    stringBuilder.append(str);
                    stringBuilder.append('=');
                    stringBuilder.append(str2);
                    stringBuilder.append(',');
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                stringBuilder.append(';');
            }
        }
        if (stringBuilder.length() > null) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        new StringBuilder("contentlist: ").append(stringBuilder.toString());
        return Uri.encode(stringBuilder.toString());
    }

    public static String getSingleContentList(Map<String, String> map) {
        return getContentList(Collections.singletonList(map));
    }
}
